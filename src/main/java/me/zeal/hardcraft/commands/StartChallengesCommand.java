package me.zeal.hardcraft.commands;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenges.Challenges;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartChallengesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] strings) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (cmd.equalsIgnoreCase("startchallenges")) {
            player.sendMessage(ChatColor.GREEN + "The challenges are now in action. Watch your step!");
            Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
                // pick a challenge
            }, 20 * 120, 20 * 120);
        }
        return true;
    }
}