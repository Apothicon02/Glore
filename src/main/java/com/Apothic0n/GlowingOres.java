package com.Apothic0n;


import com.google.common.collect.ImmutableList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class GlowingOres implements ModInitializer {
    public static final String MODID = "glore";
    @Override
    public void onInitialize() {
        addLight(Blocks.DIAMOND_ORE.getStateDefinition().getPossibleStates(), 15);
        addLight(Blocks.DEEPSLATE_DIAMOND_ORE.getStateDefinition().getPossibleStates(), 15);
        addLight(Blocks.EMERALD_ORE.getStateDefinition().getPossibleStates(), 12);
        addLight(Blocks.DEEPSLATE_EMERALD_ORE.getStateDefinition().getPossibleStates(), 12);
        addLight(Blocks.GOLD_ORE.getStateDefinition().getPossibleStates(), 10);
        addLight(Blocks.DEEPSLATE_GOLD_ORE.getStateDefinition().getPossibleStates(), 10);
        addLight(Blocks.LAPIS_ORE.getStateDefinition().getPossibleStates(), 7);
        addLight(Blocks.DEEPSLATE_LAPIS_ORE.getStateDefinition().getPossibleStates(), 7);
        addLight(Blocks.COPPER_ORE.getStateDefinition().getPossibleStates(), 7);
        addLight(Blocks.DEEPSLATE_COPPER_ORE.getStateDefinition().getPossibleStates(), 7);
        addLight(Blocks.IRON_ORE.getStateDefinition().getPossibleStates(), 4);
        addLight(Blocks.IRON_ORE.getStateDefinition().getPossibleStates(), 4);
        addLight(Blocks.COAL_ORE.getStateDefinition().getPossibleStates(), 4);
        addLight(Blocks.COAL_ORE.getStateDefinition().getPossibleStates(), 4);
    }

    private void addLight(ImmutableList<BlockState> blockStates, int light) {
        for (int i = 0; i < blockStates.size(); i++) {
            blockStates.get(i).lightEmission = light;
        }
    }
}