package perpustakaan.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class untuk mengatur koneksi aplikasi ke database MySQL.
 *
 * @author Azay Agustian
 */
public class Koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/db_perpustakaan_231011402845"
            + "?useSSL=false&serverTimezone=Asia/Jakarta";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL tidak ditemukan.", e);
        }
    }
}
