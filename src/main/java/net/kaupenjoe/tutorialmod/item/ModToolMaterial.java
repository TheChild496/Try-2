package net.kaupenjoe.tutorialmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {

    MUSGRAVITE(3, 250, 15.0F, 2.0F, 24,
			() -> Ingredient.ofItems(ModItems.MUSGRAVITE));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed,
                            float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() { return this.itemDurability; }

    public float getMiningSpeedMultiplier() { return this.miningSpeed; }

    public float getAttackDamage() { return this.attackDamage; }

    public int getMiningLevel() { return this.miningLevel; }

    public int getEnchantability() { return this.enchantability; }

    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
