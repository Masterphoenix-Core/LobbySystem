package de.master.lobby.lib.util;

import com.mojang.authlib.GameProfile;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.CraftOfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    ItemStack is;
    ItemMeta im;

    public ItemBuilder(Material mat) {
        is = new ItemStack(mat);
        im = is.getItemMeta();
    }

    public ItemBuilder(Material material, int subID) {
        is = new ItemStack(material, 1, (short) subID);
        im = is.getItemMeta();
    }

    public ItemBuilder setAmount(int amount) {
        is.setAmount(amount);
        return this;
    }

    public ItemBuilder setName(String name) {
        im.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        im.setLore(Arrays.asList(lore));
        return this;
    }
    
    public ItemBuilder setLore(List<String> lore) {
        im.setLore(lore);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int force) {
        im.addEnchant(enchantment, force, false);
        return this;
    }

    public ItemBuilder addFlag(ItemFlag itemFlag) {
        im.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder setUnbreakable() {
        im.spigot().setUnbreakable(true);
        return this;
    }
    
    public ItemBuilder setLeatherColor(Color color) {
        if (!(im instanceof LeatherArmorMeta)) {
            return this;
        } else {
            ((LeatherArmorMeta)im).setColor(color);
            return this;
        }
    }
    
    public ItemBuilder setWoolColor(DyeColor color) {
        if (!is.getType().equals(Material.WOOL)) {
            return this;
        } else {
            is.setDurability(color.getData());
            return this;
        }
    }
    
    public ItemBuilder setSkullOwner(String name, boolean forceDownloadSkinData) {
        if (!(im instanceof SkullMeta)) {
            return this;
        } else if (forceDownloadSkinData) {
            ((SkullMeta)im).setOwner(name);
            return this;
        } else {
            OfflinePlayer p = Bukkit.getOfflinePlayer(name);
            GameProfile gameProfile;
            gameProfile = ((CraftOfflinePlayer)p).getProfile();

            
            try {
                Class craftSkullMeta = ((SkullMeta)im).getClass();
                Field field = craftSkullMeta.getDeclaredField("profile");
                field.setAccessible(true);
                field.set(im, gameProfile);
                field.setAccessible(false);
            } catch (Exception var7) {
                var7.printStackTrace();
            }
            
            return this;
        }
    }

    public ItemStack build() {
        is.setItemMeta(im);
        return is;
    }

}
