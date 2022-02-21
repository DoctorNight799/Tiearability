package tierability.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import tierability.api.armor.ArmorEffectRegistry;
import tierability.item.armor.TierabilityArmor;
import tierability.util.ArmorUtils;

import java.util.Arrays;

public class TierabilityEvents {

    public static void register() {
        ServerTickEvents.START_WORLD_TICK.register((world) -> world.getPlayers().forEach((player) -> ArmorEffectRegistry.getArmorEffects().forEach(armorEffect -> {
            if(Arrays.equals(ArmorUtils.getArmorAsList(player), armorEffect.getArmorAsList())){
                if(armorEffect.getStatusEffect() != null && !player.hasStatusEffect(armorEffect.getStatusEffect())){
                    player.addStatusEffect(new StatusEffectInstance(armorEffect.getStatusEffect(), 60, armorEffect.getAmplifier(), false, false));
                }
                armorEffect.tick(player, world);
            }
        })));
    }
}
