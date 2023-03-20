package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.item.custom.ModAxeItem;
import net.kaupenjoe.tutorialmod.item.custom.ModHoeItem;
import net.kaupenjoe.tutorialmod.item.custom.ModPickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RAW_MUSGRAVITE = registerItem("raw_musgravite",
            new Item(new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
    public static final Item MUSGRAVITE = registerItem("musgravite",
            new Item(new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static final Item MOLE_SPAWN_EGG = registerItem("mole_spawn_egg",
            new SpawnEggItem(ModEntities.MOLE,0x22b341, 0x19732e,
                    new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));

    public static final Item MUSGRAVITE_SWORD = registerItem("musgravite_sword",
            new SwordItem(ModToolMaterial.MUSGRAVITE, 2, 1f,
                    new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
	public static final Item MUSGRAVITE_PICKAXE = registerItem("musgravite_pickaxe",
            new ModPickaxeItem(ModToolMaterial.MUSGRAVITE, 0, 1f,
                    new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
    public static final Item MUSGRAVITE_AXE = registerItem("musgravite_axe",
            new ModAxeItem(ModToolMaterial.MUSGRAVITE, 4, -1f,
                    new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
    public static final Item MUSGRAVITE_HOE = registerItem("musgravite_hoe",
            new ModHoeItem(ModToolMaterial.MUSGRAVITE, 0, 0f,
                    new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));
	public static final Item MUSGRAVITE_SHOVEL = registerItem("musgravite_shovel",
			new ShovelItem(ModToolMaterial.MUSGRAVITE, 0, 1f,
					new FabricItemSettings().group(ModItemGroup.MUSGRAVITE)));


    public static void registerModItems() {
        TutorialMod.LOGGER.debug("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
