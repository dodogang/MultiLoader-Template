package net.dodogang.examplemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ExampleMod.MOD_ID)
public class ExampleModForge {
    public ExampleModForge() {
        ExampleMod.LOGGER.info("Hello Fabric World!");
        ExampleMod.initialize();
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
    }

    private void onItemTooltip(ItemTooltipEvent event) {
        ExampleMod.onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }
}
