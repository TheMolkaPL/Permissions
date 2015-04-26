/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.themolka.permissions;

/**
 *
 * @author Aleksander
 */
public class Team extends Group {
    public Team(String name) {
        super(name);
    }
    
    @Override
    public String getPrefix() {
        return null;
    }
    
    @Override
    public boolean hasPrefix() {
        return false;
    }
    
    @Override
    public void setPrefix(String prefix) {}
}
