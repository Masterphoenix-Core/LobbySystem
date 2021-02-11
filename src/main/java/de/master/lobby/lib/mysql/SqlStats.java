/*
 * Copyright (c) 2020. All rights preserved.
 * Creator Masterphoenix
 * Contact: Discord: Masterphoenix#8969
 */

package de.master.lobby.lib.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlStats {
    
    /*
    MySql mySQL;
    
    public SqlStats(MySql mySQL) {
        this.mySQL = mySQL;
    }
    
    public boolean playerCosmeticExists(String uuid) {
        try {
            ResultSet rs = mySQL.query("SELECT * FROM PlayerCosmetics WHERE UUID='" + uuid + "'");
            
            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public void createPlayerCosmetics(String uuid) {
        if (!playerCosmeticExists(uuid)) {
            mySQL.update("INSERT INTO PlayerCosmetics(UUID, STANDARDLANE) VALUES('" + uuid + "','0');");    //LANES =  0 = COOKIE, 1 = RAINBOW, 2 = GLOWSTONE, 3 = BLAZE
        }
    }
    
    public int getPlayerStandardLane(String uuid) {
        if (playerCosmeticExists(uuid)) {
        
            try {
                ResultSet rs = mySQL.query("SELECT * FROM PlayerCosmetics WHERE UUID= '" + uuid + "'");
                if (rs.next()) {
                
                    return rs.getInt("STANDARDLANE");
                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        } else
            createPlayerCosmetics(uuid);
        
        return 0;
    }
    
    public void setPlayerStandardLane(String uuid, LaneTypes lane) {
    
        if (playerCosmeticExists(uuid)) {
            
            int i = 0;
            switch (lane) {
                case NONE:
                    i = 99;
                    break;
                case COOKIE:
                    break;
                case RAINBOW:
                    i = 1;
                    break;
                case GlOWSTONE:
                    i = 2;
                    break;
                case BLAZE:
                    i = 3;
                    break;
            }
            
            mySQL.update("UPDATE PlayerCosmetics SET STANDARDLANE='" + i + "' WHERE UUID='" + uuid + "';");
    
        }
        
    }
     */
    
}