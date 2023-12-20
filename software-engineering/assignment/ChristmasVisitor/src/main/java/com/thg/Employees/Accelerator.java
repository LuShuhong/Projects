package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class Accelerator <T> implements Employee{
    public String getTitle(){
        return "Accelerator!";
    }

    @Override
    public T accept(XmasBonusVisitor v) {
        return (T) v.visitAccelerator(this);
    }
}
