package perpustakaan.dao;

import perpustakaan.model.User;

/**
 * Class untuk mengetes proses login melalui UserDAO.
 *
 * @author Azay Agustian
 */
public class TestLogin {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.login("admin", "admin123");

        if (user != null) {
            System.out.println("Login berhasil.");
            System.out.println("Selamat datang, " + user.getNamaLengkap());
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}