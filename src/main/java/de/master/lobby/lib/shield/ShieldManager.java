package de.master.lobby.lib.shield;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.JoinItems;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ShieldManager {
    
    public HashMap<Player, BukkitRunnable> shieldPlayers;
    
    public ShieldManager() {
        shieldPlayers = new HashMap<>();
        
    }
    
    public void toggleShield(Player p) {
        if(!shieldPlayers.containsKey(p)) {
            
            shieldPlayers.put(p, new BukkitRunnable() {
                @Override
                public void run() {
                    CoreLib.drawCircle((new Location(Bukkit.getWorld("world"), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())).add(0.0D, 0.1D, 0.0D), 2.0F, EnumParticle.FLAME);
                    CoreLib.drawCircle((new Location(Bukkit.getWorld("world"), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())).add(0.0D, 2.2D, 0.0D), 2.0F, EnumParticle.FLAME);
                }
            });
            shieldPlayers.get(p).runTaskTimer(JavaPlugin.getPlugin(LobbyPlugin.class), 10L, 10L);
            
            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), JoinItems.shieldItemIsOn);
            p.sendMessage(CoreLib.prefix + "Du hast dein Schild §aaktiviert§7!");
            
        } else {
            
            shieldPlayers.get(p).cancel();
            shieldPlayers.remove(p);
            
            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), JoinItems.shieldItemIsOff);
            p.sendMessage(CoreLib.prefix + "Du hast dein Schild §cdeaktiviert§7!");
        }
    }
    
}
