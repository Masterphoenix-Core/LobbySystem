package de.master.lobby.lib;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.master.lobby.core.LobbyPlugin;
import de.master.lobby.lib.gadgets.GadgetManager;
import de.master.lobby.lib.inventories.cosmetics.lanes.LaneManager;
import de.master.lobby.lib.inventories.inv.CoreInventoryManager;
import de.master.lobby.lib.location.LocationManager;
import de.master.lobby.lib.mysql.MySql;
import de.master.lobby.lib.settings.SettingsManager;
import de.master.lobby.lib.shield.ShieldManager;
import de.master.lobby.lib.silent.SilentManager;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public class CoreLib {
    
    public static String version = "b0.91", prefix = "§8[§bLobbySystem §7: §a" + version + "§8] §7", noPerms = prefix + "Dazu hast du §ckeine Rechte§7.", onlyPlayers = prefix + "Dieses Feature ist §cnur für Spieler§7.";
    
    public CoreInventoryManager inventoryManager;
    public LocationManager locationManager;
    public SettingsManager settingsManager;
    public LaneManager laneManager;
    public GadgetManager gadgetManager;
    public SilentManager silentManager;
    public ShieldManager shieldManager;
    
    private final MySql mySql;
    
    public CoreLib(MySql mySql) {
        this.mySql = mySql;
        init();
    }
    
    private void init() {
        inventoryManager = new CoreInventoryManager(this);
        locationManager = new LocationManager(mySql);
        settingsManager = new SettingsManager(mySql);
        laneManager = new LaneManager(this);
        gadgetManager = new GadgetManager(mySql);
        silentManager = new SilentManager();
        shieldManager = new ShieldManager();
    }
    
    public static void drawCircle(Location loc, float radius, EnumParticle particle) {
        for(double t = 0.0D; t < 50.0D; t += 0.5D) {
            float x = radius * (float)Math.sin(t);
            float z = radius * (float)Math.cos(t);
            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, (float)loc.getX() + x, (float)loc.getY(), (float)loc.getZ() + z,
                    0.0F, 0.0F, 0.0F, 0.0F, 1);
            Iterator var8 = Bukkit.getOnlinePlayers().iterator();
            
            while(var8.hasNext()) {
                Player online = (Player)var8.next();
                ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
            }
        }
        
    }
    
    public static void sendPlayer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(JavaPlugin.getPlugin(LobbyPlugin.class), "BungeeCord", out.toByteArray());
    }
    
    public static void sendActionBar(Player p, String msg) {
        IChatBaseComponent ibc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"\"}").a(msg);
        PacketPlayOutChat packet = new PacketPlayOutChat(ibc, (byte)2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
    
}
