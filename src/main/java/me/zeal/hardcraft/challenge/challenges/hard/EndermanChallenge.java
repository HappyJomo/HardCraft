package me.zeal.hardcraft.challenge.challenges.hard;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class EndermanChallenge extends Challenge {

    private final Map<UUID, Integer> tasks = new HashMap<>();

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }

        int taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
            Location playerLoc = player.getLocation();
            World world = playerLoc.getWorld();
            Random rand = new Random();
            int x = playerLoc.getBlockX() + rand.nextInt(20) - 10;
            int z = playerLoc.getBlockZ() + rand.nextInt(20) - 10;
            int y = world.getHighestBlockYAt(x, z);
            Location teleportLoc = new Location(world, x, y, z);
            player.teleport(teleportLoc);
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
        return Challenges.ENDERMAN;
    }

    @Override
    public int getDuration() {
        return 120;
    }
}
