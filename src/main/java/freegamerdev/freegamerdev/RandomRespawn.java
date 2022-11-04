package freegamerdev.freegamerdev;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("RandomRespawn startup sequence is starting.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Thank you for using RandomRespawn.");
    }
}
