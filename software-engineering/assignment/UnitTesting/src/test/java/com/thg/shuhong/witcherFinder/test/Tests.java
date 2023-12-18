package com.thg.shuhong.witcherFinder.test;
import com.thg.shuhong.witcherFinder.WitcherFinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    WitcherFinder wf = new WitcherFinder();

    @Test
    void numberAddsUpTo10_returnTrue(){
        boolean result = wf.findingWitcher("thg!geralt!1234");
        assertTrue(result);
    }

    @ParameterizedTest(name = "If number doesn't add up to 10, return false")
    @ValueSource(strings ={"!geralt!124","!geralt1d224","!geralt!124901","1!geralt!124","1!geralt!12w4"})
    public void numbersAddUpTo10(String string){
        assertFalse(wf.findingWitcher(string));
    }



}
