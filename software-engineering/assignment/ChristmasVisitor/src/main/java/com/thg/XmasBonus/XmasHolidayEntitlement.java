package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public class XmasHolidayEntitlement implements XmasBonusVisitor {
    @Override
    public void visitAccelerator(Accelerator accelerator) {
        System.out.println("You are not entitled to any Christmas Holiday");
    }

    @Override
    public void visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        System.out.println("You are entitled to 5 days off");
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("You are entitled to 10 days off");
    }

    @Override
    public void visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
        System.out.println("You are not entitled to 365 days off");
    }
}
