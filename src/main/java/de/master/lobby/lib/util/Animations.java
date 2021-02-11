package de.master.lobby.lib.util;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.inventories.cosmetics.lanes.PlayerMoveListener;
import de.master.lobby.lib.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Animations {

    private final Random random = new Random();
    private int foodLevel = 20;
    private boolean backwards;
    private float exp = 1.0F;
    private boolean backwardsx;
    
    public Animations() {
        
        backwards = false;
        LobbyPlugin lobbyPlugin = JavaPlugin.getPlugin(LobbyPlugin.class);
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(lobbyPlugin, () -> {
            
            Bukkit.getOnlinePlayers().forEach((a) -> {
                a.getInventory().setBoots((new ItemBuilder(Material.LEATHER_BOOTS)).setName("").setLeatherColor(getRandomColor()).build());
            });
            
        }, 0L, 3 * 20L);
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(lobbyPlugin, () -> {
            if (this.backwardsx) {
                this.exp += 0.025F;
            } else
                this.exp -= 0.025F;

            if (this.exp <= 0.0F) {
                this.backwardsx = true;
            }

            if (this.exp >= 1.0F) {
                this.backwardsx = false;
            }

            if (this.backwards) {
                ++this.foodLevel;
            } else
                --this.foodLevel;

            if (this.foodLevel == 7) {
                this.backwards = true;
            }

            if (this.foodLevel == 20) {
                this.backwards = false;
            }

            Bukkit.getOnlinePlayers().forEach((a) -> {
                if (lobbyPlugin.getCoreLib().settingsManager.playerGuiAnimations.contains(a)) {
                    a.setFoodLevel(this.foodLevel);
                    a.setExp(this.exp);
                }

            });
        }, 0L, 3L);
    }


    private Color getRandomColor() {
        Color color = null;
        Random r = new Random();
        int b = r.nextInt(16);
        switch(b) {
            case 0:
                color = Color.AQUA;
                break;
            case 1:
            case 2:
                color = Color.BLACK;
                break;
            case 3:
                color = Color.FUCHSIA;
                break;
            case 4:
                color = Color.GRAY;
                break;
            case 5:
                color = Color.LIME;
                break;
            case 6:
                color = Color.MAROON;
                break;
            case 7:
                color = Color.NAVY;
                break;
            case 8:
                color = Color.OLIVE;
                break;
            case 9:
                color = Color.ORANGE;
                break;
            case 10:
                color = Color.PURPLE;
                break;
            case 11:
                color = Color.RED;
                break;
            case 12:
                color = Color.SILVER;
                break;
            case 13:
                color = Color.TEAL;
                break;
            case 15:
                color = Color.YELLOW;
                break;
            default:
                color = Color.WHITE;
                break;
        }

        return color;
    }
}
