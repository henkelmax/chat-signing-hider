package de.maxhenkel.chatsigninghider.mixin;

import net.minecraft.client.multiplayer.ClientPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {

    @Redirect(method = "handleServerData", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientPacketListener;enforcesSecureChat()Z"))
    private boolean enforcesSecureChat(ClientPacketListener instance) {
        return true;
    }

}
