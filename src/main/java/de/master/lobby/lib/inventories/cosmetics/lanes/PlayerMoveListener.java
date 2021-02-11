package de.master.lobby.lib.inventories.cosmetics.lanes;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class PlayerMoveListener implements Listener {
    
    private final LaneManager laneManager;
    
    public PlayerMoveListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
        laneManager = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().laneManager;
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();
        double x = Math.floor(from.getX());
        double z = Math.floor(from.getZ());
        if (Math.floor(to.getX()) != x || Math.floor(to.getZ()) != z) {
            
            for (int i = 0; i < 3; ++i) {
                
                Item[] items = laneManager.getItemDrops(p);
                Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(LobbyPlugin.class), () -> {
                    for (Item item : items) {
                        item.remove();
                    }
                    
                }, 10L);
                
                if (!p.getLocation().getBlock().getType().equals(Material.WATER) && !p.getLocation().getBlock().getType().equals(Material.STATIONARY_WATER)) {
                    if (p.getLocation().add(0.0D, 0.0D, 0.0D).getBlock().getType().equals(Material.GOLD_PLATE) && p.getLocation().add(0.0D, -2.0D, 0.0D).getBlock().getType().equals(Material.REDSTONE_BLOCK)) {
                        p.setVelocity(p.getLocation().getDirection().multiply(9).setY(2.2D));
                    }
                } else {
                    p.setVelocity(p.getLocation().getDirection().multiply(8).setY(2.5D));
                }
            }
        }
        
    }
}