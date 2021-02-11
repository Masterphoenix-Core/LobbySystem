package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.settings.SettingsManager;
import de.master.lobby.lib.util.Animations;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerQuitListener implements Listener {
    
    public PlayerQuitListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
    
        SettingsManager settingsManager = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().settingsManager;
        settingsManager.playerSounds.remove(p);
        settingsManager.playerGuiAnimations.remove(p);
        
        if (p.hasMetadata("build"))
            p.removeMetadata("build", JavaPlugin.getPlugin(LobbyPlugin.class));
        
    }
}
