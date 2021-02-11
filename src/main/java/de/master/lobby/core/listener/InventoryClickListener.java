package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.cosmetics.Gadgets;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.inventories.items.*;
import de.master.lobby.lib.inventories.items.cosmetics.GadgetItems;
import de.master.lobby.lib.location.Locations;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryClickListener implements Listener {
    
    private final CoreLib coreLib;
    
    public InventoryClickListener(CoreLib coreLib) {
        this.coreLib = coreLib;
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }
    
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        
        if (e.getClickedInventory() == null)
            return;
        
        if (e.getCurrentItem() == null)
            return;
        
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        ItemStack is = e.getCurrentItem();
        
        if (coreLib.inventoryManager.inventories.contains(inv)) {
            e.setCancelled(true);
            
            if (inv.equals(coreLib.inventoryManager.navigationCoreInventory.inv)) {
                if (is.equals(Locations.spawnMain.getItem()))
                    teleport(p, Locations.spawnMain);
                else if (is.equals(Locations.spawnCommunity.getItem()))
                    teleport(p, Locations.spawnCommunity);
                else if (is.equals(Locations.spawnKnockIt.getItem()))
                    teleport(p, Locations.spawnKnockIt);
                else if (is.equals(Locations.spawnBedWars.getItem()))
                    teleport(p, Locations.spawnBedWars);
                else if (is.equals(Locations.spawnMLGRush.getItem()))
                    teleport(p, Locations.spawnMLGRush);
                else if (is.equals(Locations.spawnSkyWars.getItem()))
                    teleport(p, Locations.spawnSkyWars);
                else if (is.equals(Locations.spawnSurvival.getItem()))
                    teleport(p, Locations.spawnSurvival);
                
            } else if (inv.equals(coreLib.inventoryManager.navigationSetupCoreInventory.inv)) {
                if (is.equals(Locations.spawnMain.getItem()))
                    setLocation(p, Locations.spawnMain);
                else if (is.equals(Locations.spawnCommunity.getItem()))
                    setLocation(p, Locations.spawnCommunity);
                else if (is.equals(Locations.spawnKnockIt.getItem()))
                    setLocation(p, Locations.spawnKnockIt);
                else if (is.equals(Locations.spawnBedWars.getItem()))
                    setLocation(p, Locations.spawnBedWars);
                else if (is.equals(Locations.spawnMLGRush.getItem()))
                    setLocation(p, Locations.spawnMLGRush);
                else if (is.equals(Locations.spawnSkyWars.getItem()))
                    setLocation(p, Locations.spawnSkyWars);
                else if (is.equals(Locations.spawnSurvival.getItem()))
                    setLocation(p, Locations.spawnSurvival);
                
            } else if (inv.equals(coreLib.inventoryManager.extraCoreInventory.inv)) {
                if (is.equals(ExtraItems.backToMenu)) {
                    p.closeInventory();
                    
                } else if (is.equals(ExtraItems.petsItem)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.petsCoreInventory.inv);
                    //OPEN PETS INV
                    
                } else if (is.equals(ExtraItems.shopItem)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.shopCoreInventory.inv);
                    
                    if (coreLib.settingsManager.playerSounds.contains(p))
                        p.playSound(p.getLocation(), Sound.DONKEY_ANGRY, 1.0F, 1.0F);
                    
                } else if (is.equals(ExtraItems.settingsItem)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.settingsPlayerCoreInventory.getInvFor(p, true));
                }
                
            } else if (inv.equals(coreLib.inventoryManager.shopCoreInventory.inv)) {
                
                if (is.equals(CoreInventoryManager.backToMenu)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.extraCoreInventory.inv);
                    
                } else if (is.equals(ShopItems.gadgetsItem)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.gadgetsPlayerCoreInventory.getInvFor(p, true));
                    
                } else if (is.equals(ShopItems.cosmeticsItem)) {
                    p.closeInventory();
                    p.openInventory(coreLib.inventoryManager.cosmeticsCoreInventory.inv);
                    
                }
            }
            
        } else if (coreLib.inventoryManager.settingsPlayerCoreInventory.playerSettingsInventory.containsKey(p) && coreLib.inventoryManager.settingsPlayerCoreInventory.playerSettingsInventory.get(p).equals(inv)) {
            
            e.setCancelled(true);
            
            if (is.equals(CoreInventoryManager.backToMenu)) {
                p.closeInventory();
                p.openInventory(coreLib.inventoryManager.extraCoreInventory.inv);
                return;
                
            } else if (is.equals(SettingsItems.guiAnimationsGreen) || is.equals(SettingsItems.guiAnimationsRed)) {
                coreLib.settingsManager.toggleGuiAnimations(p);
                
            } else if (is.equals(SettingsItems.soundsGreen) || is.equals(SettingsItems.soundsRed)) {
                coreLib.settingsManager.toggleSounds(p);
                
            } else if (is.equals(SettingsItems.playerHideGreen)) {
                coreLib.settingsManager.showOnlyVip(p);
                
            } else if (is.equals(SettingsItems.playerHidePurple)) {
                coreLib.settingsManager.showNoPlayers(p);
                
            } else if (is.equals(SettingsItems.playerHideRed)) {
                coreLib.settingsManager.showEveryOne(p);
                
            }
            coreLib.inventoryManager.settingsPlayerCoreInventory.reloadInvfor(p);
            
        } else if (coreLib.inventoryManager.gadgetsPlayerCoreInventory.playerGadgetInventory.containsKey(p) && coreLib.inventoryManager.gadgetsPlayerCoreInventory.playerGadgetInventory.get(p).equals(inv)) {
            
            e.setCancelled(true);
            
            if (is.equals(GadgetItems.unEquip)) {
                p.closeInventory();
                coreLib.gadgetManager.unEquip(p);
                
            } else if (is.equals(GadgetItems.fireHoeIsBought)) {
                p.closeInventory();
                coreLib.gadgetManager.equip(p, Gadgets.FIRE_HOE);
                
            } else if (is.equals(GadgetItems.lobbyBlocksIsBought)) {
                p.closeInventory();
                coreLib.gadgetManager.equip(p, Gadgets.LOBBY_BLOCKS);
                
            }
        } else if (!p.hasMetadata("build")) {
            e.setCancelled(true);
            System.out.println("DOES NOT CONTAIN");
        }
        
    }
    
    private void teleport(Player p, Locations location) {
        p.closeInventory();
        
        if (coreLib.locationManager.locationExists(location))
            p.teleport(coreLib.locationManager.getLocation(location));
        else
            p.sendMessage(CoreLib.prefix + location.getName() + " §7ist §cnoch nicht fertig §7eingerichtet!");
    }
    
    private void setLocation(Player p, Locations location) {
        p.closeInventory();
        coreLib.locationManager.createLocation(location, p.getLocation());
        p.sendMessage(CoreLib.prefix + "Du hast die Location für " + location.getName() + " §7gesetzt.");
    }
}
