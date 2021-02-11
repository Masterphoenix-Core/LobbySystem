package de.master.lobby.lib.settings;

import lombok.Getter;

public enum Settings {
    
    GUI_ANIMATIONS("§5Gui-Animationen", 1),
    PLAYER_HIDE("§cSpieler verstecken", 2),
    SOUNDS("§6Sounds", 1);
    
    Settings(String name, int maxValue) {
        this.name = name;
        this.maxValue = maxValue;
    }
    
    @Getter
    String name;
    int maxValue;
    
}
