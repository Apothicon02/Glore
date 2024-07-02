package com.Apothic0n;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import static com.Apothic0n.GloreJsonReader.customBlocks;

public class GlowingOres implements ModInitializer {
    public static final String MODID = "glore";
    @Override
    public void onInitialize() {
        try {
            GloreJsonReader.main();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        customBlocks.forEach((block, brightness) -> BuiltInRegistries.BLOCK.get(ResourceLocation.parse(block)).getStateDefinition().getPossibleStates().forEach((state -> state.lightEmission = brightness)));
    }
}