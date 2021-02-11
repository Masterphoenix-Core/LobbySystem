package de.master.lobby.lib.inventories;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.location.Locations;
import org.bukkit.inventory.Inventory;

public class NavigationCoreInventory extends CoreInventory {
    
    public NavigationCoreInventory() {
        super("§6§lNavigation", 3 * 9);
    }
    
    @Override
    public void initInventory() {
        inv.setItem(3, Locations.spawnMain.getItem());
        inv.setItem(5, Locations.spawnCommunity.getItem());
        inv.setItem(11, Locations.spawnKnockIt.getItem());
        //inv.setItem(11, );
    }
    
}
