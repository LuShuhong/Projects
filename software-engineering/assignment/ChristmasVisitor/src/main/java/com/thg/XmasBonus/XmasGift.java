package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public class XmasGift implements XmasBonusVisitor{
    @Override
    public void visitAccelerator(Accelerator accelerator) {
        System.out.println("Your Christmas Gift is James' Chocolate");
    }

    @Override
    public void visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        System.out.println("You can have one accelerator doing your work at Christmas");
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("You can have two accelerators doing your work at Christmas");
    }

    @Override
    public void visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
        System.out.println("You can have 29 accelerators doing your work at Christmas");
    }
}
