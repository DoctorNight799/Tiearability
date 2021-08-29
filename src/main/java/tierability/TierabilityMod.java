package tierability;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import tierability.block.TierabilityBlocks;
import tierability.item.TierabilityItems;
import tierability.worldgen.feature.TierabilityConfiguredFeature;

public class TierabilityMod implements ModInitializer {

	public static final String MODID = "tierability";

	public static final ItemGroup ITEM_GROUP_ITEMS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(Blocks.COBBLESTONE));
	public static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(Blocks.OBSERVER));

	@Override
	public void onInitialize() {
		TierabilityItems.register();
		TierabilityBlocks.register();
		TierabilityConfiguredFeature.register();
	}
}
