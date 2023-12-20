package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class Manager implements Employee {
    public String getTitle(){
        return "Manager!";
    }

//    @Override
//    public void accept(XmasBonusVisitor v) {
//        v.visitManager(this);
//    }
//}

    @Override
    public Object accept(XmasBonusVisitor v) {
        return v.visitManager(this);
    }
}
