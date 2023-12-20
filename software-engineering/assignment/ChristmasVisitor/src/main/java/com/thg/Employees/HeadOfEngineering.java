package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public class HeadOfEngineering implements Employee<Object> {
    public String getTitle(){
        return "Head of Engineering!";
    }

//    @Override
//    public void accept(XmasBonusVisitor v) {
//        v.visitHeadOfEngineering(this);
//    }
//}

    @Override
    public Object accept(XmasBonusVisitor v) {
        return v.visitHeadOfEngineering(this);
    }
}
