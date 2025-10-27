package net.enderflame.luminara.datagen;

import net.enderflame.luminara.block.ModBlocks;
import net.enderflame.luminara.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARCANE_STONE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MANA_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUNESTONE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANA_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ESSENCE_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANA_CRYSTAL, Models.GENERATED);
    }
}
