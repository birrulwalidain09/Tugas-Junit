package com.example.androidunittest_birrulwalidain

/**
 * Kelas Kotlin bernama PasswordUnit yang berisi sebuah fungsi untuk validasi password.
 */

class PasswordUnit {

    /**
     * Fungsi validatePassword memeriksa apakah password yang diberikan benar atau tidak. 
     * Pemeriksaan meliputi apakah password yang diberiakn kosong, kurang dari 6 karakter, atau lebih dari 15 karakter.
     * Fungsi ini mengembalikan pesan yang sesuai berdasarkan hasil validasi tersebut.
     */
    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password adalah bidang yang wajib diisi"
        }
        input.length < 6 -> {
            "Panjang password harus lebih dari 6 karakter"
        }
        input.length > 15 -> {
            "Panjang password harus kurang dari 15 karakter"
        }
        else -> {
            "Valid"
        }
    }
}
