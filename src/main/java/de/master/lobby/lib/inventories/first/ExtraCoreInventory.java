package de.master.lobby.lib.inventories.first;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.items.ExtraItems;

public class ExtraCoreInventory extends CoreInventory {

    public static String extraInvName = "§e§lExtras";

    public ExtraCoreInventory() {
        super(extraInvName, 27);
    }
    
    public void initInventory() {
    
        inv.setItem(26, ExtraItems.backToMenu);
        
        inv.setItem(10, ExtraItems.petsItem);
        inv.setItem(13, ExtraItems.shopItem);
        inv.setItem(16, ExtraItems.settingsItem);
        
    }
}
