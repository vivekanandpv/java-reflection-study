import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Class<Sample> sampleClassObject = Sample.class;

        //  https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#getDeclaredConstructors()
        //  NB: This method returns an array of length 0 if this Class object represents an interface, a primitive type, an array class, or void
        Constructor<?>[] allConstructors  = sampleClassObject.getDeclaredConstructors();
        Constructor<?>[] publicConstructors  = sampleClassObject.getConstructors();

        for (Constructor<?> c: publicConstructors) {
            System.out.println("Public Constructors: " + c);
        }

        System.out.println("-------------------------------------");

        for (Constructor<?> c: allConstructors) {
            System.out.println("All Constructors: " + c);
        }

        System.out.println("-------------------------------------");

        //  The elements in the array returned are not sorted and are not in any particular order
        Class<?>[] parameterVector = publicConstructors[0].getParameterTypes();
        Class<?>[] exceptionsVector = publicConstructors[0].getExceptionTypes();

        for (int i = 0; i < parameterVector.length; ++i) {
            System.out.println("Parameter at position: " + i + " >> " + parameterVector[i]);
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < exceptionsVector.length; ++i) {
            System.out.println("Exception at position: " + i + " >> " + exceptionsVector[i]);
        }
    }
}

class Sample {
    public Sample() {
    }

    private Sample(int i) {
    }

    protected Sample(double d) {

    }

    public Sample(int i, LocalDateTime ldt) throws IOException, NullPointerException {
    }

    public Sample(int i, LocalDateTime ldt, String message) throws IOException, NullPointerException {
    }

    public Sample(int i, LocalDateTime ldt, String message, String title) throws IOException, NullPointerException {
    }

    public Sample(int i, LocalDateTime ldt, String message, boolean flag) throws IOException, NullPointerException {
    }
}