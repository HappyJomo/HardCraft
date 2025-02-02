package me.zeal.hardcraft.challenge.challenges.normal;

import me.zeal.hardcraft.challenge.Challenge;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class NoInventoryChallenge extends Challenge {

    @EventHandler
    public void onInventoryOpen(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!isThisChallengeActive(player)) {
            return;
        }

        event.setCancelled(true);
        player.closeInventory();
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!isThisChallengeActive(player)) {
            return;
        }

        event.setCancelled(true);
        player.closeInventory();
    }

    @Override
    public Challenges getEnum() {
        return Challenges.NO_INVENTORY;
    }

    @Override
    public int getDuration() {
        return 90;
    }
}