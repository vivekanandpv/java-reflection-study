import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Book> bookClassObject = Book.class;

        //  get the constructor with a double and string parameters
        //  Watch out for the inner classes. They have a special first parameter.
        //  Using genetic type parameter Book. This avoids cast later
        Constructor<Book> bookConstructor =
                bookClassObject.getConstructor(new Class[]{
                        Double.TYPE,
                        String.class
                });

        //  No cast is required because of generic type parameter we used earlier
        //  Else, cast is required as the instance if of type Object
        Book bookInstance = bookConstructor.newInstance(new Object[]{
                154.25,
                "Learning Java Reflection"
        });

        //  getting the method getPrice
        Method getPriceMethod = bookClassObject.getMethod("getPrice", null);
        double priceValue = (double) getPriceMethod.invoke(bookInstance, null);

        System.out.println(priceValue);

        //  getting the method getNewMessage
        Method getNewMessageMethod = bookClassObject.getMethod("getNewMessage", new Class[]{String.class});
        String newMessageValue = (String) getNewMessageMethod.invoke(bookInstance, "How are you?");

        System.out.println(newMessageValue);
    }
}

class Book {
    private final double price;
    private final String title;

    public Book(double price, String title) {
        this.price = price;
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public String getNewMessage(String baseMessage) {
        return "Modified Message: " + baseMessage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}