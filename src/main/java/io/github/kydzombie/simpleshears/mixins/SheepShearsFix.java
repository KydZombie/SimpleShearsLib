package io.github.kydzombie.simpleshears.mixins;

import io.github.kydzombie.simpleshears.SimpleShears;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SheepEntity.class)
public abstract class SheepShearsFix extends AnimalEntity implements Shearable {

	protected SheepShearsFix(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> infoReturnable) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (SimpleShears.SHEARS_TAG.contains(itemStack.getItem())) {
			if (!this.world.isClient && this.isShearable()) {
				this.sheared(SoundCategory.PLAYERS);
				itemStack.damage(1, player, (playerEntity) -> {
					playerEntity.sendToolBreakStatus(hand);
				});
				infoReturnable.setReturnValue(ActionResult.SUCCESS);
			} else {
				infoReturnable.setReturnValue(ActionResult.CONSUME);
			}
		} else {
			infoReturnable.setReturnValue(super.interactMob(player, hand));
		}
	}

}
