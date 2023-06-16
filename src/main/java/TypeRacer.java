import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypeRacer {

    private IStopwatch stopwatch;
    private IWordList wordList;
    private int totalAmountOfWords;
    
    public static void main(String[] args) {
        new TypeRacer(23,5).testTypingSpeed();
    }

    public TypeRacer(int totalAmountOfWords, int bundleSize) {
        stopwatch = new Stopwatch();
        wordList = new WordList(totalAmountOfWords, bundleSize);
        this.totalAmountOfWords = totalAmountOfWords;
    }
    
    public void testTypingSpeed(){

        int mistakes = 0;
        int totalCharacters = 0;

        ArrayList<String> wordBundle;
        ArrayList<String> userWordBundle;

        String userInput;

        Scanner scanner = new Scanner(System.in);

        printCountdown();

        stopwatch.setTimeStamp();


        while (!wordList.isEmpty()) {

            wordBundle = wordList.getBundleOfWords();

            wordBundle
                    .stream()
                    .forEach(x -> System.out.print(x + " "));

            userInput = scanner.nextLine();

            userWordBundle = new ArrayList<>(Arrays.asList(userInput.split(" ")));

            for (int i = 0; i < wordBundle.size(); i++){
                // if too few characters in a given word count each there should as a mistake
                if(userWordBundle.size() <= i){
                    mistakes += wordBundle.get(i).length();
                    totalCharacters += wordBundle.get(i).length();
                    break;
                }

                String actualWord = wordBundle.get(i);
                String userTypedWord = userWordBundle.get(i);

                //will count any extra character that user might type
                for(int j = 0; j < actualWord.length() && j < userTypedWord.length() ;j++){
                    if(actualWord.charAt(j) != userTypedWord.charAt(j)){
                        mistakes++;
                    }
                    totalCharacters++;
                }
            }

            System.out.println();
            wordList.removeBundleOfWords();
        }

        scanner.close();
        printResults(mistakes, totalCharacters);
    }

    private void printCountdown() {
        System.out.println("Typing test starts in");
        System.out.println("\n3");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("2");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("go\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void printResults(int mistakes, int totalCharacters) {
        double accuracy;

        if ((totalCharacters / 4 * 3) < mistakes){
            System.out.println("Try again  your accuracy is under 75%");

        }
        else{
            double elapsedTime = stopwatch.getElapsedTime();

            accuracy = (totalCharacters - mistakes) / (double) totalCharacters * 100;


            double wpm = totalAmountOfWords / elapsedTime * 60;

            System.out.println("\n");
            System.out.println("Amount of words "+ totalAmountOfWords);
            System.out.println("time taken      "+elapsedTime+" s");
            System.out.println();
            System.out.print("Words per Minute  ");
            System.out.printf("%.1f",wpm);
            System.out.print("\nAccuracy        ");
            System.out.printf("%.1f",accuracy);
            System.out.print("%");
        }
    }
}
