package me.zeal.hardcraft.challenge;

import me.zeal.hardcraft.HardCraft;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ChallengeManager {

    private boolean isStarted; // if somebody ran the /startchallenges command
    private int taskId; // the task id to cancel to stop assigning challenges

    private static ChallengeManager INSTANCE;
    private static final Map<UUID, Challenge> playerChallenge = new HashMap<>(); // what challenge each player is doing

    private ChallengeManager() {
        for (Challenges challenge : Challenges.VALUES) {
            Bukkit.getServer().getPluginManager().registerEvents(challenge.getChallenge(), HardCraft.getPlugin());
        }
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public boolean isStarted() {
        return isStarted;
    }

    /**
     * Randomly assigns a new challenge to all online players
     */
    public void assignNewChallenges() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerChallenge.put(player.getUniqueId(), Challenges.VALUES[ThreadLocalRandom.current().nextInt(Challenges.getNumOfChallenges())].getChallenge());
        }

        playerChallenge.forEach((uuid, challenge) -> {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null || !player.isOnline()) {
                return;
            }

            challenge.startChallenge(player);
        });
    }

    public void setTimerId(int taskId) {
        this.taskId = taskId;
    }

    public int getTimerId() {
        return taskId;
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