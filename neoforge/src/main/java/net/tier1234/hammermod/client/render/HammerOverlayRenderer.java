package net.tier1234.hammermod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.ShapeOutlineFeatureRenderer;
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
import net.neoforged.neoforge.client.event.SubmitCustomGeometryEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.tier1234.hammermod.Config;
import net.tier1234.hammermod.item.custom.HammerItem;

import java.util.ArrayList;
import java.util.List;


@OnlyIn(Dist.CLIENT)
public class HammerOverlayRenderer {

    public static void register() {
        NeoForge.EVENT_BUS.register(new HammerOverlayRenderer());
    }

    @SubscribeEvent
    public void onSubmitCustomGeometry(SubmitCustomGeometryEvent event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) return;
        if (!Config.CLIENT.miscSettings.showHammerOverlay.get()) return;

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof HammerItem)) return;

        if (!(mc.hitResult instanceof BlockHitResult blockHit)) return;

        BlockPos target = blockHit.getBlockPos();
        Direction face = blockHit.getDirection();
        List<BlockPos> area = getSymmetricBlocks(target, face, 1);

        renderArea(event, mc, player, area);
    }

    private static void renderArea(SubmitCustomGeometryEvent event, Minecraft mc,
                                   LocalPlayer player, List<BlockPos> area) {
        PoseStack poseStack = event.getPoseStack();
        SubmitNodeCollector submitNodeCollector = event.getSubmitNodeCollector();
        Vec3 camPos = event.getLevelRenderState().cameraRenderState.pos;

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


            submitNodeCollector.submitShapeOutline(
                    poseStack,
                    shape,
                    RenderTypes.lines(),
                    0xFF000000,
                    3.0f,
                    false
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