package ru.you.visuals;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class YouVisuals implements ClientModInitializer {
    public static KeyBinding openMenuKey;

    @Override
    public void onInitializeClient() {
        System.out.println("§a[YouVisuals] §fЗагружен!");

        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.youvisuals.openmenu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.youvisuals"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openMenuKey.wasPressed()) {
                System.out.println("[YouVisuals] Нажат Правый Shift!");
                // TODO: Открыть меню (добавим позже)
            }
        });
    }
}
