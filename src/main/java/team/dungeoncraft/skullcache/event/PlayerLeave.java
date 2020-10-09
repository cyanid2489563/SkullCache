package team.dungeoncraft.skullcache.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import team.dungeoncraft.skullcache.SkullCache;

import java.util.UUID;

public final class PlayerLeave implements Listener {

    private final SkullCache plugin;

    public PlayerLeave(SkullCache plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();
        if (plugin.isCached(playerUUID)) {
            plugin.removeSkull(playerUUID);
        }
    }
}
