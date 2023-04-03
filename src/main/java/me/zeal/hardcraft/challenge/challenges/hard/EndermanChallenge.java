package me.zeal.hardcraft.challenge.challenges.hard;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class EndermanChallenge extends Challenge {
    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
            Location playerLoc = player.getLocation();
            World world = playerLoc.getWorld();
            Random rand = new Random();
            int x = playerLoc.getBlockX() + rand.nextInt(20) - 10;
            int z = playerLoc.getBlockZ() + rand.nextInt(20) - 10;
            int y = world.getHighestBlockYAt(x, z);
            Location teleportLoc = new Location(world, x, y, z);
            player.teleport(teleportLoc);
        }, 0, 20 * 20);
        super.startChallenge(player);
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
