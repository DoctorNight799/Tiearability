package tierability.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.item.tool.t1.T1DaggerItem;
import tierability.item.tool.t1.T1Material;
import tierability.item.tool.t1.T1SpearItem;
import tierability.item.tool.t1.T1SwordItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierAbilityTools {

    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem T1_SWORD = add("t1_sword", new T1SwordItem(T1Material.T1_MATERIAL, 0, -2.2f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_DAGGER = add("t1_dagger", new T1DaggerItem(T1Material.T1_MATERIAL, -2, -1.5f, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));
    public static final ToolItem T1_SPEAR = add("t1_spear", new T1SpearItem(T1Material.T1_MATERIAL, 0, 0, 5, new Item.Settings().group(TierabilityMod.ITEM_GROUP_ITEMS)));

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

