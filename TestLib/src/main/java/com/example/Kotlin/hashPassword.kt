package com.example.Kotlin

import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

fun main (args: Array<String>) {
   sum(4,5, {s-> println(s)})
   var temp = "test"
   temp ?.run {
       "slow"
   }.println()

}

fun MutableList<Int>.swap123(item1: Int, item2: Int) {
    var temp = this[item1]
    this[item1] = this[item2]
    this[item2] = temp
}

 fun sum(item1: Int, item2: Int, print: (Int)->Unit) {
     val sum = item1+item2
     print(sum)
 }

val random = SecureRandom()
fun generateSalt(): ByteArray {
    val salt = ByteArray(16)
    random.nextBytes(salt)
    return salt
}

fun generateSaltTest(): ByteArray {
    val salt = ByteArray(16)
    val secure = SecureRandom()
    secure.nextBytes(salt)
    return salt
}

fun isExpectedPassword(password: String, salt: ByteArray, expectedHash: ByteArray): Boolean {
    val pwdHash = hash(password, salt)
    if (pwdHash.size != expectedHash.size) return false
    return pwdHash.indices.all {
        pwdHash[it] == expectedHash[it] }
}

fun hash(password: String, salt: ByteArray): ByteArray {
    val spec = PBEKeySpec(password.toCharArray(), salt, 1000, 256)
    try {
        val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        return skf.generateSecret(spec).encoded
    } catch (e: NoSuchAlgorithmException) {
        throw AssertionError("Error while hashing a password: " + e.message, e)
    } catch (e: InvalidKeySpecException) {
        throw AssertionError("Error while hashing a password: " + e.message, e)
    } finally {
        spec.clearPassword()
    }
}