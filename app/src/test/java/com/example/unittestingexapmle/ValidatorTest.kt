package com.example.unittestingexapmle

import com.example.unittestingexapmle.Validator.DEFAULT_PASSWORD
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ValidatorTest {

    private lateinit var userRegister: UserRegister

    @Before //Herbir test fonksiyonundan öcne çalışacak..
    fun prepareData() {
        println("Before ")
        userRegister = UserRegister("Ozgur", "12345", "12345")
    }

    @After //Herbir test fonksiyonundan öcne çalışacak.. Before varsa after vardır.. Çalıştı test oldu bu çalıştı.
    //Her bir test için db açıp kapatmamak için before after açmış.. Biz validatoru test edicez
    fun tearDown() {
        println("Before ")
    }

    //2 icon görünür yeşil run test tir
    @Test
    fun test_username_invalid_returns_false() {
        val result = Validator.registerValidator(userRegister.copy(""))
        assertThat(result).isTrue() // beklentin ne. Doğru dönecek..
    }

    @Test
    fun test_password_invalid_returns_false() {
        val result = Validator.registerValidator(userRegister.copy(""))
        assertThat(result).isFalse() // beklentin ne. Yanlış dönecek boş değil ve true döndüü
    }

    @Test
    fun test_userRegister_returns_false() {
        val result = Validator.registerValidator(userRegister)
        assertThat(result).isTrue() // Hepsini test ettik yukarıyı değiştirip
    }

    @Test
    fun test_generateRegisterObject_with_name_return_true() {
        val name = "Ozgur"
        val expected = UserRegister(name, DEFAULT_PASSWORD, DEFAULT_PASSWORD)
        val result = Validator.generateRegisterObject(name)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun test_generateRegisterObject_with_name_return_false() {
        val name = "Kabil"
        val expected = UserRegister(name, DEFAULT_PASSWORD, DEFAULT_PASSWORD)
        val result = Validator.generateRegisterObject(name)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun test_string_null_control_return_true() {
        val name = "null"
        val expected = UserRegister(name, DEFAULT_PASSWORD, DEFAULT_PASSWORD)
        val result = name.isNullOrTextEmpty()
        assertThat(result).isTrue() // bu test edilmiş olacak extension ile
    }

    @Test
    fun test_test_list() {
        val result = Validator.checkPosition(MockData.prepareRcvItemList())
        assertThat(result).isFalse()
    }
}