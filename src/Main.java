import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<Sample> sampleClassObject = Sample.class;

        Method[] declaredMethods = sampleClassObject.getDeclaredMethods();
        Method[] allMethods = sampleClassObject.getMethods();

        for (Method m: declaredMethods) {
            System.out.println("Declared Methods: " + m.toString());
        }

        System.out.println("-------------------------------------");

        for (Method m: allMethods) {
            System.out.println("All Methods: " + m.toString());
        }
    }
}

class Sample {
    public void voidMethod(String message) {
    }

    public int intReturnMethod() {
        return 100;
    }

    private void privateMethod() {
    }

    protected void protectedMethod() {
    }
}