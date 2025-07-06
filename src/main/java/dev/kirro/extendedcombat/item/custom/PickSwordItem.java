package dev.kirro.extendedcombat.item.custom;

import dev.kirro.extendedcombat.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PickSwordItem extends SwordItem {

    public PickSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);

    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15f;
        } else if (state.isIn(BlockTags.PICKAXE_MINEABLE)){
            return 15f;
        } else if (state.isIn(BlockTags.AXE_MINEABLE)) {
            return 15f;
        } else if (state.isIn(BlockTags.WOOL)){
            return 15f;
        } else if (state.isOf(ModBlocks.WARDING_STONE)){
            return 15f;
        } else {
            return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1f;
        }
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        boolean result = true;
        if (state.isIn(BlockTags.PICKAXE_MINEABLE)) {
            result =  state.isIn(BlockTags.PICKAXE_MINEABLE);
        } else if (state.isIn(BlockTags.AXE_MINEABLE)) {
            result = state.isIn(BlockTags.AXE_MINEABLE);
        } else if (state.isIn(BlockTags.WOOL)) {
            result = state.isIn(BlockTags.WOOL);
        }
        return result;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }



    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        SwordBlockingComponent component = ExtendedCombatEntityComponents.SWORD_BLOCKING_COMPONENT.get(player);

        if (!world.isClient) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (player.getMainHandStack().isOf(ModItems.NETHER_STEEL_GREATSWORD)) {
                player.setCurrentHand(hand);
                component.setBlocking(true);
                player.sendMessage(Text.literal("You are now blocking"), true);
                return TypedActionResult.success(itemStack);
            } else {
                component.setBlocking(false);
                player.sendMessage(Text.literal("You are no longer blocking"), true);
                return TypedActionResult.fail(itemStack);
            }
        } else {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
    }*/
}
