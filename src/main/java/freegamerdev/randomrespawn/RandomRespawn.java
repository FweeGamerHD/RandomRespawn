package freegamerdev.randomrespawn;

import freegamerdev.randomrespawn.handlers.PlayerHandler;
import freegamerdev.randomrespawn.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("RandomRespawn has been initialized.");

        //check if config file is empty
        ConfigUtil config = new ConfigUtil(this, "config.yml");
        if(config.getConfig().getKeys(false).isEmpty()) {
            //set default values
            config.getConfig().set("radius", 5000);
            config.save();
        }

        //register event handlers
        new PlayerHandler(this, config);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Thank you for using RandomRespawn.");
    }
}
