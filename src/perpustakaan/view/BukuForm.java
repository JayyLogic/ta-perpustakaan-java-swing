package perpustakaan.view;

import perpustakaan.controller.BukuController;
import perpustakaan.model.Buku;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Form untuk mengelola data buku perpustakaan.
 *
 * @author Azay Agustian
 */
public class BukuForm extends JFrame {

    private JTextField txtKodeBuku;
    private JTextField txtJudul;
    private JTextField txtPenulis;
    private JTextField txtPenerbit;
    private JTextField txtTahunTerbit;
    private JTextField txtKategori;
    private JTextField txtStok;
    private JTextField txtLokasiRak;
    private JTextField txtCari;

    private JTable tableBuku;
    private DefaultTableModel tableModel;

    private final BukuController bukuController = new BukuController();
    private int selectedIdBuku = -1;

    public BukuForm() {
        AppTheme.setupLookAndFeel();
        initComponents();
        loadDataBuku();
    }

    private void initComponents() {
        setTitle("Kelola Data Buku - Aplikasi Perpustakaan");
        setSize(1220, 680);
        setMinimumSize(new Dimension(1180, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);

        JPanel background = new JPanel(new BorderLayout(14, 14));
        background.setBackground(AppTheme.BACKGROUND);
        background.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel lblJudul = AppTheme.createTitle("Kelola Data Buku Perpustakaan");
        JLabel lblSubjudul = AppTheme.createSubtitle("Tambah, ubah, hapus, cari, dan urutkan data buku");

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 4, 4));
        headerPanel.setBackground(AppTheme.BACKGROUND);
        headerPanel.add(lblJudul);
        headerPanel.add(lblSubjudul);

        JPanel formPanel = AppTheme.createCardPanel();
        formPanel.setLayout(new GridBagLayout());

        txtKodeBuku = new JTextField();
        txtJudul = new JTextField();
        txtPenulis = new JTextField();
        txtPenerbit = new JTextField();
        txtTahunTerbit = new JTextField();
        txtKategori = new JTextField();
        txtStok = new JTextField();
        txtLokasiRak = new JTextField();

        AppTheme.styleTextField(txtKodeBuku);
        AppTheme.styleTextField(txtJudul);
        AppTheme.styleTextField(txtPenulis);
        AppTheme.styleTextField(txtPenerbit);
        AppTheme.styleTextField(txtTahunTerbit);
        AppTheme.styleTextField(txtKategori);
        AppTheme.styleTextField(txtStok);
        AppTheme.styleTextField(txtLokasiRak);

        addFormRow(formPanel, 0, "Kode Buku", txtKodeBuku);
        addFormRow(formPanel, 1, "Judul", txtJudul);
        addFormRow(formPanel, 2, "Penulis", txtPenulis);
        addFormRow(formPanel, 3, "Penerbit", txtPenerbit);
        addFormRow(formPanel, 4, "Tahun Terbit", txtTahunTerbit);
        addFormRow(formPanel, 5, "Kategori", txtKategori);
        addFormRow(formPanel, 6, "Stok", txtStok);
        addFormRow(formPanel, 7, "Lokasi Rak", txtLokasiRak);

        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setBackground(AppTheme.BACKGROUND);
        leftPanel.setPreferredSize(new Dimension(360, 0));
        leftPanel.add(formPanel, BorderLayout.CENTER);

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnBersihkan = new JButton("Bersihkan");
        JButton btnKembali = new JButton("Kembali");

        AppTheme.stylePrimaryButton(btnTambah);
        AppTheme.styleSecondaryButton(btnUbah);
        AppTheme.styleDangerButton(btnHapus);
        AppTheme.styleSecondaryButton(btnBersihkan);
        AppTheme.styleDangerButton(btnKembali);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBackground(AppTheme.BACKGROUND);
        buttonPanel.add(btnTambah);
        buttonPanel.add(btnUbah);
        buttonPanel.add(btnHapus);
        buttonPanel.add(btnBersihkan);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(btnKembali);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        txtCari = new JTextField();
        AppTheme.styleTextField(txtCari);

        JButton btnCari = new JButton("Cari");
        JButton btnTampilSemua = new JButton("Tampil Semua");

        AppTheme.stylePrimaryButton(btnCari);
        AppTheme.styleSecondaryButton(btnTampilSemua);

        JPanel searchButtonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        searchButtonPanel.setBackground(AppTheme.BACKGROUND);
        searchButtonPanel.add(btnCari);
        searchButtonPanel.add(btnTampilSemua);

        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBackground(AppTheme.BACKGROUND);
        searchPanel.add(txtCari, BorderLayout.CENTER);
        searchPanel.add(searchButtonPanel, BorderLayout.EAST);

        tableModel = new DefaultTableModel(
                new Object[]{"ID", "Kode", "Judul", "Penulis", "Penerbit", "Tahun", "Kategori", "Stok", "Rak"},
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

        tableBuku = new JTable(tableModel);
        tableBuku.setFont(AppTheme.NORMAL_FONT);
        tableBuku.setRowHeight(27);
        tableBuku.getTableHeader().setFont(AppTheme.LABEL_FONT);
        tableBuku.getTableHeader().setBackground(AppTheme.PRIMARY);
        tableBuku.getTableHeader().setForeground(Color.WHITE);
        tableBuku.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableBuku.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableBuku.setAutoCreateRowSorter(true);

        tableBuku.getColumnModel().getColumn(0).setPreferredWidth(45);
        tableBuku.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableBuku.getColumnModel().getColumn(2).setPreferredWidth(230);
        tableBuku.getColumnModel().getColumn(3).setPreferredWidth(140);
        tableBuku.getColumnModel().getColumn(4).setPreferredWidth(140);
        tableBuku.getColumnModel().getColumn(5).setPreferredWidth(70);
        tableBuku.getColumnModel().getColumn(6).setPreferredWidth(130);
        tableBuku.getColumnModel().getColumn(7).setPreferredWidth(60);
        tableBuku.getColumnModel().getColumn(8).setPreferredWidth(80);

        JScrollPane scrollPaneTabel = new JScrollPane(tableBuku);

        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBackground(AppTheme.BACKGROUND);
        rightPanel.add(searchPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPaneTabel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel(new BorderLayout(16, 16));
        contentPanel.setBackground(AppTheme.BACKGROUND);
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(rightPanel, BorderLayout.CENTER);

        JLabel lblFooter = new JLabel(
                "Klik header tabel untuk mengurutkan data | Azay Agustian - 231011402845",
                SwingConstants.CENTER
        );
        lblFooter.setFont(AppTheme.NORMAL_FONT);
        lblFooter.setForeground(AppTheme.ACCENT);

        background.add(headerPanel, BorderLayout.NORTH);
        background.add(contentPanel, BorderLayout.CENTER);
        background.add(lblFooter, BorderLayout.SOUTH);

        add(background);

        btnTambah.addActionListener(e -> tambahBuku());
        btnUbah.addActionListener(e -> ubahBuku());
        btnHapus.addActionListener(e -> hapusBuku());
        btnBersihkan.addActionListener(e -> bersihkanForm());
        btnCari.addActionListener(e -> cariBuku());
        btnTampilSemua.addActionListener(e -> loadDataBuku());
        btnKembali.addActionListener(e -> dispose());

        tableBuku.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                isiFormDariTabel();
            }
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void addFormRow(JPanel panel, int row, String labelText, JTextField field) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 4, 6, 4);
        gbc.gridy = row;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel(labelText);
        AppTheme.styleLabel(label);

        gbc.gridx = 0;
        gbc.weightx = 0.35;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.65;
        panel.add(field, gbc);
    }

    private void loadDataBuku() {
        List<Buku> daftarBuku = bukuController.getAllBuku();
        tampilkanDataKeTabel(daftarBuku);
    }

    private void tampilkanDataKeTabel(List<Buku> daftarBuku) {
        tableModel.setRowCount(0);

        for (Buku buku : daftarBuku) {
            tableModel.addRow(new Object[]{
                buku.getIdBuku(),
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
    }

    private void tambahBuku() {
        if (!validasiInput()) {
            return;
        }

        Buku buku = ambilDataDariForm();

        if (bukuController.tambahBuku(buku)) {
            JOptionPane.showMessageDialog(this, "Data buku berhasil ditambahkan.");
            loadDataBuku();
            bersihkanForm();
        } else {
            JOptionPane.showMessageDialog(this, "Data buku gagal ditambahkan. Pastikan kode buku belum digunakan.");
        }
    }

    private void ubahBuku() {
        if (selectedIdBuku == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data buku yang ingin diubah dari tabel.");
            return;
        }

        if (!validasiInput()) {
            return;
        }

        Buku buku = ambilDataDariForm();
        buku.setIdBuku(selectedIdBuku);

        if (bukuController.ubahBuku(buku)) {
            JOptionPane.showMessageDialog(this, "Data buku berhasil diubah.");
            loadDataBuku();
            bersihkanForm();
        } else {
            JOptionPane.showMessageDialog(this, "Data buku gagal diubah.");
        }
    }

    private void hapusBuku() {
        if (selectedIdBuku == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data buku yang ingin dihapus dari tabel.");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin menghapus data buku ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi == JOptionPane.YES_OPTION) {
            if (bukuController.hapusBuku(selectedIdBuku)) {
                JOptionPane.showMessageDialog(this, "Data buku berhasil dihapus.");
                loadDataBuku();
                bersihkanForm();
            } else {
                JOptionPane.showMessageDialog(this, "Data buku gagal dihapus.");
            }
        }
    }

    private void cariBuku() {
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

    private void isiFormDariTabel() {
        int selectedRow = tableBuku.getSelectedRow();

        if (selectedRow >= 0) {
            int modelRow = tableBuku.convertRowIndexToModel(selectedRow);

            selectedIdBuku = Integer.parseInt(tableModel.getValueAt(modelRow, 0).toString());

            txtKodeBuku.setText(tableModel.getValueAt(modelRow, 1).toString());
            txtJudul.setText(tableModel.getValueAt(modelRow, 2).toString());
            txtPenulis.setText(tableModel.getValueAt(modelRow, 3).toString());
            txtPenerbit.setText(tableModel.getValueAt(modelRow, 4).toString());
            txtTahunTerbit.setText(tableModel.getValueAt(modelRow, 5).toString());
            txtKategori.setText(tableModel.getValueAt(modelRow, 6).toString());
            txtStok.setText(tableModel.getValueAt(modelRow, 7).toString());
            txtLokasiRak.setText(tableModel.getValueAt(modelRow, 8).toString());

            txtKodeBuku.setCaretPosition(0);
            txtJudul.setCaretPosition(0);
            txtPenulis.setCaretPosition(0);
            txtPenerbit.setCaretPosition(0);
            txtTahunTerbit.setCaretPosition(0);
            txtKategori.setCaretPosition(0);
            txtStok.setCaretPosition(0);
            txtLokasiRak.setCaretPosition(0);
        }
    }

    private Buku ambilDataDariForm() {
        Buku buku = new Buku();

        buku.setKodeBuku(txtKodeBuku.getText().trim());
        buku.setJudul(txtJudul.getText().trim());
        buku.setPenulis(txtPenulis.getText().trim());
        buku.setPenerbit(txtPenerbit.getText().trim());
        buku.setTahunTerbit(Integer.parseInt(txtTahunTerbit.getText().trim()));
        buku.setKategori(txtKategori.getText().trim());
        buku.setStok(Integer.parseInt(txtStok.getText().trim()));
        buku.setLokasiRak(txtLokasiRak.getText().trim());

        return buku;
    }

    private boolean validasiInput() {
        if (txtKodeBuku.getText().trim().isEmpty()
                || txtJudul.getText().trim().isEmpty()
                || txtPenulis.getText().trim().isEmpty()
                || txtPenerbit.getText().trim().isEmpty()
                || txtTahunTerbit.getText().trim().isEmpty()
                || txtKategori.getText().trim().isEmpty()
                || txtStok.getText().trim().isEmpty()
                || txtLokasiRak.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Semua field wajib diisi.");
            return false;
        }

        try {
            int tahun = Integer.parseInt(txtTahunTerbit.getText().trim());
            if (tahun < 1900 || tahun > 2100) {
                JOptionPane.showMessageDialog(this, "Tahun terbit harus berada antara 1900 sampai 2100.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tahun terbit harus berupa angka.");
            return false;
        }

        try {
            int stok = Integer.parseInt(txtStok.getText().trim());
            if (stok < 0) {
                JOptionPane.showMessageDialog(this, "Stok tidak boleh kurang dari 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Stok harus berupa angka.");
            return false;
        }

        return true;
    }

    private void bersihkanForm() {
        selectedIdBuku = -1;

        txtKodeBuku.setText("");
        txtJudul.setText("");
        txtPenulis.setText("");
        txtPenerbit.setText("");
        txtTahunTerbit.setText("");
        txtKategori.setText("");
        txtStok.setText("");
        txtLokasiRak.setText("");
        txtCari.setText("");

        tableBuku.clearSelection();
        txtKodeBuku.requestFocus();
    }
}
