# Sistem-Akadamik-SD_IslamNurMuria
Sistem Akademik - Tugas Besar Kuliah, Mata Kuliah Pemrograman Visual - Universitas Indraprasta PGRI

# Screnshoot Aplikasi
<details>
  <summary>Login & SignUp</summary>
  <img src="/../main/Screenshoot/1.jpg" name="login">
  <img src="/../main/Screenshoot/2.jpg" name="login-2">
  <img src="/../main/Screenshoot/3.jpg" name="form Admin/SignUp">
</details>
<details>
  <summary>Menu Utama</summary>
  <img src="/../main/Screenshoot/4.jpg" name="menu-utama1">
  <img src="/../main/Screenshoot/5.jpg" name="menu-utama2">
</details>
<details>
  <summary>Form Input</summary>
  <img src="/../main/Screenshoot/6.jpg" name="Form-Guru">
  <img src="/../main/Screenshoot/7.jpg" name="Form-Absen">
  <img src="/../main/Screenshoot/7-2.jpg" name="Form-Absen2">
  <img src="/../main/Screenshoot/8.jpg" name="Form-Kelas">
  <img src="/../main/Screenshoot/8-2.jpg" name="Form-Kelas2">
  <img src="/../main/Screenshoot/9.jpg" name="Form-MataPelajaran">
  <img src="/../main/Screenshoot/10.jpg" name="Form-Siswa">
  <img src="/../main/Screenshoot/11.jpg" name="Form-Nilai">
  <img src="/../main/Screenshoot/11-2.jpg" name="Form-Nilai2">
</details>
<details>
  <summary>Report/Laporan</summary>
  <img src="/../main/Screenshoot/12.jpg" name="report-Guru">
  <img src="/../main/Screenshoot/13.jpg" name="report-Siswa">
  <img src="/../main/Screenshoot/14.jpg" name="repor-Absen">
  <img src="/../main/Screenshoot/15.jpg" name="report-MataPelajaran">
  <img src="/../main/Screenshoot/16.jpg" name="report-Nilai">
</details>

# Spesifikasi Software Yang Digunakan
* Netbeans IDE 8.0
* JDK 1.8
* XAMPP 7.4.28 (Apache, MysQL, PHP & Perl)
* IReport 5.6.0 (JasperReport Lib Netbeans IDE)

# Manual Book
1. Impor sd_islamnurmuria.sql, ke phpmyadmin.
2. Nyalakan Apache dan MySQL di XAMPP, Buka/Jalankan projek aplikasi
3. *	Login
<br>Login – dengan username dan password = harus sama pada data yang ada di form Admin
4. *	Form Admin
<br>Disinilah data untuk, siapa yang bisa masuk kedalam apps SD_IslamNurMuria, dan juga disini bisa, Membuat baru, Mengedit, dan Menghapus, untuk datanya.
5. *	DashBoard(Menu Utama) / Tampilan Awal(setelah Login)
<br>Terdapat Menu Navigasi Dibagian Kiri, dan Juga isi dashboard mengenai Informasi Sekolah, dan juga ada Tanggal, waktu.
6. *	Form Guru (setelah klik Pada Menu)
  <br>a.	Dipanel dashboard, akan terganti dengan form guru, yang diharapkan, user untuk mengisi data Guru pada Sekolah SD Islam Nur Muria.
  <br>b.  Setelah Disimpan – akan muncul setelelahnya data pada Table dibawahnya.
  <br>c.	Di Form ini, terdapat Simpan, Hapus, Delete, Edit. Yang terhubung dengan Data Database.
  <br>d.	Pada NIP disini, merupakan Primary Key(yang artinya tidak bisa menambahkan dengan data/nilai yang sama yang telah ada di data database).
  <br>e.	Dan NIP ini terhubung pada relasi Form Absen, dimana Form Absen mengambil datanya(nip) dari Form Guru ini.  
7. *	Form Absen
<br>Disini, User Bisa, MengInput(simpan), Edit, Hapus, pada data yang tersedia pada database, Dan juga ada table yang bisa melihat datanya secara langsung dari database. 
  <br>a.	Inputan, pada Wali Kelas NIP, hanya bisa memilih dari NIP, yang tersedia pada data database form Guru, karena form ini terhubung dengan form Guru.
  <br>b.	Kode Kelas disini merupakan Primary Key(tidak bisa diinputkan dengan data yang sama), dan juga Kode Kelas pada Form absen iini Terhubung dengan 
      relasi 2 Form : 1. Form Kelas, 2. Transaksi Nilai.
      <br>Jadinya, Kode Kelas pada form yang Terhubung hanya bisa memilih dari data yang tersedia pada form disini form absen.
8. *	Form Kelas
<br>Ini merupakan, form Kelas(tidak Ada Primary Key), yang terhubung dengan Form Absen pada data Kode Kelas, jadinya hanya memilih Kode Kelas yang tersedia pada data Form absen.
9. *	Form Pelajaran
<br>Form ini, Memiliki Primary Key Kode Pelajaran, yang terhubung pada Transaksi Nilai, jadinya pada Nilai hanya memilih data Kode Pelajaran, hanya yang tersedia pada Form disini. Sedangkan Data Mata Pelajaran, diinputkan secara Manual : contoh Bahasa Indonesia, dsb.
10. *	Form Siswa
<br>NIS Merupakan Primary Key yang terhungung dengan Transaksi Nilai, Jadinya Apa yang DiInputkan NIS pada form ini, di Form Nilai memilih NIS yang Tersedia disini.
11. *	Transaksi Nilai
<br>Form Ini, tidak ada Primary key, tetapi Form Ini terhubung, 3 Form :
  <br>1.	NIS pada Form Siswa
  <br>2.	Kode Kelas pada Form Absen
  <br>3.	Kode Pelajaran pada Form Pelajaran/Mata Pelajaran
<br>Jadinya, Hanya bisa Memilih Data yang tersedia Pada Form Yang Terhubung.
12. *	Proses Perhitungan pada Transaksi Nilai
<br>Aturannya/Rule :
<br>Jadinya Nilai Akhir dan  Keterangan  akan Muncul  Setelah diInput/edit,
<br>Prosesnya : 
<br>Mendapatkan Nilai Akhir = 20%(tugas Harian) x 30%(UTS) x 50%(UAS)
 <br>Keteragan = 
  <br>1.	Kalau Nilai Akhir 0 s/d 44 akan Dinyatakan Tidak Lulus
  <br>2.	Kalau Nilai Akhir 45 s/d 75 Akan dinyatakan Remedial
  <br>3.	Kalai Nilai Akhir 76 s/d 100 Akan Dinyatakan LULUS.
12. Report/Laporan
<br>Merupakan Hasil Keluaran atau Hasil Proses program.


# Dibuat Oleh:
* Naufal Sholahuddin
* Bama Al Farhan N
* Wanju Bonardo A
* Ammar Baghiz F
* Yoga Pramata
* Sakti Nurfadillah
* Akbar Dul Raya
