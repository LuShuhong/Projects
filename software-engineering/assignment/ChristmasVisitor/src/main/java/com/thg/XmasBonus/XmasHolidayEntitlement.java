package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public class XmasHolidayEntitlement implements XmasBonusVisitor<Integer> {
    @Override
    public Integer visitAccelerator(Accelerator accelerator) {
//        System.out.println("You are not entitled to any Christmas Holiday");
        return 0;
    }

    @Override
    public Integer visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
//        System.out.println("You are entitled to 5 days off");
        return 5;
    }

    @Override
    public Integer visitManager(Manager manager) {
        return 10;
    }

    @Override
    public Integer visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
        return 365;
    }
}
