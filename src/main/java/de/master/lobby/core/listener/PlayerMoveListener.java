package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.Iterator;

public class PlayerMoveListener implements Listener {
    
    public PlayerMoveListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        
        Iterator<Player> shield = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().shieldManager.shieldPlayers.keySet().iterator();
        
        while (shield.hasNext()) {
    
            Player current = shield.next();
            
            if (current.equals(p)) {
                for (Player a : Bukkit.getOnlinePlayers()) {
                    if (p != a && p.getLocation().distance(a.getLocation()) <= 3.0D) {
                        double Ax = p.getLocation().getX();
                        double Ay = p.getLocation().getY();
                        double Az = p.getLocation().getZ();
                        
                        double Bx = a.getLocation().getX();
                        double By = a.getLocation().getY();
                        double Bz = a.getLocation().getZ();
                        
                        double x = Ax - Bx;
                        double y = Ay - By;
                        double z = Az - Bz;
                        
                        Vector v = new Vector(-x, -y, -z).multiply(1.2D).setY(0.8D);
                        a.setVelocity(v);
                        
                        if (!shield.hasNext()) {
                            return;
                        }
                    }
                }
                return;
            }
            
            if (shield.hasNext()) {
                Player a = shield.next();
                if (p != a && p.getLocation().distance(a.getLocation()) <= 3.0D) {
                    double Ax = p.getLocation().getX();
                    double Ay = p.getLocation().getY();
                    double Az = p.getLocation().getZ();
                    
                    double Bx = a.getLocation().getX();
                    double By = a.getLocation().getY();
                    double Bz = a.getLocation().getZ();
                    
                    double x = Ax - Bx;
                    double y = Ay - By;
                    double z = Az - Bz;
                    
                    Vector v = new Vector(x, y, z).multiply(1.2D).setY(0.8D);
                    p.setVelocity(v);
                }
            }
        }
    }
}
