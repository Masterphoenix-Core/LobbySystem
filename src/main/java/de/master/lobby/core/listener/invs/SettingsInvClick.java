package de.master.lobby.core.listener.invs;

import org.bukkit.event.Listener;

public class SettingsInvClick implements Listener {

   /*
    public SettingsInvClick() {
        Bukkit.getPluginManager().registerEvents(this, de.master.lobby.core.bootstrap.LobbyPlugin.getPlugin());
    }

    @EventHandler
    public void on(InventoryClickEvent e) {

        if (e.getClickedInventory().getName().equalsIgnoreCase(SettingsCoreInventory.settingsInvName)) {
            e.setCancelled(true);
            
            Player p = (Player) e.getWhoClicked();
            SettingsCoreInventory inv = LobbyPlugin.getInstance().getSettingsPlayerInvs().get(p);

            SqlStats sqlStats = LobbyPlugin.getInstance().getMySQL().getSqlStats();
            String uuid = p.getUniqueId().toString();

            if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.backToMenu.getItemMeta().getLore())) {
                p.openInventory(LobbyPlugin.getInstance().getExtraInv().getExtra());
    
                if(Animations.sounds.contains(p))
                    p.playSound(p.getLocation(), Sound.CREEPER_HISS, 1.0F, 1.0F);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.fightStickGreen.getItemMeta().getLore())) {
                sqlStats.setFightMode(uuid, false);
                updateInv(p, inv);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.fightStickRed.getItemMeta().getLore())) {
                sqlStats.setFightMode(uuid, true);
                updateInv(p, inv);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.guiAnimationsGreen.getItemMeta().getLore())) {
                sqlStats.setGUIAnimations(uuid, false);
    
                p.setExp(1);
                p.setHealth(p.getMaxHealth());
                p.setFoodLevel(20);
                
                Animations.getIsAllowedToGUIAnimations().remove(p);
                updateInv(p, inv);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.guiAnimationsRed.getItemMeta().getLore())) {
                sqlStats.setGUIAnimations(uuid, true);
                Animations.getIsAllowedToGUIAnimations().add(p);
                updateInv(p, inv);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.playerHideGreen.getItemMeta().getLore())) {
                sqlStats.setPlayerVisibility(uuid, false);
                updateInv(p, inv);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.playerHideRed.getItemMeta().getLore())) {
                sqlStats.setPlayerVisibility(uuid, true);
                updateInv(p, inv);
    
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.soundsGreen.getItemMeta().getLore())) {
                sqlStats.setSounds(uuid, false);
                Animations.sounds.remove(p);
                updateInv(p, inv);
                
            } else if (e.getCurrentItem().getItemMeta().getLore().equals(SettingsItems.soundsRed.getItemMeta().getLore())) {
                sqlStats.setSounds(uuid, true);
                Animations.sounds.add(p);
                updateInv(p, inv);
                
            } else
                System.out.println("ITEMSTACK NOT DEFINED");

        }
    }

    void updateInv(Player p, SettingsCoreInventory inv) {
        boolean[] booleans = SettingsBooleans.calcBooleans(p);

        boolean b1 = booleans[0];
        boolean b2 = booleans[1];
        boolean b3 = booleans[2];
        boolean b4 = booleans[3];

        inv.setInv(p, b1, b2, b3, b4);
    }
    */
}
