package tierability.util;

import net.minecraft.item.ItemStack;

public class SoulCountUtil {

    public static void setKillCount(ItemStack stack, int count){
        stack.getOrCreateNbt().putInt("killCount", count);
    }

    public static int getKillCount(ItemStack stack){
        return stack.getOrCreateNbt().getInt("killCount");
    }

    public static int getDamage(ItemStack stack){
        int count = getKillCount(stack);
        float damage = (float) count/100;
        return (int) damage;
    }
}
