package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExtraItems {
    public static ItemStack petsItem = new ItemBuilder(Material.DRAGON_EGG).setName("§a§lPets")
            .setLore("§7Klicke hier um das Menü mit", "§7den §aPets §7zu öffnen.").build();
    
    public static ItemStack shopItem = new ItemBuilder(Material.NETHER_STAR).setName("§e§lShop")
            .setLore("§7Klicke hier um das §aShopmenü §7zu öffnen.").build();
    
    public static ItemStack settingsItem = new ItemBuilder(Material.REDSTONE_COMPARATOR).setName("§c§lSettings")
            .setLore("§7Klicke hier um das §aEinstellungsmenü", "§7zu öffnen").build();
    
    public static ItemStack backToMenu = new ItemBuilder(Material.BARRIER).setName("§cZurück zum Menü")
            .setLore("§7Klicke auf §chier §7um das Inventar zu §cschließen§7.").build();
    
}
