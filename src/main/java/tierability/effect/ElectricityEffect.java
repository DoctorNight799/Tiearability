package tierability.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ElectricityEffect extends StatusEffect {
    public ElectricityEffect() {
        super(StatusEffectCategory.HARMFUL, 0xfde910);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(DamageSource.MAGIC, 0.5f*(amplifier + 1));
        super.applyUpdateEffect(entity, amplifier);
    }
}
