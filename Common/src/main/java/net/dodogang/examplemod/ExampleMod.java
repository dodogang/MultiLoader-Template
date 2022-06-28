package net.dodogang.examplemod;

import net.dodogang.examplemod.platform.IPlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.
    public static void initialize() {
        LOGGER.info("Hello from Common init on {}! we are currently in a {} environment!", IPlatformHelper.IMPL.getPlatformName(), IPlatformHelper.IMPL.isDevelopmentEnvironment() ? "development" : "production");
        LOGGER.info("Diamond Item >> {}", Registry.ITEM.getKey(Items.DIAMOND));
    }

    // This method serves as a hook to modify item tooltips. The vanilla game
    // has no mechanism to load tooltip listeners so this must be registered
    // by a mod loader like Forge or Fabric.
    public static void onItemTooltip(ItemStack stack, TooltipFlag context, List<Component> tooltip) {
        if (!stack.isEmpty()) {
            final FoodProperties food = stack.getItem().getFoodProperties();

            if (food != null) {
                tooltip.add(Component.literal("Nutrition: " + food.getNutrition()));
                tooltip.add(Component.literal("Saturation: " + food.getSaturationModifier()));
            }
        }
    }
}
