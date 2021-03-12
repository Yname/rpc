import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class One extends Two{


    public One(String name) {
        super(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Map map =null;
        if (map == null){
            System.out.println("null");
        }
        Method method ;
        method.invoke();
        System.out.println(map.isEmpty());
    }
}
