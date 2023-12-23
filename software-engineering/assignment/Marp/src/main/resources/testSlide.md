---
marp: true
theme: thg-accelerator
---

# Software Engineering
### Lecture 09 - Unit Testing
Will Wilkes, Winter 2023

---
## Types of Testing

- Unit testing - Testing at the lowest unit level, class or method
- Integration testing - Testing how units interact with one another
- Manual testing - Performed manually by a tester

---
## Advantages of Unit Testing

- Confidence in your code
- Fast feedback, cheap to run and fast to fail
- Making changes is easier - you know if you've broken anything

---
## JUnit 5

- JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage
- JUnit Platform - Foundation for test execution
- JUnit Jupiter - Modern test programming model
- JUnit Vintage - Compatibility layer for older tests

---
## Adding JUnit 5 to your project

```java
dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.6.2")
}
```

---
## Basic Syntax

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTestClass {

    @Test
    void exampleTest() {
        int result = 4 + 6;
        assertEquals(10, result);
    }

}
```

---
## Assertions

All JUnit Jupiter assertions are static methods in the org.junit.jupiter.api.Assertions class. Examples (Optional parameters in []):

- `assertTrue(boolean[, message])` or `assertFalse(boolean[, message])`
- `assertEquals(expected, value[, message])`
- `assertNotNull(presumedNotNullValue)`
- `assertThrows(expectedType, executable)`

Other types of assertion can be added through additional libraries

---
## Parameterised Tests

We can test a method the same way but for many different inputs

```java
@ParameterizedTest(name = "Number is greater than 25 - {0}")
@ValueSource(ints = {50, 75, 100})
public void numberIsGreaterThan25(Integer input) {
    assertTrue(input > 10);
}
```

---
## Life Cycle Annotations

Methods can be called before and after tests to perform additional set up or tear down tasks throught the use of annotations

`@BeforeAll` and `@AfterAll` can be used on static methods that will be called once, before or after execution

`@BeforeEach` and `@AfterEach` can be used on non-static methods called before or after each test

---
## What makes a good Unit Test

- Tests should be independent of other tests
- Should be fast, we will be run hundreds or thousands at a time
- Easy to read, clear and obvious test names
- Test one concept, tests should fail for only one reason, makes any issues easier to track down

---
## Test Driven Development

TDD is a programming practice where tests are written first, before any production code is written

The process is as follows:

- Write a failing test (Red)
- Write the minimum code to make the test pass (Green)
- Improve the existing implementation (Refactor)

---
## Demo

FizzBuzz TDD

- Print numbers from 1 to N
- For multiples of three print "Fizz"
- For multiples of five print "Buzz"
- For multiples of three and five print "FizzBuzz"

---
## Task

Write tests for your Witcher Finder and one other project