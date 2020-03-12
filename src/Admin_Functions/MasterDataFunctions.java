/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_Functions;

import DAL.DBContext;
import Model.Action;
import Model.ActionLevel;
import Model.ObjContainer;
import Model.Role;

import Model.TypeOfUser;
import Model._Object;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.ListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListDataListener;
import sdac.pkgfor.iot.health.and.traffic.systems.Admin_Page;

/**
 *
 * @author tuankqhe130156
 */
public class MasterDataFunctions {

    DBContext d = new DBContext();

    public void loadActionLevelList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        adminPanel.action_level_list.removeAllItems();
        ArrayList<ActionLevel> oc = d.getAllActionLevels();
        for (int i = 0; i < oc.size(); i++) {
            adminPanel.action_level_list.addItem(oc.get(i));
            adminPanel.permission_action_level_list.addItem(oc.get(i));
        }
    }

    public void loadObjectList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        adminPanel.obj_list.removeAll();
        ArrayList<_Object> objList = d.getAllObjects();
        DefaultListModel<_Object> model = new DefaultListModel<_Object>();
        for (int i = 0; i < objList.size(); i++) {
            model.add(i, objList.get(i));
        }
        adminPanel.obj_list.setModel(model);

    }

    public void loadActionList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        adminPanel.action_list.removeAll();
        ArrayList<Action> actList = d.getAllAction();
        DefaultListModel<Action> model = new DefaultListModel<Action>();
        for (int i = 0; i < actList.size(); i++) {
            model.add(i, actList.get(i));
        }
        adminPanel.action_list.setModel(model);
    }

    public void loadObjectContainerList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        adminPanel.obj_container_list.removeAllItems();
        ArrayList<ObjContainer> oc = d.getAllObjectContainers();
        for (int i = 0; i < oc.size(); i++) {
            adminPanel.obj_container_list.addItem(oc.get(i));
            adminPanel.permission_obj_container_list.addItem(oc.get(i));
        }
        
    }

    public void getDesignationList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        ArrayList<TypeOfUser> ds = d.getDesignations();
        for (int i = 0; i < ds.size(); i++) {
            adminPanel.user_designation.addItem(ds.get(i));
            adminPanel.obj_des.addItem(ds.get(i));
            adminPanel.role_des.addItem(ds.get(i));
            adminPanel.action_des.addItem(ds.get(i));
        }
    }

    public void getTypeOfUsersList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        ArrayList<TypeOfUser> ds = d.getAllTypeOfUser();

        for (int i = 0; i < ds.size(); i++) {
            adminPanel.userType.addItem(ds.get(i));
        }
    }

    public void getTypeOfObjectList(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        ArrayList<TypeOfUser> ds = d.getAllTypeOfObj();
        for (int i = 0; i < ds.size(); i++) {
            adminPanel.obj_type.addItem(ds.get(i));
        }
    }

    public void loadAllRoles(Admin_Page adminPanel) throws ClassNotFoundException, SQLException {
        ArrayList<Role> ds = d.getAllRoles();
        adminPanel.roles_view.removeAllItems();
        for (int i = 0; i < ds.size(); i++) {
            adminPanel.roles_view.addItem(ds.get(i));
        }
    }

}
