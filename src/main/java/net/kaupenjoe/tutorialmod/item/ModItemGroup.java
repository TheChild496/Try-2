package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class ModItemGroup {
    public static final ItemGroup MUSGRAVITE = FabricItemGroupBuilder.build(
            new Identifier(MODID, "musgravite"), () -> new ItemStack(ModItems.MUSGRAVITE));


}
