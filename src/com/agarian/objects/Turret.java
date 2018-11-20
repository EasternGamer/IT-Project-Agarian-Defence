/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.objects;

/**
 *
 * @author crysi
 */
public class Turret {

    private final int x;
    private final int y;
    private final int level;
    private int time;
    private final boolean type;

    public Turret(int x, int y, int level, boolean type) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.type = type;
    }

    public boolean getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public int getRange() {
        if (!type) {
            return 125;
        } else {
            return 300;
        }
    }

    public int getReloadTime() {
        return time;
    }

    public Turret setReloadTime(int time) {
        this.time = time;
        return this;
    }
}
