// ModItems.java
package net.enderflame.luminara.item;

import net.enderflame.luminara.Luminara;
import net.enderflame.luminara.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item MANA_FRAGMENT = register("mana_fragment",
            ManaFragmentItem::new, new Item.Settings()
                    .maxCount(64)
                    .fireproof()
                    .rarity(Rarity.RARE)

    );

    public static final Item MANA_DUST = register("mana_dust",
            Item::new, new Item.Settings()
                    .maxCount(64)
                    .rarity(Rarity.UNCOMMON)

    );

    public static final Item RUNESTONE_SHARD = register("runestone_shard",
            Item::new, new Item.Settings()
                    .maxCount(64)
                    .rarity(Rarity.COMMON)

    );

    public static final Item ESSENCE_PEARL = register("essence_pearl",
            Item::new, new Item.Settings()
                    .maxCount(16)
                    .rarity(Rarity.EPIC)

    );

    public static final Item MANA_CRYSTAL = register("mana_crystal",
            Item::new, new Item.Settings()
                    .maxCount(16)
                    .fireproof()
                    .rarity(Rarity.EPIC)

    );

    public static final RegistryKey<ItemGroup> LUMINARA_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Luminara.MOD_ID, "luminara_item_group"));
    public static final ItemGroup LUMINARA_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MANA_FRAGMENT))
            .displayName(Text.translatable("itemGroup.luminara.luminara_item_group"))
            .build();

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
       final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Luminara.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        Luminara.LOGGER.info("Registering Mod Items for " + Luminara.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, LUMINARA_ITEM_GROUP_KEY, LUMINARA_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(LUMINARA_ITEM_GROUP_KEY).register(entries -> {
            entries.add(ModItems.MANA_FRAGMENT);
            entries.add(ModItems.MANA_DUST);
            entries.add(ModItems.RUNESTONE_SHARD);
            entries.add(ModItems.ESSENCE_PEARL);
            entries.add(ModItems.MANA_CRYSTAL);
            entries.add(ModBlocks.CRYSTAL_BLOCK.asItem());
            entries.add(ModBlocks.ARCANE_STONE.asItem());
            entries.add(ModBlocks.RUNIC_BLOCK.asItem());

        });

    }
}
