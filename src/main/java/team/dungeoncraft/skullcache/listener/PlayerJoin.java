package team.dungeoncraft.skullcache.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import team.dungeoncraft.skullcache.SkullCache;

import java.util.UUID;

public final class PlayerJoin implements Listener {

    private final SkullCache plugin;

    public PlayerJoin(SkullCache plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();
        if (!plugin.isCached(playerUUID)) {
            plugin.putSkullToCache(playerUUID, getPlayerSkull(playerUUID));
        }
    }

    private ItemStack getPlayerSkull(UUID uuid) {
        ItemStack craftItem = CraftItemStack.asCraftCopy(new ItemStack(Material.PLAYER_HEAD));
        SkullMeta meta = (SkullMeta) craftItem.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
        craftItem.setItemMeta(meta);

        return craftItem;
    }
}
