package me.zeal.hardcraft.challenge.challenges.normal;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ShuffleInventoryChallenge extends Challenge {

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

            ItemStack[] playerInv = player.getInventory().getContents();
            Collections.shuffle(Arrays.asList(playerInv));
            player.getInventory().setContents(playerInv);
        }, 0, 5 * 20);

        tasks.put(player.getUniqueId(), taskId);
        super.startChallenge(player);
    }

    @Override
    public Challenges getEnum() {
        return Challenges.SHUFFLE_INVENTORY;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}