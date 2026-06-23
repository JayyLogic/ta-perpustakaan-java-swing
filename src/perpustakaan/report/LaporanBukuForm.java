package perpustakaan.report;

import perpustakaan.controller.BukuController;
import perpustakaan.model.Buku;
import perpustakaan.view.AppTheme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.List;

/**
 * Form laporan data buku perpustakaan.
 *
 * @author Azay Agustian
 */
public class LaporanBukuForm extends JFrame {

    private JTextField txtCari;
    private JLabel lblTotalData;
    private JTable tableLaporan;
    private DefaultTableModel tableModel;

    private final BukuController bukuController = new BukuController();

    public LaporanBukuForm() {
        AppTheme.setupLookAndFeel();
        initComponents();
        loadDataLaporan();
    }

    private void initComponents() {
        setTitle("Laporan Data Buku - Aplikasi Perpustakaan");
        setSize(1100, 620);
        setMinimumSize(new Dimension(1000, 580));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        JPanel background = new JPanel(new BorderLayout(14, 14));
        background.setBackground(AppTheme.BACKGROUND);
        background.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JLabel lblJudul = AppTheme.createTitle("Laporan Data Buku Perpustakaan");
        JLabel lblSubjudul = AppTheme.createSubtitle("Data laporan dapat dicari, diurutkan, dan dicetak");

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        headerPanel.setBackground(AppTheme.BACKGROUND);
        headerPanel.add(lblJudul);
        headerPanel.add(lblSubjudul);

        txtCari = new JTextField();
        AppTheme.styleTextField(txtCari);

        JButton btnCari = new JButton("Cari");
        JButton btnRefresh = new JButton("Refresh");
        JButton btnCetak = new JButton("Cetak Laporan");
        JButton btnKembali = new JButton("Kembali");

        AppTheme.stylePrimaryButton(btnCari);
        AppTheme.styleSecondaryButton(btnRefresh);
        AppTheme.stylePrimaryButton(btnCetak);
        AppTheme.styleDangerButton(btnKembali);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBackground(AppTheme.BACKGROUND);
        buttonPanel.add(btnCari);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnCetak);
        buttonPanel.add(btnKembali);

        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBackground(AppTheme.BACKGROUND);
        searchPanel.add(txtCari, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);

        tableModel = new DefaultTableModel(
                new Object[]{"No", "Kode Buku", "Judul", "Penulis", "Penerbit", "Tahun", "Kategori", "Stok", "Lokasi Rak"},
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0 || columnIndex == 5 || columnIndex == 7) {
                    return Integer.class;
                }
                return String.class;
            }
        };

        tableLaporan = new JTable(tableModel);
        tableLaporan.setFont(AppTheme.NORMAL_FONT);
        tableLaporan.setRowHeight(27);
        tableLaporan.getTableHeader().setFont(AppTheme.LABEL_FONT);
        tableLaporan.getTableHeader().setBackground(AppTheme.PRIMARY);
        tableLaporan.getTableHeader().setForeground(Color.WHITE);
        tableLaporan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableLaporan.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableLaporan.setAutoCreateRowSorter(true);

        tableLaporan.getColumnModel().getColumn(0).setPreferredWidth(45);
        tableLaporan.getColumnModel().getColumn(1).setPreferredWidth(90);
        tableLaporan.getColumnModel().getColumn(2).setPreferredWidth(260);
        tableLaporan.getColumnModel().getColumn(3).setPreferredWidth(150);
        tableLaporan.getColumnModel().getColumn(4).setPreferredWidth(150);
        tableLaporan.getColumnModel().getColumn(5).setPreferredWidth(70);
        tableLaporan.getColumnModel().getColumn(6).setPreferredWidth(140);
        tableLaporan.getColumnModel().getColumn(7).setPreferredWidth(60);
        tableLaporan.getColumnModel().getColumn(8).setPreferredWidth(90);

        JScrollPane scrollPane = new JScrollPane(tableLaporan);

        lblTotalData = new JLabel("Total data: 0 | Klik header tabel untuk mengurutkan data");
        lblTotalData.setFont(AppTheme.LABEL_FONT);
        lblTotalData.setForeground(AppTheme.PRIMARY);

        JLabel lblFooter = new JLabel(
                "Azay Agustian - 231011402845 | Laporan Data Buku Perpustakaan",
                SwingConstants.CENTER
        );
        lblFooter.setFont(AppTheme.NORMAL_FONT);
        lblFooter.setForeground(AppTheme.ACCENT);

        JPanel footerPanel = new JPanel(new BorderLayout(10, 10));
        footerPanel.setBackground(AppTheme.BACKGROUND);
        footerPanel.add(lblTotalData, BorderLayout.WEST);
        footerPanel.add(lblFooter, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBackground(AppTheme.BACKGROUND);
        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        background.add(headerPanel, BorderLayout.NORTH);
        background.add(centerPanel, BorderLayout.CENTER);
        background.add(footerPanel, BorderLayout.SOUTH);

        add(background);

        btnCari.addActionListener(e -> cariDataLaporan());

        btnRefresh.addActionListener(e -> {
            txtCari.setText("");
            loadDataLaporan();
        });

        btnCetak.addActionListener(e -> cetakLaporan());
        btnKembali.addActionListener(e -> dispose());

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void loadDataLaporan() {
        List<Buku> daftarBuku = bukuController.getAllBuku();
        tampilkanDataKeTabel(daftarBuku);
    }

    private void cariDataLaporan() {
        String keyword = txtCari.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan kata kunci pencarian.");
            return;
        }

        List<Buku> hasilCari = bukuController.cariBuku(keyword);
        tampilkanDataKeTabel(hasilCari);

        if (hasilCari.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data buku tidak ditemukan.");
        }
    }

    private void tampilkanDataKeTabel(List<Buku> daftarBuku) {
        tableModel.setRowCount(0);

        int nomor = 1;

        for (Buku buku : daftarBuku) {
            tableModel.addRow(new Object[]{
                nomor++,
                buku.getKodeBuku(),
                buku.getJudul(),
                buku.getPenulis(),
                buku.getPenerbit(),
                buku.getTahunTerbit(),
                buku.getKategori(),
                buku.getStok(),
                buku.getLokasiRak()
            });
        }

        lblTotalData.setText("Total data: " + daftarBuku.size() + " | Klik header tabel untuk mengurutkan data");
    }

    private void cetakLaporan() {
        try {
            boolean selesai = tableLaporan.print(
                    JTable.PrintMode.FIT_WIDTH,
                    new java.text.MessageFormat("Laporan Data Buku Perpustakaan"),
                    new java.text.MessageFormat("Azay Agustian - 231011402845")
            );

            if (selesai) {
                JOptionPane.showMessageDialog(this, "Laporan berhasil dicetak.");
            } else {
                JOptionPane.showMessageDialog(this, "Proses cetak dibatalkan.");
            }

        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + e.getMessage());
        }
    }
}
