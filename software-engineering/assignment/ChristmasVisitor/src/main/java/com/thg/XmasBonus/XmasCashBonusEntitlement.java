package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public class XmasCashBonusEntitlement implements XmasBonusVisitor{
    @Override
    public void visitAccelerator(Accelerator accelerator) {
        System.out.println("You got 0 bonus");;
    }

    @Override
    public void visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        System.out.println("You got £1,000 bonus");;
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("You got £2,000 bonus");;
    }

    @Override
    public void visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
        System.out.println("You got £20,000 bonus");;
    }
}
