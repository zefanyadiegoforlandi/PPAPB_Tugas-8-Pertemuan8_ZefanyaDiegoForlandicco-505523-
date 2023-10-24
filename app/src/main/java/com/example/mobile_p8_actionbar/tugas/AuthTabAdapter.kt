package com.example.mobile_p8_actionbar.tugas // Deklarasi paket

import androidx.fragment.app.Fragment // Impor kelas Fragment
import androidx.fragment.app.FragmentManager // Impor kelas FragmentManager
import androidx.lifecycle.Lifecycle // Impor kelas Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter // Impor kelas FragmentStateAdapter

class AuthTabAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    val page = arrayOf<Fragment>(RegisterFragment(), LoginFragment()) // Membuat array dari dua fragment: RegisterFragment dan LoginFragment

    override fun getItemCount(): Int {
        return page.size // Mengembalikan jumlah halaman (jumlah fragment dalam array)
    }

    override fun createFragment(position: Int): Fragment {
        return page[position] // Mengembalikan fragment yang sesuai dengan posisi yang diminta oleh ViewPager2
    }
}
