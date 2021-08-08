package helpers;

public class ActionsHelper {

    public static long getRandomInteger() {

        return (long) (Math.random() * 1000);
    }

    public static int getRandomInteger(int range) {

        return (int) (Math.random() * range);
    }

    public static String getRandomText() {
        return "marija-" + getRandomInteger();
    }

    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".rs");
    }

    public static String getRandomEmail() {
        return getRandomText() + "@google.com";
    }

}
