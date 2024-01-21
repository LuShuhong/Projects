---
marp: true
theme: thg-accelerator
---

# Software Engineering
### Classes, Fields, Methods & Modifiers

---

## Typing

Java is often defined as a statically-typed language (Python and Javascript in contrast are dynamically-typed languages).

* Dynamically-typed languages do not associate the type of a variable with its slot - this is discovered at runtime
* Statically-typed languages require that each variable has a type defined ahead of time

There is a strong correlation between statically-typed languages and "compiled" languages and between dynamically-typed languages and "scripting" languages.

In the introduction lecture we saw how Java source code is not executed directly, but is instead compiled to a "bytecode" which is then executed.

---

## Primitive types
<style scoped>
{
   font-size: 14pt;
}
</style>
These are the building blocks of every Java application.

| Data Type	| Size	| Description |
| --- | --- | --- |
| byte |	1 byte |	Stores whole numbers from -128 to 127
short |	2 bytes | Stores whole numbers from -32,768 to 32,767
int |	4 bytes |	Stores whole numbers from -2,147,483,648 to 2,147,483,647
long |	8 bytes	| Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float |	4 bytes |	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double |	8 bytes	| Stores fractional numbers. Sufficient for storing 15 decimal digits
boolean |	1 bit |	Stores true or false values
char |	2 bytes	| Stores a single character/letter - Java is unicode aware/compatible

* In Java the numeric primitives are signed (contain a sign bit that indicates positive/negative)
* As memory is finite, we have the concept of a MAX_VALUE

---

## Arrays

* Just as in Python, Java has built-in aggregate types. The `array` type is so frequently used that it has special syntax in the language:

```java
int[] myArrayOfInts = new int[10];

// we can access the array using subscript notation
int first = myArrayOfInts[0];
```
* Unlike Python we cannot slice Java arrays.
* Once an array is created, its length cannot be changed - we'll see another solution for that problem in a different lecture.

---

## Type inference

In statically-typed languages, it's common to see:
```java
String myString = new String("Hello World!");
```

where both the left-hand side of the assignment and the right-hand side _repeat_ the type of the variable (in this example the right-hand side is the constructor).

More modern languages allow for something called "type inference"

```rust
let my_string = "Hello World!";
```

```java
var myString = "Hello World";
```

Here we have an example of type inference using the string "literal", here the type of the variable is inferred from the right-hand-side of the assignment.

---
## Classes

A class serves as a blueprint to create objects, an object is an instance of a class.

An object has two things:
* State (defined by its fields)
* Behaviour (defined by its methods)

---

## Constructors

* Classes in Java have constructors (like Python). As in Python, the constructor is a place where you can place object initialisation code to ensure that the object is fully configured.
* To invoke a constructor we use the `new` keyword

---

## Java code style

* When writing Java programs developers have a certain "style" with respect to variable names etc.
* Class names start with an Uppercase character
* method names start with a lowercase character
* NamesWithMultipleWords are capitalised at wordBoundaries
* `my_string` is a legal identifier like in Python
* Opening `{` appear at the end of the line
* `}`
* appear alone on a separate line
* `} else {` is different 

---

## xcase

* In general with Java we use what's known as `camelCase` to delimit word in identifiers
* In Python we use `snake_case`
* In other languages you may see `kebab-case` (although this is unusual and not common in any THG code)
* What do we use in JavaScript?

---

## A class
```java
class ClassName {
    // fields 
    byte someByte; 
    char someChar; 

    // methods
    void methodName1() {
        // does something
    }

    int method2() {
        // does something else
        return 0;
    }
}
```

---

## Public

You may now be quite used to seeing the word `public` and not knowing what it is doing.

---

## Access Modifiers

| Modifier  | Description                                                 |
|-----------|-------------------------------------------------------------|
| `public`    | The code is accessible for all classes                      |
| `private`   | The code is only accessible within the declared class.      |
| `protected` | The code is accessible in the same package and subclasses.  |
| "default"   | The code is only accessible by classes in the same package. |

* Unlike the other modifiers, default is the normal access modifier _when you don't specify anything else_
* The `default` keyword is actually used in `switch` statements, not as an access modifier

---

```java
class Order {

    /* available outside this class directly */
    public long orderId;
    /* only accessible within this class, an accessor method must be provided for access outside this class */
    private int orderValuePounds;
    private int orderValuePennies;
    private Date orderPlaced;
}
```

---

## Accessors & mutators

* In OOP languages like Java, there is a concept of data-hiding (encapsulation).
* Here the fields are typically hidden and can only be read from or written to (updated) via separate methods
* These are colloquially known as "getters and setters" - more correctly "accessors" and "mutators"
* These methods are _so frequently required_ that your IDE will generate them for you
  * There are other tools and libraries which generate these methods as part of the compilation so they don't even appear as such in the source code!

---

## Java Beans

* One thing you will hear of is a "Java Bean".  This is partially a marketing term that evolved out of the entire Java -> Coffee cup etc branding of the language back in the 90s, however a Java Bean is something you will see:
---

```java
public class Player {

    private String nickname;
    private int chips;

    public Player(String nick, int chips) {
        this.nickname = nick;
        this.chips = chips;
    }

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nn) {
        this.nickname = nn;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int c) {
        this.chips = c;
    }

}
```

---

* This is an example of a class that would be considered a Java Bean - it entirely encapsulates its data and provides accessors/mutators for these encapsulated fields.  Notice that there is no "logic" as such in this example.
* A JavaBean is simply a Java class that follows specific coding conventions.  When these conventions are followed, then certain tools (IDEs etc) can infer certain aspects of the "bean" and display these - this is a legacy concept from the earlier days of Java, however developers still refer to Java Beans in different contexts now (which we will cover later in the course).

---

## Non-access Modifiers

| Modifier  | Description|
|-----------|--------------------------------------------------------------------|
| final     | Attributes and methods cannot be overridden/modified |
| static    | Attributes and methods belongs to the class, rather than an object |
| abstract  | The class cannot be used to create objects.|

---

## Java records

* Over time it has become apparent that using immutable objects (objects that cannot be changed after creation) are a useful tool in managing state within a system.
* In Java this is quite easy to achieve - simply create a bean with a constructor (to instantiate the object correctly), and remove any mutators (`setX` methods)
* This was such a common pattern and a common idiom to apply that the Java language spec was updated to add a `record` [keyword](https://docs.oracle.com/en/java/javase/14/language/records.html#GUID-6699E26F-4A9B-4393-A08B-1E47D4B2D263)
---

* To make the `Player` class above a record we can simply do:
```java
public record Player(String nickname, int chips) { }
```
* This single line provides a facsimile of the `Player` class above (except it removes the `setNickName` and `setChips` methods)
* This is obviously useful when you need an immutable object as it saves effort over creating a bean with the associated methods.
* Records are a feature of Java from version 14+

---

## Main

Now we understand enough to decode the java `main` method:

```java
public static void main(String[] args) {
    // your code here
}
```
* This `main` method has a particular signature as it has certain requirements.
  * We always pass an array of `String`s to this method - this by convention is called `args` (meaning arguments)
  * It's `public` so it can be accessed externally to this package
  * It's `static` as "logically" it should be executed before any objects are created via constructors
  * It looks similar enough to a `main` function in `C` to not scare away C-programmers (this was an actual *goal* of the Java language designers)