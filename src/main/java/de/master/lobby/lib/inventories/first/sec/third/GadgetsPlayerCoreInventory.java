package de.master.lobby.lib.inventories.first.sec.third;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.inventories.items.cosmetics.GadgetItems;
import de.master.lobby.lib.mysql.SqlSettings;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class GadgetsPlayerCoreInventory extends CoreInventory {
    
    public static String gadgetsInventoryName = "§b§lGadgets";
    
    public HashMap<Player, Inventory> playerGadgetInventory;
    
    public GadgetsPlayerCoreInventory() {
        super(gadgetsInventoryName, 27);
        playerGadgetInventory = new HashMap<>();
    }
    
    @Override
    public void initInventory() {
    
    }
    
    public void reloadInvfor(Player p) {
        SqlSettings settings = JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlSettings;
        
        if (playerGadgetInventory.containsKey(p)) {
            this.inv = playerGadgetInventory.get(p);
        }
        
        inv.setItem(12, GadgetItems.getLobbyBlocks(p));
        inv.setItem(14, GadgetItems.getFireHoe(p));
        
        inv.setItem(22, GadgetItems.unEquip);
        
        playerGadgetInventory.put(p, inv);
    }
    
    public Inventory getInvFor(Player p, boolean reload) {
        if (reload) {
            reloadInvfor(p);
        }
        return playerGadgetInventory.get(p);
    }
}
