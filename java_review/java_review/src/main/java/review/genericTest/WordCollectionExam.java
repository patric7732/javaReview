package review.genericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCollectionExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while(true){
            String input = sc.nextLine();
            if (input.equals("quit")){
                break;
            }
            words.add(input);
        }

        printWord(words);
        printSummary(words);

    }

    private static void printWord(List<String> words){
        System.out.println("입력된 단어");
        for( String word : words){
            System.out.println(word);
        }
    }


    private static void printSummary(List<String> words){
        int totalWord = words.size();
        int totalChar = 0;
        String longWord = "";
        int longWordChar = 0;

        for (String word : words){
            totalChar += words.size();
            if (word.length()>longWordChar){
                longWord = word;
                longWordChar = word.length();
            }
        }

        System.out.println(totalWord);
        System.out.println(totalChar);
        System.out.println(longWord);
        System.out.println(longWordChar);
    }
}
