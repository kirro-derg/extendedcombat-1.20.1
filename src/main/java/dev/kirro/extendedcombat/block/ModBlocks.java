package dev.kirro.extendedcombat.block;

import dev.kirro.extendedcombat.ExtendedCombat;

import dev.kirro.extendedcombat.block.custom.FlatBlock;
import dev.kirro.extendedcombat.block.custom.FramedGlassPanelBlock;
import dev.kirro.extendedcombat.block.custom.HeavyDoor;

import dev.kirro.extendedcombat.block.custom.WardingStoneBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import net.minecraft.registry.Registry;

import java.util.List;

public class ModBlocks {

    public static final Block NETHER_STEEL_BLOCK = registerBlock("nether_steel_block",
            new Block(AbstractBlock.Settings.create().strength(100f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block WARDING_STONE = registerBlock("warding_stone",
            new WardingStoneBlock(AbstractBlock.Settings.create().strength(6f)
                    .sounds(BlockSoundGroup.DEEPSLATE_BRICKS).nonOpaque()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
                    tooltip.add(Text.translatable("tooltip.extendedcombat.warding_stone_ln1"));
                    tooltip.add(Text.translatable("tooltip.extendedcombat.warding_stone_ln2"));
                    tooltip.add(Text.translatable("tooltip.extendedcombat.warding_stone_ln3"));
                    super.appendTooltip(stack, world, tooltip, options);
                }

            });

    public static final Block FLAT_BLOCK = registerBlock("flat_block",
            new FlatBlock(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque().luminance(state -> 15)));



    public static final Block FRAMED_GLASS_PANEL = registerBlock("framed_glass_panel",
            new FramedGlassPanelBlock(AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque()));

    public static final Block HEAVY_DOOR = registerBlock("heavy_door",
            new HeavyDoor(AbstractBlock.Settings.create().strength(25f)
                    .requiresTool().sounds(BlockSoundGroup.METAL), BlockSetType.CHERRY));

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
            fabricItemGroupEntries.add(ModBlocks.FRAMED_GLASS_PANEL);
            fabricItemGroupEntries.add(ModBlocks.FLAT_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.HEAVY_DOOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.WARDING_STONE);
        });
    }
}
