package perpustakaan.view;

import perpustakaan.controller.UserController;
import perpustakaan.model.User;

import javax.swing.*;
import java.awt.*;

/**
 * Form login aplikasi perpustakaan.
 *
 * @author Azay Agustian
 */
public class LoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnKeluar;
    private final UserController userController = new UserController();

    public LoginForm() {
        AppTheme.setupLookAndFeel();
        initComponents();
    }

    private void initComponents() {
        setTitle("Login - Aplikasi Perpustakaan");
        setSize(460, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(AppTheme.BACKGROUND);
        background.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel card = AppTheme.createCardPanel();
        card.setLayout(new BorderLayout(15, 20));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        headerPanel.setBackground(AppTheme.CARD);

        JLabel lblJudul = AppTheme.createTitle("Login Perpustakaan");
        JLabel lblSubjudul = AppTheme.createSubtitle("Silakan masuk untuk mengelola data buku");

        headerPanel.add(lblJudul);
        headerPanel.add(lblSubjudul);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 12, 14));
        formPanel.setBackground(AppTheme.CARD);

        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");

        AppTheme.styleLabel(lblUsername);
        AppTheme.styleLabel(lblPassword);

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        AppTheme.styleTextField(txtUsername);
        AppTheme.stylePasswordField(txtPassword);

        formPanel.add(lblUsername);
        formPanel.add(txtUsername);
        formPanel.add(lblPassword);
        formPanel.add(txtPassword);

        btnLogin = new JButton("Login");
        btnKeluar = new JButton("Keluar");

        AppTheme.stylePrimaryButton(btnLogin);
        AppTheme.styleDangerButton(btnKeluar);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 12, 12));
        buttonPanel.setBackground(AppTheme.CARD);
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnKeluar);

        JLabel lblFooter = new JLabel("Azay Agustian - 231011402845", SwingConstants.CENTER);
        lblFooter.setFont(AppTheme.NORMAL_FONT);
        lblFooter.setForeground(AppTheme.ACCENT);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 12));
        bottomPanel.setBackground(AppTheme.CARD);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(lblFooter, BorderLayout.SOUTH);

        card.add(headerPanel, BorderLayout.NORTH);
        card.add(formPanel, BorderLayout.CENTER);
        card.add(bottomPanel, BorderLayout.SOUTH);

        background.add(card);
        add(background);

        btnLogin.addActionListener(e -> prosesLogin());
        btnKeluar.addActionListener(e -> System.exit(0));
    }

    private void prosesLogin() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan password wajib diisi.");
            return;
        }

        User user = userController.login(username, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login berhasil. Selamat datang, " + user.getNamaLengkap());
            new MenuUtama(user.getNamaLengkap()).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login gagal. Username atau password salah.");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}
