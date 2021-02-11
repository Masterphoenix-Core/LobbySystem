package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CosmeticsItems {
    
    public static ItemStack trailItem = new ItemBuilder(Material.BREWING_STAND_ITEM).setName("§2Laufspuren").setLore("§7Klicke hier um das Shopmenü der §2Laufspuren §7zu öffnen.").build();
    
    public static ItemStack helmetItem = new ItemBuilder(Material.LEATHER_HELMET).setName("§a§lHelme").setLore("§7Klicke hier um das Shopmenü der §aHelme §7zu öffnen.").build();
    
    public static ItemStack chestPlateItem = new ItemBuilder(Material.LEATHER_CHESTPLATE).setName("§a§lBrustplatten").setLore("§7Klicke hier um das Shopmenü der §aBrustplatten §7zu öffnen.").build();
    
    public static ItemStack leggingsItem = new ItemBuilder(Material.LEATHER_LEGGINGS).setName("§a§lHosen").setLore("§7Klicke hier um das Shopmenü der §aHosen §7zu öffnen.").build();
    
    public static ItemStack bootsItem = new ItemBuilder(Material.LEATHER_BOOTS).setName("§a§lSchuhe").setLore("§7Klicke hier um das Shopmenü der §aSchuhe §7zu öffnen.").build();
    
    public static ItemStack headItem = new ItemBuilder(Material.SKULL_ITEM).setSkullOwner("Notch", false).setName("§5Köpfe").setLore("§7Klicke hier um das Shopmenü der §5Köpfe §7zu öffnen.").build();
}
