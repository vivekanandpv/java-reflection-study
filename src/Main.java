public class Main {
    public static void main(String[] args) {
        //  Instance of Class<T> is the class or interface at runtime
        //  This provides information about a given class or interface,
        //  such as its name, superclass, interfaces, fields, and methods
        Class<Integer> intClassObject = int.class;
        Class<Integer> integerClassObject = Integer.TYPE;    //  of primitive
        Class<Integer> integerWrapperClassObject = Integer.class;    //  of wrapper

        System.out.println(intClassObject.getName());
        System.out.println(integerClassObject.getName());
        System.out.println(integerWrapperClassObject.getName());

        Integer j = 100;
        boolean instance = integerWrapperClassObject.isInstance(j);
        System.out.println(instance);
    }
}