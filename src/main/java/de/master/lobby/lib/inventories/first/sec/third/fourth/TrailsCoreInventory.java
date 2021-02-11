package de.master.lobby.lib.inventories.first.sec.third.fourth;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.inventories.items.cosmetics.TrailsItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TrailsCoreInventory extends CoreInventory {
    
    public static final String extrasLaneInvName = "§eExtras§7-§eLanes";
    Inventory inv;
    
    public TrailsCoreInventory() {
        super(extrasLaneInvName, 27);
    }
    
    public Inventory getInv(Player p) {
        
        inv.setItem(10, TrailsItems.getPlayerBlazeLaneItem(p));  //EMERALD
        inv.setItem(11, TrailsItems.getPlayerGlowStoneLaneItem(p));  //DIAMOND
        inv.setItem(15, TrailsItems.getPlayerRainbowLaneItem(p)); //RAINBOW
        inv.setItem(16, TrailsItems.getPlayerCookieLaneItem(p));  //COOKIE
    
        inv.setItem(13, CoreInventoryManager.backToMenu);  //BACK TO MENU
        inv.setItem(26, TrailsItems.none);
    
        return inv;
    }
    
    public void initInventory() {
    
    
    
    }
    
    
}
