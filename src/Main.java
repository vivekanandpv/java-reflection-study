import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Class<Sample> sampleClassObject = Sample.class;

        Method method  = sampleClassObject.getDeclaredMethods()[0];

        System.out.println("Method full name: " + method.toString());
        System.out.println("Method name: " + method.getName());
        System.out.println("Return type: " + method.getReturnType());

        System.out.println("-----------------------------");

        Class<?>[] parameterVector = method.getParameterTypes();
        Class<?>[] exceptionsVector = method.getExceptionTypes();

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
    public LocalDateTime getLocalDate(String message, int number) throws IOException, NullPointerException, SQLException {
        return LocalDateTime.now();
    }
}