package net.dodogang.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.LOGGER.info("Hello Fabric world!");
        ExampleMod.initialize();
        ItemTooltipCallback.EVENT.register(ExampleMod::onItemTooltip);
    }
}
