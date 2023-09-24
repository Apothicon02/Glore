package com.Apothic0n.GlowingOres;


import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlowingOres.MODID)
public class GlowingOres {
    public static final String MODID = "glore";

    public GlowingOres() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}