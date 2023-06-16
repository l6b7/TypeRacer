import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordList implements IWordList {

    //filepath
    private int totalAmountOfWords;

    private int bundleSize;
    private ArrayList<String> wordList;


    public WordList(int totalAmountOfWords, int bundleSize) {
        this.totalAmountOfWords = totalAmountOfWords;
        this.bundleSize = bundleSize;
        wordList = new ArrayList<String>();
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                wordList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Random order Random Elements

        //getting target list length
        for (int i = wordList.size(); i > totalAmountOfWords; i--) {
            int randomIndex = (int) (Math.random() * wordList.size() - 1);
            wordList.remove(randomIndex);
        }

        Collections.shuffle(wordList);
    }


    public boolean isEmpty() {
        return wordList.isEmpty();
    }

    public ArrayList<String> getBundleOfWords() {
        ArrayList<String> bundle = new ArrayList<String>();
        if (wordList.size() > bundleSize) {
            for (int i = 0; i < 5; i++) {
                bundle.add(wordList.get(i));
            }
            return bundle;
        } else {
            return wordList;
        }
    }

    public void removeBundleOfWords() {

        if (wordList.size() >= bundleSize) {
            for (int i = 0; i < bundleSize; i++) {
                wordList.remove(0);
            }
        } else {
            wordList = new ArrayList<>();
        }
    }
}
