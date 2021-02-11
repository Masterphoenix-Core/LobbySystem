package de.master.lobby.lib.inventories.inv;

import de.master.lobby.lib.CoreLib;
import de.master.lobby.lib.inventories.*;
import de.master.lobby.lib.inventories.first.sec.third.fourth.TrailsCoreInventory;
import de.master.lobby.lib.inventories.first.ExtraCoreInventory;
import de.master.lobby.lib.inventories.first.sec.ShopCoreInventory;
import de.master.lobby.lib.inventories.first.sec.third.CosmeticsCoreInventory;
import de.master.lobby.lib.inventories.first.sec.SettingsPlayerCoreInventory;
import de.master.lobby.lib.inventories.first.sec.PetsCoreInventory;
import de.master.lobby.lib.inventories.first.sec.third.GadgetsPlayerCoreInventory;
import de.master.lobby.lib.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CoreInventoryManager {
    
    private final CoreLib coreLib;
    
    public static ItemStack backToMenu = new ItemBuilder(Material.BARRIER).setName("§cZurück ins Menü").setLore("§7Klicke §chier §7um ins §cHauptmenü §7zu gelangen.").build();
    public static ItemStack placeholder = new ItemBuilder(Material.STAINED_GLASS_PANE, 15).setName("§c").build();
    
    
    public final ArrayList<Inventory> inventories;
    
    public ExtraCoreInventory extraCoreInventory;
    
    public SettingsPlayerCoreInventory settingsPlayerCoreInventory;
    public ShopCoreInventory shopCoreInventory;
    
    public CosmeticsCoreInventory cosmeticsCoreInventory;
    public GadgetsPlayerCoreInventory gadgetsPlayerCoreInventory;
    
    public PetsCoreInventory petsCoreInventory;
    
    public NavigationCoreInventory navigationCoreInventory;
    public NavigationSetupCoreInventory navigationSetupCoreInventory;
    public SwitchCoreInventory switchCoreInventory;
    
    public TrailsCoreInventory trailsCoreInventory;
    
    public CoreInventoryManager(CoreLib coreLib) {
        this.coreLib = coreLib;
    
        inventories = new ArrayList<>();
        
        init();
    }
    
    public void init() {
        extraCoreInventory = new ExtraCoreInventory();
        
        settingsPlayerCoreInventory = new SettingsPlayerCoreInventory();
        shopCoreInventory = new ShopCoreInventory();
    
        cosmeticsCoreInventory = new CosmeticsCoreInventory();
        gadgetsPlayerCoreInventory = new GadgetsPlayerCoreInventory();
        
        petsCoreInventory = new PetsCoreInventory();
        
        navigationCoreInventory = new NavigationCoreInventory();
        navigationSetupCoreInventory = new NavigationSetupCoreInventory(navigationCoreInventory.inv);
        switchCoreInventory = new SwitchCoreInventory();
    
        trailsCoreInventory = new TrailsCoreInventory();
    
    
        register(extraCoreInventory);
    
        register(shopCoreInventory);
    
        register(cosmeticsCoreInventory);
        register(petsCoreInventory);
        
        register(navigationCoreInventory);
        register(navigationSetupCoreInventory);
        register(switchCoreInventory);
        
        register(trailsCoreInventory);
    }
    
    private void register(CoreInventory inv) {
        inventories.add(inv.inv);
    }
    
}
