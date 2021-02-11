package de.master.lobby.lib.settings;

import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.mysql.MySql;
import de.master.lobby.lib.mysql.SqlSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsManager {
    
    private final SqlSettings settings;
    
    public HashMap<Player, Integer> playerHide;
    public ArrayList<Player> playerGuiAnimations, playerSounds;
    
    public SettingsManager(MySql mySql) {
        settings = mySql.sqlSettings;
    
        playerHide = new HashMap<>();
        playerGuiAnimations = new ArrayList<>();
        playerSounds = new ArrayList<>();
    }
    
    public void toggleGuiAnimations(Player p) {
        checkFor(p);
        
        int x = settings.getPlayerSetting(p, Settings.GUI_ANIMATIONS);
        
        if (x == 1) { // DEAKTIVIERUNG
            //p.sendMessage(CoreLib.prefix + "Du hast die " + Settings.GUI_ANIMATIONS.getName() + " §cdeaktiviert§7.");
            playerGuiAnimations.remove(p);
            
        } else { // AKTIVIERUNG
            //p.sendMessage(CoreLib.prefix + "Du hast die " + Settings.GUI_ANIMATIONS.getName() + " §aaktiviert§7.");
            playerGuiAnimations.add(p);
        }
        
        settings.setPlayerSetting(p, Settings.GUI_ANIMATIONS, (-x + 1));
    }
    
    public void toggleSounds(Player p) {
        checkFor(p);
        
        int x = settings.getPlayerSetting(p, Settings.SOUNDS);
    
        if (x == 1) { // DEAKTIVIERUNG
            //p.sendMessage(CoreLib.prefix + "Du hast die " + Settings.SOUNDS.getName() + " §cdeaktiviert§7.");
            playerSounds.remove(p);
            
        } else { // AKTIVIERUNG
            //p.sendMessage(CoreLib.prefix + "Du hast die " + Settings.SOUNDS.getName() + " §aaktiviert§7.");
            playerSounds.add(p);
        }
    
        settings.setPlayerSetting(p, Settings.SOUNDS, (-x + 1));
    }
    
    public void showNoPlayers(Player p) {
        checkFor(p);
    
        Bukkit.getOnlinePlayers().forEach(a -> {
            a.hidePlayer(p);
            p.hidePlayer(a);
        });
        settings.setPlayerSetting(p, Settings.PLAYER_HIDE, 0);
        playerHide.remove(p);
        playerHide.put(p, 0);
    }
    
    public void showOnlyVip(Player p) {
        checkFor(p);
    
        Bukkit.getOnlinePlayers().forEach(a -> {
            a.showPlayer(p);
            p.showPlayer(a);
    
            if (!a.hasPermission("lobby.vip")) {
                a.hidePlayer(p);
                p.hidePlayer(a);
            }
        });
        settings.setPlayerSetting(p, Settings.PLAYER_HIDE, 1);
        playerHide.remove(p);
        playerHide.put(p, 1);
    }
    
    public void showEveryOne(Player p) {
        checkFor(p);
    
        Bukkit.getOnlinePlayers().forEach(a -> {
            a.showPlayer(p);
            p.showPlayer(a);
        });
        settings.setPlayerSetting(p, Settings.PLAYER_HIDE, 2);
        playerHide.remove(p);
        playerHide.put(p, 2);
    }
    
    private void checkFor(Player p) {
        if (!settings.playerExists(p)) {
            settings.createPlayer(p);
        }
    }
    
}
