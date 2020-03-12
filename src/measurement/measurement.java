/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurement;

import DAL.DBContext;
import Model.Role;
import User_Functions.Main_Functions;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuankqhe130156
 */
public class measurement {

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException {
        DBContext d = new DBContext();
        Main_Functions f = new Main_Functions();
        int s = 0;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            ArrayList<Role> pers = d.getRoleForUser("user");
            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.print("Role number:" + pers.size());
            System.out.println(" - Time processing: " + estimatedTime);
            s += estimatedTime;
            Thread.sleep(2000);
        }
        
        System.out.println(s/10);
        
    }
}
