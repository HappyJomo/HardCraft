package me.zeal.hardcraft.challenge.challenges.hard;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FreezeChallenge extends Challenge {

    private boolean frozen = false;
    private final Map<UUID, Integer> tasks = new HashMap<>();

    @Override
    public void startChallenge(Player player) {
        int firstTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
            frozen = true;
            player.sendMessage(ChatColor.BLUE + "Freeze!");
            Bukkit.getScheduler().scheduleSyncDelayedTask(HardCraft.getPlugin(), () -> {
                frozen = false;
                player.sendMessage(ChatColor.GREEN + "Un-Freeze!");
            }, 10 * 20);
        }, 0, 30 * 20);
        
        tasks.put(player.getUniqueId(), firstTaskId);
    }

    @Override
    public void stopChallenge(Player player) {
        Integer taskId = tasks.remove(player.getUniqueId());
        if (taskId != null) {
            Bukkit.getScheduler().cancelTask(taskId);
            frozen = false;
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (frozen) {
            Player player = event.getPlayer();
            Location from = event.getFrom();
            Location to = event.getTo();
            if (to.getBlockX() != from.getBlockX() || to.getBlockZ() != from.getBlockZ() || to.getBlockY() != from.getBlockY()) {
                player.teleport(from);
            }
        }
    }

    @Override
    public Challenges getEnum() {
        return Challenges.FROZEN;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}
