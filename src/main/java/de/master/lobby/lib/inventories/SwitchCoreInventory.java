package de.master.lobby.lib.inventories;

import de.master.lobby.lib.inventories.inv.CoreInventory;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;

public class SwitchCoreInventory extends CoreInventory {

    public static final String switcherInvName = "§eLobbyswitcher";
    
    public SwitchCoreInventory() {
        super(switcherInvName, 27);
    }
    
    public void initInventory() {
    
        for(int i = 0; i < inv.getSize(); ++i) {
            try {
                
                /*
                this.inv.setItem(i, (new ItemBuilder(Material.GOLD_BLOCK)).setName("§e§lLobby§7-§e§l" + i2)
                        .setLore("§7Alle aktuellen §eSpieler §7auf §eLobby§7-§e" + i2 + "§7: (§e"
                                + CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("Lobby-" + i2).getProperty(BridgeServiceProperty.ONLINE_COUNT).get()
                                + "§7/§e" + CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("Lobby-1").getProperty(BridgeServiceProperty.MAX_PLAYERS).get()
                                + "§7)").build());
    
                CloudNet.getInstance().getCloudGameServer("Lobby-" + i2);
                 */
            
            } catch (Exception var4) {
                var4.fillInStackTrace();
                this.inv.setItem(i, (new ItemBuilder(Material.COOKIE)).setName("§e§lLobby§7-§e§l" + i)
                        .setLore("§7Die Lobby §7(§eLobby§7-§e" + i + "§7) ist Aktuell nicht §eOnline§7!").build());
            }
        }
    }
}
