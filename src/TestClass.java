public class TestClass {
    public static void main(String[] args) {


        testStopwatch(3000,10);




    }





    public static void testStopwatch(int TimeToTestInMilliseconds, int marginOfErrorInMilliseconds){

        IStopwatch stopwatch = new Stopwatch();

        stopwatch.setTimeStamp();
        try {
            Thread.sleep(TimeToTestInMilliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double elapsedTime = stopwatch.getElapsedTime();
        int elapsedTimeInMilliseconds = (int)(elapsedTime * 1000);

        boolean testPassed = elapsedTime >= TimeToTestInMilliseconds -marginOfErrorInMilliseconds || elapsedTime <= TimeToTestInMilliseconds +marginOfErrorInMilliseconds;

        if (!testPassed){
            System.out.println("Stopwatch Test Failed | Testing for="+TimeToTestInMilliseconds + "mms Actual="+ elapsedTime + "s Margin of Error="+marginOfErrorInMilliseconds + "mms");
        }

    }




}
