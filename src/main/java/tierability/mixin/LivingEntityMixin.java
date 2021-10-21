package tierability.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tierability.item.AmuletItem;
import tierability.item.BottleWithPoisonItem;
import tierability.item.TierabilityItems;
import tierability.item.tool.TierabilityTools;
import tierability.item.tool.soulcollector.SoulcollectorSwordItem;
import tierability.util.TrinketsUtils;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    LivingEntity entity = ((LivingEntity) (Object) this);

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage (DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if(source.getAttacker() instanceof PlayerEntity player) {
            for(int i = 0; i <= player.getInventory().size(); i++){
                ItemStack stack = player.getInventory().getStack(i);
                if(!stack.isEmpty() && stack.getItem() instanceof BottleWithPoisonItem item){
                    entity.setStatusEffect(new StatusEffectInstance(StatusEffects.POISON, item.duration, item.amplifier), player);
                    return;
                }
            }
        }
        if(entity instanceof PlayerEntity player){
            if(TrinketsUtils.containsTrinket(player, TierabilityItems.SAFE_AMULET)){
                AmuletItem.activate(player);
            }
        }
    }

    @Inject(method="onDeath", at = @At("TAIL"))
    void onDeath(DamageSource source, CallbackInfo ci){
        if(source.getAttacker() instanceof LivingEntity attacker){
            if(attacker.getStackInHand(Hand.MAIN_HAND).isOf(TierabilityTools.SOULCOLLECTOR)) {
                if (!entity.world.isClient) {
                    ItemStack attackerStack = attacker.getStackInHand(Hand.MAIN_HAND);
                    int killCount = SoulcollectorSwordItem.getKillCount(attackerStack);
                    if(!(killCount == 1000)){
                        SoulcollectorSwordItem.setKillCount(attackerStack, killCount + 1);
                    }
                    ((ServerWorld)entity.world).spawnParticles(ParticleTypes.SOUL, entity.getX(), entity.getY()+1, entity.getZ(), 1, 0,0,0, 0);
                }
            }
        }
    }
}
