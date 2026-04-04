package net.tier1234.hammermod.enchantment.custom;

public class AutoSmeltEnchantmentEffect
       // implements EnchantmentEntityEffect
{

  /*  public static final MapCodec<AutoSmeltEnchantmentEffect> CODEC =
            MapCodec.unit(AutoSmeltEnchantmentEffect::new);

    @Override
    public void apply(
            ServerLevel level,
            int enchantmentLevel,
            EnchantedItemInUse itemInUse,
            Entity entity,
            Vec3 origin
    ) {
        if (enchantmentLevel <= 0 || level.isClientSide()) return;

        if (!(entity instanceof Player player)) return;

        ItemStack tool = itemInUse.itemStack();

        if (tool.getEnchantmentLevel((Holder<Enchantment>) Enchantments.SILK_TOUCH) > 0) {
            return;
        }

        BlockPos pos = BlockPos.containing(origin);
        BlockState state = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);


        if (state.isAir() || state.getDestroySpeed(level, pos) < 0) {
            return;
        }

        List<ItemStack> possibleDrops = Block.getDrops(
                state,
                level,
                pos,
                level.getBlockEntity(pos),
                player,
                tool
        );

        if (possibleDrops.isEmpty()) {
            return;
        }

        List<ItemStack> finalDrops = new ArrayList<>();
        List<ItemStack> drops = Block.getDrops(state, level, pos, level.getBlockEntity(pos), player, tool);
        if (drops.isEmpty()) return;
        for (ItemStack drop : possibleDrops) {
            ItemStack smelted = trySmeltBlock(level, state, tool, blockEntity, player);
            finalDrops.add(smelted.isEmpty() ? drop.copy() : smelted);
        }

        for (ItemStack toDrop : finalDrops) {
            if (!toDrop.isEmpty()) {
                Block.popResource(level, pos, toDrop);
            }
        }

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));

        EventHooks.onPlayerDestroyItem(player, tool, player.getUsedItemHand());

    }

    public ItemStack trySmeltBlock(ServerLevel level, BlockState state, ItemStack tool, @Nullable BlockEntity blockEntity, Player player) {
        // 1. Creiamo un input usando il BLOC CO come se fosse nello slot del forno
        SingleRecipeInput recipeInput = new SingleRecipeInput(state.getBlock().asItem().getDefaultInstance());

        var recipeOpt = level.getRecipeManager()
                .getRecipeFor(RecipeType.SMELTING, recipeInput, level);

        if (recipeOpt.isPresent()) {
            var recipe = recipeOpt.get().value();

            // Assembliamo il risultato smeltato
            ItemStack smeltResult = recipe.assemble(recipeInput, level.registryAccess());

            Item itemOfBlock = state.getBlock().asItem();
            List<ItemStack> normalDrops = Block.getDrops(state, level, BlockPos.containing(0,0,0), blockEntity, player, tool);

            int dropCount = normalDrops.stream()
                    .filter(d -> d.is(itemOfBlock))
                    .mapToInt(ItemStack::getCount)
                    .sum();

            if (dropCount > 0) {
                smeltResult.setCount(smeltResult.getCount() * dropCount);
            }

            return smeltResult;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }*/
}