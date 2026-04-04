package net.tier1234.hammermod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HammerItem5x5 extends Item {
    public HammerItem5x5(Properties properties) {
        super(properties);
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
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, TooltipDisplay tooltipDisplay, Consumer<Component> components, TooltipFlag tooltipFlag) {
        if(Minecraft.getInstance().hasShiftDown()) {
            components.accept(Component.translatable("tooltip.hammer_mod.hammer5x5.shift_down"));
        } else {
            components.accept(Component.translatable("tooltip.hammer_mod.hammer5x5"));
        }



        super.appendHoverText(pStack, pContext, tooltipDisplay, components, tooltipFlag);
    }
}