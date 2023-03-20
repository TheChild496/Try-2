package net.kaupenjoe.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class ModBlocks {
    public static final Block MUSGRAVITE_BLOCK = registerBlock("musgravite_block",
            new MusgraviteBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.MUSGRAVITE);

    public static final Block MUSGRAVITE_ORE = registerBlock("musgravite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.MUSGRAVITE);
    public static final Block DEEPSLATE_MUSGRAVITE_ORE = registerBlock("deepslate_musgravite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.MUSGRAVITE);

    public static final Block END_MUSGRAVITE_ORE = registerBlock("end_musgravite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.MUSGRAVITE);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.debug("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
