# Aplikasi Manajemen Data Perpustakaan

Project Tugas Akhir Pemrograman 2 berupa aplikasi CRUD berbasis Java Swing dan MySQL untuk mengelola data buku perpustakaan.

## Identitas Mahasiswa

- Nama: Azay Agustian
- NIM: 231011402845
- Kelas: 06TPLE013
- Program Studi: Teknik Informatika
- Universitas: Universitas Pamulang
- Semester: 6 Genap 2025/2026

## Objek / Domain

Perpustakaan, dengan fokus pengelolaan data buku.

## Fitur Aplikasi

- Login pengguna sebelum masuk ke aplikasi.
- Menu utama untuk navigasi fitur.
- CRUD data buku:
  - tambah data buku,
  - lihat data buku dalam tabel,
  - ubah data buku,
  - hapus data buku.
- Pencarian data buku berdasarkan kode, judul, penulis, atau kategori.
- Sorting data melalui header tabel.
- Validasi input pada form buku.
- Laporan data buku dan fitur cetak laporan.
- Struktur project menggunakan pemisahan package model, view, controller, dao, config, dan report.
- Akses database menggunakan JDBC dan PreparedStatement.

## Teknologi yang Digunakan

- Java Swing
- MySQL / MariaDB
- JDBC
- NetBeans IDE
- XAMPP
- Target Java 17

## Struktur Project

```text
TA_Perpustakaan/
|-- database/
|   `-- db_perpustakaan_231011402845.sql
|-- laporan/
|   |-- Laporan_Data_Buku_Perpustakaan.pdf
|   |-- Laporan_Tugas_Akhir_Aplikasi_Perpustakaan_Azay_Agustian.docx
|   `-- Laporan_Tugas_Akhir_Aplikasi_Perpustakaan_Azay_Agustian.pdf
|-- lib/
|   `-- mysql-connector-j-9.7.0.jar
|-- nbproject/
|   |-- build-impl.xml
|   |-- genfiles.properties
|   |-- project.properties
|   `-- project.xml
|-- screenshots/
|   |-- Gambar 1 Halaman Login.png
|   |-- Gambar 2 Menu Utama.png
|   |-- Gambar 3 Form Kelola Data Buku CRUD.png
|   |-- Gambar 4 Form Laporan Data Buku.png
|   |-- Gambar 5 Dialog Cetak Laporan - Tab General.png
|   |-- Gambar 6 Dialog Cetak Laporan - Tab Page Setup.png
|   `-- Gambar 7 Dialog Cetak Laporan - Tab Appearance.png
|-- src/
|   `-- perpustakaan/
|       |-- MainApp.java
|       |-- config/
|       |   |-- Koneksi.java
|       |   `-- TestKoneksi.java
|       |-- controller/
|       |   |-- BukuController.java
|       |   `-- UserController.java
|       |-- dao/
|       |   |-- BukuDAO.java
|       |   |-- TestBukuDAO.java
|       |   |-- TestLogin.java
|       |   `-- UserDAO.java
|       |-- model/
|       |   |-- Buku.java
|       |   `-- User.java
|       |-- report/
|       |   `-- LaporanBukuForm.java
|       `-- view/
|           |-- AppTheme.java
|           |-- BukuForm.java
|           |-- LoginForm.java
|           `-- MenuUtama.java
|-- .gitignore
|-- build.xml
|-- manifest.mf
|-- PANDUAN_GITHUB.md
`-- README.md
```

Catatan: folder `build/`, `dist/`, `tmp/`, `template_laporan/`, `instruksi_tugas/`, dan `nbproject/private/` tidak dimasukkan ke repository karena berisi hasil build, file kerja sementara, template, atau konfigurasi lokal.

## Database

Nama database:

```sql
db_perpustakaan_231011402845
```

File database tersedia di:

```text
database/db_perpustakaan_231011402845.sql
```

Database berisi tabel:

- `users`
- `buku`

Data login default:

```text
Username: admin
Password: admin123
```

## Cara Menjalankan Aplikasi

1. Jalankan XAMPP, lalu aktifkan Apache dan MySQL.
2. Buka phpMyAdmin.
3. Import file SQL:

   ```text
   database/db_perpustakaan_231011402845.sql
   ```

4. Buka project menggunakan NetBeans.
5. Pastikan library `mysql-connector-j-9.7.0.jar` sudah terhubung di project.
6. Jalankan main class:

   ```text
   perpustakaan.MainApp
   ```

7. Login menggunakan akun default:

   ```text
   admin / admin123
   ```

## Konfigurasi Koneksi Database

Konfigurasi koneksi berada di:

```text
src/perpustakaan/config/Koneksi.java
```

Konfigurasi default:

```java
private static final String URL = "jdbc:mysql://localhost:3306/db_perpustakaan_231011402845"
        + "?useSSL=false&serverTimezone=Asia/Jakarta";
private static final String USER = "root";
private static final String PASSWORD = "";
```

Jika MySQL lokal menggunakan password, sesuaikan nilai `PASSWORD`.

## Screenshot Aplikasi

Nama file screenshot disusun sesuai urutan tampilan aplikasi pada laporan.

### Gambar 1 Halaman Login

![Gambar 1 Halaman Login](screenshots/Gambar%201%20Halaman%20Login.png)

### Gambar 2 Menu Utama

![Gambar 2 Menu Utama](screenshots/Gambar%202%20Menu%20Utama.png)

### Gambar 3 Form Kelola Data Buku / CRUD

![Gambar 3 Form Kelola Data Buku CRUD](screenshots/Gambar%203%20Form%20Kelola%20Data%20Buku%20CRUD.png)

Screenshot lengkap tersedia di folder `screenshots/`, yaitu:

- `Gambar 1 Halaman Login.png`
- `Gambar 2 Menu Utama.png`
- `Gambar 3 Form Kelola Data Buku CRUD.png`
- `Gambar 4 Form Laporan Data Buku.png`
- `Gambar 5 Dialog Cetak Laporan - Tab General.png`
- `Gambar 6 Dialog Cetak Laporan - Tab Page Setup.png`
- `Gambar 7 Dialog Cetak Laporan - Tab Appearance.png`

## Laporan

File laporan tugas akhir, laporan data buku aplikasi, dan laporan editable DOCX tersedia di folder:

```text
laporan/
```

Catatan: sebelum submit ke Google Form, buka file DOCX laporan tugas akhir, cek daftar isi/layout, lalu export ke PDF.

## Repository GitHub

Rekomendasi nama repository:

```text
ta-perpustakaan-java-swing
```

Contoh link setelah di-upload:

```text
https://github.com/JayyLogic/ta-perpustakaan-java-swing
```

## Catatan

Folder `build/`, `dist/`, `tmp/`, `template_laporan/`, `instruksi_tugas/`, dan `nbproject/private/` tidak perlu di-upload ke GitHub karena sudah dimasukkan ke `.gitignore`.
