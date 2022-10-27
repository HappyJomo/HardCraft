package me.zeal.hardcraft.challenges;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChallengeManager {

    private static ChallengeManager INSTANCE;
    private static final Map<UUID, Challenge> playerChallenge = new HashMap<>();

    private Challenge activeChallenge;

    private ChallengeManager() {
    }

    public void setTimer() {

    }

    public Challenge getActiveChallenge(Player player) {
        return playerChallenge.get(player.getUniqueId());
    }

    public static ChallengeManager getChallengeManager() {
        if (INSTANCE == null) {
            INSTANCE = new ChallengeManager();
        }

        return INSTANCE;
    }
}