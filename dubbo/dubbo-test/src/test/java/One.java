import java.lang.reflect.Field;

public class One {
    public static void main(String[] args) {
        two two = new two();
        System.out.println(two.toString());
        String print1 = two.three3.print();

        System.out.println(print1);
        Field[] fields = two.getClass().getDeclaredFields();
        for (Field field : fields){
            if ("three2".equals(field.getName())){
                String print = two.three2.print();
                System.out.println(print);

            }

            System.out.println(field.getName());
        }

    }
}
