/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.objects;

import com.agarian.utils.AgarianUtil;
import java.awt.Point;

/**
 *
 * @author crysi
 */
public class Bullet {

    private int speed;
    private final int originalSpeed;
    private Point targetPosition = new Point();
    private final Point bulletPosition = new Point();
    private final Point originalPosition = new Point();
    private final Creature creature;
    private final Turret turret;
    private boolean hit;

    public Bullet(int x, int y, int speed, int targetX, int targetY, Creature creature, Turret turret) {

        bulletPosition.setLocation(x, y);
        originalPosition.setLocation(x, y);
        targetPosition.setLocation(targetX, targetY);
        this.speed = speed;
        this.originalSpeed = speed;
        this.creature = creature;
        this.turret = turret;
    }

    public int getX() {
        return bulletPosition.x;
    }

    public void setX(int x) {
        bulletPosition.setLocation(x, bulletPosition.y);
    }

    public int getY() {
        return bulletPosition.y;
    }

    public void setY(int y) {
        bulletPosition.setLocation(bulletPosition.x, y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDestination(Point pos) {
        this.targetPosition = pos;
    }

    public void move() {
        //Find a position along the hypo. Move bullet there.
        //Ratio?
        //Will see if I can use a ratio
        AgarianUtil utils = new AgarianUtil();
        double angularCircle = utils.getAngleCircular(originalPosition.x, originalPosition.y, targetPosition.x, targetPosition.y);
        double angle1 = utils.getAngleTriangular(originalPosition.x, originalPosition.y, targetPosition.x, targetPosition.y);
        double angle2 = 90 - angle1;
        double hypo = speed;
        speed += originalSpeed; //speed = speed + originalSpeed
        if (angularCircle <= 90) {
            bulletPosition.setLocation(bulletPosition.x + Math.cos(Math.toRadians(angle1)) * hypo, bulletPosition.y);
            bulletPosition.setLocation(bulletPosition.x, bulletPosition.y - Math.cos(Math.toRadians(angle2)) * hypo);
            if ((bulletPosition.x > targetPosition.x || bulletPosition.y < targetPosition.y) && !hit) {
                hit = true;
                if (!turret.getType()) {
                    creature.doDamage(300);
                } else {
                    creature.doDamage(180);
                }
            }
        } else if (angularCircle <= 180) {
            bulletPosition.setLocation(bulletPosition.x + Math.cos(Math.toRadians(angle1)) * hypo, bulletPosition.y);
            bulletPosition.setLocation(bulletPosition.x, bulletPosition.y + Math.cos(Math.toRadians(angle2)) * hypo);
            if ((bulletPosition.x > targetPosition.x || bulletPosition.y > targetPosition.y) && !hit) {
                hit = true;
                if (!turret.getType()) {
                    creature.doDamage(300);
                } else {
                    creature.doDamage(180);
                }
            }
        } else if (angularCircle <= 270) {
            bulletPosition.setLocation(bulletPosition.x - Math.cos(Math.toRadians(angle1)) * hypo, bulletPosition.y);
            bulletPosition.setLocation(bulletPosition.x, bulletPosition.y + Math.cos(Math.toRadians(angle2)) * hypo);
            if ((bulletPosition.x < targetPosition.x || bulletPosition.y > targetPosition.y) && !hit) {
                hit = true;
                if (!turret.getType()) {
                    creature.doDamage(300);
                } else {
                    creature.doDamage(180);
                }
            }
        } else {
            bulletPosition.setLocation(bulletPosition.x - Math.cos(Math.toRadians(angle1)) * hypo, bulletPosition.y);
            bulletPosition.setLocation(bulletPosition.x, bulletPosition.y - Math.cos(Math.toRadians(angle2)) * hypo);
            if ((bulletPosition.x < targetPosition.x || bulletPosition.y < targetPosition.y) && !hit) {
                hit = true;
                if (!turret.getType()) {
                    creature.doDamage(300);
                } else {
                    creature.doDamage(180);
                }
            }
        }
        //System.out.println(bulletPosition.x + ";" + bulletPosition.y);
        //Length of X * hypo = adj
        //System.out.println("Bullet: " + angle); Correct
    }
}
