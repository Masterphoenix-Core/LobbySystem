package de.master.lobby.core.listener.invs;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.inventories.first.sec.ShopCoreInventory;
import de.master.lobby.lib.inventories.items.ShopItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ShopInvClick implements Listener {

    /*
    public ShopInvClick() {
        Bukkit.getPluginManager().registerEvents(this, de.master.lobby.core.bootstrap.LobbyPlugin.getPlugin());
    }

    @EventHandler
    public void on(InventoryClickEvent e) {
        
        Player p = (Player) e.getWhoClicked();
    
        if (e.getClickedInventory().getName().equalsIgnoreCase(ShopCoreInventory.shopInvName)) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getLore().equals(ShopItems.backToMenu.getItemMeta().getLore())) {
                p.openInventory(LobbyPlugin.getInstance().getExtraInv().getExtra());

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(ShopItems.cosmeticsItem.getItemMeta().getLore())) {
                p.openInventory(LobbyPlugin.getInstance().getCosmeticsInv().getInv());

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(ShopItems.rankItem.getItemMeta().getLore())) {
                // OPEN RANK INVENTORY

            }
        }
    }
     */
}
