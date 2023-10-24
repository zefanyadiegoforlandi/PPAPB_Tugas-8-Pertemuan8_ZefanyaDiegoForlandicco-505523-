package com.example.mobile_p8_actionbar.tugas // Deklarasi paket

import android.content.Context // Impor kelas Context
import android.content.Intent // Impor kelas Intent
import android.os.Bundle // Impor kelas Bundle
import androidx.fragment.app.Fragment // Impor kelas Fragment
import android.view.LayoutInflater // Impor kelas LayoutInflater
import android.view.View // Impor kelas View
import android.view.ViewGroup // Impor kelas ViewGroup
import android.widget.Toast // Impor kelas Toast
import com.example.mobile_p8_actionbar.databinding.FragmentRegisterBinding // Impor binding untuk layout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1" // Konstanta untuk parameter 1
private const val ARG_PARAM2 = "param2" // Konstanta untuk parameter 2

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() { // Deklarasi kelas RegisterFragment yang merupakan subkelas dari Fragment

    // TODO: Rename and change types of parameters
    private var param1: String? = null // Properti untuk parameter 1
    private var param2: String? = null // Properti untuk parameter 2

    private lateinit var binding: FragmentRegisterBinding // Properti untuk binding layout

    override fun onCreate(savedInstanceState: Bundle?) { // Memulai metode onCreate
        super.onCreate(savedInstanceState) // Memanggil metode onCreate pada kelas induk

        arguments?.let { // Mengecek apakah terdapat argumen yang dilewatkan ke fragment
            param1 = it.getString(ARG_PARAM1) // Mengambil nilai argumen untuk parameter 1
            param2 = it.getString(ARG_PARAM2) // Mengambil nilai argumen untuk parameter 2
        }
    } // Akhir dari metode onCreate

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Memulai metode onCreateView
        // Inflate the layout for this fragment and initialize the binding
        binding = FragmentRegisterBinding.inflate(inflater, container, false) // Membuat binding layout

        with(binding) { // Memulai blok kode with untuk mengakses elemen layout menggunakan binding
            btRegister.setOnClickListener { // Menangani klik tombol Register
                val enteredUsername = etRegisterUser.text.toString() // Mengambil nilai username yang dimasukkan
                val enteredPassword = etRegisterPassword.text.toString() // Mengambil nilai password yang dimasukkan

                // Validasi dan logika pendaftaran di sini...

                if (etRegisterEmail.text.toString() == "" || etRegisterPassword.text.toString() == "" || etRegisterPhone.text.toString() == "" || etRegisterUser.text.toString() == "") {
                    // Memeriksa apakah ada kolom yang kosong, jika ya, tampilkan pesan
                    Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                } else {
                    // Menyimpan data pendaftaran ke SharedPreferences
                    val sharedPreferences = requireContext().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("username", enteredUsername) // Menyimpan username
                    editor.putString("password", enteredPassword) // Menyimpan password
                    editor.apply()

                    // Pindah ke fragment LoginFragment
                    val authActivity = activity as AuthActivity
                    authActivity.viewPager2.currentItem = 1 // Pindah ke tab Login (index 1)
                }
            }
        }

        return binding.root // Mengembalikan tampilan fragment
    } // Akhir dari metode onCreateView

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = // Metode factory newInstance
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1) // Menetapkan nilai parameter 1
                    putString(ARG_PARAM2, param2) // Menetapkan nilai parameter 2
                }
            }
    }
} // Akhir dari kelas RegisterFragment
