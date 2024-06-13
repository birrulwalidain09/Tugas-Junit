package com.example.androidunittest_birrulwalidain

/**
 * Kelas User merepresentasikan data pengguna yang memiliki beberapa properti seperti id, name, email, dan phone.
 */
class User {
    var id: Int = 0
    var name: String? = null
    var email: String? = null
    var phone: String? = null
}

/**
 * Antarmuka UserRepository adalah abstraksi untuk mengakses data dari berbagai sumber seperti database atau layanan web.
 */
interface UserRepository {
    fun getUsers(): List<User>
    fun getUserById(id: Int): User?
    fun saveUser(user: User): Boolean
}

/**
 * UserInstrumented adalah kelas yang mengimplementasikan antarmuka UserRepository dengan menggunakan 
 * daftar sederhana sebagai sumber data. Kelas ini memiliki sumber data berupa userList, yaitu daftar 
 * yang dapat diubah yang berisi semua pengguna yang telah disimpan.
 */
class UserInstrumented : UserRepository {

    private val userList = mutableListOf<User>()

    /**
     * Fungsi getUsers() mengembalikan daftar semua pengguna yang tersimpan.
     */
    override fun getUsers(): List<User> {
        return userList
    }

    /**
     * Fungsi getUserById(id: Int) mengembalikan pengguna dengan id yang sesuai atau null jika pengguna tidak ditemukan.
     */
    override fun getUserById(id: Int): User? {
        for (user in userList) {
            if (user.id == id) {
                return user
            }
        }
        return null
    }

    /**
     * Fungsi saveUser(user: User) menyimpan pengguna baru ke sumber data dan mengembalikan true jika operasi berhasil
     * dan false jika pengguna dengan id yang sama sudah ada.
     */
    override fun saveUser(user: User): Boolean {
        for (existingUser in userList) {
            if (existingUser.id == user.id) {
                return false
            }
        }
        userList.add(user)
        return true
    }
}
