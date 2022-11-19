package me.zeal.hardcraft.commands;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.ChallengeManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartChallengesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        ChallengeManager challengeManager = ChallengeManager.getChallengeManager();
        if (cmd.equalsIgnoreCase("startchallenges")) {
            if (challengeManager.isStarted()) {
                sender.sendMessage(ChatColor.RED + "Challenges are already ongoing!");
                player.sendMessage(ChatColor.RED + "To stop challenges: /stopchallenges");
                return true;
            }

            challengeManager.setStarted(true);
            player.sendMessage(ChatColor.GREEN + "The challenges are now in action. Watch your step!");
            challengeManager.setTimerId(Bukkit.getScheduler().scheduleSyncRepeatingTask(HardCraft.getPlugin(), () -> {
                ChallengeManager.getChallengeManager().assignNewChallenges();
            }, 120 * 20, 120 * 20)); // every 2 minutes
        }
        return true;
    }
}