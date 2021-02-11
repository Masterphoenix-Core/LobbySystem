package de.master.lobby.lib.special;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.util.ItemBuilder;
import lombok.Getter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TeamBoots implements Listener {

    @Getter
    private ItemStack itemStack;

    public TeamBoots() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("lobby.team.boots")) {
            this.itemStack = (new ItemBuilder(Material.LEATHER_BOOTS, 1)).setName("").setLeatherColor(Color.RED).build();
            p.getInventory().setBoots(this.itemStack);
        }

    }
}