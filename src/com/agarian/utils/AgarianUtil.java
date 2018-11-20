/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.utils;

import com.agarian.objects.Creature;
import com.agarian.objects.Turret;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crysi
 */
public class AgarianUtil {

    @Deprecated
    /*
    *Replaced with evt.getComponent() for onMouseEvent events
    *
     */
    public boolean isMouseOnComponent(int x, int y, int x1, int y1) {
        boolean onComp;
        //if () {
        //}

        return true;
    }

    /*
    *This gets the true distance from one objects to an origin point
    *It will use trigonometry/pythagoras to determine the distance and possibly the angle.
     */
    public double getDistance(int objectX, int objectY, int originX, int originY) {

        int triangleLength;
        int triangleHeight;
        if (objectX > originX) {
            triangleLength = objectX - originX;
        } else {
            triangleLength = objectX - originX;
        }
        if (objectY > originY) {
            triangleHeight = objectY - originY;
        } else {
            triangleHeight = objectY - originY;
        }
        double distance = Math.sqrt((triangleLength * triangleLength) + (triangleHeight * triangleHeight));
        return distance;
    }

    public double getAngleTriangular(int objectX, int objectY, int originX, int originY) {
        double hypo = getDistance(objectX, objectY, originX, originY);
        double triangleHeight;
        if (objectY > originY) {
            triangleHeight = objectY - originY;
        } else {
            triangleHeight = originY - objectY;
        }
        double degrees = Math.toDegrees(Math.asin(triangleHeight / hypo));
        return degrees;
    }

    public double getAngleCircular(int objectX, int objectY, int originX, int originY) {
        double hypo = getDistance(objectX, objectY, originX, originY);
        double triangleHeight;
        if (objectY > originY) {
            triangleHeight = objectY - originY;
        } else {
            triangleHeight = originY - objectY;
        }
        double degrees = Math.toDegrees(Math.asin(triangleHeight / hypo)); //Saw an example online. Didn't work as expected so I changed it slightly
        if (objectY > originY) {
            if (objectX < originX) {
                degrees = 90 - degrees;
            } else {
                degrees += 270;
            }
        } else {
            if (objectX < originX) {
                degrees += 90;
            } else {
                degrees = 270 - degrees;
            }
        }
        return degrees;
    }

    public Creature getClosest(List<Creature> creatures, Turret turret) {
        try {
            Creature creaturees = creatures.get(0);
            for (Creature creature : creatures) {
                if (getDistance(creature.getPos().x, creature.getPos().y, turret.getX(), turret.getY()) < getDistance(creaturees.getPos().x, creaturees.getPos().y, turret.getX(), turret.getY())) {
                    creaturees = creature;
                }
            }
            return creaturees;
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
}
