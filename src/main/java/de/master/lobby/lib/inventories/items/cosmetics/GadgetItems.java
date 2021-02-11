package de.master.lobby.lib.inventories.items.cosmetics;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.cosmetics.Gadgets;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class GadgetItems {
    
    public static ItemStack
            
            unEquip = new ItemBuilder(Material.BARRIER).setName("§cGadget entfernen").setLore("§7Klicke hier um dein momentanes Gadget zu §centfernen§7.").build(),
            
            fireHoeIsBought = new ItemBuilder(Material.GOLD_HOE).setName("§6Raketenwerfer").setLore("§7Klicke hier um den §6Raketenwerfer §7auszuwählen.").build(),
            fireHoeNotBought = new ItemBuilder(Material.GOLD_HOE).setName("§6Raketenwerfer").setLore("§7Du hast den §6Raketenwerfer §cnicht freigeschaltet§7.").build(),
    
            lobbyBlocksIsBought = new ItemBuilder(Material.HARD_CLAY).setName("§aBlöcke").setLore("§7Klicke hier um die §aLobby-Blöcke §7auszuwählen.").build(),
            lobbyBlocksNotBought = new ItemBuilder(Material.HARD_CLAY).setName("§aBlöcke").setLore("§7Du hast die §aLobby-Blöcke §cnicht freigeschaltet§7.").build();
    
            public static ItemBuilder lobbyBlock = new ItemBuilder(Material.HARD_CLAY).setName("§aBlöcke");
    
    public static ItemStack getFireHoe(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasGadget(p, Gadgets.FIRE_HOE)) {
            return fireHoeIsBought;
        } else
            return fireHoeNotBought;
    }
    
    public static ItemStack getLobbyBlocks(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasGadget(p, Gadgets.LOBBY_BLOCKS)) {
            return lobbyBlocksIsBought;
        } else
            return lobbyBlocksNotBought;
    }
    
}
