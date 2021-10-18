package tierability.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.item.base.BasedItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class TierabilityItems {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item T1_SHARD = add("t1_shard", new BasedItem(settings()));
    public static final Item T1_INGOT = add("t1_ingot", new BasedItem(settings()));
    public static final Item T2_SHARD = add("t2_shard", new BasedItem(settings()));
    public static final Item T2_POWDER = add("t2_powder", new BasedItem(settings()));
    public static final Item T2_INGOT = add("t2_ingot", new BasedItem(settings()));
    public static final Item BOTTLE_WITH_POISON = add("bottle_with_poison", new BottleWithPoisonItem(settings().maxCount(1)));


    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(TierabilityMod.ITEM_GROUP_ITEMS);
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
    }
}
