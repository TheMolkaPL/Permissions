/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Aleksander
 */
public class Permissions {
    private static final Map<UUID, User> users = new HashMap<>();
    
    @Deprecated
    public static User findUser(String name) {
        Validate.notNull(name, "name can not be null");
        for (User user : getUsers().values()) {
            if (user.getBukkit().getName().toLowerCase().equals(name.toLowerCase())) {
                return user;
            }
        }
        return null;
    }
    
    @Deprecated
    public static User getUser(String name) {
        Validate.notNull(name, "name can not be null");
        for (User user : getUsers().values()) {
            if (user.getBukkit().getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    
    public static User getUser(UUID uuid) {
        Validate.notNull(uuid, "uuid can not be null");
        return users.get(uuid);
    }
    
    public static Map<UUID, User> getUsers() {
        return users;
    }
    
    public static void registerUser(User user) {
        Validate.notNull(user, "user can not be null");
        users.put(user.getBukkit().getUniqueId(), user);
    }
    
    public static boolean unregisterUser(User user) {
        Validate.notNull(user, "user can not be null");
        return unregisterUser(user.getBukkit().getUniqueId());
    }
    
    public static boolean unregisterUser(UUID uuid) {
        Validate.notNull(uuid, "uuid can not be null");
        if (users.containsKey(uuid)) {
            users.remove(uuid);
            return true;
        } else {
            return false;
        }
    }
}
