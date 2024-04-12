

# Modul Pemrograman Mobile: Android Activity

## Tujuan

1. **Pengenalan Activity**: Mahasiswa memahami konsep Activity pada Aplikasi Android.
2. **Implementasi Komponen Activity**: Mahasiswa mampu memahami langkah-langkah pengimplementasian komponen Activity pada aplikasi Android sederhana.

## Teori

Dalam modul ini, kita akan fokus pada komponen dasar dalam pembuatan aplikasi Android yang sederhana. Salah satu komponen penting yang akan dipelajari adalah:

### Activity

Activity merupakan komponen utama yang berinteraksi dengan pengguna dalam sebuah aplikasi Android. Setiap Activity mengelola tampilan yang ditampilkan kepada pengguna dan memiliki daur hidup (life cycle) sendiri yang dimulai dari onCreate hingga onDestroy.


## Praktikum
### Codelab: Membuat Proyek Baru

1. **Buat Proyek Baru**: Buka Android Studio dan buat proyek baru dengan mengikuti langkah-langkah yang tersedia. Pilih jenis Activity yang sesuai dengan kebutuhan proyek Anda.
2. **Pilih Template Activity**: Pada tahap ini, Anda akan memilih jenis Activity awal dari berbagai template yang disediakan oleh Android Studio.
3. **Konfigurasi Proyek**: Masukkan nama aplikasi, package, lokasi proyek, dan target device serta SDK yang akan digunakan. Klik *Finish* untuk menyelesaikan proses pembuatan proyek.

*Penjelasan*: Langkah-langkah ini memandu Anda melalui proses pembuatan proyek baru dan memilih template Activity yang sesuai.

### Codelab: Layouting Tampilan

1. **Buka Layout Activity**: Buka berkas `activity_main.xml` pada workspace Anda.
2. **Ubah Layout**: Ubah layout dasar dari `ConstraintLayout` menjadi `LinearLayout` dan tambahkan elemen-elemen seperti `TextView`, `EditText`, dan `Button`.
3. **Extract String Resource**: Setelah menambahkan elemen-elemen tersebut, ekstrak string-string yang ada pada layout ke dalam berkas `strings.xml`.

*Penjelasan*: Langkah-langkah ini menjelaskan bagaimana melakukan layouting tampilan pada Activity.

### Codelab: Kode Logika pada MainActivity

1. **Tambahkan Variabel**: Tambahkan variabel-variabel yang akan digunakan untuk menampung view seperti `EditText`, `Button`, dan `TextView`.
2. **Inisiasi View**: Inisialisasikan variabel-variabel tersebut dalam metode `onCreate`.
3. **Implementasi OnClickListener**: Implementasikan `OnClickListener` pada Activity untuk menangani klik tombol.
4. **Tambahkan Logika Perhitungan**: Tambahkan logika perhitungan volume dan tampilkan hasilnya pada `TextView`.

*Penjelasan*: Langkah-langkah ini menjelaskan bagaimana menambahkan logika pada Activity untuk melakukan perhitungan volume.

### Codelab: Menangani Perubahan Orientasi

1. **Simpan dan Pulihkan Data**: Implementasikan metode `onSaveInstanceState` untuk menyimpan hasil perhitungan saat terjadi perubahan orientasi.
2. **Pulihkan Data**: Pada metode `onCreate`, pulihkan hasil perhitungan dari `savedInstanceState`.

*Penjelasan*: Langkah-langkah ini menjelaskan bagaimana menangani perubahan orientasi perangkat agar data tidak hilang.
