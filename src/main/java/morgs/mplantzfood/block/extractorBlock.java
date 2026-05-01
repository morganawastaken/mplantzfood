package morgs.mplantzfood.block;

import com.mojang.serialization.MapCodec;
import morgs.mplantzfood.entities.extractorEntity;
import morgs.mplantzfood.setup.items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class extractorBlock extends BaseEntityBlock {
    public extractorBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(extractorBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new extractorEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof extractorEntity counterBlockEntity)) {
            return super.useWithoutItem(state, level, pos, player, hit);
        }

        if (!level.isClientSide()) {
            Vec3 itemPos = Vec3.atLowerCornerWithOffset(pos, (double) 0.5F, 1.01, (double) 0.5F).offsetRandomXZ(level.getRandom(), 0.7F);
            ItemEntity entity = new ItemEntity(level, itemPos.x(), itemPos.y(), itemPos.z(), new ItemStack(items.dna));
            entity.setDefaultPickUpDelay();
            level.addFreshEntity(entity);
        }
        return InteractionResult.SUCCESS;
    }
}
