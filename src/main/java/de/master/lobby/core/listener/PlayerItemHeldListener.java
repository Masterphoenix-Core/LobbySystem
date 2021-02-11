package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.util.Animations;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerItemHeldListener implements Listener {
    
    public PlayerItemHeldListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void on(PlayerItemHeldEvent e) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().settingsManager.playerSounds.contains(e.getPlayer())) {
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.WOOD_CLICK, 1.0F, 1.0F);
        }
    }
}
