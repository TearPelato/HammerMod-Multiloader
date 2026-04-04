package net.tier1234.hammermod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ExcavatorEnchantmentEffect implements EnchantmentEntityEffect {

    public static final MapCodec<ExcavatorEnchantmentEffect> CODEC =
            MapCodec.unit(ExcavatorEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel,
                      int enchantmentLevel,
                      EnchantedItemInUse enchantedItemInUse,
                      Entity entity,
                      Vec3 vec3) {

        if (enchantmentLevel <= 0 || serverLevel.isClientSide()) return;
        if (!(entity instanceof LivingEntity user)) return;

        BlockPos centerPos = BlockPos.containing(vec3);
        Vec3 eyePos = user.getEyePosition(1f);
        Vec3 lookVec = user.getViewVector(1f).scale(6f);
        BlockHitResult traceResult = serverLevel.clip(new ClipContext(
                eyePos,
                eyePos.add(lookVec),
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                user
        ));

        if (traceResult.getType() == HitResult.Type.MISS) return;

        Direction dir = traceResult.getDirection();
        int range = 2;

        for (int dx = -range; dx <= range; dx++) {
            for (int dy = -range; dy <= range; dy++) {
                for (int dz = -range; dz <= range; dz++) {

                    BlockPos targetPos;

                    switch (dir) {
                        case UP, DOWN -> targetPos = centerPos.offset(dx, 0, dz);
                        case NORTH, SOUTH -> targetPos = centerPos.offset(dx, dy, 0);
                        case EAST, WEST -> targetPos = centerPos.offset(0, dy, dz);
                        default -> targetPos = centerPos;
                    }

                    if (targetPos.equals(centerPos)) continue;
                    BlockState state = serverLevel.getBlockState(targetPos);
                    if (state.isAir()) continue;
                    if (state.getDestroySpeed(serverLevel, targetPos) < 0) continue;
                    if (!state.requiresCorrectToolForDrops()) continue;
                    serverLevel.destroyBlock(targetPos, true, user);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }

}