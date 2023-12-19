package com.thg.XmasBonus;

import com.thg.Employees.Accelerator;
import com.thg.Employees.HeadOfEngineering;
import com.thg.Employees.Manager;
import com.thg.Employees.SoftwareEngineer;

public interface XmasBonusVisitor {
    void visitAccelerator(Accelerator accelerator);
    void visitSoftwareEngineer(SoftwareEngineer softwareEngineer);
    void visitManager(Manager manager);
    void visitHeadOfEngineering(HeadOfEngineering headOfEngineering);
}
