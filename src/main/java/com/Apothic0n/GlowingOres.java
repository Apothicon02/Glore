package com.Apothic0n;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import static com.Apothic0n.GloreJsonReader.customBlocks;
import static com.Apothic0n.GloreJsonReader.customBrightness;

public class GlowingOres implements ModInitializer {
    public static final String MODID = "glore";
    @Override
    public void onInitialize() {
        try {
            GloreJsonReader.main();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < customBlocks.size(); i++) {
            addLight(BuiltInRegistries.BLOCK.get(new ResourceLocation(customBlocks.get(i))).getStateDefinition().getPossibleStates(), customBrightness.get(i));
        }
    }


    private void addLight(ImmutableList<BlockState> blockStates, int light) {
        for (int i = 0; i < blockStates.size(); i++) {
            blockStates.get(i).lightEmission = light;
        }
    }
}