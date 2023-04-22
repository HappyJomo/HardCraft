package me.zeal.hardcraft.commands;

import me.zeal.hardcraft.challenge.ChallengeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopChallengesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        if (cmd.equalsIgnoreCase("stopchallenges")) {
            if (!challengeManager.isStarted()) {
                player.sendMessage(ChatColor.RED + "No challenges are active!");
                return true;
            }
        }

        challengeManager.setStarted(false);
        Bukkit.getScheduler().cancelTask(challengeManager.getTimerId());
        player.sendMessage(ChatColor.GREEN + "Stopping challenges!");

        return true;
    }
}
