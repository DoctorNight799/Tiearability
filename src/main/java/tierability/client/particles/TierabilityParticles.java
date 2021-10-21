package tierability.client.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;

public class TierabilityParticles {

    public static final DefaultParticleType SKULL_PARTICLE = add("skull_particle");
    public static final DefaultParticleType ELECTRO_PARTICLE = add("electro_particle");

    public static void register() {
        ParticleFactoryRegistry.getInstance().register(SKULL_PARTICLE, SkullParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ELECTRO_PARTICLE, SkullParticle.Factory::new);
    }

    private static DefaultParticleType add(String name) {
        return Registry.register(Registry.PARTICLE_TYPE, TierabilityMod.newId(name), FabricParticleTypes.simple());
    }
}
