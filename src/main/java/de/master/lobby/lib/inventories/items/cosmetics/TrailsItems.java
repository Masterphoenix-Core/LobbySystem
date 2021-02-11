package de.master.lobby.lib.inventories.items.cosmetics;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.inventories.cosmetics.lanes.LaneType;
import de.master.lobby.lib.mysql.SqlStats;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TrailsItems {
    
    public static ItemStack
            cookieLaneItemIsBought = new ItemBuilder(Material.COOKIE).setName("§6§lKeks - §aFreigeschaltet").setLore("§7Klicke hier um die §6Keks §7Lane auszuwählen.").build(),
            cookieLaneItemNotBought = new ItemBuilder(Material.COOKIE).setName("§6§lKeks - §cNicht freigeschaltet").setLore("§7Du hast die §6Keks §7Lane §cnicht freigeschaltet§7.").build(),
    
            glowStoneLaneItemIsBought = new ItemBuilder(Material.GLOWSTONE_DUST).setName("§e§lGlowstone - §aFreigeschaltet").setLore("§7Klicke hier um die §eGlowstone §7Lane auszuwählen.").build(),
            glowStoneLaneItemNotBought = new ItemBuilder(Material.GLOWSTONE_DUST).setName("§e§lGlowstone - §cNicht freigeschaltet").setLore("§7Du hast die §6Glowstone §7Lane §cnicht freigeschaltet§7.").build(),
    
            blazeLaneItemIsBought = new ItemBuilder(Material.BLAZE_ROD).setName("§6§lBlaze - §aFreigeschaltet").setLore("§8Klicke hier um die §6Blaze §7Lane auszuwählen.").build(),
            blazeLaneItemNotBought = new ItemBuilder(Material.BLAZE_ROD).setName("§6§lBlaze - §cNicht freigeschaltet").setLore("§7Du hast die §6Blaze §7Lane §cnicht freigeschaltet§7.").build(),
    
            rainbowItemIsBought = new ItemBuilder(Material.RECORD_9).setName("§aR§6A§1I§9N§4B§7O§EW - §aFreigeschaltet").setLore("§7Klicke hier um die §aR§6A§1I§9N§4B§7O§EW §7Lane auszuwählen.").build(),
            rainbowItemNotBought = new ItemBuilder(Material.RECORD_9).setName("§aR§6A§1I§9N§4B§7O§EW - §cNicht freigeschaltet").setLore("§7Du hast die §6Rainbow §7Lane §cnicht freigeschaltet§7.").build();
    
    public static ItemStack getPlayerCookieLaneItem(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasLane(p, LaneType.COOKIES_LANE)) {
            return cookieLaneItemIsBought;
        } else
            return cookieLaneItemNotBought;
    }
    
    public static ItemStack getPlayerGlowStoneLaneItem(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasLane(p, LaneType.GLOWSTONE_LANE)) {
            return glowStoneLaneItemIsBought;
        } else
            return glowStoneLaneItemNotBought;
    }
    
    public static ItemStack getPlayerBlazeLaneItem(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasLane(p, LaneType.BLAZE_LANE)) {
            return blazeLaneItemIsBought;
        } else
            return blazeLaneItemNotBought;
    }
    
    public static ItemStack getPlayerRainbowLaneItem(Player p) {
        if (JavaPlugin.getPlugin(LobbyPlugin.class).getMySQL().sqlCosmetics.playerHasLane(p, LaneType.RAINBOW_LANE)) {
            return rainbowItemIsBought;
        } else
            return rainbowItemNotBought;
    }
    
    
    public static ItemStack none = new ItemBuilder(Material.REDSTONE_BLOCK).setName("§cLane entfernen").setLore("§7Klicke hier um deine Lane zu §centfernen§7.").build();
    
}
