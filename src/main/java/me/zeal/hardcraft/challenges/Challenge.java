package me.zeal.hardcraft.challenges;

import org.bukkit.entity.Player;

public abstract class Challenge {

    public abstract Challenges getEnum();

    protected boolean isThisChallengeActive(Player player) {
        ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        return challengeManager.getActiveChallenge(player) != null && challengeManager.getActiveChallenge(player).getEnum() == this.getEnum();
    }
}