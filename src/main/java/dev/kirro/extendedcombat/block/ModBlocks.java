package dev.kirro.extendedcombat.block;

import dev.kirro.extendedcombat.ExtendedCombat;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    public static final Block NETHER_STEEL_BLOCK = registerBlock("nether_steel_block",
            new Block(AbstractBlock.Settings.create().strength(100f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block WARDING_BLOCK = registerBlock("warding_block",
            new Block(AbstractBlock.Settings.create().strength(6f)
                    .sounds(BlockSoundGroup.WART_BLOCK)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
                    tooltip.add(Text.translatable("tooltip.extendedcombat.warding_block"));
                    super.appendTooltip(stack, world, tooltip, options);
                }
            });

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExtendedCombat.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ExtendedCombat.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }


    public static void registerModBlocks() {
        ExtendedCombat.LOGGER.info("Registering blocks for " + ExtendedCombat.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.NETHER_STEEL_BLOCK);
        });
    }
}
