package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.JoinItems;
import de.master.lobby.lib.inventories.items.cosmetics.GadgetItems;
import de.master.lobby.lib.util.Animations;
import net.minecraft.server.v1_8_R3.EntityArrow;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerInteractListener implements Listener {
    
    public PlayerInteractListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }
    
    @EventHandler
    public void on(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        
        if (p.getItemInHand().getType() == Material.AIR || p.getItemInHand() == null) {
            return;
        }
        
        ItemStack is = p.getItemInHand();
        CoreLib coreLib = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib();
        
        if ((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
    
    
            if (is.equals(JoinItems.navItem)) {
                p.openInventory(coreLib.inventoryManager.navigationCoreInventory.inv);
                
                if (coreLib.settingsManager.playerSounds.contains(p))
                    p.getPlayer().playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 0.5F);
                
                e.setCancelled(true);
            } else if (is.equals(JoinItems.extraInvItem)) {
                p.openInventory(coreLib.inventoryManager.extraCoreInventory.inv);
                e.setCancelled(true);
            } else if (is.equals(JoinItems.lobbySwitcher)) {
                p.openInventory(coreLib.inventoryManager.switchCoreInventory.inv);
                
                if (coreLib.settingsManager.playerSounds.contains(p))
                    p.playSound(p.getLocation(), Sound.CREEPER_HISS, 1.0F, 1.0F);
                
                e.setCancelled(true);
            } else if (is.equals(JoinItems.silentLobbyIsOff) || is.equals(JoinItems.silentLobbyIsOn)) {
                coreLib.silentManager.toggleSilent(p);
                e.setCancelled(true);
            } else if (is.equals(JoinItems.shieldItemIsOff) || is.equals(JoinItems.shieldItemIsOn)) {
                coreLib.shieldManager.toggleShield(p);
                e.setCancelled(true);
    
            } else if (is.equals(GadgetItems.fireHoeIsBought) && !coreLib.gadgetManager.arrowCooldown.contains(p)) {
                p.launchProjectile(Arrow.class, p.getLocation().getDirection().multiply(5));
                coreLib.gadgetManager.startArrowCooldown(p);
            }
        }
        
    }
    
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntityType().equals(EntityType.ARROW)) {
    
            e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 0, false);
            
            new Thread(() -> {
                Location loc = e.getEntity().getLocation();
                double minX = loc.getX() - 3,
                        minY = loc.getY() - 2,
                        minZ = loc.getZ() - 3;
                double maxX = loc.getX() + 3,
                        maxY = loc.getY() + 2,
                        maxZ = loc.getZ() + 3;
    
                Bukkit.getOnlinePlayers().forEach(a -> {
                    Location aLoc = a.getLocation();
                    if (minX <= aLoc.getX() && aLoc.getX() <= maxX && minY <= aLoc.getY() && aLoc.getY() <= maxY && minZ <= aLoc.getZ() && aLoc.getZ() <= maxZ) {
                        a.setVelocity(aLoc.getDirection().multiply(-2).setY(0.7));
                    }
                });
            }).start();
    
            
        }
    }
    
}
