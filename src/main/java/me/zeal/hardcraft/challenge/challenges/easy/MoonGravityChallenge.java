package me.zeal.hardcraft.challenge.challenges.easy;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class MoonGravityChallenge extends Challenge {

    @Override
    public void startChallenge(Player player) {
        if (!isThisChallengeActive(player)) {
            return;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, getDuration() * 20, 1, false, false));
        super.startChallenge(player);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!isThisChallengeActive(player)) {
            return;
        }

        if (player.getAllowFlight()) {
            return;
        }

        Location startLoc = event.getFrom();
        Location endLoc = event.getTo();
        if (startLoc.getBlockY() <= endLoc.getBlockY()) {
            return;
        }
        player.setVelocity(new Vector(player.getVelocity().getX(), -0.1, player.getVelocity().getZ()));
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        if (!isThisChallengeActive(player)) {
            return;
        }

        event.setCancelled(true);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.MOON_GRAVITY;
    }

    @Override
    public int getDuration() {
        return 120;
    }
}
