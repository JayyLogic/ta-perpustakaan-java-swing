package perpustakaan.model;

/**
 * Model untuk menyimpan data buku perpustakaan.
 *
 * @author Azay Agustian
 */
public class Buku {

    private int idBuku;
    private String kodeBuku;
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahunTerbit;
    private String kategori;
    private int stok;
    private String lokasiRak;

    public Buku() {
    }

    public Buku(int idBuku, String kodeBuku, String judul, String penulis, String penerbit,
                int tahunTerbit, String kategori, int stok, String lokasiRak) {
        this.idBuku = idBuku;
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.stok = stok;
        this.lokasiRak = lokasiRak;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }
}