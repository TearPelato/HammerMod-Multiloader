package net.tier1234.hammermod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.tier1234.hammermod.Config;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class MagnetItem extends Item {

    public MagnetItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (level.isClientSide() || !(entity instanceof ServerPlayer player)) return;
        applyMagnet(player, (ServerLevel) level);
    }

    public static void applyMagnet(ServerPlayer player, ServerLevel level) {
        double radius = Config.CLIENT.magnetRadius.get();
        BlockPos center = player.blockPosition();

        List<ItemEntity> nearbyItems = level.getEntitiesOfClass(
                ItemEntity.class,
                new AABB(center).inflate(radius),
                item -> true
        );

        for (ItemEntity itemEntity : nearbyItems) {
            itemEntity.setPickUpDelay(0);

            Vec3 toPlayer = player.position()
                    .add(0, player.getBbHeight() / 2, 0)
                    .subtract(itemEntity.position());

            double distance = toPlayer.length();
            if (distance < 0.5) continue;

            Vec3 velocity = toPlayer.normalize().scale(Math.min(0.3 + (distance * 0.05), 0.8));
            itemEntity.setDeltaMovement(velocity);
        }
    }
}