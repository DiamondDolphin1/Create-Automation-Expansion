package io.github.DiamondDolphin1.automationexpansion.client;

import io.github.DiamondDolphin1.automationexpansion.client.screen.ExampleBlockScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

public class ClientHooks {
    public static void openExampleBlockScreen(BlockPos pos) {
        Minecraft.getInstance().setScreen(new ExampleBlockScreen(pos));
    }
}