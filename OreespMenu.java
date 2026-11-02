
package com.oreesp.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

import java.io.IOException;

public class OreespMenu extends GuiScreen {

    private boolean coordinates = true;
    private boolean fps = true;

    @Override
    public void initGui() {

        buttonList.clear();

        int center = width / 2;

        buttonList.add(new GuiButton(
            0, center - 100, height / 2 - 30,
            200, 20,
            "Coordinates: " + (coordinates ? "ON" : "OFF")
        ));

        buttonList.add(new GuiButton(
            1, center - 100, height / 2,
            200, 20,
            "FPS Counter: " + (fps ? "ON" : "OFF")
        ));

        buttonList.add(new GuiButton(
            2, center - 100, height / 2 + 30,
            200, 20,
            "Close Menu"
        ));
    }

    @Override
    protected void actionPerformed(GuiButton button)
            throws IOException {

        if (button.id == 0) {
            coordinates = !coordinates;
        }

        if (button.id == 1) {
            fps = !fps;
        }

        if (button.id == 2) {
            mc.displayGuiScreen(null);
            return;
        }

        initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        drawDefaultBackground();

        drawCenteredString(
            fontRendererObj,
            "OREESP",
            width / 2,
            height / 2 - 75,
            0x55DDFF
        );

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
