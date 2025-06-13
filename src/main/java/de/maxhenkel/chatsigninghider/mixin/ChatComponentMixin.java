package de.maxhenkel.chatsigninghider.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    //TODO Clean this up
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent;forEachLine(IIZILnet/minecraft/client/gui/components/ChatComponent$LineConsumer;)I", ordinal = 0))
    private int forEachLine(ChatComponent instance, int i, int j, boolean bl, int k, ChatComponent.LineConsumer lineConsumer, @Local(argsOnly = true) GuiGraphics guiGraphics) {
        float f = (float) getScale();
        int n = Mth.ceil((float) getWidth() / f);
        float h = minecraft.options.textBackgroundOpacity().get().floatValue();
        return instance.forEachLine(i, j, bl, k, (lx, mx, nx, line, ox, hx) -> {
            guiGraphics.fill(lx - 4, mx, lx + n + 4 + 4, nx, ARGB.color(hx * h, -16777216));
        });
    }

    @Shadow
    public abstract double getScale();

    @Shadow
    public abstract int getWidth();

}
