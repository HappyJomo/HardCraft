package me.zeal.hardcraft;

import me.zeal.hardcraft.commands.StartChallengesCommand;
import me.zeal.hardcraft.commands.StopChallengesCommand;
import me.zeal.hardcraft.commands.TestChallengeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class HardCraft extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getPluginCommand("startchallenges").setExecutor(new StartChallengesCommand());
        Bukkit.getPluginCommand("stopchallenges").setExecutor(new StopChallengesCommand());
        Bukkit.getPluginCommand("testchallenge").setExecutor(new TestChallengeCommand());

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}