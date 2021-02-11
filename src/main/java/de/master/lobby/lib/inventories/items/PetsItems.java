package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PetsItems {

    // PETS ITEMS

    public static ItemStack backToMenu = new ItemBuilder(Material.BARRIER).setName("§cZurück ins Menü")
            .setLore("§7Klicke auf §chier §7um ins §cHauptmenü §7zu gelangen.").build();

}
