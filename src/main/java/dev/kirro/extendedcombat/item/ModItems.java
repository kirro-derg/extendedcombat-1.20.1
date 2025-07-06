package dev.kirro.extendedcombat.item;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.kirro.extendedcombat.item.custom.*;
//import dev.kirro.extendedcombat.trinkets.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    public static final Item NETHER_STEEL_INGOT = registerItem("nether_steel_ingot", new Item(new Item.Settings().fireproof()) {
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext options) {
            tooltip.add(Text.translatable("tooltip.extendedcombat.nether_steel_ingot"));
            super.appendTooltip(stack, world, tooltip, options);
        }

    });
    public static final Item HANDLE = registerItem("handle", new Item(new Item.Settings().fireproof()));
    public static final Item NETHER_STEEL_UPGRADE = registerItem("nether_steel_upgrade", new Item(new Item.Settings().fireproof()));
    public static final Item GHOST_CHARM = registerItem("ghost_charm", new GhostCharmItem(new Item.Settings().fireproof().maxCount(1)));

    public static final Item NETHER_STEEL_GREATSWORD = registerItem("nether_steel_greatsword",
            new PickSwordItem(ModToolMaterials.NETHER_STEEL, 7, -2.4f, new Item.Settings().fireproof()));
    public static final Item NETHER_STEEL_PICKAXE = registerItem("nether_steel_pickaxe",
            new ModPickaxeItem(ModToolMaterials.NETHER_STEEL, 1, -3f, new Item.Settings().fireproof()));

    public static final Item NETHER_STEEL_HELMET = registerItem("nether_steel_helmet",
            new ModArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(8124).fireproof()));
    public static final Item NETHER_STEEL_CHESTPLATE = registerItem("nether_steel_chestplate",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(8124).fireproof()));
    public static final Item NETHER_STEEL_LEGGINGS = registerItem("nether_steel_leggings",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(8124).fireproof()));
    public static final Item NETHER_STEEL_BOOTS = registerItem("nether_steel_boots",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(8124).fireproof()));

    //public static final Item WOOL_SLEEVES_RIGHT = registerItem("wool_sleeve_right",
    //        new SleeveItemRight(new Item.Settings().maxCount(1)));
    //public static final Item WOOL_SLEEVES_LEFT = registerItem("wool_sleeve_left",
    //        new SleeveItemLeft(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExtendedCombat.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExtendedCombat.LOGGER.info("Registering items for " + ExtendedCombat.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(NETHER_STEEL_INGOT);
            fabricItemGroupEntries.add(HANDLE);
            fabricItemGroupEntries.add(NETHER_STEEL_UPGRADE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(NETHER_STEEL_GREATSWORD);
            fabricItemGroupEntries.add(ModItems.NETHER_STEEL_BOOTS);
            fabricItemGroupEntries.add(ModItems.NETHER_STEEL_LEGGINGS);
            fabricItemGroupEntries.add(ModItems.NETHER_STEEL_CHESTPLATE);
            fabricItemGroupEntries.add(ModItems.NETHER_STEEL_HELMET);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(NETHER_STEEL_PICKAXE);
        });
    }
}
