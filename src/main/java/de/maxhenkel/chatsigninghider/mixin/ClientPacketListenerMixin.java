package de.maxhenkel.chatsigninghider.mixin;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {

    @Redirect(method = "handleServerData", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/toasts/ToastComponent;addToast(Lnet/minecraft/client/gui/components/toasts/Toast;)V"))
    private void enforcesSecureChat(ToastComponent instance, Toast toast) {
        // Just don't show the toast
    }

    @Redirect(method = "handleServerData", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerData$ChatPreview;isAcknowledged()Z"))
    private boolean isAcknowledged(ServerData.ChatPreview preview) {
        return true;
    }

}
