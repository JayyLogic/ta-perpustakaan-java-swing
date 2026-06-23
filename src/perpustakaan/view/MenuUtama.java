package perpustakaan.view;

import perpustakaan.report.LaporanBukuForm;

import javax.swing.*;
import java.awt.*;

/**
 * Form menu utama aplikasi perpustakaan.
 *
 * @author Azay Agustian
 */
public class MenuUtama extends JFrame {

    private final String namaUser;

    public MenuUtama(String namaUser) {
        this.namaUser = namaUser;
        AppTheme.setupLookAndFeel();
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Utama - Aplikasi Perpustakaan");
        setSize(680, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(AppTheme.BACKGROUND);
        background.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel card = AppTheme.createCardPanel();
        card.setLayout(new BorderLayout(15, 20));

        JPanel headerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        headerPanel.setBackground(AppTheme.CARD);

        JLabel lblJudul = AppTheme.createTitle("Aplikasi Manajemen Data Perpustakaan");
        JLabel lblUser = AppTheme.createSubtitle("Selamat datang, " + namaUser);
        JLabel lblInfo = AppTheme.createSubtitle("Kelola data buku perpustakaan dengan mudah dan terstruktur");

        headerPanel.add(lblJudul);
        headerPanel.add(lblUser);
        headerPanel.add(lblInfo);

        JButton btnKelolaBuku = new JButton("Kelola Data Buku");
        JButton btnLaporan = new JButton("Laporan Data Buku");
        JButton btnLogout = new JButton("Logout");

        AppTheme.stylePrimaryButton(btnKelolaBuku);
        AppTheme.styleSecondaryButton(btnLaporan);
        AppTheme.styleDangerButton(btnLogout);

        JPanel menuPanel = new JPanel(new GridLayout(3, 1, 12, 12));
        menuPanel.setBackground(AppTheme.CARD);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(25, 120, 25, 120));

        menuPanel.add(btnKelolaBuku);
        menuPanel.add(btnLaporan);
        menuPanel.add(btnLogout);

        JLabel lblFooter = new JLabel("Azay Agustian - 231011402845 | Topik: Perpustakaan", SwingConstants.CENTER);
        lblFooter.setFont(AppTheme.NORMAL_FONT);
        lblFooter.setForeground(AppTheme.ACCENT);

        card.add(headerPanel, BorderLayout.NORTH);
        card.add(menuPanel, BorderLayout.CENTER);
        card.add(lblFooter, BorderLayout.SOUTH);

        background.add(card);
        add(background);

        btnKelolaBuku.addActionListener(e -> {
            new BukuForm().setVisible(true);
        });

        btnLaporan.addActionListener(e -> {
            new LaporanBukuForm().setVisible(true);
        });

        btnLogout.addActionListener(e -> prosesLogout());
    }

    private void prosesLogout() {
        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true);
            dispose();
        }
    }
}