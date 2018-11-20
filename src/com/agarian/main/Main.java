/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.main;

import com.agarian.objects.Creature;
import com.agarian.objects.Turret;
import com.agarian.ui.LoginGUI;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crysi
 */
public class Main {

    //Used during initialization when a user logs in
    public static List<Creature> creatures = new ArrayList<>();
    public static List<Turret> turrets = new ArrayList();
    public static String username;
    public static int money;
    public static int level;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new LoginGUI().setVisible(true));
    }

}
