package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class SoftwareEngineer implements Employee{
    public String getTitle(){
        return "Software Engineer!";
    }

    @Override
    public void accept(XmasBonusVisitor v) {
        v.visitSoftwareEngineer(this);
    }
}
