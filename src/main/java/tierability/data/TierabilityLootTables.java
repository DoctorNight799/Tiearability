package tierability.data;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import tierability.item.TierabilityItems;
import tierability.item.tool.TierabilityTools;

import java.util.ArrayList;
import java.util.Arrays;

public class TierabilityLootTables {

    private static FabricLootSupplierBuilder supplier;
    private static Identifier id;

    private static final ArrayList<String> NETHER_CHESTS = new ArrayList<>(Arrays.asList("bastion_bridge",
            "bastion_hoglin_stable", "bastion_other", "bastion_treasure", "nether_bridge"));

    private static final ArrayList<String> BLACKLIST = new ArrayList<>(Arrays.asList("jungle_temple",
            "end_city_treasure", "village", "ruined_portal", "woodland_mansion", "desert_pyramid", "underwater_ruin_big"));

    public static void register(){

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if(!id.toString().contains("minecraft:chests/")) return;
            TierabilityLootTables.id = id;
            TierabilityLootTables.supplier = supplier;

            overworldChest(TierabilityTools.SOULCOLLECTOR, 0.01F);
            overworldChest(TierabilityItems.SAFE_AMULET, 0.03F);
            overworldChest(TierabilityItems.BOTTLE_WITH_POISON_T1, 0.1F);
            overworldChest(TierabilityItems.FIREBALL_SPELL_BOOK, 0.4F);
            overworldChest(TierabilityItems.LIGHTNING_BOLT_SPELL_BOOK, 0.02F);
            overworldChest(TierabilityItems.POSITIVE_EFFECT_SPELL_BOOK, 0.04F);
            overworldChest(TierabilityItems.NEGATIVE_EFFECT_SPELL_BOOK, 0.04F);
            overworldChest(TierabilityItems.SWAP_SPELL_BOOK, 0.05F);
            overworldChest(TierabilityItems.HOOK_SPELL_BOOK, 0.6F);
            overworldChest(TierabilityItems.EXPLOSION_SPELL_BOOK, 0.4F);
            overworldChest(TierabilityItems.TELEPORT_SPELL_BOOK, 0.02F);
        });
    }

    static void overworldChest(Item item, Float chance){
        String chest = id.toString();

        if (!isBlacklisted(chest) && !isNetherChest(chest)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1)).withCondition(RandomChanceLootCondition.builder(chance).build())
                    .withEntry(ItemEntry.builder(item).build());
            supplier.withPool(poolBuilder.build());
        }
    }

    static boolean isBlacklisted(String string){
        for(String banned : BLACKLIST){
            if(string.contains(banned)) return true;
        }
        return false;
    }

    static boolean isNetherChest(String string){
        for(String chest : NETHER_CHESTS){
            if(string.contains(chest)) return true;
        }
        return false;
    }
}
