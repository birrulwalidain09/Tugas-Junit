package com.example.androidunittest_birrulwalidain

import org.junit.Assert.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Class ini berisi unit test untuk kelas UserInstrumented dan implementasinya dalam UserRepository.
 */

class UserInstrumentedTest {

    private lateinit var userInstrumented: UserInstrumented

    @Before
    fun setup() {
        userInstrumented = UserInstrumented()
    }

    /**
     * Metode testGetUsers() memverifikasi bahwa metode getUsers() mengembalikan daftar kosong 
     * ketika tidak ada pengguna yang disimpan di repository.
     */
    @Test
    fun testGetUsers() {
        val users = userInstrumented.getUsers()
        assertEquals(0, users.size)
    }


    /**
     * Metode testSaveUser() memastikan bahwa metode saveUser() berhasil menyimpan pengguna 
     * dan bahwa pengguna yang disimpan dapat diambil dengan benar menggunakan metode getUserById().
     */
    @Test
    fun testSaveUser() {
        val user = User().apply {
            id = 1
            name = "Birrul Walidain"
            email = "birrul200@gmail.com"
            phone = "1234567890"
        }

        /**
         * Objek User baru dibuat, diisi dengan data, dan disimpan menggunakan metode saveUser().
         */
        val result = userInstrumented.saveUser(user)
        assertEquals(true, result)

        /**
         * Objek User yang baru disimpan diambil kembali menggunakan getUserById() dan datanya diverifikasi 
         * untuk memastikan bahwa pengguna telah disimpan dengan benar.
         */
        val savedUser = userInstrumented.getUserById(1)
        assertEquals(user.id, savedUser?.id)
        assertEquals(user.name, savedUser?.name)
        assertEquals(user.email, savedUser?.email)
        assertEquals(user.phone, savedUser?.phone)
    }
}
