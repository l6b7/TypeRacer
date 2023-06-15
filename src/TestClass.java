import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {

        testWordList(25, 5);

        testStopwatch(3000, 10);


    }


    public static void testWordList(int totalAmountOfWords, int bundleSize) {
        WordList wordlist = new WordList(totalAmountOfWords, bundleSize);

        ArrayList<String> test = new ArrayList<>();
        while (!wordlist.isEmpty()) {
            wordlist.getBundleOfWords().stream().forEach(x -> System.out.print(x + " "));
            System.out.println();
            wordlist.removeBundleOfWords();
        }

        System.out.println("\n");

        if (totalAmountOfWords % bundleSize != 0) {
            System.out.println("Should return " + (totalAmountOfWords / bundleSize + 1) + " lines ");
            System.out.println(totalAmountOfWords / bundleSize + " lines with " + bundleSize + " words");
            System.out.println("and 1 line with " + totalAmountOfWords % bundleSize + " words");
        } else {
            System.out.println("Should return " + totalAmountOfWords / bundleSize + " lines\n" + bundleSize + " words each");
        }


    }

    public static void testStopwatch(int TimeToTestInMilliseconds, int marginOfErrorInMilliseconds) {

        IStopwatch stopwatch = new Stopwatch();

        stopwatch.setTimeStamp();
        try {
            Thread.sleep(TimeToTestInMilliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double elapsedTime = stopwatch.getElapsedTime();
        int elapsedTimeInMilliseconds = (int) (elapsedTime * 1000);

        boolean testPassed = elapsedTime >= TimeToTestInMilliseconds - marginOfErrorInMilliseconds || elapsedTime <= TimeToTestInMilliseconds + marginOfErrorInMilliseconds;

        if (!testPassed) {
            System.out.println("Stopwatch Test Failed | Testing for=" + TimeToTestInMilliseconds + "mms Actual=" + elapsedTime + "s Margin of Error=" + marginOfErrorInMilliseconds + "mms");
        }

    }


}
