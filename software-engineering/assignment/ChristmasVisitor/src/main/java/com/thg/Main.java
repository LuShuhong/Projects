package com.thg;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;
import com.thg.XmasBonus.XmasCashBonusEntitlement;
import com.thg.XmasBonus.XmasGift;
import com.thg.XmasBonus.XmasHolidayEntitlement;

public class Main {
    public static void main(String[] args) {
        XmasCashBonusEntitlement xmasCashBonusEntitlement = new XmasCashBonusEntitlement();
        XmasGift xmasGift = new XmasGift();
        XmasHolidayEntitlement xmasHolidayEntitlement= new XmasHolidayEntitlement();

        Accelerator accelerator = new Accelerator();
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        Manager manager = new Manager();
        HeadOfEngineering headOfEngineering = new HeadOfEngineering();

        System.out.println(accelerator.accept(xmasGift));
        System.out.println(softwareEngineer.accept(xmasGift));
        System.out.println(manager.accept(xmasGift));
        System.out.println(headOfEngineering.accept(xmasGift));
//        accelerator.accept(xmasGift);
//        softwareEngineer.accept(xmasGift);
//        manager.accept(xmasGift);
//        headOfEngineering.accept(xmasGift);

    }
}
