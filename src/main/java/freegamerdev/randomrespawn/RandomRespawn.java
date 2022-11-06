package freegamerdev.randomrespawn;

import freegamerdev.randomrespawn.commands.Fly;
import freegamerdev.randomrespawn.handlers.PlayerHandler;
import freegamerdev.randomrespawn.handlers.TorchHandler;
import freegamerdev.randomrespawn.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class RandomRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("RandomRespawn startup sequence is starting.");

        saveDefaultConfig();

        List<String> kitItems = (List<String>) getConfig().getList("kit");
        for (String itemName : kitItems) {
            Bukkit.getLogger().info(itemName);
        }

        ConfigUtil config = new ConfigUtil(this, "test.yml");
        config.getConfig().set("hello", "world");
        config.save();

        getCommand("fly").setExecutor(new Fly());

        new TorchHandler(this);
        new PlayerHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Thank you for using RandomRespawn.");
    }
}
