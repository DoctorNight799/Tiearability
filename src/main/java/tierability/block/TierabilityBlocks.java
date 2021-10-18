package tierability.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.block.base.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierabilityBlocks {

    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block T1_ORE = add("t1_ore", new BasedBlock( 2, 3.0f, 3.0f));
    public static final Block T2_ORE = add("t2_ore", new BasedBlock(2, 3.0f, 3.0f));
    public static final Block T1_BLOCK = add("t1_block", new BasedBlock(3.0f, 3.0f));
    public static final Block T2_BLOCK = add("t2_block", new BasedBlock(3.0f, 3.0f));
    public static final Block JUMPING_BLOCK_T1 = add("jump_block_t1", new JumpBlock( 2, 2));
    public static final Block JUMPING_BLOCK_T2 = add("jump_block_t2", new JumpBlock(2, 3));
    public static final Block CRAFTING_TIER_BLOCK = add("tiering_block", new CraftingTierBlock( 2));
    public static final Block FLAME_CRYSTAL = add("flame_crystal", new FlameCrystal("flame"));


    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(TierabilityMod.ITEM_GROUP_BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }

    private static FabricBlockSettings copyOf(Block block){
        return FabricBlockSettings.copyOf(block);
    }

    private static <B extends Block> B addBlockItem(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(TierabilityMod.MODID, name), block);
        return block;
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
        BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, BLOCKS.get(id)));
    }

    public static Map<Identifier, Block> getBlocks() {
        return BLOCKS;
    }
}
