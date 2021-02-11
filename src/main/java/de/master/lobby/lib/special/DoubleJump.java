package de.master.lobby.lib.special;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.util.Animations;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class DoubleJump implements Listener {
    
    private final ArrayList<Player> fixedPlayer = new ArrayList<>();
    
    public DoubleJump() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }
    
    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE && e.getPlayer().getGameMode() != GameMode.SPECTATOR) {
            this.fixedPlayer.add(e.getPlayer());
            e.setCancelled(true);
            e.getPlayer().setAllowFlight(false);
            e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.8D).setY(1.5D));
            
            if (JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().settingsManager.playerSounds.contains(e.getPlayer()))
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_WINGS, 10.0F, 10.0F);
        }
    }
    
    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerMove(PlayerMoveEvent e) {
        
        Player p = e.getPlayer();
        
        if (!p.getAllowFlight()) {
            
            Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(LobbyPlugin.class), () -> {
                if (p.isOnGround()) {
                    groundUpdate(p);
                }
                if (this.fixedPlayer.contains(p)) {
                    Bukkit.getOnlinePlayers().forEach(a -> {
                        
                        if (JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().settingsManager.playerSounds.contains(e.getPlayer()))
                            a.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
                    });
                    
                    if (p.isOnGround()) {
                        fixedPlayer.remove(p);
                    }
                }
            }, 5);
        }
    }
    
    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        groundUpdate(event.getPlayer());
    }
    
    private void groundUpdate(Player player) {
        Location location = player.getPlayer().getLocation();
        location = location.subtract(0.0D, 1.0D, 0.0D);
        Block block = location.getBlock();
        if (block.getType().isSolid()) {
            player.setAllowFlight(true);
        }
    }
}

