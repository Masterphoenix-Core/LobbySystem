package de.master.lobby.core.listener.invs;

import org.bukkit.event.Listener;

public class TrailsInvClick implements Listener {
    
    /*
    public TrailsInvClick() {
        Bukkit.getPluginManager().registerEvents(this, de.master.lobby.core.bootstrap.LobbyPlugin.getPlugin());
    }
    
    @EventHandler
    public void on(InventoryClickEvent e) throws SQLException {
    
        LaneManager laneManager = JavaPlugin.getPlugin(LobbyPlugin.class).getCoreLib().laneManager;
        Player p = (Player) e.getWhoClicked();
        
        if (e.getClickedInventory().getName().equals(TrailsCoreInventory.extrasLaneInvName)) {
            e.setCancelled(true);
    
            ItemStack[] items = TrailsItems.getLaneItems(p);
            ItemStack cookie = items[0];
            ItemStack rainbow = items[1];
            ItemStack glowstone = items[2];
            ItemStack blaze = items[3];
    
            SqlStats sqlStats = LobbyPlugin.getInstance().getMySQL().getSqlStats();
            String uuid = p.getUniqueId().toString();
            
            if (e.getCurrentItem().getItemMeta().getLore().equals(TrailsItems.backToMenu.getItemMeta().getLore())) {
                p.openInventory(LobbyPlugin.getInstance().getCosmeticsInv().getInv());
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(cookie.getItemMeta().getLore())) {
                // ACTIVATE COOKIES LANE
                if (TrailsItems.hasLane(p, SqlStats.LaneTypes.COOKIE)) {
                    laneManager.setPlayerLane(p, LaneType.COOKIES_LANE);
                    sqlStats.setPlayerStandardLane(uuid, SqlStats.LaneTypes.COOKIE);
                }
                
                p.closeInventory();
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(glowstone.getItemMeta().getLore())) {
                // ACTIVATE EMERALD LANE
                if (TrailsItems.hasLane(p, SqlStats.LaneTypes.GlOWSTONE)) {
                    PlayerMoveListener.playertyped.remove(p);
                    PlayerMoveListener.playertyped.put(p, PlayerMoveListener.Types.GLOWSTONE_LANE);
                    sqlStats.setPlayerStandardLane(uuid, SqlStats.LaneTypes.GlOWSTONE);
                }
    
                p.closeInventory();
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(blaze.getItemMeta().getLore())) {
                //ACTIVATE BLAZE LANE
                if (TrailsItems.hasLane(p, SqlStats.LaneTypes.BLAZE)) {
                    PlayerMoveListener.playertyped.remove(p);
                    PlayerMoveListener.playertyped.put(p, PlayerMoveListener.Types.BLAZE_LANE);
                    sqlStats.setPlayerStandardLane(uuid, SqlStats.LaneTypes.BLAZE);
    
                }
    
                p.closeInventory();
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(rainbow.getItemMeta().getLore())) {
                //ACTIVATE RAINBOW LANE
                if (TrailsItems.hasLane(p, SqlStats.LaneTypes.RAINBOW)) {
                    PlayerMoveListener.playertyped.remove(p);
                    PlayerMoveListener.playertyped.put(p, PlayerMoveListener.Types.RAINBOW_LANE);
                    sqlStats.setPlayerStandardLane(uuid, SqlStats.LaneTypes.RAINBOW);
                }
    
                p.closeInventory();
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(TrailsItems.none.getItemMeta().getLore())) {
                PlayerMoveListener.playertyped.remove(p);
                PlayerMoveListener.playertyped.put(p, PlayerMoveListener.Types.NO_LANE);
                sqlStats.setPlayerStandardLane(uuid, SqlStats.LaneTypes.NONE);
    
                p.closeInventory();
            }
        }
    }
     */
}
