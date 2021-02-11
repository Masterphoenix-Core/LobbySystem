package de.master.lobby.lib.inventories.inv;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.CosmeticsItems;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CoreInventory {
    
    public final CoreLib coreLib;
    public Inventory inv;
    
    public String inventoryName;
    public int inventorySize;
    
    public CoreInventory(String inventoryName, int inventorySize) {
        coreLib = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib();
        
        this.inventoryName = inventoryName;
        this.inventorySize = inventorySize;
    
        inv = Bukkit.createInventory(null, inventorySize, inventoryName);
    
        for (int i = 0; i < inv.getSize(); ++i) {
            inv.setItem(i, CoreInventoryManager.placeholder);
        }
        
        initInventory();
    }
    
    public abstract void initInventory();
    
}
