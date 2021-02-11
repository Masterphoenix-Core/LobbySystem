package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public class PlayerChatListener implements Listener {

    public PlayerChatListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasMetadata("silent")) {
            p.sendMessage(CoreLib.prefix + "§cDu kannst in der §eSilentLobby §cnicht schreiben.");
            e.setCancelled(true);
        }
    }
}