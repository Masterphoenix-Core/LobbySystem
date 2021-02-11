package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.JoinItems;
import de.master.lobby.lib.location.Locations;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        
        Player p = e.getPlayer();
        LobbyPlugin lobbyPlugin = JavaPlugin.getPlugin(LobbyPlugin.class);
        
        e.setJoinMessage(null);
        
        new Thread(() -> {
            if (!lobbyPlugin.getCoreLib().locationManager.locationExists(Locations.spawnMain)) {
                Bukkit.broadcastMessage(CoreLib.prefix + "§7Der §eSpawn §7wurde nicht gesetzt!");
            } else {
                try {
                    p.teleport(lobbyPlugin.getCoreLib().locationManager.getLocation(Locations.spawnMain));
                } catch (Exception var4) {
                    var4.printStackTrace();
                }
            }
    
            p.getInventory().clear();
    
            JoinItems.giveJoinItems(p);
            
        }).start();
    
        p.setMaxHealth(6.0D);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        p.setFlying(false);
        p.setAllowFlight(false);
        p.setExp(1.0F);
        p.setGameMode(GameMode.ADVENTURE);
        
        if (!lobbyPlugin.getMySQL().sqlCosmetics.playerLaneExists(p)) {
            lobbyPlugin.getMySQL().sqlCosmetics.createPlayerLane(p);
        }
    
        if (!lobbyPlugin.getMySQL().sqlCosmetics.playerGadgetsExists(p)) {
            lobbyPlugin.getMySQL().sqlCosmetics.createPlayerGadgets(p);
        }
        
        if (!lobbyPlugin.getMySQL().sqlSettings.playerExists(p)) {
            lobbyPlugin.getMySQL().sqlSettings.createPlayer(p);
        }
        
        new Thread(() -> {
            Bukkit.getOnlinePlayers().forEach(c -> {
                if (JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().silentManager.playerSilent(c)) {
                    JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().silentManager.hideFor(p, c);
                }
            });
        }).start();
        
        
    }
}

