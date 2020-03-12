/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author tuankqhe130156
 */
import Model.Action;
import Model.ActionLevel;
import Model.ObjContainer;
import Model.Permission;
import Model.Role;
import Model.TypeOfUser;
import Model.User;
import Model._Object;
import static User_Functions.Main_Functions.printObjectSize;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuankq
 */
public class DBContext {

    Connection connection;

    public DBContext() {
        try {
            connection = getCon();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() throws ClassNotFoundException, SQLException {
        String user = "sa";
        String pass = "sa";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=RBACDB";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }

    public void closeConnection(PreparedStatement st, ResultSet rs, Connection connection) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public TypeOfUser getTypeOfUser(String username, String IP_Address) throws ClassNotFoundException, SQLException {
        connection = getCon();
        TypeOfUser t = new TypeOfUser();
        String sql = "Select t.* from Account_Type t, [User] u\n"
                + "where u.Type=t.id and u.username=? and u.IP_Address=?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, IP_Address);
            rs = statement.executeQuery();
            if (rs.next() == false) {
                return null;
            } else {
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return t;
    }

    public ArrayList<TypeOfUser> getAllTypeOfUser() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<TypeOfUser> t = new ArrayList<>();
        String sql = "Select * from Account_Type";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                TypeOfUser m = new TypeOfUser();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                t.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return t;
    }

    public ArrayList<TypeOfUser> getAllTypeOfObj() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<TypeOfUser> t = new ArrayList<>();
        String sql = "Select * from Object_Type";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                TypeOfUser m = new TypeOfUser();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                t.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return t;
    }

    public User getUser(String username, String password, String IP) throws ClassNotFoundException, SQLException {
        connection = getCon();
        User u = new User();
        String sql = "select * from [user] where username=? and password=? and IP_Address=?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, IP);
            rs = statement.executeQuery();
            if (rs.next() == false) {
                return null;
            } else {
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("Type"));
                u.setIP_Address(rs.getString("IP_Address"));
                u.setDesignation(rs.getInt("Designation"));
                u.setFrom_date(rs.getDate("from_date"));
                u.setTo_date(rs.getDate("to_date"));
                u.setFrom_time(rs.getDate("from_time"));
                u.setTo_time(rs.getDate("to_time"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return u;
    }

    public ArrayList<TypeOfUser> getDesignations() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<TypeOfUser> d = new ArrayList<>();
        String sql = "SELECT  * from Designation";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                TypeOfUser h = new TypeOfUser();
                h.setId(rs.getInt("id"));
                h.setName(rs.getString("name"));
                d.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    public void createUser(String username, String password, int type, Date from_date, Date to_date, int from_time, int to_time, String ip, int des) throws ParseException, ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [USER]\n"
                + "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, type);
            statement.setString(4, ip);
            statement.setInt(5, des);
            statement.setDate(6, from_date);
            statement.setDate(7, to_date);
            statement.setTime(8, new java.sql.Time(formatter.parse(from_time + ":00:00").getTime()));
            statement.setTime(9, new java.sql.Time(formatter.parse(to_time + ":00:00").getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
    }

    public void createObj(String name, int type, Date from_date, Date to_date, int from_time, int to_time, String ip, int des) throws ParseException, ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [Object](name,type,ip_address,designation,from_date,to_date,from_time,to_time)\n"
                + "values(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, type);
            statement.setString(3, ip);
            statement.setInt(4, des);
            statement.setDate(5, from_date);
            statement.setDate(6, to_date);
            statement.setTime(7, new java.sql.Time(formatter.parse(from_time + ":00:00").getTime()));
            statement.setTime(8, new java.sql.Time(formatter.parse(to_time + ":00:00").getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
    }

    public void createAction(String name, Date from_date, Date to_date, int from_time, int to_time, String ip, int des) throws ParseException, ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [Action]\n"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        ResultSet rs = null;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, ip);
            statement.setInt(3, des);
            statement.setDate(4, from_date);
            statement.setDate(5, to_date);
            statement.setTime(6, new java.sql.Time(formatter.parse(from_time + ":00:00").getTime()));
            statement.setTime(7, new java.sql.Time(formatter.parse(to_time + ":00:00").getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
    }

    public void createRole(String name, Date from_date, Date to_date, int from_time, int to_time, String ip, int des) throws ParseException, ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [Role](name,ip_address,designation,from_date,to_date,from_time,to_time)\n"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, ip);
            statement.setInt(3, des);
            statement.setDate(4, from_date);
            statement.setDate(5, to_date);
            statement.setTime(6, new java.sql.Time(formatter.parse(from_time + ":00:00").getTime()));
            statement.setTime(7, new java.sql.Time(formatter.parse(to_time + ":00:00").getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void createObjContainer(String name) throws ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [Object_Container](name)\n"
                + "values(?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            statement.close();
        }
    }

    public void createActionLevel(String name) throws ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into [Action_Level](name)\n"
                + "values(?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.close();
            statement.close();
        }
    }

    public ArrayList<_Object> getAllObjects() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<_Object> t = new ArrayList<>();
        String sql = "Select * from Object";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                _Object u = new _Object();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setType(rs.getInt("Type"));
                u.setIP_Address(rs.getString("IP_Address"));
                u.setDesignation(rs.getInt("Designation"));
                u.setFrom_date(rs.getDate("from_date"));
                u.setTo_date(rs.getDate("to_date"));
                u.setFrom_time(rs.getDate("from_time"));
                u.setTo_time(rs.getDate("to_time"));
                t.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return t;
    }

    public ArrayList<ObjContainer> getAllObjectContainers() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<ObjContainer> d = new ArrayList<>();
        String sql = "SELECT  * from Object_Container";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                ObjContainer h = new ObjContainer();
                h.setId(rs.getInt("id"));
                h.setName(rs.getString("name"));
                d.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    public ArrayList<Action> getAllAction() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<Action> d = new ArrayList<>();
        String sql = "SELECT  * from Action";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Action h = new Action();
                h.setId(rs.getInt("id"));
                h.setName(rs.getString("name"));
                h.setIP_Address(rs.getString("IP_Address"));
                h.setDesignation(rs.getInt("Designation"));
                h.setFrom_date(rs.getDate("from_date"));
                h.setTo_date(rs.getDate("to_date"));
                h.setFrom_time(rs.getDate("from_time"));
                h.setTo_time(rs.getDate("to_time"));
                d.add(h);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    public ArrayList<ActionLevel> getAllActionLevels() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<ActionLevel> d = new ArrayList<>();
        String sql = "SELECT  * from Action_Level";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                ActionLevel h = new ActionLevel();
                h.setId(rs.getInt("id"));
                h.setName(rs.getString("name"));
                d.add(h);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    public String addObjToContainer(int obj, int container) throws ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into ObjectContainer_Obj values (?,?)";
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement(sql);
            statement.setInt(1, container);
            statement.setInt(2, obj);
            statement.executeUpdate();
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "This object is already exist in this container!!";
        } finally {
            connection.close();
            statement.close();
        }
    }

    public String addActionToActionLevel(int act, int actLv) throws ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "insert into ActionLevel_Action values (?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, act);
            statement.setInt(2, actLv);
            statement.executeUpdate();
            return "Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "This action is already exist in this action level!!";
        } finally {
            connection.close();
            statement.close();
        }
    }

    public ArrayList<_Object> getObjectsFromAnObjectContainer(int ObjContainerId) throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<_Object> d = new ArrayList<>();
        String sql = "select Object.* from ObjectContainer_Obj,Object\n"
                + "where ObjContainer=? and Object.id=ObjectContainer_Obj.Obj";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ObjContainerId);
            rs = statement.executeQuery();
            while (rs.next()) {
                _Object u = new _Object();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setType(rs.getInt("Type"));
                u.setIP_Address(rs.getString("IP_Address"));
                u.setDesignation(rs.getInt("Designation"));
                u.setFrom_date(rs.getDate("from_date"));
                u.setTo_date(rs.getDate("to_date"));
                u.setFrom_time(rs.getDate("from_time"));
                u.setTo_time(rs.getDate("to_time"));
                d.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    public ArrayList<Action> getActionFromActionLevel(int ActionLevelId) throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<Action> d = new ArrayList<>();
        String sql = "select Action.* from ActionLevel_Action,Action\n"
                + "where Action_Level=? and Action.id=ActionLevel_Action.Action";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ActionLevelId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Action u = new Action();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                d.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return d;
    }

    ///////////////////////////////////////////
    public int createPermission(ArrayList<Permission> list) throws ClassNotFoundException, SQLException {
        connection = getCon();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String sql = "insert into permission values (?,?)";
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, list.get(i).getAction().getId());
                statement.setInt(2, list.get(i).getObj().getId());
                count += statement.executeUpdate();
                System.out.println("Permission created successfully!");
            } catch (Exception e) {
                System.out.println("Permission had been created!");
            }
        }
        connection.close();
        return count;
    }

    public ArrayList<Role> getRoleForUser(String username) throws SQLException, ClassNotFoundException {
        ArrayList<Role> roles = new ArrayList<>();
        String sql = "select r.* from Role r,[User] u where r.IP_Address=u.IP_Address and r.Designation=u.Designation\n"
                + "and r.from_date=u.from_date and r.to_date=u.to_date and r.from_time=u.from_time and \n"
                + "r.to_time=u.to_time and u.username=?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = getCon();
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            rs = statement.executeQuery();
            while (rs.next()) {
                Role u = new Role();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setIP_Address(rs.getString("IP_Address"));
                u.setDesignation(rs.getInt("Designation"));
                u.setFrom_date(rs.getDate("from_date"));
                u.setTo_date(rs.getDate("to_date"));
                u.setFrom_time(rs.getDate("from_time"));
                u.setTo_time(rs.getDate("to_time"));
                roles.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }

        return roles;
    }

    public ArrayList<Role> getAllRoles() throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<Role> roles = new ArrayList<>();
        String sql = "select * from Role";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Role u = new Role();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setIP_Address(rs.getString("IP_Address"));
                u.setDesignation(rs.getInt("Designation"));
                u.setFrom_date(rs.getDate("from_date"));
                u.setTo_date(rs.getDate("to_date"));
                u.setFrom_time(rs.getDate("from_time"));
                u.setTo_time(rs.getDate("to_time"));
                roles.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return roles;
    }

    public ArrayList<Permission> getPermissionsOfARole(int roleId) throws ClassNotFoundException, SQLException {
        connection = getCon();
        ArrayList<Permission> p = new ArrayList<>();
        String sql = "select a.id as ActId, a.name as ActName,o.name as OName,o.id as OId from Action a,Object o,\n"
                + "(select permission.* from permission, \n"
                + "(select o.id from object o ,role r  where \n"
                + "o.IP_Address=r.IP_Address and o.Designation=r.Designation and o.from_date=r.from_date \n"
                + "and o.to_date=r.to_date and o.from_time=r.from_time and o.to_time=r.to_time and r.id=?) a\n"
                + "where Permission.Obj=a.id) tb\n"
                + "where tb.Action=a.id and tb.Obj=o.id";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, roleId);
            rs = statement.executeQuery();
            while (rs.next()) {

                Permission u = new Permission();
                u.getAction().setId(rs.getInt("ActId"));
                u.getAction().setName(rs.getString("ActName"));
                u.getObj().setId(rs.getInt("OId"));
                u.getObj().setName(rs.getString("OName"));
                p.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return p;
    }

//    public static void main(String args[]) throws ClassNotFoundException, SQLException {
//        DBContext db = new DBContext();
//        ArrayList<Permission> role = db.getPermissionsOfARole(1);
//        System.out.println(role.size());
//    }
    public boolean checkPermissionForUser(int role, Permission per) throws ClassNotFoundException, SQLException {
        connection = getCon();
        String sql = "select a.id as act_id,\n"
                + "a.IP_Address as act_ip,\n"
                + "	   a.Designation as act_des,\n"
                + "	   a.from_date as act_frDate,\n"
                + "	   a.to_date as act_toDate,\n"
                + "	   a.from_time as act_frTime,\n"
                + "	   a.to_time as act_toTime,\n"
                + "	   o.id as obj_id,\n"
                + "	   o.IP_Address as obj_ip,\n"
                + "	   o.Designation as obj_des,\n"
                + "	   o.from_date as obj_frDate,\n"
                + "	   o.to_date as obj_toDate,\n"
                + "	   o.from_time as obj_frTime,\n"
                + "	   o.to_time as obj_toTime\n"
                + "from Action a,Object o,\n"
                + "(select permission.* from permission, \n"
                + "	(select o.id from object o ,role r  where \n"
                + "	o.IP_Address=r.IP_Address and o.Designation=r.Designation and o.from_date=r.from_date \n"
                + "	and o.to_date=r.to_date and o.from_time=r.from_time and o.to_time=r.to_time and r.id=?) \n"
                + "b\n"
                + "where Permission.Obj=b.id) \n"
                + "tb\n"
                + "where tb.Action=a.id and tb.Obj=o.id\n"
                + "and a.IP_Address=o.IP_Address and a.Designation=o.Designation\n"
                + "and a.from_date=o.from_date and a.to_date=o.to_date\n"
                + "and a.from_time=o.from_time and a.to_time=o.to_time\n"
                + "and a.id=? and o.id=?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, role);
            statement.setInt(2, per.getAction().getId());
            statement.setInt(3, per.getObj().getId());
            rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(statement, rs, connection);
        }
        return false;
    }

}
