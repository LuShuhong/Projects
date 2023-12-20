package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

import javax.swing.text.html.Option;
import java.util.Optional;

public class XmasGift implements XmasBonusVisitor<Optional<String>>{
    @Override
    public Optional<String> visitAccelerator(Accelerator accelerator) {
//        System.out.println("Your Christmas Gift is James' Chocolate");
        return Optional.empty();
    }

    @Override
    public Optional<String> visitSoftwareEngineer(SoftwareEngineer softwareEngineer) {
//        System.out.println("You can have one accelerator doing your work at Christmas");
        return Optional.of("You can have one accelerator doing your work at Christmas");
    }

    @Override
    public Optional<String> visitManager(Manager manager) {
//        System.out.println("You can have two accelerators doing your work at Christmas");
        return Optional.of("You can have two accelerator doing your work at Christmas");
    }

    @Override
    public Optional<String> visitHeadOfEngineering(HeadOfEngineering headOfEngineering) {
//        System.out.println("You can have 29 accelerators doing your work at Christmas");
        return Optional.of("Lump of coal");
    }
}


