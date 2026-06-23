package perpustakaan.dao;

import perpustakaan.model.Buku;
import java.util.List;

/**
 * Class untuk mengetes proses ambil dan cari data buku.
 *
 * @author Azay Agustian
 */
public class TestBukuDAO {

    public static void main(String[] args) {
        BukuDAO bukuDAO = new BukuDAO();

        System.out.println("=== DATA SELURUH BUKU ===");
        List<Buku> daftarBuku = bukuDAO.getAllBuku();

        for (Buku buku : daftarBuku) {
            System.out.println(
                    buku.getKodeBuku() + " | "
                    + buku.getJudul() + " | "
                    + buku.getPenulis() + " | "
                    + buku.getKategori() + " | Stok: "
                    + buku.getStok()
            );
        }

        System.out.println();
        System.out.println("=== HASIL PENCARIAN: Java ===");

        List<Buku> hasilCari = bukuDAO.cariBuku("Java");

        for (Buku buku : hasilCari) {
            System.out.println(
                    buku.getKodeBuku() + " | "
                    + buku.getJudul() + " | "
                    + buku.getPenulis()
            );
        }
    }
}