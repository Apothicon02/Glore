package com.Apothic0n.GlowingOres;


import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.Apothic0n.GlowingOres.GloreJsonReader.customBlocks;
import static com.Apothic0n.GlowingOres.GloreJsonReader.customBrightness;

@Mod(GlowingOres.MODID)
public class GlowingOres {
    public static final String MODID = "glore";

    public GlowingOres() throws Exception {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        GloreJsonReader.main();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (int i = 0; i < customBlocks.size(); i++) {
                addLight(BuiltInRegistries.BLOCK.get(new ResourceLocation(customBlocks.get(i))).getStateDefinition().getPossibleStates(), customBrightness.get(i));
            }
        });
    }

    private void addLight(ImmutableList<BlockState> blockStates, int light) {
        for (int i = 0; i < blockStates.size(); i++) {
            blockStates.get(i).lightEmission = light;
        }
    }
}