/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import pl.themolka.permissions.plugin.PermissionsPlugin;

/**
 *
 * @author Aleksander
 */
public class User {
    private final Player bukkit;
    private final List<Group> groups;
    
    public User(Player bukkit) {
        this.bukkit = bukkit;
        this.groups = new ArrayList<>();
    }
    
    public void addToGroup(Group group) {
        this.addToGroup(group, true);
    }
    
    public void addToGroup(Group group, boolean reload) {
        this.groups.add(group);
        
        if (reload) {
            this.reload();
        }
    }
    
    public Player getBukkit() {
        return this.bukkit;
    }
    
    public List<Group> getGroups() {
        return this.groups;
    }
    
    public List<String> getPermissions() {
        List<String> permissions = new ArrayList<>();
        for (Group group : this.getGroups()) {
            permissions.addAll(group.getPermissions());
        }
        return permissions;
    }
    
    public void reload() {
        // Set to op if has the asterisk
        List<String> permissions = this.getPermissions();
        if (permissions.contains("*")) {
            this.getBukkit().setOp(true);
            return;
        } else {
            this.getBukkit().setOp(false);
        }
        
        for (PermissionAttachmentInfo last : this.getBukkit().getEffectivePermissions()) {
            if (last.getAttachment() == null || last.getAttachment().getPlugin() == null) {
                continue;
            } else if (last.getAttachment().getPlugin().equals(PermissionsPlugin.get())) {
                this.getBukkit().addAttachment(PermissionsPlugin.get(), last.getPermission(), false);
            }
        }
        
        // Add new permissions
        for (String permission : permissions) {
            boolean allow = true;
            if (permission.startsWith("-")) {
                allow = false;
                permission = permission.substring(1);
            }
            this.getBukkit().addAttachment(PermissionsPlugin.get(), permission, allow);
        }
        
        this.getBukkit().recalculatePermissions();
    }
    
    public boolean removeFromGroup(Group group) {
        return this.removeFromGroup(group, true);
    }
    
    public boolean removeFromGroup(Group group, boolean reload) {
        boolean result = this.groups.remove(group);
        
        if (reload) {
            this.reload();
        }
        return result;
    }
    
    public void removeFromTeams() {
        removeFromTeams(true);
    }
    
    public void removeFromTeams(boolean reload) {
        List<Group> toRemove = new ArrayList<>();
        for (Group group : this.getGroups()) {
            if (group instanceof Team) {
                toRemove.add(group);
            }
        }
        
        for (Group group : toRemove) {
            this.removeFromGroup(group, reload);
        }
    }
}
