package de.master.lobby.lib.silent;

import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.JoinItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SilentManager {
    
    public ArrayList<String> silentLobby;
    
    public SilentManager() {
        silentLobby = new ArrayList<>();
        
    }
    
    public void toggleSilent(Player p) {
    
        if (!silentLobby.contains(p.getName())) {
    
            silentLobby.add(p.getName());
            Bukkit.getOnlinePlayers().forEach(a -> {
                a.hidePlayer(p);
                p.hidePlayer(a);
            });
            p.sendMessage(CoreLib.prefix + "Du bist nun in der §cSilent Lobby§7.");
            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), JoinItems.silentLobbyIsOn);
            
        } else {
    
            silentLobby.remove(p.getName());
            Bukkit.getOnlinePlayers().forEach(a -> {
                a.showPlayer(p);
                p.showPlayer(a);
            });
            p.sendMessage(CoreLib.prefix + "Du bist nun in der §enormalen Lobby§7.");
            p.getInventory().setItem(p.getInventory().getHeldItemSlot(), JoinItems.silentLobbyIsOff);
    
        }
        
    }
    
    public void hideFor(Player p, Player t) {
        p.hidePlayer(t);
        t.hidePlayer(p);
    }
    
    public boolean playerSilent(Player p) {
        return silentLobby.contains(p.getName());
    }
    
}
