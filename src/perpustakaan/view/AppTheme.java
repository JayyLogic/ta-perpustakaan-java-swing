package perpustakaan.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class untuk menyimpan tema tampilan aplikasi perpustakaan.
 *
 * @author Azay Agustian
 */
public class AppTheme {

    public static final Color PRIMARY = new Color(27, 67, 50);
    public static final Color SECONDARY = new Color(45, 106, 79);
    public static final Color ACCENT = new Color(139, 94, 52);
    public static final Color BACKGROUND = new Color(248, 244, 227);
    public static final Color CARD = new Color(255, 255, 255);
    public static final Color TEXT = new Color(35, 35, 35);
    public static final Color DANGER = new Color(190, 55, 55);

    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.PLAIN, 15);
    public static final Font LABEL_FONT = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font NORMAL_FONT = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 13);

    private AppTheme() {
    }

    public static void setupLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            UIManager.put("control", BACKGROUND);
            UIManager.put("nimbusBase", PRIMARY);
            UIManager.put("nimbusBlueGrey", SECONDARY);
            UIManager.put("text", TEXT);

        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Gagal menerapkan tema: " + e.getMessage());
        }
    }

    public static JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(CARD);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(20, 24, 20, 24)
        ));
        return panel;
    }

    public static JLabel createTitle(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(TITLE_FONT);
        label.setForeground(PRIMARY);
        return label;
    }

    public static JLabel createSubtitle(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(SUBTITLE_FONT);
        label.setForeground(TEXT);
        return label;
    }

    public static void styleLabel(JLabel label) {
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT);
    }

    public static void styleTextField(JTextField textField) {
        textField.setFont(NORMAL_FONT);
        textField.setBorder(createInputBorder());
        textField.setBackground(Color.WHITE);
        textField.setForeground(TEXT);
        textField.setPreferredSize(new Dimension(230, 34));
        textField.setMinimumSize(new Dimension(180, 34));
    }

    public static void stylePasswordField(JPasswordField passwordField) {
        passwordField.setFont(NORMAL_FONT);
        passwordField.setBorder(createInputBorder());
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(TEXT);
        passwordField.setPreferredSize(new Dimension(230, 34));
        passwordField.setMinimumSize(new Dimension(180, 34));
    }

    public static void stylePrimaryButton(JButton button) {
        styleButton(button, SECONDARY);
    }

    public static void styleSecondaryButton(JButton button) {
        styleButton(button, ACCENT);
    }

    public static void styleDangerButton(JButton button) {
        styleButton(button, DANGER);
    }

    private static void styleButton(JButton button, Color color) {
        button.setFont(BUTTON_FONT);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(140, 36));
    }

    private static Border createInputBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(190, 190, 190)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        );
    }
}