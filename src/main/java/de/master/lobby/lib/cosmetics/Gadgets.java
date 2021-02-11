package de.master.lobby.lib.cosmetics;

import lombok.Getter;

public enum Gadgets {
    
    FIRE_HOE("FIRE_HOE"),
    LOBBY_BLOCKS("BLOCKS");
    
    Gadgets(String name) {
        this.name = name;
    }
    
    @Getter
    String name;
    
}
