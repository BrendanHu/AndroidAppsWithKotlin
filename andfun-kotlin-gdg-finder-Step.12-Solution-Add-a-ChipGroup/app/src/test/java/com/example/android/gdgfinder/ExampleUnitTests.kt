package com.example.android.gdgfinder

import com.example.android.gdgfinder.unitTestSandbox.fibonacciNumbers
import com.example.android.gdgfinder.unitTestSandbox.makeList
import com.example.android.gdgfinder.unitTestSandbox.mockableMethods
import com.example.android.gdgfinder.unitTestSandbox.nPrimes
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    // Basic addition test
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    // Tests makeList()
    @Test
    fun `Initializes an empty mutable list to store numbers`() {
        assertTrue(makeList().isEmpty() && makeList() is MutableList<Int>)
    }
    // Tests fibonacci number generator
    @Test
    fun `First N Fibonacci numbers`() {
        assertEquals(mutableListOf(1,1), fibonacciNumbers(2))
        assertEquals(mutableListOf(1,1,2), fibonacciNumbers(3))
        assertEquals(mutableListOf(1,1,2,3,5), fibonacciNumbers(5))
        assertEquals(mutableListOf(1,1,2,3,5,8,13,21,34,55), fibonacciNumbers(10))
    }
    // Tests prime number generator
    @Test
    fun primesTest() {
        assertTrue(nPrimes(1).isEmpty())
        assertEquals(mutableListOf(2,3,5), nPrimes(5))
        assertEquals(mutableListOf(2,3,5,7,11,13,17,19), nPrimes(20))
        assertEquals(mutableListOf(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97), nPrimes(100))
    }
    // Basic use of mocks to feed valid inputs to functions without changing any of the
    // actual code.
    @Test
    fun verifiedWithMock() {
        // give the class a mocked subclass with the parameter filled out.
        val service = mockk<mockableMethods>()
        every { service.getData("Expected parameter") } returns "Expected output"
        // assigns result to the return value of getData
        val result = service.getData("Expected parameter")
        // do test
        verify { service.getData("Expected parameter") }  //checks if mock was invoked as expected
        assertEquals("Expected output", result)
    }
}