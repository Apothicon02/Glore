package com.Apothic0n.GlowingOres.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(value = Blocks.class, priority = 1)
public class BlocksMixin {

    @ModifyExpressionValue(
        method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;REDSTONE_WIRE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;DIAMOND_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setDiamond(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 15);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;SANDSTONE_STAIRS:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;EMERALD_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setEmerald(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 12);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;SUSPICIOUS_GRAVEL:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;GOLD_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setGold(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 10);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;GLASS:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;LAPIS_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setLapis(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 7);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;DEEPSLATE_GOLD_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;IRON_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setIron(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 4);
    }

    @ModifyExpressionValue(
            method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;of()Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;"),
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;DEEPSLATE_IRON_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;COAL_ORE:Lnet/minecraft/world/level/block/Block;", opcode = Opcodes.PUTSTATIC)),
            require = 1
    )
    private static BlockBehaviour.Properties setCoal(BlockBehaviour.Properties properties) {
        return properties.lightLevel(brightness -> 4);
    }
}