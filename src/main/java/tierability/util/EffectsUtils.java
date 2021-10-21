package tierability.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EffectsUtils {
    public static final ArrayList<StatusEffect> NEGATIVE_EFFECTS = new ArrayList<>(List.of(StatusEffects.BLINDNESS, StatusEffects.INSTANT_DAMAGE,
            StatusEffects.BAD_OMEN, StatusEffects.HUNGER, StatusEffects.LEVITATION, StatusEffects.NAUSEA, StatusEffects.POISON, StatusEffects.SLOWNESS,
            StatusEffects.UNLUCK, StatusEffects.WEAKNESS,StatusEffects.WITHER, StatusEffects.MINING_FATIGUE, StatusEffects.INVISIBILITY));
    public static final ArrayList<StatusEffect> POSITIVE_EFFECTS = new ArrayList<>(List.of(StatusEffects.HASTE, StatusEffects.SPEED, StatusEffects.RESISTANCE,
            StatusEffects.FIRE_RESISTANCE, StatusEffects.DOLPHINS_GRACE, StatusEffects.ABSORPTION, StatusEffects.HERO_OF_THE_VILLAGE, StatusEffects.GLOWING,
            StatusEffects.HEALTH_BOOST, StatusEffects.INSTANT_HEALTH, StatusEffects.REGENERATION, StatusEffects.STRENGTH, StatusEffects.JUMP_BOOST,
            StatusEffects.LUCK, StatusEffects.SATURATION, StatusEffects.NIGHT_VISION, StatusEffects.SLOW_FALLING, StatusEffects.WATER_BREATHING));

    public static StatusEffect getRandomNegative(){
        return NEGATIVE_EFFECTS.get(new Random().nextInt(NEGATIVE_EFFECTS.size()));
    }

    public static StatusEffect getRandomPositive(){
        return POSITIVE_EFFECTS.get(new Random().nextInt(POSITIVE_EFFECTS.size()));
    }

    public static void add(LivingEntity entity, StatusEffect effect, int duration, int amplifier){
        entity.addStatusEffect(new StatusEffectInstance(effect, duration, amplifier));
    }
}
