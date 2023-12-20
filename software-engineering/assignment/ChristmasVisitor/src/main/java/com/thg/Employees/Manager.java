package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class Manager <T> implements Employee {
    public String getTitle(){
        return "Manager!";
    }

//    @Override
//    public void accept(XmasBonusVisitor v) {
//        v.visitManager(this);
//    }
//}

    @Override
    public T accept(XmasBonusVisitor v) {
        return (T) v.visitManager(this);
    }
}
