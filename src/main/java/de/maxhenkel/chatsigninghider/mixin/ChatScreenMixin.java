package de.maxhenkel.chatsigninghider.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.multiplayer.ProfileKeyPairManager;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Signer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin {

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerData$ChatPreview;showToast()Z"))
    private boolean showToast(ServerData.ChatPreview packet) {
        return false;
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/ChatScreen;renderTooltip(Lcom/mojang/blaze3d/vertex/PoseStack;Ljava/util/List;II)V"))
    private void renderTooltip(ChatScreen screen, PoseStack poseStack, List<? extends FormattedCharSequence> list, int i, int j) {

    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ProfileKeyPairManager;signer()Lnet/minecraft/util/Signer;"))
    private Signer signer(ProfileKeyPairManager manager) {
        return null;
    }

}
