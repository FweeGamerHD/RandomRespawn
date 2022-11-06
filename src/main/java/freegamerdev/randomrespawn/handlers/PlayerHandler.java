package freegamerdev.randomrespawn.handlers;

import freegamerdev.randomrespawn.RandomRespawn;
import freegamerdev.randomrespawn.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerHandler implements Listener {
    private ConfigUtil config;

    public PlayerHandler(RandomRespawn plugin, ConfigUtil config) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.config = config;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        int radius = this.config.getConfig().getInt("radius");

        Bukkit.getLogger().info("A Player has respawned.");
        Bukkit.getLogger().info("The radius is: " + radius);

    }
}
