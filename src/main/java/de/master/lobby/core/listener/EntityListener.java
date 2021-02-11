package de.master.lobby.core.listener;

import de.master.lobby.core.LobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EntityListener implements Listener {

    public EntityListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(LobbyPlugin.class));
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {

            Player p = (Player)e.getEntity();
            if (p.getItemInHand().getType().equals(Material.STICK)) {
                e.setCancelled(false);
                e.setDamage(0.0D);
            } else
                e.setCancelled(true);

        }

    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityBlockChange(EntityChangeBlockEvent e) {
        e.setCancelled(true);
    }

}
