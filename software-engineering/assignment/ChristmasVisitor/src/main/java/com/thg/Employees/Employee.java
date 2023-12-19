package com.thg.Employees;

import com.thg.XmasBonus.XmasBonusVisitor;

public interface Employee {
    String getTitle();
    void accept(XmasBonusVisitor v);
}
