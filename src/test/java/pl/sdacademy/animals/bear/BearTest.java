package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;
import pl.sdacademy.clock.Clock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat();

        boolean result = bear.isAlive();

        assertTrue(result == true);
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




