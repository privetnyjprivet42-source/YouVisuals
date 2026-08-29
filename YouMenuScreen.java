package ru.you.visuals;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class YouMenuScreen extends Screen {
    
    protected YouMenuScreen() {
        super(Text.literal("YouVisuals"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("§cЗакрыть"),
            button -> this.close()
        ).dimensions(this.width / 2 - 50, this.height / 2 + 30, 100, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(
            this.textRenderer,
            Text.literal("§a§lYouVisuals §f— Меню"),
            this.width / 2, this.height / 2 - 30, 0xFFFFFF
        );
        context.drawCenteredTextWithShadow(
            this.textRenderer,
            Text.literal("§7Нажми Правый Shift, чтобы закрыть"),
            this.width / 2, this.height / 2 - 10, 0xAAAAAA
        );
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 344) {
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}