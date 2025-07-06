package dev.kirro.extendedcombat.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class SkyBoxBlockEntity extends BlockEntity {
    public SkyBoxBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SKYBOX_BLOCK, pos, state);
    }
}
