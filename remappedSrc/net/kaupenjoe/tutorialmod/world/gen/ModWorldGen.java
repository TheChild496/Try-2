package net.kaupenjoe.tutorialmod.world.gen;

public class ModWorldGen {
    public static void generateWorldGen() {

		ModOreGeneration.generateOres();

        ModEntitySpawn.addEntitySpawn();
    }
}
