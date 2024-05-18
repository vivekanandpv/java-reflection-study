import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Class<Sample> sampleClassObject = Sample.class;

        //  this method returns the public fields of the class
        //  and of all its superclasses and superinterfaces.
        Field[] publicFields = sampleClassObject.getFields();

        for(Field f: publicFields) {
            System.out.println("Public fields: " + f);
            System.out.println("\t>> Modifier:\t" + Modifier.toString(f.getModifiers()));
        }

        System.out.println("--------------------------");

        //  all the fields declared by the class or interface
        //  represented by this Class object.
        //  This includes public, protected, default (package) access,
        //  and private fields, but excludes inherited fields.
        Field[] allFields = sampleClassObject.getDeclaredFields();

        for(Field f: allFields) {
            System.out.println("All fields: " + f);
            System.out.println("\t>> Modifier:\t" + Modifier.toString(f.getModifiers()));
        }
    }
}

class Demo {
    public double price = 0.0;
    private int pages = 100;
    protected String message = "Hi there!";
}

class Sample extends Demo {
    public LocalDateTime now = LocalDateTime.now();
    private String sampleTitle = "Title";
    protected String secret = "Universe";
    public static final double PI = 3.14159265359;
}