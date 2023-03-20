package net.kaupenjoe.tutorialmod.world.dimensions;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class ModDimensions {
	public static RegistryKey<World> KJDIM_DIMESION_KEY = RegistryKey.of(Registry.WORLD_KEY,
			new Identifier(MODID, "kjdim"));

	static final RegistryKey<DimensionType> KJDIM_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
			KJDIM_DIMESION_KEY.getValue());


    public static void register() { TutorialMod.LOGGER.debug("Registering ModDimensions for " + MODID); }
}
