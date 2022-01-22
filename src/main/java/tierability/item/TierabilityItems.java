package tierability.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.api.item.Spells;
import tierability.item.base.BasedItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class TierabilityItems {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item CRIMSON_STICK = add("crimson_stick", new BasedItem(settings()));
    public static final Item T1_SHARD = add("t1_shard", new BasedItem(settings()));
    public static final Item T1_INGOT = add("t1_ingot", new BasedItem(settings()));
    public static final Item T1_ORB = add("t1_orb", new BasedItem(settings()));
    public static final Item T2_SHARD = add("t2_shard", new BasedItem(settings()));
    public static final Item T2_POWDER = add("t2_powder", new BasedItem(settings()));
    public static final Item T2_INGOT = add("t2_ingot", new BasedItem(settings()));
    public static final Item T2_ORB = add("t2_orb", new BasedItem(settings()));
    public static final Item T3_SCRAP = add("t3_scrap", new BasedItem(settings()));
    public static final Item T3_INGOT = add("t3_ingot", new BasedItem(settings()));
    public static final Item T3_ORB = add("t3_orb", new BasedItem(settings()));
    public static final Item FLAME_SHARD = add("flame_shard", new BasedItem(settings()));
    public static final Item ELECTRO_SHARD = add("electro_shard", new BasedItem(settings()));
    public static final Item SOUL_SHARD = add("soul_shard", new BasedItem(settings()));
    public static final Item NATURE_SHARD = add("nature_shard", new BasedItem(settings()));
    public static final Item SOUL_FRAGMENT = add("soul_fragment", new BasedItem(settings()));
    public static final Item SOUL = add("soul", new BasedItem(settings()));
    public static final Item FLAME_INGOT = add("flame_ingot", new BasedItem(settings()));
    public static final Item ELECTRO_INGOT = add("electro_ingot", new BasedItem(settings()));
    public static final Item SOUL_INGOT = add("soul_ingot", new BasedItem(settings()));
    public static final Item NATURE_INGOT = add("nature_ingot", new BasedItem(settings()));
    public static final Item BOTTLE_WITH_POISON_T1 = add("bottle_with_poison_t1", new BottleWithPoisonItem(artSettings(), 100, 0));
    public static final Item BOTTLE_WITH_POISON_T2 = add("bottle_with_poison_t2", new BottleWithPoisonItem(artSettings(), 160, 0));
    public static final Item BOTTLE_WITH_POISON_T3 = add("bottle_with_poison_t3", new BottleWithPoisonItem(artSettings(), 200, 1));
    public static final Item BOTTLE_WITH_POISON_T4 = add("bottle_with_poison_t4", new BottleWithPoisonItem(artSettings(), 240, 2));
    public static final Item EXPLOSION_SPELL_BOOK = add("explosion_book", new SingleSpellBookItem(artSettings(), Spells.EXPLOSION));
    public static final Item LIGHTNING_BOLT_SPELL_BOOK = add("lightning_bolt_book", new SingleSpellBookItem(artSettings(), Spells.LIGHTNING_BOLT));
    public static final Item INSTA_KILL_SPELL_BOOK = add("death_note", new SingleSpellBookItem(artSettings(), Spells.INSTA_KILL));
    public static final Item NEGATIVE_EFFECT_SPELL_BOOK = add("negative_book", new SingleSpellBookItem(artSettings(), Spells.RANDOM_NEGATIVE_EFFECT));
    public static final Item POSITIVE_EFFECT_SPELL_BOOK = add("positive_book", new SingleSpellBookItem(artSettings(), Spells.RANDOM_POSITIVE_EFFECT));
    public static final Item FIREBALL_SPELL_BOOK = add("fireball_book", new SingleSpellBookItem(artSettings(), Spells.CAST_FIREBALL));
    public static final Item HOOK_SPELL_BOOK = add("hook_book", new SingleSpellBookItem(artSettings(), Spells.HOOK_ENTITY));
    public static final Item TELEPORT_SPELL_BOOK = add("teleport_book", new SingleSpellBookItem(artSettings(), Spells.CHANGE_ENTITY_POS));
    public static final Item SWAP_SPELL_BOOK = add("swap_book", new SingleSpellBookItem(artSettings(), Spells.CHANGE_WITH_ENTITY));
    public static final Item RANDOM_SPELL_BOOK_T1 = add("random_book_t1", new RandomSpellBook(artSettings(), new ArrayList<>(List.of(Spells.HOOK_ENTITY, Spells.CHANGE_ENTITY_POS, Spells.CHANGE_WITH_ENTITY, Spells.EXPLOSION))));
    public static final Item RANDOM_SPELL_BOOK_T2 = add("random_book_t2", new RandomSpellBook(artSettings(), new ArrayList<>(List.of(Spells.HOOK_ENTITY, Spells.CHANGE_ENTITY_POS, Spells.CHANGE_WITH_ENTITY, Spells.EXPLOSION, Spells.CAST_FIREBALL, Spells.LIGHTNING_BOLT, Spells.RANDOM_NEGATIVE_EFFECT, Spells.RANDOM_POSITIVE_EFFECT))));
    public static final Item SAFE_AMULET = add("safe_amulet", new AmuletItem(artSettings().maxCount(1)));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(TierabilityMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(TierabilityMod.ITEM_GROUP_MATERIALS);
    }

    private static FabricItemSettings artSettings(){
        return new FabricItemSettings().group(TierabilityMod.ITEM_GROUP_ARTIFACTS);
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
    }
}
