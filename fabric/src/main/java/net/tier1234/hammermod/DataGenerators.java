package net.tier1234.hammermod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.tier1234.hammermod.datagen.ModBlockTagProvider;
import net.tier1234.hammermod.datagen.ModDatapackProvider;
import net.tier1234.hammermod.datagen.ModItemTagProvider;
import net.tier1234.hammermod.datagen.ModRecipeProvider;
import net.tier1234.hammermod.registries.ModEnchantments;

public class DataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider((output, registries) ->
                new ModItemTagProvider(output, registries));   // ItemTagProvider ha bisogno anche dei block tags

    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);
    }
}