package net.regions_unexplored.world.level.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.regions_unexplored.block.RuBlocks;

import javax.annotation.Nullable;

public class TillableDirtBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public TillableDirtBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {

        if (PotionUtils.getPotion(player.getItemInHand(hand))== Potions.WATER) {
            for (int i = 0; i < 5; ++i) {
                level.addParticle(ParticleTypes.SPLASH, (double) pos.getX() + level.random.nextDouble(), (double) (pos.getY() + 1), (double) pos.getZ() + level.random.nextDouble(), (double) (level.random.nextFloat() / 2.0F), 5.0E-5D, (double) (level.random.nextFloat() / 2.0F));
            }
            level.playSound((Player) null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
            if(level.getBlockState(pos)==RuBlocks.FOREST_DIRT.get().defaultBlockState()||level.getBlockState(pos)==RuBlocks.FOREST_COARSE_DIRT.get().defaultBlockState()){
                level.setBlock(pos, RuBlocks.FOREST_MUD.get().defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, RuBlocks.FOREST_MUD.get().defaultBlockState()));
            }
            else if(level.getBlockState(pos)==RuBlocks.PLAINS_DIRT.get().defaultBlockState()||level.getBlockState(pos)==RuBlocks.PLAINS_COARSE_DIRT.get().defaultBlockState()){
                level.setBlock(pos, RuBlocks.PLAINS_MUD.get().defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, RuBlocks.PLAINS_MUD.get().defaultBlockState()));
            }
            else{
                level.setBlock(pos, Blocks.MUD.defaultBlockState(), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, Blocks.MUD.defaultBlockState()));
            }
            if (player instanceof ServerPlayer serverPlayer) {
                if(serverPlayer.gameMode.getGameModeForPlayer() != GameType.CREATIVE){
                    player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE, 1));
                }
            }
            else if (player.level.isClientSide()) {
                if(Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId()).getGameMode() != GameType.CREATIVE){
                    player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE, 1));
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else {
            return super.use(state, level, pos, player, hand, result);
        }
    }

    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {

        if (ToolActions.SHOVEL_FLATTEN == action && context.getItemInHand().canPerformAction(ToolActions.SHOVEL_FLATTEN)) {
            Block block = state.getBlock();
            if (block == RuBlocks.FOREST_COARSE_DIRT.get()) {
                return RuBlocks.FOREST_DIRT_PATH.get().defaultBlockState();
            } else if (block == RuBlocks.FOREST_DIRT.get()) {
                return RuBlocks.FOREST_DIRT_PATH.get().defaultBlockState();
            } else if (block == RuBlocks.PLAINS_COARSE_DIRT.get()) {
                return RuBlocks.PLAINS_DIRT_PATH.get().defaultBlockState();
            } else if (block == RuBlocks.PLAINS_DIRT.get()) {
                return RuBlocks.PLAINS_DIRT_PATH.get().defaultBlockState();
            } else {
                return null;
            }

        }

        if (ToolActions.HOE_TILL == action && context.getItemInHand().canPerformAction(ToolActions.HOE_TILL)) {
            Block block = state.getBlock();
            if (block == RuBlocks.FOREST_COARSE_DIRT.get()) {
                return RuBlocks.FOREST_DIRT.get().defaultBlockState();
            } else if (block == RuBlocks.FOREST_DIRT.get()) {
                return RuBlocks.FOREST_FARMLAND.get().defaultBlockState();
            } else if (block == RuBlocks.PLAINS_COARSE_DIRT.get()) {
                return RuBlocks.PLAINS_DIRT.get().defaultBlockState();
            } else if (block == RuBlocks.PLAINS_DIRT.get()) {
                return RuBlocks.PLAINS_FARMLAND.get().defaultBlockState();
            } else {
                return null;
            }

        }
        return null;
    }
}