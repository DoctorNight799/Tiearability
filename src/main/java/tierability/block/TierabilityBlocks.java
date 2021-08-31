package tierability.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.block.base.BasedBlock;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierabilityBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block T1_ORE = add("t1_ore", new BasedBlock("cube_all"));

    private static <B extends Block> void addBlock(String name, B block) {
        BLOCKS.put(new Identifier(TierabilityMod.MODID, name), block);
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

    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(TierabilityMod.ITEM_GROUP_BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }
    public static void register() {

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

    public static Map<Identifier, Block> getBlocks() {
        return BLOCKS;
    }

}