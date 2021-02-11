package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShopItems {
    
    // SHOP ITEMS
    
    public static ItemStack cosmeticsItem = new ItemBuilder(Material.LEATHER_CHESTPLATE).setName("§5§lCosmetic")
            .setLore("§7Klicke hier um den §6Shop §7von", "§5Cosmetics §7zu öffnen.").build();
    
    public static ItemStack gadgetsItem = new ItemBuilder(Material.DIAMOND_HOE).setName("§b§lGadgets")
            .setLore("§7Klicke hier um den §6Shop §7von", "§bGadgets §7zu öffnen.").build();
    
}
