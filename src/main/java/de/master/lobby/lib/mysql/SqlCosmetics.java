package de.master.lobby.lib.mysql;

import de.master.lobby.lib.cosmetics.Gadgets;
import de.master.lobby.lib.inventories.cosmetics.lanes.LaneType;
import de.master.lobby.lib.settings.Settings;
import lombok.SneakyThrows;
import org.bukkit.entity.Player;

import java.sql.ResultSet;

public class SqlCosmetics {
    
    private final MySql mySql;
    
    private final String laneTableName = "lanes";
    private final String gadgetsTableName = "gadgets";
    
    public SqlCosmetics(MySql mySql) {
        this.mySql = mySql;
        
        //mySql.update("CREATE TABLE IF NOT EXISTS " + laneTableName + " (`uuid` VARCHAR(36) NOT NULL, `cookies` INT NOT NULL, `blaze` INT NOT NULL, `glowstone` INT NOT NULL, `rainbow` INT NOT NULL);");
        mySql.update("CREATE TABLE IF NOT EXISTS " + gadgetsTableName
                + "(UUID VARCHAR(36),"
                + Gadgets.FIRE_HOE.getName() + " INT,"
                + Gadgets.LOBBY_BLOCKS.getName() + " INT"
                + ");");
        
    }
    
    @SneakyThrows
    public boolean playerLaneExists(Player p) {
        ResultSet rs = mySql.query("SELECT * FROM " + laneTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getString("UUID") != null;
        }
        return false;
    }
    
    @SneakyThrows
    public void createPlayerLane(Player p) {
        mySql.update("INSERT INTO " + laneTableName + "(UUID, COOKIES, BLAZE, GLOWSTONE, RAINBOW) VALUES('" + p.getUniqueId().toString() + "', 0, 0, 0, 0);");
    }
    
    @SneakyThrows
    public boolean playerHasLane(Player p, LaneType lane) {
        ResultSet rs = mySql.query("SELECT * FROM " + laneTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getInt(lane.getName()) == 1;
        } else
            return false;
    }
    
    @SneakyThrows
    public void setPlayerOwnsLane(Player p, LaneType lane, boolean owns) {
        if (owns) {
            mySql.update("UPDATE " + laneTableName + " SET " + lane.getName() + "=1 WHERE UUID='" + p.getUniqueId().toString() + "';");
        } else
            mySql.update("UPDATE " + laneTableName + " SET " + lane.getName() + "=0 WHERE UUID='" + p.getUniqueId().toString() + "';");
        
    }
    
    @SneakyThrows
    public boolean playerGadgetsExists(Player p) {
        ResultSet rs = mySql.query("SELECT * FROM " + gadgetsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getString("UUID") != null;
        }
        return false;
    }
    
    @SneakyThrows
    public void createPlayerGadgets(Player p) {
        mySql.update("INSERT INTO " + gadgetsTableName + "(UUID, " + Gadgets.FIRE_HOE.getName() + ", " + Gadgets.LOBBY_BLOCKS.getName() +") VALUES('" + p.getUniqueId().toString() + "', 0, 0);");
    }
    
    @SneakyThrows
    public boolean playerHasGadget(Player p, Gadgets gadget) {
        ResultSet rs = mySql.query("SELECT * FROM " + gadgetsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getInt(gadget.getName()) == 1;
        } else
            return false;
    }
    
    @SneakyThrows
    public void setPlayerOwnsGadget(Player p, LaneType lane, boolean owns) {
        if (owns) {
            mySql.update("UPDATE " + laneTableName + " SET " + lane.getName() + "=1 WHERE UUID='" + p.getUniqueId().toString() + "';");
        } else
            mySql.update("UPDATE " + laneTableName + " SET " + lane.getName() + "=0 WHERE UUID='" + p.getUniqueId().toString() + "';");
        
    }
    
}
