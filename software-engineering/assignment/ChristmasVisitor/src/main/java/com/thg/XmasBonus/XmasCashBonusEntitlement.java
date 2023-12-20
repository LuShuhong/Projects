package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public class XmasCashBonusEntitlement implements XmasBonusVisitor<Integer>{
    @Override
    public Integer visitAccelerator(Accelerator accelerator) {
//        System.out.println("You got 0 bonus");
        return 0;
    }

    @Override
    public Integer visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
//        System.out.println("You got £1,000 bonus");;
        return 1000;
    }

    @Override
    public Integer visitManager(Manager manager) {
//        System.out.println("You got £2,000 bonus");
        return 2000;
    }

    @Override
    public Integer visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
//        System.out.println("You got £20,000 bonus");;
        return 500000;
    }
}
