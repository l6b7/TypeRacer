import java.util.ArrayList;
import java.util.Scanner;

public class TypeRacer {

    private IStopwatch stopwatch;
    private IWordList wordList;

    public static void main(String[] args) {
        new TypeRacer();
    }

    public TypeRacer() {

        stopwatch = new Stopwatch();
        wordList = new WordList(23, 5);


        System.out.println("Type");

        stopwatch.setTimeStamp();


        while (!wordList.isEmpty()) {
            wordList.getBundleOfWords();

            wordList.removeBundleOfWords();
        }


        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();

        System.out.println(stopwatch.getElapsedTime());


    }


    // Readwords


    // Display information
    // hit 0 to quit
    // else play


    //loop // stop if ends or 0 is pressed

    // Start Timestamps
    // display words

    //~userinput

    // check accuracy // if acc <85% then display words again...

    //loop


    // display WPM


}
