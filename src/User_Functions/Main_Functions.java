/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Functions;

import DAL.DBContext;

import Model.Permission;
import Model.Role;
import java.awt.Color;
import java.util.ArrayList;
import sdac.pkgfor.iot.health.and.traffic.systems.UserForm;
import java.lang.String;
import java.lang.instrument.Instrumentation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
/**
 *
 * @author tuankqhe130156
 */
public class Main_Functions {

    DBContext d = new DBContext();

    public static void printObjectSize(Object object) {
        System.out.println(ObjectSizeCalculator.getObjectSize(object));
    }

    public void getRolesForUser(UserForm userPanel, String username) throws SQLException, ClassNotFoundException {
        userPanel.role.removeAllItems();
        ArrayList<Role> pers = d.getRoleForUser(username);
        for (int i = 0; i < pers.size(); i++) {
            userPanel.role.addItem(pers.get(i));
        }
    }

    public void getPermissionOfRole(UserForm userPanel, int roleId) throws ClassNotFoundException, SQLException {
        userPanel.permission.removeAllItems();
        ArrayList<Permission> pers = d.getPermissionsOfARole(roleId);
        for (int i = 0; i < pers.size(); i++) {
            userPanel.permission.addItem(pers.get(i));
        }
    }

    public void checkPermissionForUser(UserForm userPanel, int role, int per) throws ClassNotFoundException, SQLException {
        
        Permission selectedPer = ((Permission) userPanel.permission.getSelectedItem());
//        long startTime = System.currentTimeMillis();
        boolean access = d.checkPermissionForUser(role, selectedPer);
//        long estimatedTime = System.currentTimeMillis() - startTime;
//        System.out.println("time processing: " + estimatedTime);
        if (access) {
            JOptionPane.showMessageDialog(userPanel, "Access granted!\nSuccessfully activated the role " + ((Role) userPanel.role.getSelectedItem()).getName()
                    + " and permission " + (selectedPer));
            userPanel.message.setText("Access granted!");
            userPanel.message.setForeground(new Color(21, 81, 37));
        } else {
            JOptionPane.showMessageDialog(userPanel, "Access denied!");
            userPanel.message.setText("Access denied!");
            userPanel.message.setForeground(Color.red);
        }

        userPanel.message.setVisible(true);
    }
}
