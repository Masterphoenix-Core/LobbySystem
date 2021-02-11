/*
 * Copyright (c) 2020. All rights preserved.
 * Creator Masterphoenix
 * Contact: Discord: Masterphoenix#8969
 */

package de.master.lobby.lib.mysql;

import de.master.lobby.lib.CoreLib;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;

import java.sql.*;

public class MySql {

    private String host = "localhost", database = "test", user = "root", password = "";

    private Connection con;

    public SqlStats sqlStats;
    public SqlCosmetics sqlCosmetics;
    public SqlSettings sqlSettings;

    @SneakyThrows
    public MySql() {
        
        connect().join();
        
        //sqlStats = new SqlStats(this);
        sqlCosmetics = new SqlCosmetics(this);
        sqlSettings = new SqlSettings(this);
        
        //update("CREATE TABLE IF NOT EXISTS Spawns(NAME varchar(100), WORLD varchar(100), X varchar(100), Y varchar(100), Z varchar(100), YAW varchar(100), PITCH varchar(100));");
        //update("CREATE TABLE IF NOT EXISTS PlayerSettings(UUID varchar(40), A int, B int, C int, D int);");
        //update("CREATE TABLE IF NOT EXISTS PlayerCosmetics(UUID varchar(40), STANDARDLANE varchar(2));");
        //update("CREATE TABLE IF NOT EXISTS Players(UUID varchar(40));");
    }

    public Thread connect() {
        
        Thread t = new Thread(() -> {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", user, password);
                Bukkit.getConsoleSender().sendMessage(CoreLib.prefix+ "§8[§b§lMySQL§8] §aVerbindung hergestellt!");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§8[§b§lMySQL§8] §cVerbindung konnte nicht hergestellt werden!");
                Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§8[§b§lMySQL§8] §cError:" + e.getMessage());
            }
        });
    
        t.setName("MySqlThread");
        t.start();
        
        return t;
        
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
                Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§8[§b§lMySQL§8] §cVerbindung unterbrochen!");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§8[§b§lMySQL§8] §cVerbindung konnte nicht unterbrochen werden!");
            Bukkit.getConsoleSender().sendMessage(CoreLib.prefix + "§8[§b§lMySQL§8] §cError:" + e.getMessage());
        }
    }

    public void update(String qry) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
