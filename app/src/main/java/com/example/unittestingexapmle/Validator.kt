package com.example.unittestingexapmle

object Validator {
    private const val PASSWORD_MIN_COUNT = 5
    const val DEFAULT_PASSWORD = "212345"

    /**
     * @param userRegister data class to be validate
     */
    fun registerValidator(userRegister: UserRegister): Boolean {
        userRegister.apply {
            if (userName.isEmpty()) return false
            if (password.isEmpty()) return false
            if (password != confirmedPassword) return false
            if (password.length < PASSWORD_MIN_COUNT) return false
            return true
        }
    }

    fun generateRegisterObject(name: String): UserRegister { //name veriyorsun sana bir nesne oluşturuyor..
        return UserRegister(name, "12345", "12345")
    }

    fun checkPosition(rcvList: ArrayList<RecyclerItem>): Boolean {
        val filteredList = rcvList.filter {
            it.isChecked && it.position % 2 == 0
        }
        return filteredList.isEmpty()
    }
}

//veri tabanından "","null",null gelme ihtimalini test edeceğiz kontrol edeceğiz
fun String.isNullOrTextEmpty(): Boolean {
    return this.isBlank() || this == "null"

}