package me.zeal.hardcraft;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class HardCraft extends JavaPlugin {
    // TODO
    // Make random bad stuff happen every 2 minutes or so. For example move slower, can't place blocks for x seconds, can't break blocks...

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}