package com.example.android.gdgfinder.unitTestSandbox

fun fibonacciNumbers(n: Int): MutableList<Int> {
    var fibSequence = makeList()
    if (n == 0) {
        return fibSequence
    } else if (n == 1) {
        fibSequence.add(1)
    } else if (n == 2) {
        fibSequence.add(1)
        fibSequence.add(1)
    } else {
        for (i in 1 until n) {
            if (fibSequence.isNullOrEmpty()) {
                fibSequence.add(i)
                fibSequence.add(i)
            } else {
                fibSequence.add(fibSequence[i - 2]!! + fibSequence[i - 1]!!)
            }
        }
    }
    return fibSequence
}

fun makeList(): MutableList<Int> {
    return mutableListOf()
}
// Returns a list of prime numbers from 1 to n inclusive
fun nPrimes(n: Int): MutableList<Int> {

    var primes = makeList()
    if (n == 0 || n == 1) {
        return primes
    }
    for (i in 1..n) {
        // initializes list
        if (i == 2 && i > 1) {
            primes.add(2)
        } else {
            for (j in 2..i) {
                if (i % j == 0) {
                    break
                } else if (j == i - 1 && i % j != 0) {
                    primes.add(i)
                }
            }
        }
    }
    return primes
}

class mockableMethods {
    fun getData(someParameterName: String): String {
        return someParameterName
    }
    fun doSomething(someParameterName: String): String {
        return "No"
    }
}
