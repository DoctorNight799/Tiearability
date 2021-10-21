package tierability.item;

import net.minecraft.item.ItemStack;
import tierability.item.base.BasedItem;

public class BottleWithPoisonItem extends BasedItem {

    public final int duration;
    public final int amplifier;
    public BottleWithPoisonItem(Settings settings, int duration, int amplifier) {
        super(settings.maxCount(1));
        this.duration = duration;
        this.amplifier = amplifier;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
