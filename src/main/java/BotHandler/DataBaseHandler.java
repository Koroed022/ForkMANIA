package BotHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler {
    ArrayList<Heap> heapList= new ArrayList<Heap>();
    public static final String linkDB = "jdbc:sqlite:./databases/main.db";
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = linkDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public ArrayList<Heap> selectAll(){
        String sql = "SELECT chatId, name, ifSend FROM Users";
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("chatId") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getBoolean("ifSend"));
                heapList.add(new Heap(rs.getInt("chatId"), rs.getString("name"),rs.getBoolean("ifSend")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return heapList;
    }

    public void update(int id, String name, double capacity) {
        String sql = "UPDATE warehouses SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM warehouses WHERE id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);


            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUser(String chatID, String name, String lastname){
        String sql = "INSERT INTO Users (chatID, name, lastname) VALUES (?,?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, chatID);
            pstmt.setString(2,name);
            pstmt.setString(3,lastname);
            System.out.println(chatID + "  " + name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void addHero(String heroID, String heroName){
        String sql = "INSERT INTO Heroes (id, name) VALUES (?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, heroID);
            pstmt.setString(2, heroName);

            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void addInventory(String material, int warehouseId, double qty) {
        // SQL for creating a new material
        String sqlMaterial = "INSERT INTO materials(description) VALUES(?)";

        // SQL for posting inventory
        String sqlInventory = "INSERT INTO inventory(warehouse_id,material_id,qty)"
                + "VALUES(?,?,?)";

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt1 = null, pstmt2 = null;

        try {
            // connect to the database
            conn = this.connect();
            if(conn == null)
                return;

            // set auto-commit mode to false
            conn.setAutoCommit(false);

            // 1. insert a new material
            pstmt1 = conn.prepareStatement(sqlMaterial,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt1.setString(1, material);
            int rowAffected = pstmt1.executeUpdate();

            // get the material id
            rs = pstmt1.getGeneratedKeys();
            int materialId = 0;
            if (rs.next()) {
                materialId = rs.getInt(1);
            }

            if (rowAffected != 1) {
                conn.rollback();
            }
            // 2. insert the inventory
            pstmt2 = conn.prepareStatement(sqlInventory);
            pstmt2.setInt(1, warehouseId);
            pstmt2.setInt(2, materialId);
            pstmt2.setDouble(3, qty);
            //
            pstmt2.executeUpdate();
            // commit work
            conn.commit();

        } catch (SQLException e1) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e1.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
}
