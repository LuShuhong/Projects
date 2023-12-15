package com.thg.shuhong.witcherFinder.test;
import com.thg.shuhong.witcherFinder.WitcherFinder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    WitcherFinder wf = new WitcherFinder();

    @Test
    void numberAddsUpTo10_returnTrue(){
        boolean result = wf.findingWitcher("thg!geralt!1234");
        assertTrue(result);
    }


}
