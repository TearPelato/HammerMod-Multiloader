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

public class HammerItem5x5 extends DiggerItem {
    public HammerItem5x5(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
    public static List<BlockPos> getBlocksToBeDestroyed(BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        int range = 2; // 5x5 area => -2 to +2 in both dimensions

        BlockHitResult traceResult = player.level().clip(new ClipContext(
                player.getEyePosition(1f),
                player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f)),
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                player
        ));

        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        Direction face = traceResult.getDirection();

        // Horizontal plane (X/Z), breaking top or bottom
        if (face == Direction.UP || face == Direction.DOWN) {
            for (int dx = -range; dx <= range; dx++) {
                for (int dz = -range; dz <= range; dz++) {
                    positions.add(initialBlockPos.offset(dx, 0, dz));
                }
            }
        }

        // Vertical plane (Y/Z), breaking from side (East/West)
        if (face == Direction.EAST || face == Direction.WEST) {
            for (int dy = -range; dy <= range; dy++) {
                for (int dz = -range; dz <= range; dz++) {
                    positions.add(initialBlockPos.offset(0, dy, dz));
                }
            }
        }

        // Vertical plane (X/Y), breaking from front/back (North/South)
        if (face == Direction.NORTH || face == Direction.SOUTH) {
            for (int dx = -range; dx <= range; dx++) {
                for (int dy = -range; dy <= range; dy++) {
                    positions.add(initialBlockPos.offset(dx, dy, 0));
                }
            }
        }

        return positions;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.hammer_mod.hammer5x5.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.hammer_mod.hammer5x5"));
        }



        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}