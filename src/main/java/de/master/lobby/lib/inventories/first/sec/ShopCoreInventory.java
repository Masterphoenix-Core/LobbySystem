package de.master.lobby.lib.inventories.first.sec;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.inventories.items.ShopItems;
import lombok.Getter;

@Getter
public class ShopCoreInventory extends CoreInventory {
    
    public static final String shopInvName = "§dShop";

    public ShopCoreInventory() {
        super(shopInvName, 27);
    }
    
    public void initInventory() {
    
        inv.setItem(11, ShopItems.cosmeticsItem);
        inv.setItem(15, ShopItems.gadgetsItem);
    
        inv.setItem(13, CoreInventoryManager.backToMenu);
    }
}
