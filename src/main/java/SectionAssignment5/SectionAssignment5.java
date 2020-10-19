package SectionAssignment5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
public class Assignment5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Pick Question: ");
            int qeustionNumber = scanner.nextInt();
            switch (qeustionNumber){
                case 1:
                    linesWordsChars();
                    break;
                case 2:
                    drawHistogram();
                    break;
                case 3:
                    uniqueNames();
                    break;
                default:
                    System.out.println("Wrong Question Number!! start again.");
            }
        }
    }
    private static void uniqueNames() {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> nameSet = new HashSet<>();
        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            nameSet.add(name);
        }while(!name.isBlank());
        System.out.println("Unique name list contains: ");
        for(String printName: nameSet){
            System.out.println(printName);
        }
    }
    private static void drawHistogram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File: ");
        String fileName = scanner.next();
        int[] countArray = {0,0,0,0,0,0,0,0,0,0,0};
        String[] strings = {"00-09: ","10-19: ","20-29: ","30-39: ","40-49: ","50-59: "
                ,"60-69: ","70-79: ","80-89: ","90-99: "," 100: "};
        File file = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                int score = fileScanner.nextInt();
                countOccurance(countArray, score);
            }
            for(int i = 0;i < strings.length;i++) {
                System.out.print(strings[i]);
                for (int j = 0; j < countArray[i];j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void countOccurance(int[] countArray, double score) {
        if(0 <= score && score <= 9){
            countArray[0]++;
            return;
        } else if(10 <= score && score <= 19) {
            countArray[1]++;
            return;
        } else if(20 <= score && score <= 29) {
            countArray[2]++;
            return;
        } else if(30 <= score && score <= 39) {
            countArray[3]++;
            return;
        } else if(40 <= score && score <= 49) {
            countArray[4]++;
            return;
        } else if(50 <= score && score <= 59) {
            countArray[5]++;
            return;
        } else if(60 <= score && score <= 69) {
            countArray[6]++;
            return;
        } else if(70 <= score && score <= 79) {
            countArray[7]++;
            return;
        } else if(80 <= score && score <= 89) {
            countArray[8]++;
            return;
        } else if(90 <= score && score <= 99) {
            countArray[9]++;
            return;
        } else if(score == 100)  {
            countArray[10]++;
            return;
        }
    }
    private static void linesWordsChars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File: ");
        String fileName = scanner.next();
        int numberOfLines = 0;
        int numberOfWords = 0;
        int numberOfChars = 0;
        File file = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                numberOfLines++;
                String line = fileScanner.nextLine();
                numberOfWords += line.split(" ").length;
                numberOfChars += line.length();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Lines = "+numberOfLines);
        System.out.println("Words = "+numberOfWords);
        System.out.println("Chars = "+numberOfChars);
    }
}