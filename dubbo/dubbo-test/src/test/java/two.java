public class two {

    private static int num = 100;
    private int num2 = 10;
    private static Three three = new Three();
    private int num4 = 80;
    private static final int num5 = 223;
    Three three2 = new Three();
    public static Three three3 = new Three();

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        two.num = num;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public static Three getThree() {
        return three;
    }

    public static void setThree(Three three) {
        two.three = three;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public static int getNum5() {
        return num5;
    }

    public Three getThree2() {
        return three2;
    }

    public void setThree2(Three three2) {
        this.three2 = three2;
    }

    public static Three getThree3() {
        return three3;
    }

    public static void setThree3(Three three3) {
        two.three3 = three3;
    }

    public static String say(){
        int num3 = num / 0;
        System.out.println(num/0);
        return "yzz";
    }

    public  String say2(){
        int num3 = num / 0;
        System.out.println(num/0);
        return "yzz";
    }


    static {

        System.out.println(getNum());
        setNum(90);
        System.out.println(num);
        System.out.println(getNum());
    }
}
