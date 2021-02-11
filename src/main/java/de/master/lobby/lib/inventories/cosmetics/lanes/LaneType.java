package de.master.lobby.lib.inventories.cosmetics.lanes;

import lombok.Getter;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public enum LaneType {
    
    COOKIES_LANE("COOKIES"),
    BLAZE_LANE("BLAZE"),
    GLOWSTONE_LANE("GLOWSTONE"),
    RAINBOW_LANE("RAINBOW"),
    NO_LANE("NONE");
    
    LaneType(String name) {
        this.name = name;
    }
    
    @Getter
    String name;
    
}
