package com.gess.appkotlin.utils

import java.security.MessageDigest
import java.util.*

object Sign {
    fun sign(param: TreeMap<String, String>):String{
        val sb = StringBuffer()
        param.forEach({
            sb.append("${it.key}=${it.value}&")
        })
        if (sb.lastIndexOf("&") == sb.length - 1){
            val ss = sb.substring(0,sb.length - 1)
            println(ss)
        }
        println(sb.lastIndexOf("&"))
        println(sb.length)
        var case = sb.substring(0,sb.length - 1)
        println("okhttp 加密前 = $case")
        val res = md5(case)
        println("okhttp 加密后 = $res")
        return res
    }

    fun md5(str: String): String {
        val digest = MessageDigest.getInstance("MD5")
        val result = digest.digest(str.toByteArray())
        println("result${result.size}")
        return toHex(result)
    }


    fun toHex(byteArray: ByteArray): String {
        val result = with(StringBuilder()) {
            byteArray.forEach {
                val hex = it.toInt() and (0xFF)
                val hexStr = Integer.toHexString(hex)
                if (hexStr.length == 1) {
                    this.append("0").append(hexStr)
                } else {
                    this.append(hexStr)
                }
            }
            this.toString()
        }
        return result
    }
}