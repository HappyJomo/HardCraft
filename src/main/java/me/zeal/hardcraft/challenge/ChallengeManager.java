package me.zeal.hardcraft.challenge;

import me.zeal.hardcraft.HardCraft;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class ChallengeManager {

    private boolean isStarted; // if somebody ran the /startchallenges command
    private int taskId; // the task id to cancel to stop assigning challenges

    private static ChallengeManager INSTANCE;
    private final Map<UUID, Challenge> playerChallenge = new HashMap<>(); // what challenge each player is doing

    private ChallengeManager() {
        for (Challenges challenge : Challenges.VALUES) {
            System.out.println("Registering challenge: " + challenge);
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
        double rand = Math.random();
        Challenges.Difficulty difficulty;
        if (rand < 0.4) {
            difficulty = Challenges.Difficulty.EASY;
        } else if (rand < 0.65) {
            difficulty = Challenges.Difficulty.NORMAL;
        } else if (rand < 0.85) {
            difficulty = Challenges.Difficulty.HARD;
        } else {
            difficulty = Challenges.Difficulty.EXTREME;
        }

        List<Challenges> challenges = new ArrayList<>(Arrays.asList(Challenges.VALUES));
        Collections.shuffle(challenges);

        for (Challenges challenge : challenges) {
            if (challenge.getDifficulty() == difficulty) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    assignNewChallenge(player, challenge);
                    return;
                }
            }
        }

        /*playerChallenge.forEach((uuid, challenge) -> {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null || !player.isOnline()) {
                return;
            }

            challenge.startChallenge(player);
        });*/
    }

    public void assignNewChallenge(Player player, Challenges challenge) {
        Challenge prevChallenge = playerChallenge.put(player.getUniqueId(), challenge.getChallenge());
        if (prevChallenge != null) {
            prevChallenge.stopChallenge(player);
        }

        System.out.println("Assigning challenge " + challenge + " to " + player.getName());
        challenge.getChallenge().startChallenge(player);
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