package net.tier1234.hammermod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.level.LevelRenderEvents;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShapeRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class Hammer5x5OverlayRenderer {

    public static void register() {
        LevelRenderEvents.BEFORE_BLOCK_OUTLINE.register((context, blockOutlineContext) -> {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;
            if (player == null || mc.level == null) return false;

            ItemStack held = player.getMainHandItem();
            if (!(held.getItem() instanceof HammerItem5x5)) return false;

            HitResult hitResult = mc.hitResult;
            if (!(hitResult instanceof BlockHitResult blockHit)) return false;

            BlockPos target = blockHit.getBlockPos();
            Direction face = blockHit.getDirection();

            List<BlockPos> area = getSymmetricBlocks(target, face, 2);

            renderArea(context, mc, player, area);

            return false;
        });
    }

    private static void renderArea(LevelRenderContext context, Minecraft mc,
                                   LocalPlayer player, List<BlockPos> area) {
        PoseStack poseStack = context.poseStack();
        Camera camera = mc.gameRenderer.getMainCamera();
        Vec3 camPos = camera.position();

        VertexConsumer vertexConsumer = context.bufferSource()
                .getBuffer(RenderTypes.LINES);

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

            ShapeRenderer.renderShape(
                    poseStack,
                    vertexConsumer,
                    shape,
                    0.0, 0.0, 0.0,
                    0xFF000000,
                    5.0f
            );

            poseStack.popPose();
        }
    }

    private static List<BlockPos> getSymmetricBlocks(BlockPos target, Direction face, int radius) {
        List<BlockPos> blocks = new ArrayList<>();
        Direction.Axis axis = face.getAxis();

        for (int a = -radius; a <= radius; a++)
            for (int b = -radius; b <= radius; b++)
                blocks.add(switch (axis) {
                    case Y -> target.offset(a, 0, b);
                    case X -> target.offset(0, a, b);
                    case Z -> target.offset(a, b, 0);
                });

        return blocks;
    }
}