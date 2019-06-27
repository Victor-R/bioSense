package biosensews.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaConexao implements IMySQL {

    private FabricaConexao() {

    }

    /**
     * Retorna uma conexão com o banco de dados
     *
     * @return Conexão configurada previamente
     */
    public static Connection getConexao() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
        }

        return con;
    }

    public static void close(Connection con) {

    }

    public static void close(Connection con, PreparedStatement pstm) {

    }

    public static void close(Connection con, PreparedStatement pstm, ResultSet res) {

    }

}
