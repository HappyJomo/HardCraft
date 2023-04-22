package me.zeal.hardcraft.commands;

import me.zeal.hardcraft.HardCraft;
import me.zeal.hardcraft.challenge.ChallengeManager;
import me.zeal.hardcraft.challenge.challenges.ChallengeTimer;
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

            challengeManager.setTimerId(new ChallengeTimer().runTaskTimer(HardCraft.getPlugin(), 0, 1).getTaskId());
        }
        return true;
    }
}