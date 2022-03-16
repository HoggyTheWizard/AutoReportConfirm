package com.hoggythewizard.autoreportconfirm;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import com.hoggythewizard.utils.Timer;
import net.minecraft.util.*;
import tv.twitch.chat.Chat;

import java.lang.Thread;



public class ARCMessages {
    @SubscribeEvent
    public void ClientChatReceivedEvent(ClientChatReceivedEvent event){
        final Minecraft mc = Minecraft.getMinecraft();
        String message = event.message.getUnformattedText();
        if (message.contains("Please type") && message.contains("/report confirm")) {
            event.setCanceled(true);
            new Thread()
            {
                @Override
                public void run()
                {
                    Timer.waitTime(1000);
                    mc.thePlayer.sendChatMessage("/cr confirm");
                }
            }.start();
        }
        else if (message.contains("Thanks for your Public Chat report.")) {
            event.setCanceled(true);
            ChatComponentText first = new ChatComponentText("[ARC] ");
            first.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED));
            ChatComponentText second = new ChatComponentText("Successfully submitted your report.");
            second.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN));
            mc.thePlayer.addChatComponentMessage(new ChatComponentText(
                    first.getFormattedText() + second.getFormattedText()));
        }
        else {
            event.setCanceled(false);
        }
    }
}
