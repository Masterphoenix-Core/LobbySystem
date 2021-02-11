package de.master.lobby.lib.mysql;

import de.master.lobby.lib.settings.Settings;
import lombok.SneakyThrows;
import org.bukkit.entity.Player;

import java.sql.ResultSet;

public class SqlSettings {
    
    private final MySql mySql;
    
    private final String settingsTableName = "settings";
    
    public SqlSettings(MySql mySql) {
        this.mySql = mySql;
    
        mySql.update("CREATE TABLE IF NOT EXISTS " + settingsTableName + "(UUID VARCHAR(36), " + Settings.GUI_ANIMATIONS + " INT, " + Settings.PLAYER_HIDE + " INT, " + Settings.SOUNDS + " INT);");
        //mySql.update("ALTER TABLE " + settingsTableName + " ADD UNIQUE UUID;");
    
    }
    
    public void createPlayer(Player p) {
        System.out.println("Create Player" + p.getName());
        mySql.update("INSERT INTO " + settingsTableName + "(UUID, " + Settings.GUI_ANIMATIONS + ", " + Settings.PLAYER_HIDE + ", " + Settings.SOUNDS + ") VALUES('" + p.getUniqueId().toString() + "', '1', '2', '1');");
    }
    
    @SneakyThrows
    public boolean playerExists(Player p) {
        ResultSet rs = mySql.query("SELECT * FROM " + settingsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getString("UUID") != null;
        }
        return false;
    }
    
    @SneakyThrows
    public byte getPlayerSetting(Player p, Settings setting) {
        ResultSet rs = mySql.query("SELECT * FROM " + settingsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getByte(setting.toString());
        }
        return 0;
    }
    
    public void setPlayerSetting(Player p, Settings setting, int value) {
        mySql.update("UPDATE " + settingsTableName + " SET " + setting + "=" + value + " WHERE UUID='" + p.getUniqueId().toString() + "';");
    }
    
    @SneakyThrows
    public boolean getPlayerGuiAnimations(Player p) {
        ResultSet rs = mySql.query("SELECT * FROM " + settingsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getInt(Settings.GUI_ANIMATIONS.toString()) == 1;
        }
        return false;
    }
    
    @SneakyThrows
    public boolean getPlayerSounds(Player p) {
        ResultSet rs = mySql.query("SELECT * FROM " + settingsTableName + " WHERE UUID='" + p.getUniqueId().toString() + "';");
        if (rs.next()) {
            return rs.getInt(Settings.SOUNDS.toString()) == 1;
        }
        return false;
    }
    
}
