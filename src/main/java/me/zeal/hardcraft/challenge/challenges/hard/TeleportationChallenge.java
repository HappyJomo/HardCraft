package me.zeal.hardcraft.challenge.challenges.hard;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class TeleportationChallenge extends Challenge {

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }
        Location playerLoc = player.getLocation();
        World world = playerLoc.getWorld();
        Random rand = new Random();
        int x = playerLoc.getBlockX() + rand.nextInt(201) - 100;
        int z = playerLoc.getBlockZ() + rand.nextInt(201) - 100;
        int y = world.getHighestBlockYAt(x, z);
        Location teleportLoc = new Location(world, x, y, z);
        player.teleport(teleportLoc);
        super.startChallenge(player);
    }
    @Override
    public Challenges getEnum() {
        return Challenges.TELEPORTATION;
    }

    @Override
    public int getDuration() {
        return 0;
    }
}
