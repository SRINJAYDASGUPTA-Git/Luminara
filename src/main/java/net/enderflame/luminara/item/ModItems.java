// ModItems.java
package net.enderflame.luminara.item;

import net.enderflame.luminara.Luminara;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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

    private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
       final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Luminara.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        Luminara.LOGGER.info("Registering Mod Items for " + Luminara.MOD_ID);
    }
}
