package tierability.api.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import tierability.client.particles.TierabilityParticles;
import tierability.item.SingleSpellBookItem;
import tierability.util.EffectsUtils;

import java.util.Random;

public class Spells {

    public static final Spell EXPLOSION = new Spell((target, world, attacker, random) -> {
        if(!world.isClient){
            world.createExplosion(attacker, target.getX(), target.getY()+1, target.getZ(), 1f, Explosion.DestructionType.NONE);
        }
    }, 20*20, true);

    public static final Spell LIGHTNING_BOLT = new Spell((target, world, attacker, random) -> {
        BlockHitResult result = SingleSpellBookItem.longRaycast(attacker.world, (PlayerEntity) attacker);
        BlockPos pos = result.getBlockPos().add(0.5D, 0, 0.5D);
        if(world.isClient) {
            for(int i = 0; i<=7;i++) {
                world.addParticle(TierabilityParticles.ELECTRO_PARTICLE, pos.getX() + random.nextFloat(), pos.getY()+1 + random.nextFloat(), pos.getZ() + random.nextFloat(), 0, 0, 0);
            }
        }else{
            LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            bolt.updatePosition(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(bolt);
        }
    }, 30*20, false);

    public static final Spell INSTA_KILL = new Spell((target, world, attacker, random) -> {
        if(world.isClient){
            for(int i = 0; i<=7;i++) {
                world.addParticle(TierabilityParticles.SKULL_PARTICLE, target.getX() + random.nextFloat(), target.getY()+1 + random.nextFloat(), target.getZ() + random.nextFloat(), 0, 0, 0);
            }
        }else{
            target.kill();
        }
    }, 60*20, true);

    public static final Spell RANDOM_NEGATIVE_EFFECT = new Spell((target, world, attacker, random) -> {
        if(!world.isClient){
            target.addStatusEffect(new StatusEffectInstance(EffectsUtils.getRandomNegative(), 10*20, 0), attacker);
        }
    }, 20*20, true);

    public static final Spell RANDOM_POSITIVE_EFFECT = new Spell((target, world, attacker, random) -> {
        if(!world.isClient){
            target.addStatusEffect(new StatusEffectInstance(EffectsUtils.getRandomPositive(), 10*20, 0), attacker);
        }
    }, 20*20, true);

    public static final Spell CAST_FIREBALL = new Spell((target, world, attacker, random) -> {
        if(!world.isClient) {
            BlockHitResult result = SingleSpellBookItem.longRaycast(attacker.world, (PlayerEntity) attacker);
            BlockPos pos = result.getBlockPos().add(0.5D, 0, 0.5D);
            Vec3d vec3d = attacker.getRotationVec(1.0F);
            double x = pos.getX() - (attacker.getX() + vec3d.x * 4.0D);
            double y = pos.getY() - (0.5D + attacker.getBodyY(0.5D));
            double z = pos.getZ() - (attacker.getZ() + vec3d.z * 4.0D);
            FireballEntity fireballEntity = new FireballEntity(world, attacker, x, y, z, 2);
            fireballEntity.setPosition(attacker.getX() + vec3d.x * 4.0D, attacker.getBodyY(0.5D) + 0.5D, fireballEntity.getZ() + vec3d.z * 4.0D);
            world.spawnEntity(fireballEntity);
        }
    }, 25*20, false);

    public static final Spell HOOK_ENTITY = new Spell((target, world, attacker, random) -> {
        if(!world.isClient){
            double x1 = attacker.getX();
            double y1 = attacker.getY();
            double z1 = attacker.getZ();
            float yaw1 = attacker.getYaw();
            float pitch1 = attacker.getPitch();
            target.updatePositionAndAngles(x1, y1, z1, yaw1, pitch1);
        }
    }, 5*20, true);

    public static final Spell CHANGE_WITH_ENTITY = new Spell((target, world, attacker, random) -> {
        if(!world.isClient){
            double x = target.getX();
            double y = target.getY();
            double z = target.getZ();
            float yaw = target.getYaw();
            float pitch = target.getPitch();
            double x1 = attacker.getX();
            double y1 = attacker.getY();
            double z1 = attacker.getZ();
            float yaw1 = attacker.getYaw();
            float pitch1 = attacker.getPitch();
            target.updatePositionAndAngles(x1, y1, z1, yaw1, pitch1);
            attacker.teleport(x, y, z);
            attacker.setYaw(yaw);
            attacker.setPitch(pitch);
        }
    }, 10*20, true);

    public static final Spell CHANGE_ENTITY_POS = new Spell((target, world, attacker, random) -> {
        if (!world.isClient) {
            double d = target.getX();
            double e = target.getY();
            double f = target.getZ();

            for(int i = 0; i < 16; ++i) {
                double g = target.getX() + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
                double h = MathHelper.clamp(target.getY() + (double)(target.getRandom().nextInt(16) - 8), world.getBottomY(), (world.getBottomY() + (world).getHeight() - 1));
                double j = target.getZ() + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (target.hasVehicle()) {
                    target.stopRiding();
                }

                if (target.teleport(g, h, j, true)) {
                    SoundEvent soundEvent = target instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    target.playSound(soundEvent, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }, 10*20, true);

    public record Spell(Invoker invoker, int coolDown, boolean requiresEntity) {
    }

    public interface Invoker {
        void invoke(LivingEntity target, World world, LivingEntity attacker, Random random);
    }
}
