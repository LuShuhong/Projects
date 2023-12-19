package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class HeadOfEngineering implements Employee{
    public String getTitle(){
        return "Head of Engineering!";
    }

    @Override
    public void accept(XmasBonusVisitor v) {
        v.visitHeadOfEngineering(this);
    }
}
