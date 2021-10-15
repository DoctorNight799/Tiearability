package tierability.item.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TierableItem extends BasedItem {
    public TierableItem(Settings settings) {
        super(settings);
    }

    public static int getCurrentTier(ItemStack stack){
        if(stack.getOrCreateNbt().getInt("Tier") >= 2) return stack.getOrCreateNbt().getInt("Tier");
        else return 1;
    }

    public static ItemStack withTier(Item item, int tier){
        ItemStack itemStack = new ItemStack(item);
        if (tier >= 2){
            itemStack.getOrCreateNbt().putInt("Tier", tier);
        }
        return itemStack;
    }

}
