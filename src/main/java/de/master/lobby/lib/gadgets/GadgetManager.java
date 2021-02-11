package de.master.lobby.lib.gadgets;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.cosmetics.Gadgets;
import de.master.lobby.lib.inventories.items.cosmetics.GadgetItems;
import de.master.lobby.lib.mysql.MySql;
import jdk.internal.org.jline.utils.ShutdownHooks;
import jdk.tools.jlink.internal.TaskHelper;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GadgetManager {
    
    private final MySql mySql;
    
    public GadgetManager(MySql mySql) {
        this.mySql = mySql;
        
        arrowCooldown = new ArrayList<>();
    }
    
    public void equip(Player p, Gadgets gadget) {
        
        switch (gadget) {
            case FIRE_HOE:
                
                if (!p.getGameMode().equals(GameMode.ADVENTURE))
                    p.setGameMode(GameMode.ADVENTURE);
                
                p.getInventory().setItem(7, GadgetItems.getFireHoe(p));
                break;
            case LOBBY_BLOCKS:
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().setItem(7, GadgetItems.lobbyBlock.setAmount(5).build());
                break;
            default:
                break;
        }
        
    }
    
    public void unEquip(Player p) {
        if (!p.getGameMode().equals(GameMode.ADVENTURE))
            p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().setItem(7, null);
    }
    
    public void removeBlockAfter(Player p, Block b) {
        
        new Thread(() -> {
            Bukkit.getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(LobbyPlugin.class), () -> {
                
                if (p.getInventory().contains(GadgetItems.lobbyBlock.build().getType())) {
                    p.getInventory().addItem(GadgetItems.lobbyBlock.setAmount(1).build());
                } else {
                    p.getInventory().setItem(7, GadgetItems.lobbyBlock.setAmount(1).build());
                }
                b.setType(Material.AIR);
                
            }, 20 * 3);
            
        }).start();
        
    }
    
    public ArrayList<Player> arrowCooldown;
    
    public int task;
    
    public void startArrowCooldown(Player p) {
        
        Thread t = new Thread(() -> {
            
            arrowCooldown.add(p);
            final int[] i = {8};
            Timer timer = new Timer("CooldownTimer");
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    
                    if (p.getInventory().getItem(7) != null && p.getInventory().getItem(7).getType().equals(GadgetItems.fireHoeIsBought.getType())) {
                        ItemStack is = p.getInventory().getItem(7);
                        is.setDurability((short) (4 * i[0]));
                    }
    
                    if (i[0] == 0) {
                        arrowCooldown.remove(p);
                        timer.cancel();
                    }
                    i[0]--;
                }
            }, 0, 500);
            
            
        });
        
        t.start();
        
    }
    
    
}
