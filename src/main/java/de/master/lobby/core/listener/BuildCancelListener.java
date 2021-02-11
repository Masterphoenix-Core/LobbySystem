package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.items.cosmetics.GadgetItems;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildCancelListener implements Listener {

    public BuildCancelListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        if (!e.getPlayer().hasMetadata("build")) {
    
            ItemStack is = e.getItemInHand().clone();
            ItemStack blocks = GadgetItems.lobbyBlock.build().clone();
    
            is.setAmount(1);
            blocks.setAmount(1);
            
            if (is.equals(blocks)) {
                Player p = e.getPlayer();
                Block b = e.getBlock();
    
                CoreLib coreLib = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib();
                
                coreLib.gadgetManager.removeBlockAfter(p, b);
            
            } else
                e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBuild(BlockBreakEvent e) {
        if (!e.getPlayer().hasMetadata("build")) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBuild(PlayerDropItemEvent e) {
        if (!e.getPlayer().hasMetadata("build")) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBuild(PlayerPickupItemEvent e) {
        if (!e.getPlayer().hasMetadata("build")) {
            e.setCancelled(true);
        }

    }

}
