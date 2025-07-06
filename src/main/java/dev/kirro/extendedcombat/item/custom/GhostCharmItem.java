package dev.kirro.extendedcombat.item.custom;

import dev.kirro.extendedcombat.component.ExtendedCombatComponents;
import dev.kirro.extendedcombat.component.GhostCharmComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class GhostCharmItem extends Item {

    public GhostCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player == null) return ActionResult.PASS;
        World world = context.getWorld();

        if (!world.isClient) {
            GhostCharmComponent component = ExtendedCombatComponents.GHOST_CHARM_COMPONENT.get(player);
            boolean currentState = component.isInvisible();

            component.setInvisible(!currentState);
            player.setInvisible(!currentState);

            if (!currentState) {
                player.sendMessage(Text.literal("You are now invisible."), true);
            } else {
                player.sendMessage(Text.literal("You are now visible."), true);
            }

            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON, SoundCategory.PLAYERS, 1.0F, 1.0F);
            context.getStack().damage(1, player, p -> p.sendToolBreakStatus(context.getHand()));
        }
        return ActionResult.SUCCESS;
    }
}