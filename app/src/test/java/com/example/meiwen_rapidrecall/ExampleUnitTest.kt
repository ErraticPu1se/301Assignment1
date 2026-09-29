package com.example.meiwen_rapidrecall

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

/** Unit tests for the assignment's non-Android game and repository logic. */
class ExampleUnitTest {
    @Test
    fun generatorReturnsRequestedNumberOfDigits() {
        val sequence = SequenceGenerator(Random(10)).generate(7)

        assertEquals(7, sequence.length)
        assertTrue(sequence.all(Char::isDigit))
    }

    @Test(expected = IllegalArgumentException::class)
    fun generatorRejectsLengthOutsideAssignmentRange() {
        SequenceGenerator().generate(11)
    }

    @Test
    fun repositoryCalculatesSessionSummary() {
        val repository = AttemptRepository()
        repository.addAttempt(
            Attempt(3, "123", "123", true, 1L),
        )
        repository.addAttempt(
            Attempt(4, "0000", "9876", false, 2L),
        )

        assertEquals(2, repository.getTotalAttempts())
        assertEquals(1, repository.getCorrectAttempts())
        assertEquals(50.0, repository.getAccuracy(), 0.001)
        assertTrue(repository.getAttempts().first().isCorrect)
        assertFalse(repository.getAttempts().last().isCorrect)
    }

    @Test
    fun emptyRepositoryHasZeroAccuracy() {
        assertEquals(0.0, AttemptRepository().getAccuracy(), 0.001)
    }
}
