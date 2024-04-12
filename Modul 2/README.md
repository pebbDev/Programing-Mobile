
# Modul Pemrograman Mobile: Android ListView
## A. Tujuan

1. **Mahasiswa mengetahui apa itu Android ListView dan apa saja yang diperlukan untuk dapat membangun aplikasi ListView.**
   
   Android ListView adalah sebuah komponen tampilan (widget) yang digunakan untuk menampilkan data/item dalam bentuk list. ListView menggunakan Adapter untuk menampilkan item. Item ListView sendiri bisa berasal dari array / database. Ada beberapa Adapter yang bisa digunakan pada ListView, di antaranya:
   - ArrayAdapter
   - BaseAdapter
   - CursorAdapter
   - WrapperListAdapter

2. **Mahasiswa mampu memahami tahapan dalam membangun aplikasi Android dengan menggunakan ListView.**
   
   Tahapan dalam membangun aplikasi Android dengan ListView meliputi:
   - Menambahkan obyek ListView di berkas layout xml dari activity / fragment.
   - Mendefinisikan model kelas (POJO) yang akan digunakan sebagai data source.
   - Membuat berkas layout xml untuk baris item di ListView.
   - Membuat sebuah kelas adapter yang inherit ke BaseAdapter.
   - Mendefinisikan obyek ListView dan selanjutnya pasang obyek adapter (binding) agar bisa menampilkan koleksi data ke dalam ListView.

## B. Teori

Android ListView telah digantikan oleh RecyclerView dalam beberapa tahun terakhir. Meskipun demikian, tetap ada manfaat dari mempelajari ListView seperti:
- Mendapatkan wawasan mengapa RecyclerView bekerja sebagaimana mestinya.
- Merasakan ListView dalam kode lawas, dan yang terbaik adalah mengetahui cara bekerjanya.

Langkah-langkah mengimplementasikan ListView sebagai berikut:
1. Tambahkan obyek ListView di berkas layout xml dari activity / fragment.
2. Definisikan model kelas (POJO) yang akan digunakan sebagai data source.
3. Buat berkas layout xml untuk baris item di ListView.
4. Buat sebuah kelas adapter yang inherit ke BaseAdapter.
5. Definisikan obyek ListView dan selanjutnya pasang obyek adapter (binding) agar bisa menampilkan koleksi data ke dalam ListView.

## C. Praktikum

### Codelab ListView

1. **Buat proyek baru di Android Studio dengan kriteria sebagai berikut:**
   - Nama Project: MyListView
   - Target & Minimum Target SDK: Phone and Tablet, Api Level 21
   - Tipe Activity: Empty Activity
   - Activity Name: MainActivity

2. **Buka `activity_main.xml` dan tambahkan komponen ListView lalu sesuaikan kodenya seperti berikut:**

   ```xml
   <ListView
       android:id="@+id/lv_list"
       android:layout_width="match_parent"
       android:layout_height="match_parent"/>
   ```

3. **Buka `MainActivity.java` dan tambahkan kode untuk membuat ListView menggunakan ArrayAdapter:**

   ```java
   public class MainActivity extends AppCompatActivity {
       private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           ListView listView = findViewById(R.id.lv_list);
           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
           listView.setAdapter(adapter);
       }
   }
   ```

4. **Tambahkan kelas `Hero` untuk model data pahlawan:**

   ```java
   class Hero {
       private int photo;
       private String name;
       private String description;
       // tambahkan setter & getter
   }
   ```

5. **Buat berkas `item_hero.xml` untuk tampilan list dengan ImageView dan dua TextView:**

   ```xml
   <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:padding="16dp">

       <ImageView
           android:id="@+id/img_photo"
           android:layout_width="100dp"
           android:layout_height="150dp"
           android:scaleType="fitXY" />

       <TextView
           android:id="@+id/txt_name"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:layout_marginStart="26dp"
           android:layout_toEndOf="@id/img_photo"
           android:text="@string/name_heroes"
           android:textSize="18sp"
           android:textStyle="bold" />

       <TextView
           android:id="@+id/txt_description"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:layout_below="@id/txt_name"
           android:layout_marginStart="26dp"
           android:layout_marginTop="10dp"
           android:layout_toRightOf="@id/img_photo"
           android:ellipsize="end"
           android:maxLines="3"
           android:text="@string/lorem" />

   </RelativeLayout>
   ```

6. **Buat kelas `HeroAdapter` yang merupakan custom adapter yang inherit dari BaseAdapter:**

   ```java
   public class HeroAdapter extends BaseAdapter {
       private final Context context;
       private ArrayList<Hero> heroes;

       // tambahkan konstruktor, setter & getter, dan metode getView
   }
   ```

7. **Buat data pahlawan di dalam strings.xml:**

   ```xml
   <string-array name="data_name">
       <item>Cut Nyak Dien</item>
       <item>Ki Hajar Dewantara</item>
       <item>Moh Yamin</item>
       <item>Patimura</item>
       <item>R A Kartini</item>
       <item>Sukarno</item>
   </string-array>

   <string-array name="data_description">
       <!-- deskripsi untuk masing-masing pahlawan -->
   </string-array>
   ```

8. **Tambahkan kode untuk memasukkan data tersebut ke dalam ListView:**

   ```java
   public class MainActivity extends AppCompatActivity {
       private String[] dataName;
       private String[] dataDescription;
       private TypedArray dataPhoto;
       private HeroAdapter adapter;
       private ArrayList<Hero> heroes;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           adapter = new HeroAdapter(this);
           ListView listView = findViewById(R

.id.lv_list);
           listView.setAdapter(adapter);

           prepare();
           addItem();
       }

       private void addItem() {
           heroes = new ArrayList<>();

           for (int i = 0; i < dataName.length; i++) {
               Hero hero = new Hero();
               hero.setPhoto(dataPhoto.getResourceId(i, -1));
               hero.setName(dataName[i]);
               hero.setDescription(dataDescription[i]);
               heroes.add(hero);
           }

           adapter.setHeroes(heroes);
       }

       private void prepare() {
           dataName = getResources().getStringArray(R.array.data_name);
           dataDescription = getResources().getStringArray(R.array.data_description);
           dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
       }
   }

Link modul : https://drive.google.com/file/d/1ngU27bxyKpSl2WLZMlDQThXxgs0_wOlI/view?usp=sharing
