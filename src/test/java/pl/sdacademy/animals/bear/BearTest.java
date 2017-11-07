package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat();

        assertTrue(bear.isAlive());
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow () {
        Bear bear = new BlackBear(1);
        bear.eat();

        assertTrue(new Duration(bear.getLastMealTime(), DateTime.now()).isShorterThan(Duration.standardSeconds(1)));
    }

    @Test
    void bearShouldNotBeAliveIfItHasNotEatenForMoreThan10Days() {
        Bear bear = new BlackBear(1, new TestClock());

        boolean result = bear.isAlive();

        assertTrue(result);
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow () {

        Bear bear = new BlackBear(1);
        bear.eat();

        DateTime result = bear.getLastMealTime();

       assertTrue(new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1)));
    }

          @Test
             void bearShouldNotBeAliveIfItHasNotEatenForMoreThan10Days () {
                Bear bear = new BlackBear(1, new TestClock());

             boolean result = bear.isAlive();

             assertTrue(result == false);
    }

    @Test
    void bearWeightPlus () {
        Bear bear = new BlackBear(6);
        bear.eatWeight(7);

        int result = bear.getWeight();

        assertTrue(result==13);
    }
}




