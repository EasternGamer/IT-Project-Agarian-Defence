/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.utils;

import com.agarian.ui.game.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author crysi
 */
public class SpacedTimer implements ActionListener {

    private final Timer time = new Timer(600, this);
    private final GamePanel panel;
    private int spawnCount;

    public SpacedTimer(GamePanel panel, int spawnCount) {
        this.spawnCount = spawnCount;
        this.panel = panel;
    }

    public void startTimer() {
        time.start();
    }

    public void stopTimer() {
        time.stop();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (spawnCount > 1) {
            panel.spawnEnemies();
            spawnCount--;
        } else {
            time.stop();
            spawnCount = 10;
        }

    }
}
