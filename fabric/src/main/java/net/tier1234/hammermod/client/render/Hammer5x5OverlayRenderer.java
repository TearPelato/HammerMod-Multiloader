package net.tier1234.hammermod.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.ArrayList;
import java.util.List;

public class Hammer5x5OverlayRenderer {

    public static void register() {
        WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register(Hammer5x5OverlayRenderer::onBeforeBlockOutline);
    }

    private static boolean onBeforeBlockOutline(WorldRenderContext context, HitResult hitResult) {
        if (!(hitResult instanceof BlockHitResult blockHit)) {
            return true;
        }

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) {
            return true;
        }

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof HammerItem5x5)) {
            return true;
        }

        renderArea(context, blockHit);
        return false;
    }

    private static void renderArea(WorldRenderContext context, BlockHitResult hitResult) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;

        BlockPos target = hitResult.getBlockPos();
        Direction face = hitResult.getDirection();

        List<BlockPos> area = getSymmetricBlocks(target, face, 2); // radius = 2 → 5x5

        PoseStack poseStack = context.matrixStack();
        Vec3 camPos = context.camera().getPosition();
        VertexConsumer vertexConsumer = context.consumers().getBuffer(RenderType.lines());

        for (BlockPos pos : area) {
            BlockState state = mc.level.getBlockState(pos);
            if (state.isAir()) continue;

            VoxelShape shape = state.getShape(mc.level, pos, CollisionContext.of(player));
            if (shape.isEmpty()) continue;

            double dx = pos.getX() - camPos.x;
            double dy = pos.getY() - camPos.y;
            double dz = pos.getZ() - camPos.z;

            poseStack.pushPose();
            poseStack.translate(dx, dy, dz);

            LevelRenderer.renderVoxelShape(
                    poseStack, vertexConsumer, shape,
                    0.0, 0.0, 0.0,
                    0.0f, 0.0f, 0.0f, 0.4f, false
            );

            poseStack.popPose();
        }
    }

    private static List<BlockPos> getSymmetricBlocks(BlockPos target, Direction face, int radius) {
        List<BlockPos> blocks = new ArrayList<>();
        Direction.Axis axis = face.getAxis();

        for (int a = -radius; a <= radius; a++) {
            for (int b = -radius; b <= radius; b++) {
                blocks.add(switch (axis) {
                    case Y -> target.offset(a, 0, b);
                    case X -> target.offset(0, a, b);
                    case Z -> target.offset(a, b, 0);
                });
            }
        }
        return blocks;
    }
}