# Complete the class below so the function check() completes successfully
#  and displays the correct answers
#  See https://en.wikipedia.org/wiki/Rational_number#Arithmetic for
#   how to calculate the different functions
#  Display integers in their simplest form.

from math import gcd

class Rat(object):
    def __init__(self, numerator, denominator):
        d = gcd (numerator, denominator)
        self.num = numerator // d
        self.den = denominator // d
       
    def __str__(self):
        return (f'{self.num} / {self.den}')

    def __add__(self, b): 
        numerator = self.num * b.den + self.den * b.num
        denominator = self.den * b.den
        return Rat(numerator, denominator)
    
    def __sub__(self, b):
        numerator = self.num * b.den - self.den * b.num
        denominator = self.den * b.den
        return Rat(numerator, denominator)

    def __mul__(self,b):
        numerator = self.num * b.num
        denominator = self.den * b.den
        return Rat(numerator, denominator)

    def __truediv__(self,b):
        numerator = self.num * b.den
        denominator = self.den * b.num
        return Rat(numerator, denominator)

    def __eq__(self,b):
        return self.num * b.den == self.den * b.num

    def __gt__(self,b):
        return self.num * b.den > self.den * b.num

    def __le__(self,b):
        return self.num * b.den <= self.den * b.num


def check_demo ():
    a = Rat(1, 2)
    b = Rat(2, 6)
    exprs = ['a', 'b', 'a + b']
    check_exprs(a,b,exprs)

def check():
    a = Rat(1, 2)
    b = Rat(2, 6)
    exprs = ['a', 'b', 'a + b', 'a - b', 'a * b', 'a / b', 'a == b', 'a != b', 'a > b', 'a <= b']
    check_exprs(a,b,exprs)

def check_exprs(a,b, exprs):
    for e in exprs:
        print(f'{e:6} evaluates to {eval(e)}')

check_demo()
check()

