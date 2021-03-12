public class Two {
    private String name;

    public Two() {
        new One("yuu");
    }

    public Two(String name) {
        this.name = name;
        System.out.println(name);
    }
    public static void print(){
        System.out.println("ajdsfjalddf");
    }
    static {
        print();
    }
}
