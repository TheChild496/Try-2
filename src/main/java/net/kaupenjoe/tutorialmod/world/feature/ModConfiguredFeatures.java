package net.kaupenjoe.tutorialmod.world.feature;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_MUSGRAVITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MUSGRAVITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MUSGRAVITE_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> END_MUSGRAVITE_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.END_MUSGRAVITE_ORE.getDefaultState()));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MUSGRAVITE_ORE =
            ConfiguredFeatures.register("musgravite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_MUSGRAVITE_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> END_MUSGRAVITE_ORE =
            ConfiguredFeatures.register("end_musgravite_ore",Feature.ORE, new OreFeatureConfig(END_MUSGRAVITE_ORES, 12));

    public static void registerConfiguredFeatures() {
        TutorialMod.LOGGER.debug("Registering the ModConfiguredFeatures for " + MODID);
    }
}
