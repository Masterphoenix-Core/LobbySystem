package de.master.lobby.lib.inventories.cosmetics.lanes;

import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class LaneManager {
    
    private final CoreLib coreLib;
    
    private final HashMap<Player, LaneType> playerLane;
    
    public LaneManager(CoreLib coreLib) {
        this.coreLib = coreLib;
        playerLane = new HashMap<>();
    }
    
    public void setPlayerLane(Player p, LaneType lane) {
        playerLane.remove(p);
        playerLane.put(p, lane);
    }
    
    public Item[] getItemDrops(Player p) {
    
        LaneType laneType = playerLane.get(p);
        
        Item[] drops;
        switch (laneType) {
            case COOKIES_LANE:
                drops = new Item[]{Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.COOKIE).build()),
                        Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                                new ItemBuilder(Material.COOKIE).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.COOKIE).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.GOLD_INGOT).build())};
                break;
            case BLAZE_LANE:
                drops = new Item[]{Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.BLAZE_POWDER).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.BLAZE_POWDER).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.GOLD_NUGGET).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.EMERALD).build())};
                break;
            case GLOWSTONE_LANE:
                drops = new Item[]{Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.GLOWSTONE_DUST).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.GLOWSTONE_DUST).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.GLOWSTONE_DUST).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.DIAMOND).build())};
                break;
            case RAINBOW_LANE:
                drops = new Item[]{Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 1).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 2).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 4).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 5).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 9).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 10).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 11).build()), Bukkit.getWorld(p.getWorld().getName()).dropItemNaturally(p.getLocation(),
                        new ItemBuilder(Material.INK_SACK, 14).build())};
                break;
        
            case NO_LANE:
                drops = new Item[0];
                break;
        
            default:
                return null;
        }
    
        return drops;
        
    }
    
}
