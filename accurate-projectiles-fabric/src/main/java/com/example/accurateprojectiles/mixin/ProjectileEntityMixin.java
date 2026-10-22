package com.example.accurateprojectiles.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileEntityMixin {
    /**
     * Changes only the uncertainty used to calculate launch velocity. Gravity, drag,
     * speed, shooter momentum, collision and every other projectile type remain vanilla.
     * Restricting this to player-owned instances also leaves dispenser and mob launches alone.
     */
    @ModifyVariable(
            method = "calculateVelocity(DDDFF)Lnet/minecraft/util/math/Vec3d;",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 1
    )
    private float accurateProjectiles$removeLaunchSpread(float uncertainty) {
        ProjectileEntity projectile = (ProjectileEntity) (Object) this;
        Entity owner = projectile.getOwner();

        if (!(owner instanceof PlayerEntity)) {
            return uncertainty;
        }

        if (projectile instanceof EnderPearlEntity
                || projectile instanceof WindChargeEntity
                || projectile instanceof PotionEntity) {
            return 0.0F;
        }

        return uncertainty;
    }
}
