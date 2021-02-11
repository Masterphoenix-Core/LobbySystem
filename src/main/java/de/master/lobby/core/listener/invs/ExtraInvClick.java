package de.master.lobby.core.listener.invs;

import org.bukkit.event.Listener;

public class ExtraInvClick implements Listener {

    public ExtraInvClick() {
    }

    /*
    @EventHandler
    public void on(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getName().equalsIgnoreCase(ExtraCoreInventory.extraInvName)) {

            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getLore().equals(ExtraItems.backToMenu.getItemMeta().getLore())) {
                p.closeInventory();

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(ExtraItems.petsItem.getItemMeta().getLore())) {
                //OPEN PETS INVENTORY

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(ExtraItems.shopItem.getItemMeta().getLore())) {
                p.openInventory(LobbyPlugin.getInstance().getInventories().getShopMainInv());
                
                if(Animations.sounds.contains(p))
                    p.playSound(p.getLocation(), Sound.DONKEY_ANGRY, 1.0F, 1.0F);

            } else if (e.getCurrentItem().getItemMeta().getLore().equals(ExtraItems.settingsItem.getItemMeta().getLore())) {
                if (LobbyPlugin.getInstance().getSettingsPlayerInvs().containsKey(p)) {

                    SettingsCoreInventory inv = LobbyPlugin.getInstance().getSettingsPlayerInvs().get(p);
                    updateInv(p, inv);
    
                    if(Animations.sounds.contains(p))
                        p.playSound(p.getLocation(), Sound.DIG_SNOW, 1.0F, 1.0F);

                } else {

                    SettingsCoreInventory inv = new SettingsCoreInventory();
                    updateInv(p, inv);
    
                    if(Animations.sounds.contains(p))
                        p.playSound(p.getLocation(), Sound.DIG_SNOW, 1.0F, 1.0F);
                    
                    LobbyPlugin.getInstance().getSettingsPlayerInvs().put(p, inv);
                }
            }
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
