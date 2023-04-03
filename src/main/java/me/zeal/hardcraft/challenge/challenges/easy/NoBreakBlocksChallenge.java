package me.zeal.hardcraft.challenge.challenges.easy;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class NoBreakBlocksChallenge extends Challenge {

    @EventHandler
    public void onNoBreakBlocks(BlockBreakEvent event) {
        if (!isThisChallengeActive(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_BREAK_BLOCKS;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}