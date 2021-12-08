package tierability.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ElectricFieldEffect extends StatusEffect {
    public ElectricFieldEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xffdc33);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
