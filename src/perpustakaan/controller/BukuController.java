package perpustakaan.controller;

import perpustakaan.dao.BukuDAO;
import perpustakaan.model.Buku;

import java.util.List;

/**
 * Controller untuk menghubungkan tampilan dengan proses data buku.
 *
 * @author Azay Agustian
 */
public class BukuController {

    private final BukuDAO bukuDAO;

    public BukuController() {
        this.bukuDAO = new BukuDAO();
    }

    public List<Buku> getAllBuku() {
        return bukuDAO.getAllBuku();
    }

    public boolean tambahBuku(Buku buku) {
        return bukuDAO.tambahBuku(buku);
    }

    public boolean ubahBuku(Buku buku) {
        return bukuDAO.ubahBuku(buku);
    }

    public boolean hapusBuku(int idBuku) {
        return bukuDAO.hapusBuku(idBuku);
    }

    public List<Buku> cariBuku(String keyword) {
        return bukuDAO.cariBuku(keyword);
    }
}
