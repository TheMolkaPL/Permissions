/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksander
 */
public class Group {
    private final String name;
    private final List<String> permissions;
    private String prefix;
    
    public Group(String name) {
        this.name = name.toLowerCase();
        this.permissions = new ArrayList<>();
    }
    
    public void addPermission(String permission) {
        this.permissions.add(permission.toLowerCase());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group) {
            return ((Group) obj).getName().equals(this.getName());
        }
        return false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<String> getPermissions() {
        return this.permissions;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public boolean hasPrefix() {
        return this.prefix != null;
    }
    
    public void setPermissions(List<String> permissions) {
        if (permissions != null) {
            for (String permission : permissions) {
                this.addPermission(permission);
            }
        }
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public boolean removePermission(String permission) {
        return this.permissions.remove(permission.toLowerCase());
    }
}
