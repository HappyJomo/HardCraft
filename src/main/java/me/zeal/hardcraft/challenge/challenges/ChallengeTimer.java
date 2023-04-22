package me.zeal.hardcraft.challenge.challenges;

import me.zeal.hardcraft.challenge.ChallengeManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ChallengeTimer extends BukkitRunnable {

    private static final int CHALLENGE_DURATION = 120 * 20; // How long until we receive the next challenge

    private boolean assignedFirst = false;
    private int tick = 0;

    @Override
    public void run() {
        if (!assignedFirst) {
            assignedFirst = true;
            ChallengeManager.getChallengeManager().assignNewChallenges();
            return;
        }

        if (tick++ >= CHALLENGE_DURATION) {
            ChallengeManager.getChallengeManager().assignNewChallenges();
            tick = 0;
        }

        if (tick % 20 == 0) {
            String remainingTime = formatTime((CHALLENGE_DURATION - tick) / 20);
            PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.GREEN + "Next Challenge: " + ChatColor.YELLOW + remainingTime + "\"}"), (byte) 2);
            for (Player player : Bukkit.getOnlinePlayers()) {
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
            }
        }
    }

    private String formatTime(int time) {
        int minutes = time / 60;
        time %= 60;
        return String.format("%02d:%02d", minutes, time);
    }
}
