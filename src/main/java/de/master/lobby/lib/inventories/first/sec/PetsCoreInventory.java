package de.master.lobby.lib.inventories.first.sec;

import de.master.lobby.lib.inventories.inv.CoreInventory;

public class PetsCoreInventory extends CoreInventory {
    
    public static String petsInventoryName = "§6§lPets";
    
    public PetsCoreInventory() {
        super(petsInventoryName, 54);
    }
    
    @Override
    public void initInventory() {
    
    }
}
