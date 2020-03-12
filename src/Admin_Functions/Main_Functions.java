/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Functions;

import DAL.DBContext;
import Model.Action;
import Model.ActionLevel;
import Model.Permission;
import Model.Role;

import Model.TypeOfUser;
import Model._Object;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sdac.pkgfor.iot.health.and.traffic.systems.Admin_Page;
import sdac.pkgfor.iot.health.and.traffic.systems.UserForm;

/**
 *
 * @author tuankqhe130156
 */
public class Main_Functions {

    DBContext d = new DBContext();

    public void create_User(Admin_Page adminPanel) throws ParseException, ClassNotFoundException, SQLException {
        String username = adminPanel.getUserName().getText();
        String password = adminPanel.getPassword().getText();
        int type = ((TypeOfUser) adminPanel.getUserType().getSelectedItem()).getId();
        Date from_date = new java.sql.Date(adminPanel.getUser_from_date().getDate().getTime());
        Date to_date = new java.sql.Date(adminPanel.getUser_to_date().getDate().getTime());
        int from_time = (int) (adminPanel.getUser_from_time().getValue());
        int to_time = (int) (adminPanel.getUser_to_time().getValue());
        String ip = adminPanel.getUser_ip().getText();
        int des = ((TypeOfUser) adminPanel.getUser_designation().getSelectedItem()).getId();
        d.createUser(username, password, type, from_date, to_date, from_time, to_time, ip, des);
    }

    public void hideList(JPanel panel) {
        panel.setVisible(false);
    }

    public void showList(JPanel panel) {
        panel.setVisible(true);
    }

    public void resetAllCreateUser(Admin_Page adminPanel) {
        adminPanel.userName.setText("");
        adminPanel.password.setText("");
        adminPanel.userType.setSelectedIndex(0);
        adminPanel.user_from_date.setDate(new java.util.Date());
        adminPanel.user_to_date.setDate(new java.util.Date());
        adminPanel.user_from_time.setValue(6);
        adminPanel.user_to_time.setValue(6);
        adminPanel.user_ip.setText("");
        adminPanel.user_designation.setSelectedIndex(0);
    }

    public void create_Object(Admin_Page adminPanel) throws ParseException, ClassNotFoundException, SQLException {
        String name = adminPanel.getObj_name().getText();
        int type = ((TypeOfUser) adminPanel.getObj_type().getSelectedItem()).getId();
        Date from_date = new java.sql.Date(adminPanel.getObj_from_date().getDate().getTime());
        Date to_date = new java.sql.Date(adminPanel.getObj_to_date().getDate().getTime());
        int from_time = (int) (adminPanel.getObj_from_time().getValue());
        int to_time = (int) (adminPanel.getObj_to_time().getValue());
        String ip = adminPanel.getObj_ip().getText();
        int des = ((TypeOfUser) adminPanel.getObj_des().getSelectedItem()).getId();
        d.createObj(name, type, from_date, to_date, from_time, to_time, ip, des);
    }

    public void resetAllCreateObject(Admin_Page adminPanel) {
        adminPanel.obj_name.setText("");
        adminPanel.obj_type.setSelectedIndex(0);
        adminPanel.obj_from_date.setDate(new java.util.Date());
        adminPanel.obj_to_date.setDate(new java.util.Date());
        adminPanel.obj_from_time.setValue(6);
        adminPanel.obj_to_time.setValue(6);
        adminPanel.obj_ip.setText("");
        adminPanel.obj_des.setSelectedIndex(0);
    }

    public void createAction(Admin_Page adminPanel) throws ParseException, ClassNotFoundException, SQLException {
        String name = adminPanel.action_name.getText();
        Date from_date = new java.sql.Date(adminPanel.action_from_date.getDate().getTime());
        Date to_date = new java.sql.Date(adminPanel.action_to_date.getDate().getTime());
        int from_time = (int) (adminPanel.action_from_time.getValue());
        int to_time = (int) (adminPanel.action_to_time.getValue());
        String ip = adminPanel.action_ip.getText();
        int des = ((TypeOfUser) adminPanel.action_des.getSelectedItem()).getId();
        d.createAction(name, from_date, to_date, from_time, to_time, ip, des);
    }

    public void resetAction(Admin_Page adminPanel) {
        adminPanel.action_name.setText("");
        adminPanel.action_from_date.setDate(new java.util.Date());
        adminPanel.action_to_date.setDate(new java.util.Date());
        adminPanel.action_from_time.setValue(6);
        adminPanel.action_to_time.setValue(6);
        adminPanel.action_ip.setText("");
        adminPanel.action_des.setSelectedIndex(0);
    }

    public void create_Role(Admin_Page adminPanel) throws ParseException, ClassNotFoundException, SQLException {
        String name = adminPanel.role_Name.getText();
        Date from_date = new java.sql.Date(adminPanel.role_from_date.getDate().getTime());
        Date to_date = new java.sql.Date(adminPanel.role_to_date.getDate().getTime());
        int from_time = (int) (adminPanel.role_from_time.getValue());
        int to_time = (int) (adminPanel.role_to_time.getValue());
        String ip = adminPanel.role_IP.getText();
        int des = ((TypeOfUser) adminPanel.role_des.getSelectedItem()).getId();
        d.createRole(name, from_date, to_date, from_time, to_time, ip, des);
    }

    public void resetAllCreateRole(Admin_Page adminPanel) {
        adminPanel.role_Name.setText("");
        adminPanel.role_from_date.setDate(new java.util.Date());
        adminPanel.role_to_date.setDate(new java.util.Date());
        adminPanel.role_from_time.setValue(6);
        adminPanel.role_to_time.setValue(6);
        adminPanel.role_IP.setText("");
        adminPanel.role_des.setSelectedIndex(0);
    }

    public void createObjContainer(Admin_Page aThis) throws ClassNotFoundException, SQLException {
        d.createObjContainer(aThis.obj_container_name.getText());
    }

    public void resetObjContainer(Admin_Page aThis) {
        aThis.obj_container_name.setText("");
    }

    public void createActionLevel(Admin_Page aThis) throws ClassNotFoundException, SQLException {
        d.createActionLevel(aThis.action_level_name.getText());
    }

    public void resetActionLevel(Admin_Page aThis) {
        aThis.action_level_name.setText("");
    }

    ////////////////////////////////////////
    public String addObjToContainer(int obj, int container) throws ClassNotFoundException, SQLException {
        return d.addObjToContainer(obj, container);
    }

    public String addActionToActionLv(int act, int actLv) throws ClassNotFoundException, SQLException {
        return d.addActionToActionLevel(act, actLv);
    }

    ///////////////////////////////////////
    public void showActionObject(Admin_Page adminPanel, ArrayList<Permission> list) {
        int count = 0;
        DefaultTableModel model = (DefaultTableModel) adminPanel.permission_create_table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            String act = list.get(i).getAction().getName();
            String obj = list.get(i).getObj().getName();
            Object[] row = {act, obj};
            count++;
            model.addRow(row);
        }
        adminPanel.permission_create_table.setModel(model);
        adminPanel.permission_count.setText("Total: " + String.valueOf(count));
    }

    public ArrayList<Permission> loadPermission(int actionLevelId, int ObjContainerId) throws ClassNotFoundException, SQLException {
        ArrayList<Action> actionList = d.getActionFromActionLevel(actionLevelId);
        ArrayList<_Object> objectList = d.getObjectsFromAnObjectContainer(ObjContainerId);
        ArrayList<Permission> permissonList = new ArrayList<Permission>();
        for (int i = 0; i < actionList.size(); i++) {
            for (int j = 0; j < objectList.size(); j++) {
                permissonList.add(new Permission(actionList.get(i), objectList.get(j)));
            }
        }
        return permissonList;
    }

    public void createPermission(Admin_Page adminPanel, ArrayList<Permission> permissonList) throws ClassNotFoundException, SQLException {
        int count = d.createPermission(permissonList);
        if (count == 0) {
            JOptionPane.showMessageDialog(adminPanel, "All permissions for this selected ActionLevel and ObjectContainer had been created!");
        } else {
            JOptionPane.showMessageDialog(adminPanel, count + " permissions were created!");
        }
    }

    public void getPermissionOfRole(Admin_Page adminPanel, int roleId) throws ClassNotFoundException, SQLException {
        adminPanel.show_permission.removeAllItems();
        ArrayList<Permission> pers = d.getPermissionsOfARole(roleId);
        for (int i = 0; i < pers.size(); i++) {
            adminPanel.show_permission.addItem(pers.get(i));
        }
    }
    
}
