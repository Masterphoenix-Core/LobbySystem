package de.master.lobby.core.commands;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NavigationCommandExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String lable, String[] args) {
    
        if (!(s instanceof Player)) {
            s.sendMessage(CoreLib.onlyPlayers);
            return false;
        }
        
        Player p = (Player)s;
        if (p.hasPermission("lobby.nav")) {
            if (args.length == 0) {
                
                p.openInventory(JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().inventoryManager.navigationSetupCoreInventory.inv);
                p.getPlayer().playSound(p.getLocation(), Sound.CREEPER_HISS, 1.0F, 1.0F);

            } else
                p.sendMessage(CoreLib.prefix + (" §7Bitte verwende: §a/nav"));
        } else
            p.sendMessage(CoreLib.noPerms);

        return false;
    }
}
