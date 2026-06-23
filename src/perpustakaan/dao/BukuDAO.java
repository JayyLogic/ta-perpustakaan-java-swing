package perpustakaan.dao;

import perpustakaan.config.Koneksi;
import perpustakaan.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO untuk mengelola data buku.
 *
 * @author Azay Agustian
 */
public class BukuDAO {

    public List<Buku> getAllBuku() {
        List<Buku> daftarBuku = new ArrayList<>();

        String sql = "SELECT * FROM buku ORDER BY id_buku DESC";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Buku buku = new Buku();
                buku.setIdBuku(rs.getInt("id_buku"));
                buku.setKodeBuku(rs.getString("kode_buku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                buku.setKategori(rs.getString("kategori"));
                buku.setStok(rs.getInt("stok"));
                buku.setLokasiRak(rs.getString("lokasi_rak"));

                daftarBuku.add(buku);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data buku: " + e.getMessage());
        }

        return daftarBuku;
    }

    public boolean tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (kode_buku, judul, penulis, penerbit, tahun_terbit, kategori, stok, lokasi_rak) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getKodeBuku());
            ps.setString(2, buku.getJudul());
            ps.setString(3, buku.getPenulis());
            ps.setString(4, buku.getPenerbit());
            ps.setInt(5, buku.getTahunTerbit());
            ps.setString(6, buku.getKategori());
            ps.setInt(7, buku.getStok());
            ps.setString(8, buku.getLokasiRak());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data buku: " + e.getMessage());
            return false;
        }
    }

    public boolean ubahBuku(Buku buku) {
        String sql = "UPDATE buku SET kode_buku = ?, judul = ?, penulis = ?, penerbit = ?, "
                   + "tahun_terbit = ?, kategori = ?, stok = ?, lokasi_rak = ? WHERE id_buku = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, buku.getKodeBuku());
            ps.setString(2, buku.getJudul());
            ps.setString(3, buku.getPenulis());
            ps.setString(4, buku.getPenerbit());
            ps.setInt(5, buku.getTahunTerbit());
            ps.setString(6, buku.getKategori());
            ps.setInt(7, buku.getStok());
            ps.setString(8, buku.getLokasiRak());
            ps.setInt(9, buku.getIdBuku());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal mengubah data buku: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusBuku(int idBuku) {
        String sql = "DELETE FROM buku WHERE id_buku = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idBuku);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data buku: " + e.getMessage());
            return false;
        }
    }

    public List<Buku> cariBuku(String keyword) {
        List<Buku> daftarBuku = new ArrayList<>();

        String sql = "SELECT * FROM buku "
                   + "WHERE kode_buku LIKE ? OR judul LIKE ? OR penulis LIKE ? OR kategori LIKE ? "
                   + "ORDER BY id_buku DESC";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String cari = "%" + keyword + "%";

            ps.setString(1, cari);
            ps.setString(2, cari);
            ps.setString(3, cari);
            ps.setString(4, cari);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Buku buku = new Buku();
                    buku.setIdBuku(rs.getInt("id_buku"));
                    buku.setKodeBuku(rs.getString("kode_buku"));
                    buku.setJudul(rs.getString("judul"));
                    buku.setPenulis(rs.getString("penulis"));
                    buku.setPenerbit(rs.getString("penerbit"));
                    buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                    buku.setKategori(rs.getString("kategori"));
                    buku.setStok(rs.getInt("stok"));
                    buku.setLokasiRak(rs.getString("lokasi_rak"));

                    daftarBuku.add(buku);
                }
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari data buku: " + e.getMessage());
        }

        return daftarBuku;
    }
}