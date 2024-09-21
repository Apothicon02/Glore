package com.Apothic0n.GlowingOres;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import static com.Apothic0n.GlowingOres.GloreJsonReader.customBlocks;

@Mod(GlowingOres.MODID)
public class GlowingOres {
    public static final String MODID = "glore";

    public GlowingOres() throws Exception {
        try {
            GloreJsonReader.main();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        customBlocks.forEach((block, brightness) -> {
            Block registeredBlock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.parse(block));
            if (registeredBlock == null || registeredBlock == Blocks.AIR) {
                throw new RuntimeException("Could not locate "+block+", this could be due to a typo in the block name or the mod the block is added by being incompatible with Glore's method of making blocks emit light.");
            } else {
                registeredBlock.getStateDefinition().getPossibleStates().forEach((state -> state.lightEmission = brightness));
            }
        });
    }
}