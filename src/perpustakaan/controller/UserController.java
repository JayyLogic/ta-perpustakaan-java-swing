package perpustakaan.controller;

import perpustakaan.dao.UserDAO;
import perpustakaan.model.User;

/**
 * Controller untuk mengatur proses login pengguna.
 *
 * @author Azay Agustian
 */
public class UserController {

    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
