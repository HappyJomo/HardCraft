package me.zeal.hardcraft.challenge.challenges;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoPlaceBlocksChallenge extends Challenge {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!isThisChallengeActive(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_PLACE_BLOCKS;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}