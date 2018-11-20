/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.objects;

import java.awt.Point;

/**
 *
 * @author crysi
 */
public class Creature {

    private int health;
    private final int speed;
    private int distance;
    //The damage percentage the creature will take. Modified by if it is armored or not.
    private final double damageMultiplier;
    //The position of the creature.
    private Point pos;

    public Creature(int health, int speed, double damageMultiplier, Point pos) {
        this.health = health;
        this.speed = speed;
        this.damageMultiplier = damageMultiplier;
        this.pos = pos;
        distance = 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void doDamage(int damage) {
        this.health -= damage * damageMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public int getY() {
        return pos.y;
    }

    public int getX() {
        return pos.x;
    }

    public void move() {
        distance++;
        if (distance < (70)) {
            pos.setLocation(pos.x + speed, pos.y);
        } else if (distance < (220)) {
            pos.setLocation(pos.x, pos.y - speed);
        } else if (distance < (470)) {
            pos.setLocation(pos.x + speed, pos.y);
        } else if (distance < (670)) {
            pos.setLocation(pos.x, pos.y + speed);
        } else if (distance < (820)) {
            pos.setLocation(pos.x - speed, pos.y);
        } else if (distance < (920)) {
            pos.setLocation(pos.x, pos.y + speed);
        } else if (distance < (1320)) {
            pos.setLocation(pos.x + speed, pos.y);
        } else if (distance < (1370)) {
            pos.setLocation(pos.x, pos.y - speed);
        } else if (distance < (1420)) {
            pos.setLocation(pos.x + speed, pos.y);
        } else if (distance < (1520)) {
            pos.setLocation(pos.x, pos.y - speed);
        } else if (distance < (1570)) {
            pos.setLocation(pos.x - speed, pos.y);
        } else if (distance < (1720)) {
            pos.setLocation(pos.x, pos.y - speed);
        } else if (distance < (3000)) {
            pos.setLocation(pos.x + speed, pos.y);
        }
    }

    public Creature setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    @Deprecated
    public Creature copy() {
//        return new Creature(health, speed, damageMultiplier, pos, path);//Doesn't work as expected
        return null;
    }
}
