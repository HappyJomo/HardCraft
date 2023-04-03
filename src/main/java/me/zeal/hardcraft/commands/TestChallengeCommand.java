package me.zeal.hardcraft.commands;

import me.zeal.hardcraft.challenge.ChallengeManager;
import me.zeal.hardcraft.challenge.Challenges;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (cmd.equalsIgnoreCase("testchallenge")) {
            if (args.length != 1) {
                printError(player);
                return true;
            }

            Challenges challenge;
            try {
                challenge = Challenges.valueOf(args[0].toUpperCase());
            } catch (IllegalArgumentException ex) {
                printError(player);
                return true;
            }

            ChallengeManager.getChallengeManager().assignNewChallenge(player, challenge);
            return true;
        }
        return false;
    }

    private void printError(Player player) {
        StringBuilder sb = new StringBuilder();
        for (Challenges chal : Challenges.VALUES) {
            sb.append(chal.name())
                    .append(", ");
        }

        sb.setLength(sb.length() - 2);
        player.sendMessage(ChatColor.RED + "Invalid Usage! (/testchallenge <challenge>)");
        player.sendMessage(ChatColor.RED + "Valid Challenges: " + ChatColor.YELLOW + sb);
    }

}
