package me.zeal.hardcraft.challenge;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public abstract class Challenge implements Listener {

    public abstract Challenges getEnum();

    /**
     * @return the amount of time this challenge is active in seconds
     */
    public abstract int getDuration();

    protected boolean isThisChallengeActive(Player player) {
        ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        return challengeManager.getActiveChallenge(player) != null && challengeManager.getActiveChallenge(player).getEnum() == this.getEnum();
    }

    /**
     * Assign potion effects or anything we need to start a challenge once a challenge is assigned to a player
     * @param player the player doing the challenge
     */
    public void startChallenge(Player player) {
    }

    public void stopChallenge(Player player) {

    }
}