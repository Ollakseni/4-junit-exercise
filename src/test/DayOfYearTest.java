package refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

/**
 * Write your tests for the DayOfYear.dayOfYear method here. Write each test case
 * in its own method annotated with @Test, for example:
 *
 * @Test
 * void firstDayOfJanuaryIsDayOne() {
 *     assertEquals(1, DayOfYear.dayOfYear(1, 1, 2023));
 * }
 */

public class DayOfYearTest {

    @Test
    void firstDayOfTheYear() {
        assertEquals(1, DayOfYear.dayOfYearFixed(1, 1, 2019));
    }

    @Test
    void numberOfMarchFirst() {
        assertEquals(60, DayOfYear.dayOfYearFixed(3, 1, 2019));
    }

    @Test
    void numberOfLastDayOfFebruary() {
        assertEquals(59, DayOfYear.dayOfYearFixed(2, 28, 2019));
    }

    @Test
    void leapYearFebruary() {
        assertEquals(60, DayOfYear.dayOfYearFixed(2, 29, 2020));
    }

    @Test
    void lastDayOfNonLeapYear() {
        assertEquals(365, DayOfYear.dayOfYearFixed(12, 31, 2019));
    }

    @Test
    void lastDayOfLeapYear() {
        assertEquals(366, DayOfYear.dayOfYearFixed(12, 31, 2020));
    }

    @Test
    void centuryYearsAreLeapYearsOnlyWhenDivisibleBy400() {
        assertEquals(60, DayOfYear.dayOfYearFixed(2, 29, 2000));
        assertEquals(59, DayOfYear.dayOfYearFixed(2, 28, 1900));
    }
    @Test
    void testNonLeapYearFebruary() {
        assertThrows(IllegalArgumentException.class, () -> {
                    DayOfYear.dayOfYearFixed(2, 29, 2019);
        });
    }

}
