package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class SoftwareEngineer <T> implements Employee{
    public String getTitle(){
        return "Software Engineer!";
    }

//    @Override
//    public void accept(XmasBonusVisitor v) {
//        v.visitSoftwareEngineer(this);
//    }
//}

    @Override
    public T accept(XmasBonusVisitor v) {
        return (T) v.visitSoftwareEngineer(this);
    }
}