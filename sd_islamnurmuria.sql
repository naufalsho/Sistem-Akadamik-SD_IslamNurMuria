-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Jul 2021 pada 23.08
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sd_islamnurmuria`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absen`
--

CREATE TABLE `absen` (
  `wali_kelas_nip` varchar(30) NOT NULL,
  `kd_kelas` varchar(30) NOT NULL,
  `absen` varchar(30) NOT NULL,
  `tidak_absen` varchar(30) NOT NULL,
  `izin_sakit` varchar(30) NOT NULL,
  `total_siswa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `absen`
--

INSERT INTO `absen` (`wali_kelas_nip`, `kd_kelas`, `absen`, `tidak_absen`, `izin_sakit`, `total_siswa`) VALUES
('00000001', '11', '30', '3', '3', '36'),
('00000002', '12', '20', '13', '13', '46');

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` char(3) NOT NULL,
  `namalengkap` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `namalengkap`, `user`, `password`) VALUES
('001', 'Naufal Sholahuddin', 'admin', 'admin'),
('002', 'wanju', 'wanju', 'wanju');

-- --------------------------------------------------------

--
-- Struktur dari tabel `guru`
--

CREATE TABLE `guru` (
  `nama` varchar(40) NOT NULL,
  `nip` char(18) NOT NULL,
  `email` varchar(40) NOT NULL,
  `no_hp` char(15) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `jenis_kel` varchar(20) NOT NULL,
  `tgl_lahir` varchar(40) NOT NULL,
  `tmp_lahir` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `guru`
--

INSERT INTO `guru` (`nama`, `nip`, `email`, `no_hp`, `alamat`, `jenis_kel`, `tgl_lahir`, `tmp_lahir`) VALUES
('Guru1', '00000001', 'example@gmail.com', '08500000000', 'Jl.Bogor', 'Laki-Laki', '1-januari-1977', 'bogor'),
('Guru2', '00000002', 'example2@gmail.com', '08500000000', 'Jl. Jakarta', 'Perempuan', '2-februari-1977', 'jakarta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelas`
--

CREATE TABLE `kelas` (
  `kd_kelas` varchar(30) NOT NULL,
  `kelas` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kelas`
--

INSERT INTO `kelas` (`kd_kelas`, `kelas`) VALUES
('11', '1A'),
('12', '1B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilai`
--

CREATE TABLE `nilai` (
  `nis` char(18) NOT NULL,
  `kd_kelas` varchar(30) NOT NULL,
  `kd_mapel` varchar(40) NOT NULL,
  `tugas_harian` int(3) NOT NULL,
  `uts` int(3) NOT NULL,
  `uas` int(3) NOT NULL,
  `nilai_akhir` double(4,1) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nilai`
--

INSERT INTO `nilai` (`nis`, `kd_kelas`, `kd_mapel`, `tugas_harian`, `uts`, `uas`, `nilai_akhir`, `keterangan`) VALUES
('124', '12', '99', 80, 30, 40, 80.0, '   Lulus'),
('123', '11', '98', 10, 10, 80, 45.0, 'Remedial'),
('123', '11', '98', 100, 40, 50, 57.0, 'Remedial');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelajaran`
--

CREATE TABLE `pelajaran` (
  `kd_mapel` varchar(40) NOT NULL,
  `mapel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelajaran`
--

INSERT INTO `pelajaran` (`kd_mapel`, `mapel`) VALUES
('98', 'Bahasa inggris'),
('99', 'Bahasa Indonesia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` char(18) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `tmp_lahir` varchar(40) NOT NULL,
  `tgl_lahir` varchar(40) NOT NULL,
  `kelas` varchar(40) NOT NULL,
  `agama` varchar(40) NOT NULL,
  `jenis_kel` varchar(40) NOT NULL,
  `nama_wali` varchar(40) NOT NULL,
  `jenis_kel_wali` varchar(20) NOT NULL,
  `no_telp_wali` char(15) NOT NULL,
  `alamat_wali` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `tmp_lahir`, `tgl_lahir`, `kelas`, `agama`, `jenis_kel`, `nama_wali`, `jenis_kel_wali`, `no_telp_wali`, `alamat_wali`) VALUES
('123', 'wanju', 'bogor', '17', '1', 'kristen', 'Laki-Laki', 'kiki', 'laki laki', '021', 'bogor'),
('124', 'siswa2', 'jakarta', '1-2-2013', '4', 'none', 'Perempuan', 'wali2', 'laki', '085', 'jakarta');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD PRIMARY KEY (`kd_kelas`),
  ADD KEY `wali_kelas_nip` (`wali_kelas_nip`);

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `kelas`
--
ALTER TABLE `kelas`
  ADD KEY `kd_kelas` (`kd_kelas`);

--
-- Indeks untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD KEY `nis` (`nis`),
  ADD KEY `kd_mapel` (`kd_mapel`),
  ADD KEY `kd_kelas` (`kd_kelas`);

--
-- Indeks untuk tabel `pelajaran`
--
ALTER TABLE `pelajaran`
  ADD PRIMARY KEY (`kd_mapel`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD CONSTRAINT `absen_ibfk_1` FOREIGN KEY (`wali_kelas_nip`) REFERENCES `guru` (`nip`);

--
-- Ketidakleluasaan untuk tabel `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `kelas_ibfk_1` FOREIGN KEY (`kd_kelas`) REFERENCES `absen` (`kd_kelas`);

--
-- Ketidakleluasaan untuk tabel `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`nis`) REFERENCES `siswa` (`nis`),
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`kd_mapel`) REFERENCES `pelajaran` (`kd_mapel`),
  ADD CONSTRAINT `nilai_ibfk_3` FOREIGN KEY (`kd_kelas`) REFERENCES `absen` (`kd_kelas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
