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
import net.tier1234.hammermod.Config;
import net.tier1234.hammermod.item.custom.HammerItem2x2;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class Hammer2x2OverlayRenderer {

    public static void register() {
        LevelRenderEvents.BEFORE_BLOCK_OUTLINE.register((context, blockOutlineContext) -> {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;
            if (player == null || mc.level == null) return true;
            if (!Config.CLIENT.showHammerOverlay.get()) return false;
            ItemStack held = player.getMainHandItem();
            if (!(held.getItem() instanceof HammerItem2x2)) return true;

            HitResult hitResult = mc.hitResult;
            if (!(hitResult instanceof BlockHitResult blockHit)) return true;

            BlockPos target = blockHit.getBlockPos();
            Direction face = blockHit.getDirection();
            Vec3 hitLocation = blockHit.getLocation();

            List<BlockPos> area = get2x2Blocks(target, face, hitLocation);

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
                    2.0f
            );

            poseStack.popPose();
        }

        context.bufferSource().endBatch(RenderTypes.LINES);
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