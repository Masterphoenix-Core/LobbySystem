package de.master.lobby.lib.location;

import de.master.lobby.lib.mysql.MySql;
import lombok.SneakyThrows;
import org.bukkit.*;
import org.graalvm.compiler.loop.MathUtil;

import java.math.MathContext;
import java.sql.ResultSet;

public class LocationManager {
    
    private final MySql mySql;
    
    private final String locationTableName = "locations";
    
    public LocationManager(MySql mySql) {
        this.mySql = mySql;
        
        mySql.update("CREATE TABLE IF NOT EXISTS " + locationTableName + "(NAME VARCHAR(50), WORLD VARCHAR(50), X VARCHAR(255), Y VARCHAR(255), Z VARCHAR(255), YAW VARCHAR(255), PITCH VARCHAR(255));");
        mySql.update("ALTER TABLE " + locationTableName + " ADD UNIQUE(NAME);");
        
    }
    
    public void createLocation(Locations locationType, Location location) {
        if (!locationExists(locationType)) {
            mySql.update("INSERT INTO " + locationTableName + "(NAME, WORLD, X, Y, Z, YAW, PITCH) VALUES('"
                    + locationType.name() + "', '" + location.getWorld().getName() + "'," + "'"
                    + round(location.getX(), 4) + "','" + round(location.getY(), 4) + "','" + round(location.getZ(), 4) + "','"
                    + location.getYaw() + "','" + location.getPitch() + "');");
        }
    }
    
    @SneakyThrows
    public boolean locationExists(Locations location) {
        ResultSet rs = mySql.query("SELECT * FROM " + locationTableName + " WHERE NAME='" + location.name() + "';");
        if (rs.next()) {
            return rs.getString("name") != null;
        }
        return false;
    }
    
    @SneakyThrows
    public Location getLocation(Locations location) {
        if (locationExists(location)) {
            ResultSet rs = mySql.query("SELECT * FROM " + locationTableName + " WHERE NAME='" + location.name() + "';");
            
            World world = null;
            double x = 0, y = 0, z = 0;
            float yaw = 0, pitch = 0;
            
            while (rs.next()) {
                world = Bukkit.getWorld(rs.getString("WORLD"));
                x = Double.parseDouble(rs.getString("X"));
                y = Double.parseDouble(rs.getString("Y"));
                z = Double.parseDouble(rs.getString("Z"));
                yaw = Float.parseFloat(rs.getString("Yaw"));
                pitch = Float.parseFloat(rs.getString("Pitch"));
            }
            return new Location(world, x, y, z, yaw, pitch);
        }
        
        throw new IllegalAccessException();
    }
    
    public static double round(final double number, final int digits) {
        return (int) number + (Math.round(Math.pow(10, digits) * (number - (int) number))) / (Math.pow(10, digits));
    }
}
