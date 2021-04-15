public class TimerTester {
    public static void main(String[] args) {
        Timer t1 = new Timer();

        for (long i = 0; i < 10000000000L; i++){

        }

        t1.stop();

        Timer t2 = new Timer(0);

        t2.stop(93623040);

        System.out.println(t1);
        System.out.println(t2);
    }
}
