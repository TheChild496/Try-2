package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MUSGRAVITE = FabricItemGroupBuilder.build(
            new Identifier(TutorialMod.MOD_ID, "musgravite"), () -> new ItemStack(ModItems.MUSGRAVITE));


}
