package perpustakaan.dao;

import perpustakaan.config.Koneksi;
import perpustakaan.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO untuk proses akses data user.
 *
 * @author Azay Agustian
 */
public class UserDAO {

    public User login(String username, String password) {
        User user = null;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setNamaLengkap(rs.getString("nama_lengkap"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Login gagal: " + e.getMessage());
        }

        return user;
    }
}