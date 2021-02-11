package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinItems {
    
    public static ItemStack navItem = new ItemBuilder(Material.COMPASS).setName("§e§lTeleporter").setLore("", "§7Klicke hier um einen Spielmodus auszuwählen.").build(),
    extraInvItem = new ItemBuilder(Material.WATCH).setName("§e§lExtras").setLore("", "§7Klicke hier um die Extras zu öffnen.").build(),
    silentLobbyIsOff = new ItemBuilder(Material.TNT).setName("§c§lSilent Lobby §8§l| §c§lAus").setLore("", "§7Klicke hier um in die SilentLobby zu gelangen.").build(),
    silentLobbyIsOn =new ItemBuilder(Material.TNT).setName("§c§lSilent Lobby §8§l| §a§lAn").setLore("", "§7Klicke hier um in die normale Lobby zu gelangen.").build(),
    shieldItemIsOff = new ItemBuilder(Material.EYE_OF_ENDER).setName("§5§lSchutzschild §8§l| §c§lAus").setLore("", "§7Klicke hier um das Schutzschild zu aktivieren.").build(),
    shieldItemIsOn = new ItemBuilder(Material.EYE_OF_ENDER).setName("§5§lSchutzschild §8§l| §a§lAn").setLore("", "§7Klicke hier um das Schutzschild zu deaktivieren.").build(),
    lobbySwitcher = new ItemBuilder(Material.NETHER_STAR).setName("§2§lLobbyswitcher").setLore("", "§7Klicke um auf eine andere Lobby zukommen§8.").build();
    
    public static void giveJoinItems(Player p) {
        Inventory inv = p.getInventory();
    
        System.out.println("Join Items for " + p.getName());
        
        inv.clear();
        
        inv.setItem(0, navItem);
        inv.setItem(1, extraInvItem);
        
        inv.setItem(8, lobbySwitcher);
    
        if (p.hasPermission("lobby.silent")) {
            if(!p.hasMetadata("silent"))
                inv.setItem(3, silentLobbyIsOff);
            else
                inv.setItem(3, silentLobbyIsOn);
        }
    
        if (p.hasPermission("lobby.shield"))
            inv.setItem(5, shieldItemIsOff);
        
    }
}
