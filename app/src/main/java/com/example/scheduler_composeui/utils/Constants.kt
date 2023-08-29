package com.example.scheduler_composeui.utils

object Constants {

    const val Tag : String ="로그"
}
enum class responseState{
    Okay,
    Fail
}
object API{
    const val baseUrl : String = "http://hch507.dothome.co.kr/"

    const val registerPhp : String ="UserRegister.php"
    const val loginPhp : String ="UserLogin.php"
    const val validatePhp : String="UserValidate.php"
}