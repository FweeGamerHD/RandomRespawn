package freegamerdev.randomrespawn.handlers;

import freegamerdev.randomrespawn.RandomRespawn;
import freegamerdev.randomrespawn.util.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

public class PlayerHandler implements Listener {
    private ConfigUtil config;

    public PlayerHandler(RandomRespawn plugin, ConfigUtil config) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.config = config;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        int area = this.config.getConfig().getInt("area");

        Random random = new Random();
        int x = random.nextInt(area);
        int z = random.nextInt(area);
        boolean isNegativeX = random.nextBoolean();
        boolean isNegativeZ = random.nextBoolean();
        if (isNegativeX) {
            x = -x;
        } else if (isNegativeZ) {
            z = -z;
        }

        //generate a safe y coordinate with the x and z coordinates
        int y = player.getWorld().getHighestBlockYAt(x, z);

        //teleport player to the newly generated coordinates
        event.setRespawnLocation(new Location(player.getWorld(), x, y, z));

    }
}
