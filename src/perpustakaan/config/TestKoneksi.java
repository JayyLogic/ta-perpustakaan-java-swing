package perpustakaan.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class untuk melakukan test koneksi database MySQL.
 *
 * @author Azay Agustian
 */
public class TestKoneksi {

    public static void main(String[] args) {
        try (Connection conn = Koneksi.getConnection()) {
            if (conn != null) {
                System.out.println("Test koneksi sukses.");
            }
        } catch (SQLException e) {
            System.out.println("Test koneksi gagal: " + e.getMessage());
        }
    }
}
