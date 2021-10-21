package tierability.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import tierability.api.item.Spells;
import tierability.item.base.BasedItem;

import java.util.ArrayList;

public class RandomSpellBook extends BasedItem {

    public final ArrayList<Spells.Spell> spells;

    public RandomSpellBook(Settings settings, ArrayList<Spells.Spell> spells) {
        super(settings.maxCount(1));
        this.spells = spells;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        ArrayList<Spells.Spell> spellsThatRequiresEntity = new ArrayList<>();
        spells.forEach(spell -> {
            if(spell.requiresEntity()){
                spellsThatRequiresEntity.add(spell);
            }
        });
        if(user.getItemCooldownManager().isCoolingDown(this)){
            return ActionResult.FAIL;
        }
        var spell = spellsThatRequiresEntity.get(user.getRandom().nextInt(spellsThatRequiresEntity.size()));
        spell.invoker().invoke(entity, entity.world, user, user.getRandom());
        user.getItemCooldownManager().set(this, spell.coolDown());
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ArrayList<Spells.Spell> spellsThatNotRequiresEntity = new ArrayList<>();
        spells.forEach(spell -> {
            if(!spell.requiresEntity()){
                spellsThatNotRequiresEntity.add(spell);
            }
        });
        if(user.getItemCooldownManager().isCoolingDown(this)){
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        if(spellsThatNotRequiresEntity.isEmpty()){
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        var spell = spellsThatNotRequiresEntity.get(user.getRandom().nextInt(spellsThatNotRequiresEntity.size()));
        spell.invoker().invoke(null, user.world, user, user.getRandom());
        user.getItemCooldownManager().set(this, spell.coolDown());
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public static BlockHitResult longRaycast(World world, PlayerEntity player) {
        float f = player.getPitch();
        float g = player.getYaw();
        Vec3d vec3d = player.getCameraPosVec(1.0F);
        float h = MathHelper.cos(-g * 0.017453292F - 3.1415927F);
        float i = MathHelper.sin(-g * 0.017453292F - 3.1415927F);
        float j = -MathHelper.cos(-f * 0.017453292F);
        float k = MathHelper.sin(-f * 0.017453292F);
        float l = i * j;
        float n = h * j;
        Vec3d vec3d2 = vec3d.add((double)l * 100.0D, (double)k * 100.0D, (double)n * 100.0D);
        return world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
