package net.dodogang.examplemod;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class ExampleModQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        ExampleMod.LOGGER.info("Hello Quilt world!");
        ExampleMod.initialize();
    }
}
