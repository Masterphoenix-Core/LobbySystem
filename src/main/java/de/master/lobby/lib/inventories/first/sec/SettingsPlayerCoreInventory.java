package de.master.lobby.lib.inventories.first.sec;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.inventories.items.SettingsItems;
import de.master.lobby.lib.mysql.SqlSettings;
import de.master.lobby.lib.settings.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class SettingsPlayerCoreInventory extends CoreInventory {
    
    public static final String settingsInvName = "§c§lSettings";
    
    public HashMap<Player, Inventory> playerSettingsInventory;
    
    public SettingsPlayerCoreInventory() {
        super(settingsInvName, 54);
        playerSettingsInventory = new HashMap<>();
    }
    
    @Override
    public void initInventory() {
    
    }
    
    public void reloadInvfor(Player p) {
        SqlSettings settings = JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlSettings;
        
        if (playerSettingsInventory.containsKey(p)) {
            this.inv = playerSettingsInventory.get(p);
        }
        
        inv.setItem(13, SettingsItems.playerHideItem);
        
        if (settings.getPlayerSetting(p, Settings.PLAYER_HIDE) == 0) {
            inv.setItem(22, SettingsItems.playerHideRed);
        } else if (settings.getPlayerSetting(p, Settings.PLAYER_HIDE) == 1) {
            inv.setItem(22, SettingsItems.playerHidePurple);
        } else if (settings.getPlayerSetting(p, Settings.PLAYER_HIDE) == 2) {
            inv.setItem(22, SettingsItems.playerHideGreen);
        }
        
        inv.setItem(24, SettingsItems.guiAnimationsItem);
        
        if (settings.getPlayerGuiAnimations(p)) {
            inv.setItem(33, SettingsItems.guiAnimationsGreen);
        } else {
            inv.setItem(33, SettingsItems.guiAnimationsRed);
        }
        
        inv.setItem(25, SettingsItems.soundsItem);
        
        if (settings.getPlayerSounds(p)) {
            inv.setItem(34, SettingsItems.soundsGreen);
        } else {
            inv.setItem(34, SettingsItems.soundsRed);
        }
        
        inv.setItem(40, CoreInventoryManager.backToMenu);
        
        playerSettingsInventory.put(p, inv);
    }
    
    public Inventory getInvFor(Player p, boolean reload) {
        if (reload) {
            reloadInvfor(p);
        }
        return playerSettingsInventory.get(p);
    }
    
}
