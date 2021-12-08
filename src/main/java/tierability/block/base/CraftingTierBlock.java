package tierability.block.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.client.models.BasePatterns;
import ru.bclib.client.models.ModelsHelper;
import ru.bclib.client.models.PatternsHelper;
import ru.bclib.interfaces.BlockModelProvider;
import tierability.screen.TierCraftingScreenHandler;

import java.io.Serial;
import java.util.HashMap;
import java.util.Optional;

public class CraftingTierBlock extends Block implements BlockModelProvider {

    private static final Text SCREEN_TITLE = new TranslatableText("container.tier");

    public CraftingTierBlock(int miningLevel) {
        super(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(2.0f, 1.0f).sounds(BlockSoundGroup.STONE));
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new TierCraftingScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), SCREEN_TITLE);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            player.incrementStat(Stats.INTERACT_WITH_SMITHING_TABLE);
            return ActionResult.CONSUME;
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public JsonUnbakedModel getItemModel(Identifier resourceLocation) {
        return getBlockModel(resourceLocation, getDefaultState());
    }

    @Override
    @Environment(EnvType.CLIENT)
    public @Nullable JsonUnbakedModel getBlockModel(Identifier blockId, BlockState blockState) {
        String blockName = blockId.getPath();
        Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_SIDED, new HashMap<String, String>() {
            @Serial
            private static final long serialVersionUID = 1L;

            {
                put("%modid%", blockId.getNamespace());
                put("%particle%", blockName + "_top");
                put("%down%", blockName + "_bottom");
                put("%up%", blockName + "_top");
                put("%north%", blockName + "_front_t1");
                put("%south%", blockName + "_front_t2");
                put("%west%", blockName + "_side_t1");
                put("%east%", blockName + "_side_t2");
            }
        });
        return ModelsHelper.fromPattern(pattern);
    }
}
