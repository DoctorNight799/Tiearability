package tierability.item.tool;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.item.tool.t1.*;
import tierability.item.tool.t2.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierabilityTools {

    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem T1_SWORD = add("t1_sword", new T1SwordItem(T1Material.T1_MATERIAL, 0, -2.2f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_DAGGER = add("t1_dagger", new T1DaggerItem(T1Material.T1_MATERIAL, -2, -1.5f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_SPEAR = add("t1_spear", new T1SpearItem(T1Material.T1_MATERIAL, 1, -2.6f, 5, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_PICKAXE = add("t1_pickaxe", new T1PickaxeItem(T1Material.T1_MATERIAL, -2, -2.6f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_AXE = add("t1_axe", new T1AxeItem(T1Material.T1_MATERIAL, 3, -3f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_SHOVEL = add("t1_shovel", new T1ShovelItem(T1Material.T1_MATERIAL, -1.5f, -2.8f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_HOE = add("t1_hoe", new T1HoeItem(T1Material.T1_MATERIAL, -5, -0.9f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));

    public static final ToolItem T2_SWORD = add("t2_sword", new T2SwordItem(T2Material.T2_MATERIAL, 0, -2.2f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_DAGGER = add("t2_dagger", new T2DaggerItem(T2Material.T2_MATERIAL, -2, -1.5f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_SPEAR = add("t2_spear", new T2SpearItem(T2Material.T2_MATERIAL, 1, -2.6f, 6, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_PICKAXE = add("t2_pickaxe", new T2PickaxeItem(T2Material.T2_MATERIAL, -2, -2.6f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_AXE = add("t2_axe", new T2AxeItem(T2Material.T2_MATERIAL, 2, -2.8f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_SHOVEL = add("t2_shovel", new T2ShovelItem(T2Material.T2_MATERIAL, -1.5f, -2.8f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T2_HOE = add("t2_hoe", new T2HoeItem(T2Material.T2_MATERIAL, -6, 0.2f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        return item;
    }

    public static void register(){
        for (Identifier id : TOOLITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, TOOLITEMS.get(id));
        }
    }
}

