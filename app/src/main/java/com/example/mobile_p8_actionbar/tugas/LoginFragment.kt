package com.example.mobile_p8_actionbar.tugas // Deklarasi paket

import android.content.Context // Impor kelas Context
import android.content.Intent // Impor kelas Intent
import android.os.Bundle // Impor kelas Bundle
import androidx.fragment.app.Fragment // Impor kelas Fragment
import android.view.LayoutInflater // Impor kelas LayoutInflater
import android.view.View // Impor kelas View
import android.view.ViewGroup // Impor kelas ViewGroup
import android.widget.Toast // Impor kelas Toast
import com.example.mobile_p8_actionbar.R // Impor sumber daya R
import com.example.mobile_p8_actionbar.databinding.FragmentLoginBinding // Impor binding untuk layout
import com.example.mobile_p8_actionbar.databinding.FragmentRegisterBinding // Impor binding untuk layout RegisterFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1" // Deklarasi konstanta dengan nama ARG_PARAM1
private const val ARG_PARAM2 = "param2" // Deklarasi konstanta dengan nama ARG_PARAM2

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() { // Deklarasi kelas LoginFragment yang merupakan subkelas Fragment

    // TODO: Rename and change types of parameters
    private var param1: String? = null // Deklarasi properti param1 dengan tipe data String dan nilai awal null
    private var param2: String? = null // Deklarasi properti param2 dengan tipe data String dan nilai awal null

    private lateinit var binding: FragmentLoginBinding // Deklarasi properti binding yang digunakan untuk mengakses tata letak

    override fun onCreate(savedInstanceState: Bundle?) { // Memulai metode onCreate
        super.onCreate(savedInstanceState) // Memanggil metode onCreate pada kelas induk dan mengirimkan bundle (data sesi)

        arguments?.let { // Memeriksa apakah ada argumen yang dikirimkan ke fragment
            param1 = it.getString(ARG_PARAM1) // Mengambil nilai ARG_PARAM1 dari argumen dan menyimpannya ke properti param1
            param2 = it.getString(ARG_PARAM2) // Mengambil nilai ARG_PARAM2 dari argumen dan menyimpannya ke properti param2
        }
    } // Akhir dari metode onCreate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Memulai metode onCreateView
        // Inflate the layout for this fragment and initialize the binding
        binding = FragmentLoginBinding.inflate(inflater, container, false) // Menghubungkan properti binding dengan layout

        with(binding) { // Memulai blok kode with untuk mengakses elemen layout menggunakan binding
            btLoginLogin.setOnClickListener { // Menambahkan tindakan klik ke tombol btLoginLogin
                val enteredUsername = etLoginUsername.text.toString() // Mengambil teks dari etLoginUsername
                val enteredPassword = etLoginPass.text.toString() // Mengambil teks dari etLoginPass

                // Mendapatkan data pendaftaran dari Shared Preferences
                val sharedPreferences = requireContext().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE) // Mengakses Shared Preferences
                val registeredUsername = sharedPreferences.getString("username", "") // Mengambil data username dari Shared Preferences
                val registeredPassword = sharedPreferences.getString("password", "") // Mengambil data password dari Shared Preferences

                // Memeriksa apakah username dan password sesuai
                if (enteredUsername == registeredUsername && enteredPassword == registeredPassword) {
                    // Username dan password sesuai, izinkan akses ke halaman beranda
                    val intentToHome = Intent(requireContext(), HomePageActivity::class.java) // Membuat intent untuk pindah ke halaman beranda
                    startActivity(intentToHome) // Memulai aktivitas beranda
                } else {
                    // Username atau password salah, tampilkan pesan kesalahan
                    Toast.makeText(requireContext(), "Username or password is incorrect", Toast.LENGTH_SHORT).show() // Menampilkan pesan kesalahan
                }
            }
        }

        return binding.root // Mengembalikan root tata letak sebagai tampilan
    } // Akhir dari metode onCreateView

    companion object { // Memulai blok companion object
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = // Mendefinisikan metode newInstance
            LoginFragment().apply { // Membuat instance baru dari LoginFragment
                arguments = Bundle().apply { // Menginisialisasi Bundle untuk argumen
                    putString(ARG_PARAM1, param1) // Menambahkan nilai ARG_PARAM1 ke Bundle
                    putString(ARG_PARAM2, param2) // Menambahkan nilai ARG_PARAM2 ke Bundle
                }
            }
    } // Akhir dari companion object
} // Akhir dari kelas LoginFragment
