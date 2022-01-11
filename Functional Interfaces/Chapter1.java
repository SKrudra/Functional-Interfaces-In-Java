import java.util.Random;

interface I1 {
    void method1();
    String method2(String s);
}

class C1 implements I1 {
    @Override
    public void method1() {
        // noop
    }
    @Override
    public String method2(String s) { return s; }
}

// Java 8: static and default methods 
interface I2 {
    String S = "I2";
    static void method1() {System.out.println(S);}
    
    default String method2(String x) {
        return S + x;
    }
}

class C2 implements I2 {
    @Override
    public String method2(String x) { return x; }
}

class C3 implements I2 {}

class TestI2 {
    public static void main(String[] args) {
        I2.method1();
        I2 objC2 = new C2();
        I2 objC3 = new C3();
        System.out.println(objC2.method2("Hello"));
        System.out.println(objC3.method2("Hello"));
    }
}


// Java 9: private methods
interface I3 {
    private int getNumber() {
        return (new Random()).nextInt(100);
    }

    default String M1(String s) { return s + getNumber(); }
}

class C4 implements I3 {}

class TestI3 {
    public static void main(String[] args) {
        I3 objC4 = new C4();
        System.out.println(objC4.M1("Hello")); 
    }
}

interface I4 {
    private static String getPrefix(String g) {
        return g.equals("male") ? "Mr. " : "Ms. ";
    }
    public static String getName(String name, String gender) {
        return getPrefix(gender) + name;
    }
}

class TestI4 {
    public static void main(String[] args) {
        System.out.println(I4.getName("Smith", "male"));
        System.out.println(I4.getName("Martha", "female"));
    }
}