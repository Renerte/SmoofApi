package net.renerte.smoofapi.mixins;

import net.minecraft.item.Item;
import net.renerte.smoofapi.annotations.RecipeRemaining;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class RemainingItemMixin {
    @Inject(method = "getRecipeRemainder", at = @At("HEAD"), cancellable = true)
    protected void getRecipeRemainder(CallbackInfoReturnable<Item> cir){
        if ((Object)this instanceof Item && ((Object)this).getClass().isAnnotationPresent(RecipeRemaining.class))
            cir.setReturnValue((Item)(Object)this);
    }

    @Inject(method = "hasRecipeRemainder", at = @At("HEAD"), cancellable = true)
    private void hasRecipeRemainder(CallbackInfoReturnable<Boolean> cir) {
        if ((Object)this instanceof Item && ((Object)this).getClass().isAnnotationPresent(RecipeRemaining.class))
            cir.setReturnValue(true);
    }
}
