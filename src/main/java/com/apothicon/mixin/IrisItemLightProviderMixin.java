package com.apothicon.mixin;

import com.apothicon.GloreJsonReader;
import net.irisshaders.iris.api.v0.item.IrisItemLightProvider;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.trim.ArmorTrim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.atomic.AtomicInteger;

@Mixin(IrisItemLightProvider.class)
public interface IrisItemLightProviderMixin {

    @Inject(method = "getLightEmission", at = @At("RETURN"), cancellable = true)
    private void getLightEmission(Player player, ItemStack stack, CallbackInfoReturnable<Integer> ci) {
        int trimGlow = getTrimGlow(player);
        if (trimGlow > 0) {
            ci.setReturnValue(ci.getReturnValue()+trimGlow);
        }
    }

    @Unique
    private int getTrimGlow(Player player) {
        AtomicInteger returnValue = new AtomicInteger();
        Inventory.EQUIPMENT_SLOT_MAPPING.keySet().forEach((int slot) -> checkSlot(player.getInventory().getSlot(slot), returnValue));
        return returnValue.get();
    }

    @Unique
    private void checkSlot(SlotAccess slot, AtomicInteger returnValue) {
        ArmorTrim trim = slot.get().getComponents().get(DataComponents.TRIM);
        if (trim != null) {
            String trimName = trim.material().getRegisteredName();
            GloreJsonReader.customTrims.forEach((string, brightness) -> {
                if (trimName.contains(string)) {
                    returnValue.addAndGet(brightness);
                }
            });
        }
    }
}