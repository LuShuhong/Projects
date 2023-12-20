package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class Accelerator implements Employee{
    public String getTitle(){
        return "Accelerator!";
    }

    @Override
    public Object accept(XmasBonusVisitor v) {
        return v.visitAccelerator(this);
    }
}
