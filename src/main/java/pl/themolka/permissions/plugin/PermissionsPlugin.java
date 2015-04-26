/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions.plugin;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Aleksander
 */
public final class PermissionsPlugin extends JavaPlugin {
    private static Plugin plugin;
    
    @Override
    public void onEnable() {
        plugin = this;
        
        for (OfflinePlayer offline : this.getServer().getOperators()) {
            offline.setOp(false);
        }
    }
    
    public static Plugin get() {
        return plugin;
    }
}
