-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Jun 2026 pada 15.16
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpustakaan_231011402845`
--

CREATE DATABASE IF NOT EXISTS `db_perpustakaan_231011402845`
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE `db_perpustakaan_231011402845`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `buku`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(150) NOT NULL,
  `penulis` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `tahun_terbit` int(11) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `lokasi_rak` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `kode_buku`, `judul`, `penulis`, `penerbit`, `tahun_terbit`, `kategori`, `stok`, `lokasi_rak`) VALUES
(1, 'BK001', 'Pemrograman Java Dasar - Azay Agustian 231011402845', 'Azay Agustian', 'UNPAM Press', 2026, 'Pemrograman', 5, 'Rak A1'),
(2, 'BK002', 'Dasar-Dasar Basis Data', 'Andi Nugroho', 'Informatika', 2021, 'Database', 7, 'Rak A2'),
(3, 'BK003', 'Algoritma dan Struktur Data', 'Budi Santoso', 'Elex Media', 2020, 'Algoritma', 4, 'Rak A3'),
(4, 'BK004', 'Pemrograman Berorientasi Objek', 'Rina Kurnia', 'Gramedia', 2022, 'Pemrograman', 6, 'Rak B1'),
(5, 'BK005', 'Sistem Informasi Manajemen', 'Dewi Lestari', 'Salemba Empat', 2019, 'Sistem Informasi', 3, 'Rak B2'),
(6, 'BK006', 'Jaringan Komputer', 'Fajar Pratama', 'Andi Publisher', 2021, 'Jaringan', 8, 'Rak C1'),
(7, 'BK007', 'Rekayasa Perangkat Lunak', 'Agus Saputra', 'Informatika', 2023, 'RPL', 5, 'Rak C2'),
(8, 'BK008', 'Desain Antarmuka Pengguna', 'Nadia Putri', 'Elex Media', 2020, 'UI/UX', 4, 'Rak D1'),
(9, 'BK009', 'Keamanan Sistem Informasi', 'Rizky Maulana', 'Gramedia', 2022, 'Keamanan', 6, 'Rak D2'),
(10, 'BK010', 'Analisis dan Perancangan Sistem', 'Siti Aminah', 'UNPAM Press', 2024, 'Analisis Sistem', 7, 'Rak E1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `nama_lengkap`) VALUES
(1, 'admin', 'admin123', 'Azay Agustian');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`),
  ADD UNIQUE KEY `kode_buku` (`kode_buku`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
