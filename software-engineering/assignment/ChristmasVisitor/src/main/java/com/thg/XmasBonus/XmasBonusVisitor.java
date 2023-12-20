package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public interface XmasBonusVisitor<T> {
    T visitAccelerator(Accelerator accelerator);
    T visitSoftwareEngineer(SoftwareEngineer softwareEngineer);
    T visitManager(Manager manager);
    T visitHeadOfEngineering(HeadOfEngineering headOfEngineering);
}
