package perpustakaan;

import perpustakaan.view.AppTheme;
import perpustakaan.view.LoginForm;

import javax.swing.SwingUtilities;

/**
 * Class utama untuk menjalankan aplikasi manajemen data perpustakaan.
 *
 * @author Azay Agustian
 */
public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppTheme.setupLookAndFeel();
            new LoginForm().setVisible(true);
        });
    }
}