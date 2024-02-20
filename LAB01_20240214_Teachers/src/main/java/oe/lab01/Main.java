package oe.lab01;

//FIlE->NEW PROJECT. LANGUAGE: JAVA, BUILD SYSTEM: MAVEN
//CTRL + ALT + L : Format document
public class Main {

    //MAIN TAB TAB to autogenerate
    public static void main(String[] args) {

        // 0. Basics
        System.out.println("Hello World");      // SOUT TAB TAB to autogenerate

        //Calculate the Circumference and the area of a circle!
        int radius = 3;
        double circumference = 2 * radius * Math.PI;  //More precise than simply hardcoding "3.14"
        double area = Math.pow(radius, 2) * Math.PI;
        System.out.println(circumference);
        System.out.println(area);

        // 1. String formatting
        //-create formatted string: String.format
        //-write formatted string to console: printf
        // %d is integer, %f is floating point number, %s is text (insert as string), %n is platform-specific new line char.
        System.out.println(String.format("The area of the circle is %s", area));
        System.out.printf("The area of the circle is %s%n", area);                          // full fractional part
        System.out.printf("The area of the circle is %f%n", area);                          // default precision
        System.out.printf("The area of the circle is %.4f%n", area);                        // 4 digits precision
        System.out.printf("The area of the circle is %10.4f%n", area);                      // 10 digits width (total number of digits)
        System.out.printf("The area of a %d radius circle is %.4f%n", radius, area);
        System.out.printf("The area of a %2$d radius circle is %1$.4f%n", area, radius);    // explicit ordering
        System.out.printf("The area of a %2$4d radius circle is %1$.4f%n", area, radius);   // 4 digits width for integer
        System.out.printf("The area of a %2$04d radius %3$9s is%n %1$.4f%n", area, radius, "circle");


        // 2. Concatenate odd numbers from 1 to 9 into a string!

        //String s="";
        StringBuilder sb = new StringBuilder();     //Use StringBuilder because strings are immutable

        // FORI TAB TAB to autogenerate
        for (int i = 1; i < 10; i += 2) {
            //s+=i+" ";
            sb.append(i).append(" ");
        }
        String result = sb.toString();              //Only one string is created, here.
        System.out.println(result);

        //Check if result is correct!

        //This doesn't work here, because == means reference-equality!!!
        //if (result=="1 3 5 7 9 ") System.out.println("Correct!");

        //To compare strings, use equals or equalsIgnoreCase
        if (result.equals("1 3 5 7 9 ")) System.out.println("Correct!");

        //Example for equals, ignoring the case.
        String a = "apple";
        System.out.println("APPle".equalsIgnoreCase(a));


        // 3. String interning
        String first = "This is a string";
        String second = "This is a string";                     //Content is same as "first", so it will be reused.
        String third = new String("This is a string");  		//new keyword will always create a new string.

        System.out.println(first == second ? "1. and 2. are equal by reference." : "1. and 2. are not equal by reference.");    //True
        System.out.println(first.equals(second) ? "1. and 2. are equal by value." : "1. and 2. are not equal by value.");      //True
        System.out.println(first == third ? "1. and 3. are equal by reference." : "1. and 3. are not equal by reference.");     //False
        System.out.println(first.equals(third) ? "1. and 3. are equal by value." : "1. and 3. are not equal by value.");        //True


        // 4. Creating and handling instances
        Circle c1 = new Circle(4);
        Shape shape = new Circle(3);

        System.out.println(c1.getArea());
        System.out.println(shape.getCircumference());
    }
}