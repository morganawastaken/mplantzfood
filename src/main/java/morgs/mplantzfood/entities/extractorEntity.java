package morgs.mplantzfood.entities;

import morgs.mplantzfood.setup.blockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class extractorEntity extends BlockEntity {
    public extractorEntity(BlockPos pos, BlockState state) {
        super(blockEntities.EXTRACTOR_ENTITY, pos, state);
    }
}
