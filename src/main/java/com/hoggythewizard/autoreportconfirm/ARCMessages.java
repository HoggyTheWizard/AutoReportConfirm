package com.hoggythewizard.autoreportconfirm;

import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;



public class ARCMessages {
    @SubscribeEvent
    public void ClientChatReceivedEvent(ClientChatReceivedEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        String message = event.message.getUnformattedText();
        if (message.contains("&aPlease type &r&e/report confirm&r&e")) {
            event.setCanceled(true);
            mc.thePlayer.sendChatMessage("/cr confirm");
        }
        else if (message.contains("&aThanks for your Public Chat report.")) {
            event.setCanceled(true);
            mc.thePlayer.addChatComponentMessage(new ChatComponentText(
                    "&c[ARC] &aSuccessfully submitted your report."));
        }
    }
}
