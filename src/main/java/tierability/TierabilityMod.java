package tierability;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.block.TierabilityBlocks;
import tierability.event.TierabilityEvents;
import tierability.item.TierabilityItems;
import tierability.item.armor.TierabilityArmor;
import tierability.item.tool.TierabilityTools;
import tierability.screen.TierCraftingScreen;
import tierability.screen.TierCraftingScreenHandler;
import tierability.util.TierRecipe;
import tierability.worldgen.feature.TierabilityConfiguredFeature;

public class TierabilityMod implements ModInitializer {

	public static final String MODID = "tierability";

	public static final ItemGroup ITEM_GROUP_ITEMS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "items"),
			() -> new ItemStack(TierabilityTools.T1_SWORD));
	public static final ItemGroup ITEM_GROUP_ARMOR = FabricItemGroupBuilder.build(
			new Identifier(MODID, "armor"),
			() -> new ItemStack(TierabilityArmor.T1_CHESTPLATE));
	public static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier(MODID, "blocks"),
			() -> new ItemStack(TierabilityBlocks.T1_ORE));

	public static final ScreenHandlerType<TierCraftingScreenHandler> TIER_UPGRADE = ScreenHandlerRegistry.registerSimple(new Identifier("tier"), TierCraftingScreenHandler::new);
	public static final RecipeType<TierRecipe> TIER_RECIPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MODID, "tiering"), new RecipeType<TierRecipe>() {
		@Override
		public String toString() {
			return null;
		}
	});
	public static final RecipeSerializer<TierRecipe> TIER_RECIPE_SER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MODID, "tier_recipe"), new TierRecipe.Serializer());

	@Override
	public void onInitialize() {
		TierabilityItems.register();
		TierabilityTools.register();
		TierabilityArmor.register();
		TierabilityBlocks.register();
		TierabilityEvents.register();
		TierabilityConfiguredFeature.register();
		ScreenRegistry.register(TIER_UPGRADE, TierCraftingScreen::new);
	}

}
