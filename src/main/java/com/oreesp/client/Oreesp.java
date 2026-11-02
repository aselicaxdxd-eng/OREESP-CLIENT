
package com.oreesp.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import org.lwjgl.input.Keyboard;

@Mod(
    modid = Oreesp.MODID,
    name = Oreesp.NAME,
    version = Oreesp.VERSION
)
public class Oreesp {

    public static final String MODID = "oreesp";
    public static final String NAME = "OREESP";
    public static final String VERSION = "1.0";

    public static KeyBinding menuKey;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        menuKey = new KeyBinding(
            "key.oreesp.menu",
            Keyboard.KEY_RSHIFT,
            "key.categories.oreesp"
        );

        ClientRegistry.registerKeyBinding(menuKey);

        FMLCommonHandler.instance().bus().register(this);

        System.out.println("[OREESP] Successfully initialized!");
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {

        if (menuKey != null && menuKey.isPressed()) {

            Minecraft.getMinecraft().displayGuiScreen(
                new OreespMenu()
            );
        }
    }
}

