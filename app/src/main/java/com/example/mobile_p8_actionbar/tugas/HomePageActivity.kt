package com.example.mobile_p8_actionbar.tugas // Deklarasi paket

import android.graphics.Color // Impor kelas Color
import android.graphics.drawable.ColorDrawable // Impor kelas ColorDrawable
import android.os.Bundle // Impor kelas Bundle
import android.view.Menu // Impor kelas Menu
import android.view.MenuItem // Impor kelas MenuItem
import androidx.appcompat.app.ActionBar // Impor kelas ActionBar
import androidx.appcompat.app.AppCompatActivity // Impor kelas AppCompatActivity
import com.example.mobile_p8_actionbar.R // Impor sumber daya R

class HomePageActivity : AppCompatActivity() { // Deklarasi kelas HomePageActivity yang merupakan subkelas AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) { // Memulai metode onCreate
        super.onCreate(savedInstanceState) // Memanggil metode onCreate pada kelas induk

        setContentView(R.layout.activity_home_page) // Menetapkan tampilan aktivitas dengan layout activity_home_page

        val actionBar = supportActionBar // Mendapatkan ActionBar

        // Set the custom action bar style
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM) // Menampilkan tampilan kustom pada action bar
        actionBar?.setCustomView(R.layout.custom_action_bar) // Menetapkan tampilan kustom dengan layout custom_action_bar

        // Define ColorDrawable object and parse color using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#3c59ff"))
        // Membuat objek ColorDrawable dengan warna yang ditentukan

        // Set BackgroundDrawable
        actionBar?.setBackgroundDrawable(colorDrawable) // Menetapkan latar belakang action bar dengan warna yang telah didefinisikan
    } // Akhir dari metode onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { // Memulai metode onCreateOptionsMenu
        menuInflater.inflate(R.menu.menu_homepage, menu) // Menampilkan menu dari menu_homepage.xml
        return super.onCreateOptionsMenu(menu)
    } // Akhir dari metode onCreateOptionsMenu

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Memulai metode onOptionsItemSelected
        return when (item.itemId) { // Memeriksa item menu yang dipilih
            R.id.action_signout -> { // Jika item "action_signout" dipilih
                finish() // Menutup aktivitas
                true
            }
            else -> true // Untuk item lainnya, kembalikan true
        }
    } // Akhir dari metode onOptionsItemSelected
} // Akhir dari kelas HomePageActivity
