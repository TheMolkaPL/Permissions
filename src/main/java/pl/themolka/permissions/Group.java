/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Aleksander
 */
public class Group {
    private final String name;
    private final List<String> permissions;
    private String prefix;
    
    public Group(String name) {
        Validate.notNull(name, "name can not be null");
        this.name = name.toLowerCase();
        this.permissions = new ArrayList<>();
    }
    
    public void addPermission(String permission) {
        Validate.notNull(permission, "permission can not be null");
        this.permissions.add(permission.toLowerCase());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group) {
            if (((Group) obj).getName().equals(this.getName())) {
                return true;
            }
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
        Validate.notNull(permission, "permission can not be null");
        return this.permissions.remove(permission.toLowerCase());
    }
}
