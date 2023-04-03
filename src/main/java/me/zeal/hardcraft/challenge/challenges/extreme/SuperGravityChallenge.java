package me.zeal.hardcraft.challenge.challenges.extreme;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class SuperGravityChallenge extends Challenge {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!isThisChallengeActive(event.getPlayer())) {
            return;
        }
        Player player = event.getPlayer();
        if (player.getAllowFlight()) {
            return;
        }
        World world = player.getWorld();
        Location playerLoc = player.getLocation();
        int x = playerLoc.getBlockX();
        int z = playerLoc.getBlockZ();
        if (!player.isOnGround()) {
            int highestBlock = world.getHighestBlockYAt(x, z);
            if (playerLoc.getBlockY() - highestBlock > 3) {
                player.setVelocity(new Vector(player.getVelocity().getX(), -1.2, player.getVelocity().getZ()));
            } else {
                player.setVelocity(new Vector(player.getVelocity().getX(), -0.5, player.getVelocity().getZ()));
            }
        }
    }
    @Override
    public Challenges getEnum() {
        return Challenges.SUPER_GRAVITY;
    }

    @Override
    public int getDuration() {
        return 120;
    }
}
