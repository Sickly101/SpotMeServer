/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrox.spotmeserverrestful.dto;

import java.awt.Color;
import java.sql.Connection;

/**
 *
 * @author Sickly
 */
public class Stash {
   /* public void insertStaticGrades(Connection con) throws Exception{
        //Grades
        //UIAA
        insertGrade(con, new Grade(1, "1-3", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(1, "4", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(1, "4+", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(1, "5-", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(1, "5", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(1, "5+", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(1, "6-", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(1, "6", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(1, "6+", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(1, "7-", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(1, "7", Color.RED.getRGB()));
        insertGrade(con, new Grade(1, "7+", Color.RED.getRGB()));
        insertGrade(con, new Grade(1, "8-", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(1, "8", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(1, "8+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(1, "9-", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(1, "9", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(1, "9+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(1, "10-", Color.PINK.getRGB()));//Pink
        insertGrade(con, new Grade(1, "10", Color.PINK.getRGB()));
        insertGrade(con, new Grade(1, "10+", Color.PINK.getRGB()));
        insertGrade(con, new Grade(1, "11-", Color.PINK.getRGB()));
        insertGrade(con, new Grade(1, "11", Color.PINK.getRGB()));
        insertGrade(con, new Grade(1, "11+", Color.PINK.getRGB()));
        //französisch
        insertGrade(con, new Grade(2, "1-3", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(2, "4", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(2, "4+", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(2, "5a", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(2, "5b", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(2, "5c", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(2, "6a", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(2, "6a+", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(2, "6b", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(2, "6b+", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(2, "6c", Color.RED.getRGB()));
        insertGrade(con, new Grade(2, "6c+", Color.RED.getRGB()));
        insertGrade(con, new Grade(2, "7a", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(2, "7a+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(2, "7b", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(2, "7b+", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(2, "7c", Color.PINK.getRGB()));
        insertGrade(con, new Grade(2, "7c+", Color.PINK.getRGB()));
        insertGrade(con, new Grade(2, "8a", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(2, "8a+", Color.RED.getRGB()));
        insertGrade(con, new Grade(2, "8b", Color.RED.getRGB()));
        insertGrade(con, new Grade(2, "8b+", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(2, "8c", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(2, "8c+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(2, "9a", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(2, "9a+", Color.PINK.getRGB()));
        insertGrade(con, new Grade(2, "9b", Color.PINK.getRGB()));
        // USA
        insertGrade(con, new Grade(3, "5.0-5.2", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(3, "5.3", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(3, "5.4", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(3, "5.5", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(3, "5.6", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(3, "5.7", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(3, "5.8", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(3, "5.9", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(3, "5.10", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(3, "5.10a", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(3, "5.10b", Color.RED.getRGB()));
        insertGrade(con, new Grade(3, "5.10c", Color.RED.getRGB()));
        insertGrade(con, new Grade(3, "5.10d", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(3, "5.11a", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.11b", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.11c", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.11d", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.12a", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.12b", Color.PINK.getRGB()));//Pink
        insertGrade(con, new Grade(3, "5.12c", Color.PINK.getRGB()));
        insertGrade(con, new Grade(3, "5.12d", Color.PINK.getRGB()));
        insertGrade(con, new Grade(3, "5.13a", Color.PINK.getRGB()));
        insertGrade(con, new Grade(3, "5.13b", Color.PINK.getRGB()));
        insertGrade(con, new Grade(3, "5.13c", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.13d", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.14a", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.14b", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.14c", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(3, "5.14d", Color.PINK.getRGB()));//Pink
        insertGrade(con, new Grade(3, "5.15a", Color.PINK.getRGB()));
        insertGrade(con, new Grade(3, "5.15b", Color.PINK.getRGB()));
        //Sächsisch
        insertGrade(con, new Grade(4, "I-III", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(4, "IV", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(4, "V", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(4, "VI", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(4, "VIIa", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(4, "VIIb", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(4, "VIIc", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(4, "VIIIa", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(4, "VIIIb", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(4, "VIIIC", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(4, "IXa", Color.RED.getRGB()));
        insertGrade(con, new Grade(4, "IXb", Color.RED.getRGB()));
        insertGrade(con, new Grade(4, "IXc", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(4, "Xa", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(4, "Xb", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(4, "Xc", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(4, "XIa", Color.PINK.getRGB()));
        insertGrade(con, new Grade(4, "XIb", Color.PINK.getRGB()));
        insertGrade(con, new Grade(4, "XIc", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(4, "XIIa", Color.PINK.getRGB()));
        //australien
        insertGrade(con, new Grade(5, "10-12", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(5, "13", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(5, "14", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(5, "15", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(5, "16", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(5, "17", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(5, "18", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(5, "19", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(5, "20", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(5, "21", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(5, "22", Color.RED.getRGB()));
        insertGrade(con, new Grade(5, "23", Color.RED.getRGB()));
        insertGrade(con, new Grade(5, "24", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(5, "25", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(5, "26", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(5, "27", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(5, "28", Color.PINK.getRGB()));
        insertGrade(con, new Grade(5, "29", Color.PINK.getRGB()));
        insertGrade(con, new Grade(5, "30", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(5, "31", Color.RED.getRGB()));
        insertGrade(con, new Grade(5, "32", Color.RED.getRGB()));
        insertGrade(con, new Grade(5, "33", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(5, "34", Color.GRAY.getRGB()));
        // britisch
        insertGrade(con, new Grade(6, "4a", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(6, "4b", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(6, "4c", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(6, "5a", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(6, "5b", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(6, "5c", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(6, "6a", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(6, "6b", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(6, "6c", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(6, "7a", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(6, "7b", Color.RED.getRGB()));
        // FontBleu
        insertGrade(con, new Grade(7, "Fb1", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(7, "Fb2", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(7, "Fb3", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(7, "Fb4-", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(7, "Fb4", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(7, "Fb4+", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(7, "Fb5a", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(7, "Fb5b", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(7, "Fb5c", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(7, "Fb6a", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(7, "Fb6b", Color.RED.getRGB()));
        insertGrade(con, new Grade(7, "Fb6c", Color.RED.getRGB()));
        insertGrade(con, new Grade(7, "Fb7a", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(7, "Fb7a+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(7, "Fb7b", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(7, "Fb7b+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(7, "Fb7c", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(7, "Fb7c+", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(7, "Fb8a", Color.PINK.getRGB()));//Pink
        insertGrade(con, new Grade(7, "Fb8a+", Color.PINK.getRGB()));
        insertGrade(con, new Grade(7, "Fb8b", Color.PINK.getRGB()));
        insertGrade(con, new Grade(7, "Fb8b+", Color.PINK.getRGB()));
        insertGrade(con, new Grade(7, "Fb8c", Color.PINK.getRGB()));
        insertGrade(con, new Grade(7, "Fb8c+", Color.PINK.getRGB()));
        // USA Bouldering
        insertGrade(con, new Grade(8, "VB-", Color.YELLOW.getRGB())); //Yellow
        insertGrade(con, new Grade(8, "V0-", Color.BLUE.getRGB())); //Blue
        insertGrade(con, new Grade(8, "V0", Color.BLUE.getRGB()));
        insertGrade(con, new Grade(8, "V1", Color.BLACK.getRGB())); //Black
        insertGrade(con, new Grade(8, "V2", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(8, "V3", Color.BLACK.getRGB()));
        insertGrade(con, new Grade(8, "V4", Color.GREEN.getRGB())); //Green
        insertGrade(con, new Grade(8, "V5", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(8, "V6", Color.GREEN.getRGB()));
        insertGrade(con, new Grade(8, "V7", Color.RED.getRGB())); //Red
        insertGrade(con, new Grade(8, "V8", Color.RED.getRGB()));
        insertGrade(con, new Grade(8, "V9", Color.RED.getRGB()));
        insertGrade(con, new Grade(8, "V10", Color.GRAY.getRGB())); //Grey
        insertGrade(con, new Grade(8, "V11", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(8, "V12", Color.GRAY.getRGB()));
        insertGrade(con, new Grade(8, "V13", Color.PINK.getRGB())); //Pink
        insertGrade(con, new Grade(8, "V14", Color.PINK.getRGB()));
        insertGrade(con, new Grade(8, "V15", Color.PINK.getRGB()));
        insertGrade(con, new Grade(8, "V16", Color.PINK.getRGB()));
    }
*/
}
