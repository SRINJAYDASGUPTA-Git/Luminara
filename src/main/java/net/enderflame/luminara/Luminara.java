package net.enderflame.luminara;

import net.enderflame.luminara.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Luminara implements ModInitializer {
	public static final String MOD_ID = "luminara";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItems.registerModItems();
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (!itemStack.isOf(ModItems.MANA_FRAGMENT)) {
                return;
            }
            list.add(Text.translatable("item.luminara.mana_fragment.tooltip")
                    .formatted(Formatting.AQUA, Formatting.ITALIC));
        });

	}
}