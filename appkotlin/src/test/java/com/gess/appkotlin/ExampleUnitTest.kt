package com.gess.appkotlin

import com.gess.appkotlin.utils.Sign
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val time = System.currentTimeMillis() / 1000
//        val time = 1647486975
        val param = TreeMap<String,String>()
        param.put("app_id","be11563dd9")
        param.put("app_secret","ZjA3MjU0Nzk2MjE0YzIyOTYzMGUwN2MxNzcyM2JlYzU0ZGFkMTJjZjEyMDVlNjQ3Y2ZhMGUwOWRiY2YwOWE1Mw==")
        param.put("sign_ver","1.0")
        param.put("timestamp","$time")
        println(time)
        println("sign ---------------------  ${Sign.sign(param)}")
//        println("sign =====================  ${sign().md5("app_id=xxxx&app_secret=xxxxxxxxxx&sign_ver=1.0&timestamp=128097733")}")
    }
}
