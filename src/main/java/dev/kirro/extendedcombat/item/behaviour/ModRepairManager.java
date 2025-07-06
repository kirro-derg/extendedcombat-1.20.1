package dev.kirro.extendedcombat.item.behaviour;

import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModRepairManager {
    public static final Set<Item> REPAIRABLE_ITEMS = Set.of(
            ModItems.NETHER_STEEL_GREATSWORD,
            ModItems.NETHER_STEEL_PICKAXE,
            ModItems.NETHER_STEEL_HELMET,
            ModItems.NETHER_STEEL_CHESTPLATE,
            ModItems.NETHER_STEEL_LEGGINGS,
            ModItems.NETHER_STEEL_BOOTS
    );

    public static void repairItemsWithXP(PlayerEntity player, int xpAmount) {
        List<ItemStack> allItems = new ArrayList<>();
        allItems.addAll(player.getInventory().main);
        allItems.addAll(player.getInventory().armor);


        for (ItemStack stack : allItems) {
            if (stack != null && REPAIRABLE_ITEMS.contains(stack.getItem()) && stack.isDamaged()) {
                int repairAmount = xpAmount * 2;
                int damage = stack.getDamage();
                int toRepair = Math.min(repairAmount, damage);

                stack.setDamage(damage - toRepair);
                xpAmount -= toRepair / 2;

                if (xpAmount <= 0) break;
            }
        }
    }
}
