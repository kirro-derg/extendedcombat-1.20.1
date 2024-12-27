package dev.kirro.extendedcombat.item;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.kirro.extendedcombat.item.custom.ModArmorMaterial;
import dev.kirro.extendedcombat.item.custom.ModToolMaterials;
import dev.kirro.extendedcombat.item.custom.PickSwordItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item NETHER_STEEL_INGOT = registerItem("nether_steel_ingot", new Item(new Item.Settings()));
    public static final Item HANDLE = registerItem("handle", new Item(new Item.Settings()));
    public static final Item NETHER_STEEL_UPGRADE = registerItem("nether_steel_upgrade", new Item(new Item.Settings()));

    public static final Item NETHER_STEEL_GREATSWORD = registerItem("nether_steel_greatsword",
            new PickSwordItem(ModToolMaterials.NETHER_STEEL, 10, -2.7f, new Item.Settings()));

    public static final Item NETHER_STEEL_HELMET = registerItem("nether_steel_helmet",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item NETHER_STEEL_CHESTPLATE = registerItem("nether_steel_chestplate",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item NETHER_STEEL_LEGGINGS = registerItem("nether_steel_leggings",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item NETHER_STEEL_BOOTS = registerItem("nether_steel_boots",
            new ArmorItem(ModArmorMaterial.NETHER_STEEL, ArmorItem.Type.BOOTS, new Item.Settings()));

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
    }
}
