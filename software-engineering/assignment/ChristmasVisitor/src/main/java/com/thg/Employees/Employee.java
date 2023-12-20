package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public interface Employee<T> {
    String getTitle();
     T accept(XmasBonusVisitor v);
}
