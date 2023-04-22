package me.zeal.hardcraft.challenge.challenges.extreme;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LaunchChallenge extends Challenge {

    private final Map<UUID, Integer> tasks = new HashMap<>();

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }
        int taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
            if (!isThisChallengeActive(player)) {
                Bukkit.getScheduler().cancelTask(tasks.get(player.getUniqueId()));
                return;
            }
            player.setVelocity(new Vector(0, 20, 0));
        }, 0, 20 * 20);

        tasks.put(player.getUniqueId(), taskId);
        super.startChallenge(player);
    }

    @Override
    public void stopChallenge(Player player) {
        Integer taskId = tasks.remove(player.getUniqueId());
        if (taskId != null) {
            Bukkit.getScheduler().cancelTask(taskId);
        }
    }

    @Override
    public Challenges getEnum() {
        return Challenges.LAUNCH;
    }

    @Override
    public int getDuration() {
        return 120;
    }
}
