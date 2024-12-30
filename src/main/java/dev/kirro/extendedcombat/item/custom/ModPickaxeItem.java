package dev.kirro.extendedcombat.item.custom;


import dev.kirro.extendedcombat.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;


public class ModPickaxeItem extends PickaxeItem {
    public ModPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(ModBlocks.WARDING_STONE)){
            return 20f;
        } else {
            return state.isIn(BlockTags.PICKAXE_MINEABLE) ? 20F : 1.0F;
        }
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        boolean result = true;
        if (state.isIn(BlockTags.PICKAXE_MINEABLE)) {
            result =  state.isIn(BlockTags.PICKAXE_MINEABLE);
        }
        return result;
    }
}
