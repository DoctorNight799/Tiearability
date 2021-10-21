package tierability.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import tierability.item.base.BaseTrinketItem;
import tierability.util.EffectsUtils;

public class AmuletItem extends BaseTrinketItem {
    public AmuletItem(Settings settings) {
        super(settings);
    }

    public static void activate(LivingEntity entity){
        if(entity instanceof PlayerEntity player) {
            if(!player.getItemCooldownManager().isCoolingDown(TierabilityItems.SAFE_AMULET)) {
                if (player.getHealth() <= 5) {
                    player.world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1F,1 );
                    EffectsUtils.add(player, StatusEffects.RESISTANCE, 5*20, 255);
                    EffectsUtils.add(player, StatusEffects.REGENERATION, 10*20, 0);
                    player.getItemCooldownManager().set(TierabilityItems.SAFE_AMULET, 10 * 20);
                }
            }
        }
    }
}
