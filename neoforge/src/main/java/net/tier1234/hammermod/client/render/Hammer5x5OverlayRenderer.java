package net.tier1234.hammermod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ShapeRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class Hammer5x5OverlayRenderer {

    public static void register() {
        NeoForge.EVENT_BUS.register(new Hammer5x5OverlayRenderer());
    }

    @SubscribeEvent
    public void onRenderLevel(RenderLevelStageEvent.AfterOpaqueBlocks event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) return;

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof HammerItem5x5)) return;

        if (!(mc.hitResult instanceof BlockHitResult blockHit)) return;

        BlockPos target = blockHit.getBlockPos();
        Direction face = blockHit.getDirection();

        List<BlockPos> area = getSymmetricBlocks(target, face, 2); // 5x5

        renderArea(event, mc, player, area);
    }

    private static void renderArea(RenderLevelStageEvent event, Minecraft mc,
                                   LocalPlayer player, List<BlockPos> area) {
        PoseStack poseStack = event.getPoseStack();
        Vec3 camPos = event.getLevelRenderState().cameraRenderState.pos;

        VertexConsumer vertexConsumer = mc.renderBuffers()
                .bufferSource()
                .getBuffer(RenderTypes.lines());

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
                    0xFF000000, 5.0f
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