package de.master.lobby.lib.inventories;

import com.sun.tools.javac.code.Types;
import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.location.Locations;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class NavigationSetupCoreInventory extends CoreInventory {
    
    public NavigationSetupCoreInventory(Inventory navigationInventory) {
        super("§6Set Spawns", navigationInventory.getSize());
    }
    
    @Override
    public void initInventory() {
        inv.setItem(3, Locations.spawnMain.getItem());
        inv.setItem(5, Locations.spawnCommunity.getItem());
        inv.setItem(11, Locations.spawnKnockIt.getItem());
        //inv.setItem(11, );
        
    }
    
    
}
