package de.master.lobby.core.commands;

import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.CoreLib;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class BuildCommandExecutor implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    
        if (!(s instanceof Player)) {
            s.sendMessage(CoreLib.onlyPlayers);
            return false;
        }
        
        Player p = (Player) s;
        LobbyPlugin plugin = JavaPlugin.getPlugin(LobbyPlugin.class);

        if (p.hasPermission("lobby.build")) {
            if (args.length == 0) {
                if (!p.hasMetadata("build")) {
                    p.setMetadata("build", new FixedMetadataValue(plugin, "build"));
                    p.removeMetadata(p.getName(), plugin);
                    p.sendMessage(CoreLib.prefix + "Du bist nun im §aBaumodus.");
                    p.setGameMode(GameMode.CREATIVE);
                } else {
                    p.removeMetadata("build", plugin);
                    p.sendMessage(CoreLib.prefix + "Du bist nun nicht mehr im §aBaumodus.");
                    p.setGameMode(GameMode.ADVENTURE);
                }
            } else if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t != null) {
                    if (!t.hasMetadata("build")) {
                        t.setMetadata("build", new FixedMetadataValue(plugin, "build"));
                        p.sendMessage(CoreLib.prefix + "§7Du hast den Spieler §a" + t.getName() + " §7erfolgreich in den §aBaumodus gesetzt.");
                        t.sendMessage(CoreLib.prefix + "§7Der Spieler §a" + p.getName() + " §7hat dich erfolgreich in den §aBaumodus gesetzt.");
                        t.setGameMode(GameMode.CREATIVE);
                    } else {
                        t.removeMetadata("build", plugin);
                        p.sendMessage(CoreLib.prefix + "§7Du hast den Spieler §a" + t.getName() + " §7erfolgreich aus dem §aBaumodus gesetzt.");
                        t.sendMessage(CoreLib.prefix + "§7Der Spieler §a" + p.getName() + " §7hat dich erfolgreich §7aus dem §aBaumodus gesetzt.");
                        t.setGameMode(GameMode.ADVENTURE);
                    }
                } else
                    p.sendMessage(CoreLib.prefix + "§7Dieser §aSpieler §7existiert nicht!");
            } else
                p.sendMessage(CoreLib.prefix + "§7Bitte verwende: /§abuild §7<§aSpieler§7>");
        } else
            p.sendMessage(CoreLib.noPerms);

        return false;
    }
}
