package me.whiteship;

import org.junit.Assert;
import org.junit.Test;

public class MoimTest {

    @Test
    public void isFull() {
        //given
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;

        //when //then
        Assert.assertFalse(moim.isEnrollmentFull());
    }
}
