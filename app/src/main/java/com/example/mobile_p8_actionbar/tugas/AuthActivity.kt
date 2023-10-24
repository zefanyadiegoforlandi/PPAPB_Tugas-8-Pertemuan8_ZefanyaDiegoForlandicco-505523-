package com.example.mobile_p8_actionbar.tugas // Deklarasi paket

import androidx.appcompat.app.AppCompatActivity // Impor kelas AppCompatActivity
import android.os.Bundle // Impor kelas Bundle
import android.view.Menu // Impor kelas Menu
import androidx.viewpager2.widget.ViewPager2 // Impor kelas ViewPager2
import com.example.mobile_p8_actionbar.R // Impor sumber daya R
import com.example.mobile_p8_actionbar.databinding.ActivityAuthBinding // Impor binding untuk layout
import com.google.android.material.tabs.TabLayoutMediator // Impor kelas TabLayoutMediator

class AuthActivity : AppCompatActivity() { // Deklarasi kelas AuthActivity yang merupakan subkelas AppCompatActivity

    lateinit var mediator: TabLayoutMediator // Deklarasi properti mediator dengan penginisialisasi tertunda
    lateinit var viewPager2: ViewPager2 // Deklarasi properti viewPager2 dengan penginisialisasi tertunda

    override fun onCreate(savedInstanceState: Bundle?) { // Memulai metode onCreate
        val binding = ActivityAuthBinding.inflate(layoutInflater) // Membuat objek binding dari layout

        super.onCreate(savedInstanceState) // Memanggil metode onCreate pada kelas induk

        title = "Dashboard" // Menetapkan judul aktivitas menjadi "Dashboard"

        setContentView(binding.root) // Menetapkan tampilan aktivitas dengan layout yang diikat

        supportActionBar?.hide() // Menyembunyikan action bar (bilah atas)

        with(binding) { // Memulai blok kode with untuk mengakses elemen layout menggunakan binding
            viewPager2 = authViewPager // Menghubungkan properti viewPager2 dengan elemen authViewPager

            authViewPager.adapter = AuthTabAdapter(supportFragmentManager, this@AuthActivity.lifecycle) // Menetapkan adapter untuk authViewPager

            mediator = TabLayoutMediator(authTabLayout, authViewPager) { tab, position ->
                // Fungsi lambda untuk menentukan teks pada setiap tab
                when(position) {
                    0 -> tab.text = "Register" // Tab pertama dengan teks "Register"
                    1 -> tab.text = "Log In" // Tab kedua dengan teks "Log In"
                }
            }

            mediator.attach() // Menghubungkan TabLayout dan ViewPager2 menggunakan mediator
        }
    } // Akhir dari metode onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Memulai metode onCreateOptionsMenu
        menuInflater.inflate(R.menu.menu_option, menu) // Menampilkan menu opsi
        return super.onCreateOptionsMenu(menu)
    } // Akhir dari metode onCreateOptionsMenu
} // Akhir dari kelas AuthActivity
