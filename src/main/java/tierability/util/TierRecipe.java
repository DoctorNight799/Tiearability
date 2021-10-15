package tierability.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import tierability.TierabilityMod;
import tierability.block.TierabilityBlocks;
import tierability.item.base.TierableItem;

import java.util.stream.Stream;

public class TierRecipe implements Recipe<Inventory> {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;
    private final Identifier id;

    public TierRecipe(Identifier id, Ingredient base, Ingredient addition, ItemStack result) {
        this.id = id;
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    public boolean matches(Inventory inventory, World world) {
        return this.base.test(inventory.getStack(0)) && this.addition.test(inventory.getStack(1));
    }

    public ItemStack craft(Inventory inventory) {
        ItemStack itemStack = this.result.copy();
        NbtCompound nbtCompound = inventory.getStack(0).getNbt();
        if (nbtCompound != null) {
            itemStack.setNbt(nbtCompound.copy());
        }

        return itemStack;
    }

    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    public ItemStack getOutput() {
        return this.result;
    }

    public boolean testAddition(ItemStack stack) {
        return this.addition.test(stack);
    }

    public ItemStack createIcon() {
        return new ItemStack(TierabilityBlocks.CRAFTING_TIER_BLOCK);
    }

    public Identifier getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return TierabilityMod.TIER_RECIPE_SER;
    }

    public RecipeType<?> getType() {
        return TierabilityMod.TIER_RECIPE;
    }

    public boolean isEmpty() {
        return Stream.of(this.base, this.addition).anyMatch((ingredient) -> {
            return ingredient.getMatchingStacks().length == 0;
        });
    }

    public static class Serializer implements RecipeSerializer<TierRecipe> {
        public Serializer() {
        }
        public static Item getItem(JsonObject json) {
            String string = JsonHelper.getString(json, "item");
            Item item = (Item) Registry.ITEM.getOrEmpty(new Identifier(string)).orElseThrow(() -> {
                return new JsonSyntaxException("Unknown item '" + string + "'");
            });
            if (item == Items.AIR) {
                throw new JsonSyntaxException("Invalid item: " + string);
            } else {
                return item;
            }
        }

        public static ItemStack outputFromJson(JsonObject json) {
            Item item = getItem(json);
            if (json.has("data")) {
                throw new JsonParseException("Disallowed data tag found");
            } else {
                int a = JsonHelper.getInt(json, "Tier", 0);

                int i = JsonHelper.getInt(json, "count", 1);
                if (i < 1) {
                    throw new JsonSyntaxException("Invalid output count: " + i);
                } else {
                    if(a > 0) {
                        ItemStack tierItem = new ItemStack(item,i);
                        NbtCompound nbtCompound = tierItem.getOrCreateNbt();
                        nbtCompound.putInt("Tier", a);


                        tierItem.writeNbt(nbtCompound);
                        return tierItem;
                    } else  {
                        return new ItemStack(item, i);
                    }
                }
            }
        }

        public TierRecipe read(Identifier identifier, JsonObject jsonObject) {
            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(jsonObject, "base"));
            Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getObject(jsonObject, "addition"));
            ItemStack itemStack = outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            return new TierRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public TierRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
            Ingredient ingredient2 = Ingredient.fromPacket(packetByteBuf);
            ItemStack itemStack = packetByteBuf.readItemStack();
            return new TierRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public void write(PacketByteBuf packetByteBuf, TierRecipe TierRecipe) {
            TierRecipe.base.write(packetByteBuf);
            TierRecipe.addition.write(packetByteBuf);
            packetByteBuf.writeItemStack(TierRecipe.result);
        }
    }
}
