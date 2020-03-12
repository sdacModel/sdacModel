/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdac.pkgfor.iot.health.and.traffic.systems;

import Admin_Functions.MasterDataFunctions;
import Admin_Functions.Main_Functions;
import Model.Action;
import Model.ActionLevel;
import Model.ObjContainer;
import Model.Permission;
import Model.Role;
import Model.TypeOfUser;
import Model._Object;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author tuankqhe130156
 */
public class Admin_Page extends javax.swing.JDialog {

    /**
     * Creates new form Admin_Page
     */
    LoginForm father;
    Main_Functions u_Functions;
    MasterDataFunctions getMasterData = new MasterDataFunctions();
    ArrayList<Permission> permissonList;

    public Admin_Page(LoginForm father, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.father = father;
        u_Functions = new Main_Functions();

        initComponents();
        username.setText(father.inputUserName);
        getMasterData.getDesignationList(this);
        getMasterData.getTypeOfUsersList(this);
        getMasterData.getTypeOfObjectList(this);
        getMasterData.loadObjectList(this);
        getMasterData.loadObjectContainerList(this);
        getMasterData.loadActionList(this);
        getMasterData.loadActionLevelList(this);
        getMasterData.loadAllRoles(this);
        u_Functions.hideList(obj_list_panel);
        u_Functions.hideList(action_list_panel);
        try {
            permissonList = u_Functions.loadPermission(((ActionLevel) permission_action_level_list.getSelectedItem()).getId(),
                    ((ObjContainer) permission_obj_container_list.getSelectedItem()).getId());
            u_Functions.getPermissionOfRole(this, ((Role) roles_view.getSelectedItem()).getId());
        } catch (Exception e) {

        }
        //////////////
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        ////////////////////////////////////////////////
        obj_list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
//                    int index = list.locationToIndex(evt.getPoint());
                    _Object obj = obj_list.getSelectedValue();
                    ObjContainer objContainer = (ObjContainer) obj_container_list.getSelectedItem();
                    String result = u_Functions.addObjToContainer(obj.getId(), objContainer.getId());
                    JOptionPane.showMessageDialog(list, result + (result.equals("Success!") ? (" Added " + obj.getName() + " to " + objContainer.getName()) : ""));
                }
            }
        });

        action_list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
//                    int index = list.locationToIndex(evt.getPoint());
                    Action act = action_list.getSelectedValue();
                    ActionLevel actLv = (ActionLevel) action_level_list.getSelectedItem();
                    String result = u_Functions.addActionToActionLv(act.getId(), actLv.getId());
                    JOptionPane.showMessageDialog(list, result + (result.equals("Success!") ? (" Added " + act.getName() + " to " + actLv.getName()) : ""));
                }
            }
        });
    }

    public JTextField getPassword() {
        return password;
    }

    public JTextField getUserName() {
        return userName;
    }

    public JComboBox<TypeOfUser> getUserType() {
        return userType;
    }

    public JComboBox<TypeOfUser> getUser_designation() {
        return user_designation;
    }

    public JDateChooser getUser_from_date() {
        return user_from_date;
    }

    public JSpinner getUser_from_time() {
        return user_from_time;
    }

    public JTextField getUser_ip() {
        return user_ip;
    }

    public JDateChooser getUser_to_date() {
        return user_to_date;
    }

    public JSpinner getUser_to_time() {
        return user_to_time;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user_ip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        userType = new javax.swing.JComboBox<>();
        user_from_date = new com.toedter.calendar.JDateChooser();
        user_to_date = new com.toedter.calendar.JDateChooser();
        user_from_time = new javax.swing.JSpinner();
        user_to_time = new javax.swing.JSpinner();
        user_designation = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        obj_name = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        obj_ip = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        create_obj_button = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        obj_from_date = new com.toedter.calendar.JDateChooser();
        obj_to_date = new com.toedter.calendar.JDateChooser();
        obj_from_time = new javax.swing.JSpinner();
        obj_to_time = new javax.swing.JSpinner();
        obj_type = new javax.swing.JComboBox<>();
        obj_des = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        action_name = new javax.swing.JTextField();
        action_create_btn = new javax.swing.JButton();
        action_from_date = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        action_to_date = new com.toedter.calendar.JDateChooser();
        action_to_time = new javax.swing.JSpinner();
        action_from_time = new javax.swing.JSpinner();
        jLabel42 = new javax.swing.JLabel();
        action_ip = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        action_des = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        role_Name = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        role_IP = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        create_role_btn = new javax.swing.JButton();
        role_des = new javax.swing.JComboBox<>();
        role_from_date = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        role_to_date = new com.toedter.calendar.JDateChooser();
        role_from_time = new javax.swing.JSpinner();
        jLabel37 = new javax.swing.JLabel();
        role_to_time = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        obj_container_name = new javax.swing.JTextField();
        obj_container_create = new javax.swing.JButton();
        show_obj_list = new javax.swing.JCheckBox();
        obj_list_panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obj_list = new javax.swing.JList<>();
        jLabel38 = new javax.swing.JLabel();
        obj_container_list = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        action_level_name = new javax.swing.JTextField();
        show_action_list = new javax.swing.JCheckBox();
        obj_container_create1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        action_list_panel = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        action_level_list = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        action_list = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        permission_create_table = new javax.swing.JTable();
        permission_obj_container_list = new javax.swing.JComboBox<>();
        permission_action_level_list = new javax.swing.JComboBox<>();
        permission_count = new javax.swing.JLabel();
        refresh_create_permission = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        roles_view = new javax.swing.JComboBox<>();
        show_permission = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        refresh_create_role_permission = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin_Page");

        jPanel8.setBackground(new java.awt.Color(108, 205, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Admin User Creation Panel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel1.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, -1));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 290, -1));

        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 108, -1, -1));

        jLabel4.setText("User Type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 146, -1, -1));

        jLabel5.setText("From day");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 181, -1, -1));

        jLabel6.setText("From time");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        user_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_ipActionPerformed(evt);
            }
        });
        jPanel1.add(user_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 290, -1));

        jLabel7.setText("IP Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel8.setText("Designation");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        jPanel1.add(createBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jLabel9.setText("To");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, 20));

        jLabel10.setText("To");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, 20));

        jPanel1.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 290, -1));
        jPanel1.add(user_from_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));
        jPanel1.add(user_to_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        user_from_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel1.add(user_from_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 130, -1));

        user_to_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel1.add(user_to_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 130, -1));

        jPanel1.add(user_designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 290, -1));

        jTabbedPane1.addTab("Create Users", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 255));
        jLabel11.setText("Admin Object Creation Panel");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel12.setText("Object Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel2.add(obj_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, -1));

        jLabel13.setText("Object Type");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 108, -1, -1));

        jLabel15.setText("From date");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel16.setText("From time");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        obj_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obj_ipActionPerformed(evt);
            }
        });
        jPanel2.add(obj_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 290, -1));

        jLabel17.setText("IP Address");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel18.setText("Designation");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        create_obj_button.setText("Create");
        create_obj_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_obj_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(create_obj_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jLabel19.setText("To");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, 20));

        jLabel20.setText("To");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, 20));
        jPanel2.add(obj_from_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));
        jPanel2.add(obj_to_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        obj_from_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel2.add(obj_from_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 130, -1));

        obj_to_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel2.add(obj_to_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 130, -1));

        jPanel2.add(obj_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 290, 20));

        jPanel2.add(obj_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 290, -1));

        jTabbedPane1.addTab("Create Objects", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 255));
        jLabel14.setText("Admin Action Creation Panel");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel21.setText("Action Name");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel3.add(action_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, -1));

        action_create_btn.setText("Create");
        action_create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action_create_btnActionPerformed(evt);
            }
        });
        jPanel3.add(action_create_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));
        jPanel3.add(action_from_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel28.setText("From date");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel29.setText("From time");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel39.setText("To");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 20));
        jPanel3.add(action_to_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        action_to_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel3.add(action_to_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 130, -1));

        action_from_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel3.add(action_from_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, -1));

        jLabel42.setText("To");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 20));

        action_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action_ipActionPerformed(evt);
            }
        });
        jPanel3.add(action_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 290, -1));

        jLabel43.setText("IP Address");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel47.setText("Designation");
        jPanel3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jPanel3.add(action_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 290, -1));

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jTabbedPane1.addTab("Create Action", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 204, 255));
        jLabel22.setText("Admin Role Creation Panel");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel23.setText("Role Name");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel4.add(role_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 290, -1));

        jLabel24.setText("From date");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel25.setText("From time");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        role_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                role_IPActionPerformed(evt);
            }
        });
        jPanel4.add(role_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 290, -1));

        jLabel26.setText("IP Address");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel27.setText("Designation");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        create_role_btn.setText("Create Role");
        create_role_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_role_btnActionPerformed(evt);
            }
        });
        jPanel4.add(create_role_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        role_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                role_desActionPerformed(evt);
            }
        });
        jPanel4.add(role_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 290, -1));
        jPanel4.add(role_from_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jLabel36.setText("To");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, 20));
        jPanel4.add(role_to_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        role_from_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel4.add(role_from_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 130, -1));

        jLabel37.setText("To");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, 20));

        role_to_time.setModel(new javax.swing.SpinnerNumberModel(6, 6, 12, 1));
        jPanel4.add(role_to_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 130, -1));

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jTabbedPane1.addTab("Create Role ", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 204, 255));
        jLabel30.setText("Admin Object Container Creation Panel");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel31.setText("Obj Container Name");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel5.add(obj_container_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 250, -1));

        obj_container_create.setText("Create");
        obj_container_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obj_container_createActionPerformed(evt);
            }
        });
        jPanel5.add(obj_container_create, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        show_obj_list.setBackground(new java.awt.Color(255, 255, 255));
        show_obj_list.setText("Show list");
        show_obj_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_obj_listActionPerformed(evt);
            }
        });
        jPanel5.add(show_obj_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        obj_list_panel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setViewportView(obj_list);

        jLabel38.setText("Container:");

        javax.swing.GroupLayout obj_list_panelLayout = new javax.swing.GroupLayout(obj_list_panel);
        obj_list_panel.setLayout(obj_list_panelLayout);
        obj_list_panelLayout.setHorizontalGroup(
            obj_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(obj_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(obj_list_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(obj_container_list, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        obj_list_panelLayout.setVerticalGroup(
            obj_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(obj_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(obj_list_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(obj_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)
                        .addComponent(obj_container_list, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel5.add(obj_list_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 360, 220));

        jTabbedPane1.addTab("Obj Container", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setText("Action Level Name:");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 70, -1, -1));
        jPanel6.add(action_level_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 250, -1));

        show_action_list.setBackground(new java.awt.Color(255, 255, 255));
        show_action_list.setText("Show list");
        show_action_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_action_listActionPerformed(evt);
            }
        });
        jPanel6.add(show_action_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        obj_container_create1.setText("Create");
        obj_container_create1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obj_container_create1ActionPerformed(evt);
            }
        });
        jPanel6.add(obj_container_create1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 204, 255));
        jLabel32.setText("Admin Action Level Creation Panel");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        action_list_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setText("Level list");

        jScrollPane6.setViewportView(action_list);

        javax.swing.GroupLayout action_list_panelLayout = new javax.swing.GroupLayout(action_list_panel);
        action_list_panel.setLayout(action_list_panelLayout);
        action_list_panelLayout.setHorizontalGroup(
            action_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(action_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_list_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(action_level_list, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        action_list_panelLayout.setVerticalGroup(
            action_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(action_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(action_list_panelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(action_list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44)
                        .addComponent(action_level_list, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.add(action_list_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 370, 220));

        jTabbedPane1.addTab("Action Level", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 204, 255));
        jLabel34.setText("Automatic Permisson Creation Panel");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 27, -1, -1));

        jLabel40.setText("Object Container");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jButton9.setText("Execute");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 110, -1));

        jLabel41.setText("Action Levels");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        permission_create_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Action Name", "Obj Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(permission_create_table);
        if (permission_create_table.getColumnModel().getColumnCount() > 0) {
            permission_create_table.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 250, 270));

        permission_obj_container_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permission_obj_container_listActionPerformed(evt);
            }
        });
        jPanel7.add(permission_obj_container_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 130, 30));

        permission_action_level_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permission_action_level_listActionPerformed(evt);
            }
        });
        jPanel7.add(permission_action_level_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, 30));

        permission_count.setText("Total:");
        jPanel7.add(permission_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        refresh_create_permission.setText("Refresh");
        refresh_create_permission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_create_permissionActionPerformed(evt);
            }
        });
        jPanel7.add(refresh_create_permission, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jTabbedPane1.addTab("Permission Creation", jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setText("Role Name:");
        jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        roles_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roles_viewActionPerformed(evt);
            }
        });
        jPanel9.add(roles_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, -1));

        jPanel9.add(show_permission, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 200, -1));

        jLabel46.setText("Permisson Name:");
        jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        refresh_create_role_permission.setText("Refresh");
        refresh_create_role_permission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_create_role_permissionActionPerformed(evt);
            }
        });
        jPanel9.add(refresh_create_role_permission, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jTabbedPane1.addTab("Roles and Permisson", jPanel9);

        jPanel10.setBackground(new java.awt.Color(0, 102, 204));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Magneto", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("SDAC Model");

        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("username");

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(username)
                .addGap(138, 138, 138)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(username))
                    .addComponent(jLabel35))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_ipActionPerformed

    private void obj_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obj_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obj_ipActionPerformed

    private void role_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_role_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_role_IPActionPerformed

    private void role_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_role_desActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_role_desActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        father.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    public void setUserName(JTextField userName) {
        this.userName = userName;
    }

    public void setUserType(JComboBox<TypeOfUser> userType) {
        this.userType = userType;
    }

    public void setUser_designation(JComboBox<TypeOfUser> user_designation) {
        this.user_designation = user_designation;
    }

    public void setUser_from_date(JDateChooser user_from_date) {
        this.user_from_date = user_from_date;
    }

    public void setUser_from_time(JSpinner user_from_time) {
        this.user_from_time = user_from_time;
    }

    public void setUser_ip(JTextField user_ip) {
        this.user_ip = user_ip;
    }

    public void setUser_to_date(JDateChooser user_to_date) {
        this.user_to_date = user_to_date;
    }

    public void setUser_to_time(JSpinner user_to_time) {
        this.user_to_time = user_to_time;
    }

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        try {
            u_Functions.create_User(this);
            JOptionPane.showMessageDialog(this, "Create user successfully!");
            u_Functions.resetAllCreateUser(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_createBtnActionPerformed

    public JTextField getObj_address() {
        return obj_ip;
    }

    public JTextField getObj_ip() {
        return obj_ip;
    }

    public JComboBox<TypeOfUser> getObj_des() {
        return obj_des;
    }

    public JDateChooser getObj_from_date() {
        return obj_from_date;
    }

    public JSpinner getObj_from_time() {
        return obj_from_time;
    }

    public JTextField getObj_name() {
        return obj_name;
    }

    public JDateChooser getObj_to_date() {
        return obj_to_date;
    }

    public JSpinner getObj_to_time() {
        return obj_to_time;
    }

    public JComboBox<TypeOfUser> getObj_type() {
        return obj_type;
    }

    private void create_obj_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_obj_buttonActionPerformed

        if (obj_name.getText().equals("") || obj_ip.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all field!");
        } else {
            try {
                u_Functions.create_Object(this);
                JOptionPane.showMessageDialog(this, "Create object successfully!");
                getMasterData.loadObjectList(this);
                u_Functions.resetAllCreateObject(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }

    }//GEN-LAST:event_create_obj_buttonActionPerformed

    private void action_create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action_create_btnActionPerformed
        if (action_name.getText().equals("")|| action_ip.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill the action name!");
        } else {
            try {
                u_Functions.createAction(this);
                JOptionPane.showMessageDialog(this, "Create action successfully!");
                getMasterData.loadActionList(this);
                u_Functions.resetAction(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_action_create_btnActionPerformed

    private void create_role_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_role_btnActionPerformed
        if (role_Name.getText().equals("") || role_IP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all field!");
        } else {
            try {
                u_Functions.create_Role(this);
                JOptionPane.showMessageDialog(this, "Create role successfully!");
                u_Functions.resetAllCreateRole(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_create_role_btnActionPerformed

    private void obj_container_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obj_container_createActionPerformed
        if (obj_container_name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill the object container name!");
        } else {
            try {
                u_Functions.createObjContainer(this);
                JOptionPane.showMessageDialog(this, "Create object container successfully!");
                getMasterData.loadObjectContainerList(this);
                u_Functions.resetObjContainer(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_obj_container_createActionPerformed

    private void obj_container_create1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obj_container_create1ActionPerformed
        if (action_level_name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill the object container name!");
        } else {
            try {
                u_Functions.createActionLevel(this);
                JOptionPane.showMessageDialog(this, "Create action level successfully!");
                getMasterData.loadActionLevelList(this);
                u_Functions.resetActionLevel(this);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        }
    }//GEN-LAST:event_obj_container_create1ActionPerformed

    private void show_obj_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_obj_listActionPerformed
        if (show_obj_list.isSelected()) {
            obj_list_panel.setVisible(true);
        } else {
            obj_list_panel.setVisible(false);
        }
    }//GEN-LAST:event_show_obj_listActionPerformed

    private void show_action_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_action_listActionPerformed
        if (show_action_list.isSelected()) {
            action_list_panel.setVisible(true);
        } else {
            action_list_panel.setVisible(false);
        }
    }//GEN-LAST:event_show_action_listActionPerformed

    private void permission_obj_container_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permission_obj_container_listActionPerformed
        try {
            permissonList = u_Functions.loadPermission(((ActionLevel) permission_action_level_list.getSelectedItem()).getId(),
                    ((ObjContainer) permission_obj_container_list.getSelectedItem()).getId());
            u_Functions.showActionObject(this, permissonList);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_permission_obj_container_listActionPerformed

    private void permission_action_level_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permission_action_level_listActionPerformed
        try {
            permissonList = u_Functions.loadPermission(((ActionLevel) permission_action_level_list.getSelectedItem()).getId(),
                    ((ObjContainer) permission_obj_container_list.getSelectedItem()).getId());
            u_Functions.showActionObject(this, permissonList);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_permission_action_level_listActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        u_Functions.createPermission(this, permissonList);
        try {
            permissonList = u_Functions.loadPermission(((ActionLevel) permission_action_level_list.getSelectedItem()).getId(),
                    ((ObjContainer) permission_obj_container_list.getSelectedItem()).getId());
            u_Functions.getPermissionOfRole(this, ((Role) roles_view.getSelectedItem()).getId());
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void roles_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roles_viewActionPerformed
        try {
            u_Functions.getPermissionOfRole(this, ((Role) roles_view.getSelectedItem()).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_roles_viewActionPerformed

    private void refresh_create_permissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_create_permissionActionPerformed
        try {
            permissonList = u_Functions.loadPermission(((ActionLevel) permission_action_level_list.getSelectedItem()).getId(),
                    ((ObjContainer) permission_obj_container_list.getSelectedItem()).getId());
            u_Functions.showActionObject(this, permissonList);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_refresh_create_permissionActionPerformed

    private void refresh_create_role_permissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_create_role_permissionActionPerformed
        getMasterData.loadAllRoles(this);
        try {
            u_Functions.getPermissionOfRole(this, ((Role) roles_view.getSelectedItem()).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_refresh_create_role_permissionActionPerformed

    private void action_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_action_ipActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        u_Functions.resetAllCreateUser(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        u_Functions.resetAllCreateObject(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        u_Functions.resetAction(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        u_Functions.resetAllCreateRole(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Admin_Page dialog = new Admin_Page((LoginForm) new javax.swing.JFrame(), new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton action_create_btn;
    public javax.swing.JComboBox<TypeOfUser> action_des;
    public com.toedter.calendar.JDateChooser action_from_date;
    public javax.swing.JSpinner action_from_time;
    public javax.swing.JTextField action_ip;
    public javax.swing.JComboBox<ActionLevel> action_level_list;
    public javax.swing.JTextField action_level_name;
    public javax.swing.JList<Action> action_list;
    private javax.swing.JPanel action_list_panel;
    public javax.swing.JTextField action_name;
    public com.toedter.calendar.JDateChooser action_to_date;
    public javax.swing.JSpinner action_to_time;
    private javax.swing.JButton createBtn;
    private javax.swing.JButton create_obj_button;
    private javax.swing.JButton create_role_btn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton obj_container_create;
    private javax.swing.JButton obj_container_create1;
    public javax.swing.JComboBox<ObjContainer> obj_container_list;
    public javax.swing.JTextField obj_container_name;
    public javax.swing.JComboBox<TypeOfUser> obj_des;
    public com.toedter.calendar.JDateChooser obj_from_date;
    public javax.swing.JSpinner obj_from_time;
    public javax.swing.JTextField obj_ip;
    public javax.swing.JList<_Object> obj_list;
    private javax.swing.JPanel obj_list_panel;
    public javax.swing.JTextField obj_name;
    public com.toedter.calendar.JDateChooser obj_to_date;
    public javax.swing.JSpinner obj_to_time;
    public javax.swing.JComboBox<TypeOfUser> obj_type;
    public javax.swing.JTextField password;
    public javax.swing.JComboBox<ActionLevel> permission_action_level_list;
    public javax.swing.JLabel permission_count;
    public javax.swing.JTable permission_create_table;
    public javax.swing.JComboBox<ObjContainer> permission_obj_container_list;
    private javax.swing.JButton refresh_create_permission;
    private javax.swing.JButton refresh_create_role_permission;
    public javax.swing.JTextField role_IP;
    public javax.swing.JTextField role_Name;
    public javax.swing.JComboBox<TypeOfUser> role_des;
    public com.toedter.calendar.JDateChooser role_from_date;
    public javax.swing.JSpinner role_from_time;
    public com.toedter.calendar.JDateChooser role_to_date;
    public javax.swing.JSpinner role_to_time;
    public javax.swing.JComboBox<Role> roles_view;
    private javax.swing.JCheckBox show_action_list;
    private javax.swing.JCheckBox show_obj_list;
    public javax.swing.JComboBox<Permission> show_permission;
    public javax.swing.JTextField userName;
    public javax.swing.JComboBox<TypeOfUser> userType;
    public javax.swing.JComboBox<TypeOfUser> user_designation;
    public com.toedter.calendar.JDateChooser user_from_date;
    public javax.swing.JSpinner user_from_time;
    public javax.swing.JTextField user_ip;
    public com.toedter.calendar.JDateChooser user_to_date;
    public javax.swing.JSpinner user_to_time;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
