package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class Accelerator implements Employee{
    public String getTitle(){
        return "Accelerator!";
    }

    @Override
    public void accept(XmasBonusVisitor v) {
        v.visitAccelerator(this);
    }
}
