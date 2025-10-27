package net.enderflame.luminara.block;

import net.enderflame.luminara.Luminara;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ARCANE_STONE = register("arcane_stone",
            Block::new,
            AbstractBlock.Settings.create().strength(1.5f).requiresTool(),
            true);

    public static final Block CRYSTAL_BLOCK = register("crystal_block",
            Block::new,
            AbstractBlock.Settings.create().strength(2.0f).requiresTool().luminance(
                    state -> 15
            ),
            true);

    public static final Block RUNIC_BLOCK = register("runic_block",
            Block::new,
            AbstractBlock.Settings.create().strength(3.0f).requiresTool(),
            true);


    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Luminara.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Luminara.MOD_ID, name));
    }

    public static void registerModBlocks() {
        Luminara.LOGGER.info("Registering Mod Blocks for " + Luminara.MOD_ID);
    }

}