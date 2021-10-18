package tierability.item.tool;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.item.tool.t1.*;
import tierability.item.tool.t1_2.T1_2HammerItem;
import tierability.item.tool.t1_2.T1_2Material;
import tierability.item.tool.t1_upgraded.*;
import tierability.item.tool.t2.*;
import tierability.item.tool.t2_upgraded.T2UpgradedMaterial;
import tierability.item.tool.t2_upgraded.T2UpgradedPickaxeItem;
import tierability.item.tool.t2_upgraded.T2UpgradedSwordItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierabilityTools {

    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem T1_SWORD = add("t1_sword", new T1SwordItem(T1Material.T1_MATERIAL, 0, -2.2f, settings()));
    public static final ToolItem T1_DAGGER = add("t1_dagger", new T1DaggerItem(T1Material.T1_MATERIAL, -2, -1.5f, settings()));
    public static final ToolItem T1_SPEAR = add("t1_spear", new T1SpearItem(T1Material.T1_MATERIAL, 1, -2.6f, 5, settings()));
    public static final ToolItem T1_PICKAXE = add("t1_pickaxe", new T1PickaxeItem(T1Material.T1_MATERIAL, -2, -2.6f, settings()));
    public static final ToolItem T1_AXE = add("t1_axe", new T1AxeItem(T1Material.T1_MATERIAL, 3, -3f, settings()));
    public static final ToolItem T1_SHOVEL = add("t1_shovel", new T1ShovelItem(T1Material.T1_MATERIAL, -1.5f, -2.8f, settings()));
    public static final ToolItem T1_HOE = add("t1_hoe", new T1HoeItem(T1Material.T1_MATERIAL, -5, -0.9f, settings()));

    public static final ToolItem T2_SWORD = add("t2_sword", new T2SwordItem(T2Material.T2_MATERIAL, 0, -2.2f, settings()));
    public static final ToolItem T2_DAGGER = add("t2_dagger", new T2DaggerItem(T2Material.T2_MATERIAL, -2, -1.5f, settings()));
    public static final ToolItem T2_SPEAR = add("t2_spear", new T2SpearItem(T2Material.T2_MATERIAL, 1, -2.6f, 6, settings()));
    public static final ToolItem T2_PICKAXE = add("t2_pickaxe", new T2PickaxeItem(T2Material.T2_MATERIAL, -2, -2.6f, settings()));
    public static final ToolItem T2_AXE = add("t2_axe", new T2AxeItem(T2Material.T2_MATERIAL, 2, -2.8f, settings()));
    public static final ToolItem T2_SHOVEL = add("t2_shovel", new T2ShovelItem(T2Material.T2_MATERIAL, -1.5f, -2.8f, settings()));
    public static final ToolItem T2_HOE = add("t2_hoe", new T2HoeItem(T2Material.T2_MATERIAL, -6, 0.2f, settings()));

    public static final ToolItem T1_2_HAMMER = add("t1_2_hammer", new T1_2HammerItem(T1_2Material.T1_2_MATERIAL, -2, -2.2f, settings()));

    public static final ToolItem T1_UPGRADED_SWORD = add("t1_upgraded_sword", new T1UpgradedSwordItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, 0, -2.1f, settings()));
    public static final ToolItem T1_UPGRADED_DAGGER = add("t1_upgraded_dagger", new T1UpgradedDaggerItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -2, -1.4f, settings()));
    public static final ToolItem T1_UPGRADED_SPEAR = add("t1_upgraded_spear", new T1UpgradedSpearItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, 1, -2.5f, 6, settings()));
    public static final ToolItem T1_UPGRADED_PICKAXE = add("t1_upgraded_pickaxe", new T1UpgradedPickaxeItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -2, -2.5f, settings()));
    public static final ToolItem T1_UPGRADED_AXE = add("t1_upgraded_axe", new T1UpgradedAxeItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, 2, -2.7f, settings()));
    public static final ToolItem T1_UPGRADED_SHOVEL = add("t1_upgraded_shovel", new T1ShovelItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -1.5f, -2.7f, settings()));
    public static final ToolItem T1_UPGRADED_HOE = add("t1_upgraded_hoe", new T1UpgradedHoeItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -6, 0.3f, settings()));

    public static final ToolItem T2_UPGRADED_SWORD = add("t2_upgraded_sword", new T2UpgradedSwordItem(T2UpgradedMaterial.T2_UPGRADED_MATERIAL, 0, -2.1f, settings()));
    public static final ToolItem T2_UPGRADED_DAGGER = add("t2_upgraded_dagger", new T1UpgradedDaggerItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -2, -1.4f, settings()));
    public static final ToolItem T2_UPGRADED_SPEAR = add("t2_upgraded_spear", new T1UpgradedSpearItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, 1, -2.5f, 6, settings()));
    public static final ToolItem T2_UPGRADED_PICKAXE = add("t2_upgraded_pickaxe", new T2UpgradedPickaxeItem(T2UpgradedMaterial.T2_UPGRADED_MATERIAL, -2, -2.5f, settings()));
    public static final ToolItem T2_UPGRADED_AXE = add("t2_upgraded_axe", new T1UpgradedAxeItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, 2, -2.7f, settings()));
    public static final ToolItem T2_UPGRADED_SHOVEL = add("t2_upgraded_shovel", new T1ShovelItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -1.5f, -2.7f, settings()));
    public static final ToolItem T2_UPGRADED_HOE = add("t2_upgraded_hoe", new T1UpgradedHoeItem(T1UpgradedMaterial.T1_UPGRADED_MATERIAL, -6, 0.3f, settings()));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(TierabilityMod.ITEM_GROUP_TOOLS);
    }

    public static void register(){
        TOOLITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, TOOLITEMS.get(id)));
    }
}

