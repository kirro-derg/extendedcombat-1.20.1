package dev.kirro.extendedcombat.item.custom;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.kirro.extendedcombat.block.ModBlocks;
import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
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

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            builder.putAll(super.getAttributeModifiers(equipmentSlot));
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(
                    "Weapon range modifier",
                    0.55, // The additional reach range you want to add
                    EntityAttributeModifier.Operation.ADDITION
            ));
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(
                    "Weapon reach modifier",
                    0.55, // The additional reach range you want to add
                    EntityAttributeModifier.Operation.ADDITION
            ));

        }

        return builder.build();
    }




}
