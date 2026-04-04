package net.tier1234.hammermod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
import net.tier1234.hammermod.item.custom.HammerItem2x2;

import java.util.ArrayList;
import java.util.List;

public class Hammer2x2OverlayRenderer {

    public static void register() {
        WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register(Hammer2x2OverlayRenderer::onBeforeBlockOutline);
    }

    private static boolean onBeforeBlockOutline(WorldRenderContext context, HitResult hitResult) {
        // Controllo se è un colpo su un blocco
        if (!(hitResult instanceof BlockHitResult blockHit)) {
            return true; // non è un blocco → lascia fare a vanilla
        }

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) {
            return true;
        }

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof HammerItem2x2)) {
            return true;
        }

        // È il nostro hammer → rendiamo l'area 2x2 e blocchiamo l'outline vanilla
        render2x2Area(context, blockHit);
        return false;
    }

    private static void render2x2Area(WorldRenderContext context, BlockHitResult hitResult) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;

        BlockPos target = hitResult.getBlockPos();
        Direction face = hitResult.getDirection();
        Vec3 hitLocation = hitResult.getLocation();

        List<BlockPos> area = get2x2Blocks(target, face, hitLocation);

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
                    poseStack,
                    vertexConsumer,
                    shape,
                    0.0, 0.0, 0.0,
                    0.0f, 0.0f, 0.0f, 0.4f,   // R G B Alpha  → grigio trasparente
                    false
            );

            poseStack.popPose();
        }
    }

    private static List<BlockPos> get2x2Blocks(BlockPos target, Direction face, Vec3 hitLocation) {
        List<BlockPos> blocks = new ArrayList<>();

        double lx = hitLocation.x - Math.floor(hitLocation.x);
        double ly = hitLocation.y - Math.floor(hitLocation.y);
        double lz = hitLocation.z - Math.floor(hitLocation.z);

        int offA, offB;

        switch (face.getAxis()) {
            case Y -> {
                offA = lx < 0.5 ? -1 : 0;
                offB = lz < 0.5 ? -1 : 0;
                for (int da = 0; da <= 1; da++)
                    for (int db = 0; db <= 1; db++)
                        blocks.add(target.offset(offA + da, 0, offB + db));
            }
            case X -> {
                offA = ly < 0.5 ? -1 : 0;
                offB = lz < 0.5 ? -1 : 0;
                for (int da = 0; da <= 1; da++)
                    for (int db = 0; db <= 1; db++)
                        blocks.add(target.offset(0, offA + da, offB + db));
            }
            case Z -> {
                offA = lx < 0.5 ? -1 : 0;
                offB = ly < 0.5 ? -1 : 0;
                for (int da = 0; da <= 1; da++)
                    for (int db = 0; db <= 1; db++)
                        blocks.add(target.offset(offA + da, offB + db, 0));
            }
        }
        return blocks;
    }
}