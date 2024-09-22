package com.apothicon.glore;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.Mod;

import static com.apothicon.glore.GloreJsonReader.customBlocks;

@Mod(Glore.MODID)
public class Glore {
    public static final String MODID = "glore";

    public Glore() throws Exception {
        try {
            GloreJsonReader.main();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        customBlocks.forEach((block, brightness) -> {
            Block registeredBlock = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(block));
            if (registeredBlock == Blocks.AIR) {
                throw new RuntimeException("Could not locate "+block+", this could be due to a typo in the block name or the mod the block is added by being incompatible with Glore's method of making blocks emit light.");
            } else {
                registeredBlock.getStateDefinition().getPossibleStates().forEach((state -> state.lightEmission = brightness));
            }
        });
    }
}