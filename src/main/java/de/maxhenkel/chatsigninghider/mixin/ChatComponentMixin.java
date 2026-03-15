package de.maxhenkel.chatsigninghider.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/client/gui/components/ChatComponent$1")
public abstract class ChatComponentMixin {

    @WrapOperation(method = "accept", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/chat/GuiMessage$Line;tag()Lnet/minecraft/client/multiplayer/chat/GuiMessageTag;"))
    private GuiMessageTag accept(GuiMessage.Line instance, Operation<GuiMessageTag> original) {
        return null;
    }

}
