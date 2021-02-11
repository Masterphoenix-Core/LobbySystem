package de.master.lobby.core;

import de.master.lobby.core.commands.*;
import de.master.lobby.core.listener.*;
import de.master.lobby.core.listener.invs.*;
import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.mysql.MySql;
import de.master.lobby.lib.special.*;
import de.master.lobby.lib.util.Animations;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class LobbyPlugin extends JavaPlugin {
    
    private MySql mySQL;
    private CoreLib coreLib;
    
    @Override
    public void onEnable() {
        
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        initialize();
        register();
    
        Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§bLobbyPlugin §7by §e§lMasterphoenix §aactivated§7.");
    }
    
    private void initialize() {
    
        mySQL = new MySql();
        coreLib = new CoreLib(mySQL);
    }
    
    private void register() {
        new Animations();
        
        new ExtraInvClick();
        new SettingsInvClick();
        new ShopInvClick();
        new TrailsInvClick();
    
        new BuildCancelListener();
        new EntityListener();
        new InventoryClickListener(coreLib);
        new PlayerChatListener();
        new PlayerInteractListener();
        new PlayerItemHeldListener();
        new PlayerJoinListener();
        new PlayerMoveListener();
        new PlayerQuitListener();
        
        new TeamBoots();
        new DoubleJump();
        //desgvo = new Desgvo();
        
        this.getCommand("setspawn").setExecutor(new SetSpawnCommandExecutor());
        this.getCommand("build").setExecutor(new BuildCommandExecutor());
        this.getCommand("nav").setExecutor(new NavigationCommandExecutor());
    }
}
