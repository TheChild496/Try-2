package net.kaupenjoe.tutorialmod.block;

import net.kaupenjoe.tutorialmod.world.dimensions.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MusgraviteBlock extends Block {
    public MusgraviteBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (!player.isSneaking()) {
                MinecraftServer server = world.getServer();
                if (server != null) {
                    if (player instanceof ServerPlayerEntity) {
                        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                        if (world.getRegistryKey() == ModDimensions.KJDIM_KEY) {
                            ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                            if (overWorld != null) {
                                BlockPos destPos = getDest(player.getBlockPos(), overWorld, false);
                                serverPlayer.teleport(overWorld, destPos.getX(), destPos.getY(), destPos.getZ(), serverPlayer.getYaw(), serverPlayer.getPitch());
                            }
                        } else {
                            ServerWorld daylightWorld = server.getWorld(ModDimensions.KJDIM_KEY);
                            if (daylightWorld != null) {
                                BlockPos destPos = getDest(serverPlayer.getBlockPos(), daylightWorld, true);
                                boolean doSetBlock = true;
                                for (BlockPos checkPos : BlockPos.iterate(destPos.down(10).west(10), destPos.up(10).east(10))) {
                                    if (daylightWorld.getBlockState(checkPos).getBlock() instanceof MusgraviteBlock) {
                                        doSetBlock = false;
                                        break;
                                    }
                                }
                                if (doSetBlock) {
                                    daylightWorld.setBlockState(destPos, ModBlocks.MUSGRAVITE_BLOCK.getDefaultState());
                                }
                                serverPlayer.teleport(daylightWorld, destPos.getX(), destPos.getY(), destPos.getZ(), serverPlayer.getYaw(), serverPlayer.getPitch());
                            }
                        }
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    public static BlockPos getDest(BlockPos pos, World destWorld, boolean thisIsToDaylightDim) {
        double y = 61;
        if (!thisIsToDaylightDim) {
            y = pos.getY();
        }
        BlockPos destPos = new BlockPos(pos.getX(), y, pos.getZ());
        int tries = 0;
        while ((!destWorld.getBlockState(destPos).isAir() && !destWorld.getBlockState(destPos).canBucketPlace(Fluids.WATER)) &&
                (!destWorld.getBlockState(destPos.up()).isAir() && !destWorld.getBlockState(destPos.up()).canBucketPlace(Fluids.WATER)) &&
                tries < 25) {
            destPos = destPos.up(2);
            tries++;
        }
        return destPos;
    }
}

