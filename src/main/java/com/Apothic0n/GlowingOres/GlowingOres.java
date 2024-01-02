package com.Apothic0n.GlowingOres;


import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlowingOres.MODID)
public class GlowingOres {
    public static final String MODID = "glore";

    public GlowingOres() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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
        });
    }

    private void addLight(ImmutableList<BlockState> blockStates, int light) {
        for (int i = 0; i < blockStates.size(); i++) {
            blockStates.get(i).lightEmission = light;
        }
    }
}