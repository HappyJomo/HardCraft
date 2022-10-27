package me.zeal.hardcraft.challenges;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoPlaceBlocksChallenge extends Challenge {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        if (!isThisChallengeActive(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_PLACE_BLOCKS;
    }

    /*@Override
    protected boolean isThisChallenge() {
        ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        return challengeManager.getActiveChallenge() != null && challengeManager.getActiveChallenge() instanceof NoPlaceBlocksChallenge;
    }*/
}