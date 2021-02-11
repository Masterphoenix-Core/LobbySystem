package de.master.lobby.lib.inventories.first.sec.third;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.inventories.items.CosmeticsItems;

public class CosmeticsCoreInventory extends CoreInventory {
    
    public static final String extrasCosmeticsInvName = "§eExtras§7-§eCosmetics";
    
    public CosmeticsCoreInventory() {
        super(extrasCosmeticsInvName, 54);
    }
    
    public void initInventory() {
    
        inv.setItem(21, CosmeticsItems.headItem);
        inv.setItem(19, CosmeticsItems.trailItem);
        inv.setItem(15, CosmeticsItems.helmetItem);
        inv.setItem(23, CosmeticsItems.chestPlateItem);
        inv.setItem(25, CosmeticsItems.leggingsItem);
        inv.setItem(33, CosmeticsItems.bootsItem);
        
        inv.setItem(40, CoreInventoryManager.backToMenu);
        
    }
    
}
