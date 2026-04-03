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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.tier1234.hammermod.Config;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


public class VeinMinerEnchantmentEffect implements EnchantmentEntityEffect {

    public static final MapCodec<VeinMinerEnchantmentEffect> CODEC =
            MapCodec.unit(VeinMinerEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel,
                      int enchantmentLevel,
                      EnchantedItemInUse enchantedItemInUse,
                      Entity entity,
                      Vec3 vec3) {

        if (enchantmentLevel <= 0 || serverLevel.isClientSide) return;
        if (!(entity instanceof LivingEntity user)) return;

        BlockPos startPos = BlockPos.containing(vec3);
        BlockState startState = serverLevel.getBlockState(startPos);
        Block targetBlock = startState.getBlock();
        if (startState.isAir() || startState.getDestroySpeed(serverLevel, startPos) < 0)
            return;
        int maxBlocks = Config.CLIENT.veinminerRange.get();
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

        Queue<BlockPos> queue = new ArrayDeque<>();
        Set<BlockPos> visited = new HashSet<>();

        queue.add(startPos);
        visited.add(startPos);

        int broken = 0;

        while (!queue.isEmpty() && broken < maxBlocks) {
            BlockPos current = queue.poll();
            BlockState state = serverLevel.getBlockState(current);

            if (state.getBlock() != targetBlock) continue;

            if (!current.equals(startPos)) {
                serverLevel.destroyBlock(current, true, user);
                broken++;
            }

            for (Direction dir : Direction.values()) {
                BlockPos next = current.relative(dir);
                if (visited.contains(next)) continue;

                BlockState nextState = serverLevel.getBlockState(next);
                if (nextState.getBlock() == targetBlock) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}