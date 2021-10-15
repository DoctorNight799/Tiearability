package tierability.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tierability.item.TierabilityItems;
import tierability.item.base.TierableItem;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    LivingEntity entity = ((LivingEntity) (Object) this);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage (DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        Entity player = source.getAttacker();
        ItemStack stack = new ItemStack(TierabilityItems.BOTTLE_WITH_POISON);
        if(player instanceof PlayerEntity) {
            if (((PlayerEntity) player).getInventory().contains(stack)) {
                switch (TierableItem.getCurrentTier(stack)) {
                    case (1):
                        entity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100), player);
                        break;
                    case(2):
                        entity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 160), player);
                        break;
                    case(3):
                        entity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 1), player);
                        break;
                    case(4):
                        entity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 240, 2), player);
                        break;
                }
            }
        }
    }
}
