package de.master.lobby.lib.inventories.items;

import de.master.lobby.lib.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
public class SettingsItems {

    public static ItemStack guiAnimationsItem = new ItemBuilder(Material.EXP_BOTTLE).setName("§5GUI-Animationen")
            .setLore("§7Klicke auf die §aFarbe §7um die §5GUI-Animationen §7ein oder auszuschalten.").build();
    
    public static ItemStack guiAnimationsGreen = new ItemBuilder(Material.INK_SACK, 10).setName("§aAktiviert")
                    .setLore("§7Die §5GUI-Animationen §7sind §aaktiviert§7.").build();
    
    public static ItemStack guiAnimationsRed = new ItemBuilder(Material.INK_SACK, 1).setName("§cDeaktiviert")
            .setLore("§7Die §5GUI-Animationen §7sind §cdeaktiviert§7.").build();
    
    public static ItemStack playerHideItem = new ItemBuilder(Material.MONSTER_EGG, 92).setName("§aSpieleransicht")
                .setLore("§7Klicke auf die §aFarbe §7um deine §aSpieleransicht §7zu ändern.").build();
    
    public static ItemStack playerHideGreen = new ItemBuilder(Material.INK_SACK, 10).setName("§aAlle Spieler Anzeigen")
            .setLore("§7Momentan werden dir §aAlle Spieler §7angezeigt.").build();
    
    public static ItemStack playerHidePurple = new ItemBuilder(Material.INK_SACK, 14).setName("§5Nur VIPs Anzeigen")
            .setLore("§7Momentan werden dir §5Nur VIPs §7angezeigt.").build();
    
    public static ItemStack playerHideRed = new ItemBuilder(Material.INK_SACK, 1).setName("§cKeine Spieler Anzeigen")
            .setLore("§7Momentan werden dir §cKeine Spieler §7angezeigt.").build();
    
    public static ItemStack soundsItem = new ItemBuilder(Material.RECORD_3).setName("§bGUI-Sounds")
            .setLore("§7Klicke auf die §aFarbe §7um deine §bGUI-Sounds §7zu ändern.").build();
    
    public static ItemStack soundsGreen = new ItemBuilder(Material.INK_SACK, 10).setName("§aSounds abspielen")
            .setLore("§7Momentan hörst du §aAlle Sounds§7.").build();
    
    public static ItemStack soundsRed = new ItemBuilder(Material.INK_SACK, 1).setName("§cKeine Sounds abspielen")
            .setLore("§7Momentan hörst du §ckeine Sounds§7.").build();
}
