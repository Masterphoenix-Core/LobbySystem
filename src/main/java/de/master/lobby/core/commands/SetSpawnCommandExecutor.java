package de.master.lobby.core.commands;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.location.Locations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetSpawnCommandExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String lable, String[] args) {
        Player p = (Player)s;
        if (p.hasPermission("lobby.setspawn")) {
            if (args.length == 1) {
    
                CoreLib coreLib = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib();
                
                if (args[0].equalsIgnoreCase("Lobby")) {
                    coreLib.locationManager.createLocation(Locations.spawnMain, p.getLocation());
                    p.sendMessage(CoreLib.prefix + "Du hast erfolgreich den §aLobby §7Spawn gesetzt.");

                } else
                    sendHelp(p);
            } else
                sendHelp(p);
            
        } else
            p.sendMessage(CoreLib.noPerms);

        return false;
    }

    private void sendHelp(Player p) {
        p.sendMessage(CoreLib.prefix + " §7============[LobbySystem]============");
        p.sendMessage(CoreLib.prefix + " §7/setspawn Lobby | Setze den Lobby Spawn.");
        p.sendMessage(CoreLib.prefix + " §7====================================");
    }
}