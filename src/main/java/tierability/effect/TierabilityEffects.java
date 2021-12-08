package tierability.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class TierabilityEffects {

    private static final Map<Identifier, StatusEffect> EFFECTS = new LinkedHashMap<>();

    public static final StatusEffect ELECTRICITY_EFFECT = add("electricity_effect", new ElectricityEffect());
    public static final StatusEffect ELECTRIC_FIELD_EFFECT = add("electric_field_effect", new ElectricFieldEffect());
    public static final StatusEffect PARALYSE_EFFECT = add("paralyse_effect", new ParalyseEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, UUID.randomUUID().toString(), -1D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, UUID.randomUUID().toString(), -0.7d, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    private static <S extends StatusEffect> S add(String name, S effect) {
        EFFECTS.put(new Identifier(TierabilityMod.MODID, name), effect);
        return effect;
    }

    public static void register(){
        EFFECTS.forEach((id, effect) -> Registry.register(Registry.STATUS_EFFECT, id, EFFECTS.get(id)));
    }
}
