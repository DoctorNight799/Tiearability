package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import ru.bclib.blocks.BaseBlock;

import java.util.Collections;
import java.util.List;

public class BasedBlock extends BaseBlock {

    public BasedBlock(FabricBlockSettings settings) {
        super(settings);
    }

    public BasedBlock(int miningLevel, float hardness, float resistance){
        super(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness,resistance).sounds(BlockSoundGroup.STONE));
    }

    public BasedBlock(float hardness, float resistance){
        super(FabricBlockSettings.of(Material.METAL).requiresTool().strength(hardness,resistance).sounds(BlockSoundGroup.METAL));
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        Identifier identifier = this.getLootTableId();
        if (identifier == LootTables.EMPTY) {
            return Collections.emptyList();
        }
        LootContext lootContext = builder.parameter(LootContextParameters.BLOCK_STATE, state).build(LootContextTypes.BLOCK);
        ServerWorld serverWorld = lootContext.getWorld();
        LootTable lootTable = serverWorld.getServer().getLootManager().getTable(identifier);
        return lootTable.generateLoot(lootContext);
    }


}
