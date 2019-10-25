package utilities;

public class Utils {
    private static final String EXIT_MSG = "Exit signal received.";

    public static void setShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println(EXIT_MSG)
        ));
    }
}
