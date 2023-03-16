package net.kaupenjoe.tutorialmod.events;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public class guide {

    public class ExampleMod implements ModInitializer
    {

        @Override
        public void onInitialize()
        {
            AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) ->
            {
                BlockState state = world.getBlockState(pos);
            /* Manual spectator check is necessary because AttackBlockCallbacks
               fire before the spectator check */
                if (state.isToolRequired() && !player.isSpectator() &&
                        player.getMainHandStack().isEmpty())
                {
                    player.damage(DamageSource.GENERIC, 1.0F);
                }
                return ActionResult.PASS;
            });
        }
    }
}
