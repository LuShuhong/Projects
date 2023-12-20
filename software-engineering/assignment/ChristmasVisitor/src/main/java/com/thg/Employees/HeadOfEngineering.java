package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class HeadOfEngineering <T> implements Employee<Object> {
    public String getTitle(){
        return "Head of Engineering!";
    }

//    @Override
//    public void accept(XmasBonusVisitor v) {
//        v.visitHeadOfEngineering(this);
//    }
//}

    @Override
    public T accept(XmasBonusVisitor v) {
        return (T) v.visitHeadOfEngineering(this);
    }
}
