package net.tier1234.hammermod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem2x2 extends DiggerItem {
    public HammerItem2x2(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
    // Inside HammerItem class
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(
                player.getEyePosition(1f),
                player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f)),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        Direction face = traceResult.getDirection();

        if (face == Direction.UP || face == Direction.DOWN) {
            // 2x2 horizontal (XZ plane)
            positions.add(initialBlockPos);
            positions.add(initialBlockPos.offset(1, 0, 0));
            positions.add(initialBlockPos.offset(0, 0, 1));
            positions.add(initialBlockPos.offset(1, 0, 1));
        } else if (face == Direction.NORTH || face == Direction.SOUTH) {
            // 2x2 vertical (XY plane)
            positions.add(initialBlockPos);
            positions.add(initialBlockPos.offset(1, 0, 0));
            positions.add(initialBlockPos.offset(0, 1, 0));
            positions.add(initialBlockPos.offset(1, 1, 0));
        } else if (face == Direction.EAST || face == Direction.WEST) {
            // 2x2 vertical (YZ plane)
            positions.add(initialBlockPos);
            positions.add(initialBlockPos.offset(0, 1, 0));
            positions.add(initialBlockPos.offset(0, 0, 1));
            positions.add(initialBlockPos.offset(0, 1, 1));
        }

        return positions;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
           tooltipComponents.add(Component.translatable("tooltip.hammer_mod.hammer2x2.shift_down"));
        } else {
           tooltipComponents.add(Component.translatable("tooltip.hammer_mod.hammer2x2"));
        }



        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

