package com.hoggythewizard.autoreportconfirm;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "autoreportconfirm", version = "1.0", name = "AutoReportConfirm")
public class AutoReportConfirm
{
    @EventHandler
    public void postInit(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ARCMessages());
    }
}

