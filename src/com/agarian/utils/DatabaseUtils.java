/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agarian.utils;

import com.agarian.objects.Creature;
import com.agarian.objects.Turret;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author crysi
 */
public class DatabaseUtils {

    private Connection connection;
    //CREATURE TABLE
    ///HEALTH
    ///SPEED
    ///DAMAGEMULTI
    ///POSITION_X
    ///POSITION_Y
    ///PATH

    //TURRET TABLE
    ///POSITION_X
    ///POSITION_Y
    ///LEVEL
    ///TYPE
    //Will be using VARCHAR for all datatypes in here. Will convert them later.
    public DatabaseUtils() throws SQLException {
        connection = DriverManager.getConnection("jdbc:hsqldb:file:/CameronDwyer/Java/AgarianDefence;create=true");
        try {
            connection.createStatement().execute("CREATE TABLE LOGININFO (USERNAMES VARCHAR(50))");
        } catch (SQLException e) {
            //Ignored
            //System.out.println(e.getLocalizedMessage());
        }
    }

    public String getTableName(String name) {

        String[] searchNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] replaceNumbers = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

        String username = StringUtils.replaceEachRepeatedly(name, searchNumbers, replaceNumbers);

        return username;
    }

    public List<Turret> getTurrets(String tableName) {
        String resultStatement = "SELECT * FROM PUBLIC." + getTableName(tableName) + "_TURRETS";
        List<Turret> turrets = new ArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery(resultStatement);
            while (rs.next()) {
                turrets.add(new Turret(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)), Boolean.parseBoolean(rs.getString(4))));
            }
            //connection.createStatement().execute("TRUNCATE TABLE " + tableName + "_TURRETS");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return turrets;
    }

    public List<Creature> getCreatures(String tableName) {
        String resultStatement = "SELECT * FROM PUBLIC." + getTableName(tableName) + "_CREATURES";
        List<Creature> creatures = new ArrayList();
        try {
            ResultSet rs = connection.createStatement().executeQuery(resultStatement);
            while (rs.next()) {
                creatures.add(new Creature(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)), new Point(Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)))).setDistance(Integer.parseInt(rs.getString(6))));
            }
            // connection.createStatement().execute("TRUNCATE TABLE " + tableName + "_CREATURES");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return creatures;
    }

    public int[] getUserInfo(String tableName) {
        int[] info = null;
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM PUBLIC." + getTableName(tableName));
            while (rs.next()) {
                    int[] stuff = {Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3))};
                    info = stuff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;
    }

    public void createProfile(String tableName) {
        String userDataTableScript = "CREATE TABLE " + getTableName(tableName) + " (MONEY VARCHAR(20), LEVEL VARCHAR(20), HQ_HEALTH VARCHAR(3))";
        String userTurretTableScript = "CREATE TABLE " + getTableName(tableName) + "_TURRETS (POSITION_X VARCHAR(3), POSITION_Y VARCHAR(3), LEVEL VARCHAR(2), TYPE VARCHAR(5))";
        String userCreatureTableScript = "CREATE TABLE " + getTableName(tableName) + "_CREATURES (HEALTH VARCHAR(5), SPEED VARCHAR(3), DAMAGEMULTI VARCHAR(20), POSITION_X VARCHAR(3), POSITION_Y VARCHAR(3), PATH VARCHAR(1000))";
        try {
            Statement statement = connection.createStatement();
            statement.execute(userDataTableScript);
            statement.execute(userTurretTableScript);
            statement.execute(userCreatureTableScript);
            statement.execute("INSERT INTO PUBLIC." + getTableName(tableName) + " (MONEY,LEVEL) VALUES ('150', '0')");
            statement.execute("INSERT INTO PUBLIC.LOGININFO (USERNAMES) VALUES ('" + getTableName(tableName) + "')");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM PUBLIC.LOGININFO");
            while (rs.next()) {
                usernames.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usernames;

    }

    public DatabaseUtils save(String tableName, int money, int level, int hqHealth, List<Creature> creatures, List<Turret> turrets) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE TABLE " + getTableName(tableName));
            statement.execute("TRUNCATE TABLE " + getTableName(tableName) + "_TURRETS");
            statement.execute("TRUNCATE TABLE " + getTableName(tableName) + "_CREATURES");
            statement.addBatch("INSERT INTO PUBLIC." + getTableName(tableName) + " (MONEY, LEVEL, HQ_HEALTH) VALUES ('" + money + "', '" + level + "', '" + hqHealth + "')");

            creatures.forEach(creature -> {
                String statementString = "INSERT INTO PUBLIC." + getTableName(tableName)
                        + "_CREATURES (HEALTH, SPEED, DAMAGEMULTI, POSITION_X, POSITION_Y, PATH)"
                        + " VALUES ('" + creature.getHealth() + "','" + creature.getSpeed() + "','" + creature.getDamageMultiplier() + "','" + creature.getPos().x + "','" + creature.getPos().y + "','" + creature.getDistance() + "')";
                try {
                    statement.addBatch(statementString);
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            turrets.forEach(turret -> {
                String statementString = "INSERT INTO PUBLIC." + getTableName(tableName)
                        + "_TURRETS (POSITION_X, POSITION_Y, LEVEL, TYPE)"
                        + " VALUES ('" + turret.getX() + "','" + turret.getY() + "','" + turret.getLevel() + "','" + turret.getType() + "')";
                try {
                    statement.addBatch(statementString);
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            statement.executeBatch();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    public void end() {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
