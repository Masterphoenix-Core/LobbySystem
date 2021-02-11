package de.master.lobby.lib.location;

import de.master.lobby.lib.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Locations {

    spawnMain ("§6Spawn"),
    spawnCommunity ("§5Community"),
    spawnKnockIt ("§6KnockIt"),
    spawnBedWars ("§cBedWars"),
    spawnMLGRush("§9MLGRush"),
    spawnSkyWars ("§aSkywars"),
    spawnSurvival ("§2Survival");

    Locations(String name) {
        this.name = name;
    }
    
    public ItemStack getItem() {
        return getItem(this);
    }
    
    private ItemStack getItem(Locations loc) {
    
        ItemStack is = null;
        switch (loc) {
            
            case spawnMain:
                is = new ItemBuilder(Material.MAGMA_CREAM).setName(loc.getName()).setLore("", "Klicke hier um dich zum " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnCommunity:
                is = new ItemBuilder(Material.SKULL_ITEM).setName(loc.getName()).setSkullOwner("Masterphoenix_", true).setLore("", "Klicke hier um dich zur " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnKnockIt:
                is = new ItemBuilder(Material.STICK).setName(loc.getName()).setLore("", "Klicke hier um dich zu " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnBedWars:
                is = new ItemBuilder(Material.BED).setName(loc.getName()).setLore("", "Klicke hier um dich zu " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnMLGRush:
                is = new ItemBuilder(Material.WATER_BUCKET).setName(loc.getName()).setLore("", "Klicke hier um dich zu " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnSkyWars:
                is = new ItemBuilder(Material.GRASS).setName(loc.getName()).setLore("", "Klicke hier um dich zu " + loc.getName() + " zu teleportieren!").build();
                break;
            case spawnSurvival:
                is = new ItemBuilder(Material.SAPLING).setName(loc.getName()).setLore("", "Klicke hier um dich zu " + loc.getName() + " zu teleportieren!").build();
                break;
            
            default:
                break;
            
        }
        
        return is;
        
    }

    @Getter
    String name;
}
