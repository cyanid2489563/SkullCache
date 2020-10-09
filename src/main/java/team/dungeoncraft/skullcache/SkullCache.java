package team.dungeoncraft.skullcache;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import team.dungeoncraft.skullcache.listener.PlayerJoin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class SkullCache extends JavaPlugin {

    public static SkullCache plugin;
    private final Map<UUID, ItemStack> skullCaches = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), plugin);
    }

    @Override
    public void onDisable() {
        skullCaches.clear();
    }

    public boolean isCached(UUID uuid) {
        return skullCaches.containsKey(uuid);
    }

    public void putSkullToCache(UUID uuid, ItemStack skull) {
        skullCaches.put(uuid, skull);
    }

    public void removeSkull(UUID uuid) {
        skullCaches.remove(uuid);
    }

    public ItemStack getSkull(UUID uuid) {
        return skullCaches.get(uuid);
    }
}
