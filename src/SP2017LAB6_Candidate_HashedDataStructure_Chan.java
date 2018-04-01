import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class SP2017LAB6_Candidate_HashedDataStructure_Chan {
    public static ArrayList<Candidate_Chan> readFile(){
        ArrayList<Candidate_Chan> list = new ArrayList<>();
        String name, ID, degree, phone;
        int  expYear;
        double lastSalary;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Max\\OneDrive - Dallas County Community College District\\Github\\academicProjects\\Academic_hashedDataSctructure\\src\\CandidateInfo.txt"))) {
               String line;
               String[] ss;
                while ((line = br.readLine()) != null) {
                    ss = line.split("-");
                    if (ss.length <= 4){
                        name = ss[0];
                        ID = ss[1];
                        phone = ss[2];
                        degree = ss[3];
                        list.add(new Candidate_Chan(name, ID, phone, degree));
                    }
                    else {
                        name = ss[0];
                        ID = ss[1];
                        phone = ss[2];
                        degree = ss[3];
                        expYear = Integer.parseInt(ss[4]);
                        lastSalary = Double.parseDouble(ss[5]);
                        list.add(new ExperienceCandidate_Chan(name, ID, phone, degree, expYear, lastSalary));
                    }
                }
            }
            catch (Exception e){
                System.out.println("File not found.");
            }
            return list;
    }
    public static void displayMenu(){
        System.out.println("1. Insert Candidate or Candidate with Experience");
        System.out.println("2. Fetch");
        System.out.println("3. Encapsulation");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Show All");
        System.out.println("7. Back to main menu");
        System.out.print("Choice: ");
    }
    public static void menu1(LQHashed_Chan datastr){
        Scanner keyboard = new Scanner(System.in);
        int choice;
        displayMenu();
        choice = keyboard.nextInt();
        System.out.println();
        switch (choice){
            case 1: //insert case
                System.out.println("[Please choose a type of candidate to insert]");
                System.out.println("1. Candidate");
                System.out.println("2. Candidate with experience");
                System.out.print("Choice: ");
                int insertChoice = keyboard.nextInt();
                switch (insertChoice){
                    case 1:
                        keyboard.nextLine();
                        System.out.println();//NEEDS EDIT
                }
        }
    }
    public static void menu2 (Hashtable hashtable){

    }
    public static void main(String[] args) {
        LQHashed_Chan testStruct = new LQHashed_Chan(20);
        Scanner keyboard = new Scanner(System.in);
        int choiceMainMenu;
        do {
            System.out.println("[Please choose structure type to work with]");
            System.out.println("1. LQHashed Data Structure");
            System.out.println("2. Java Hashtable Data Structure");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choiceMainMenu = keyboard.nextInt();
            System.out.println();
            switch (choiceMainMenu){
                case 1: //case for LQHashed struct
                    ArrayList<Candidate_Chan> list = readFile(); //collecting data from file
                    for (int i = 0; i < list.size(); i++){ //inserting info from file to data structure
                        testStruct.insert(list.get(i));
                    }
                    testStruct.showAll(); // showAll to prove that all objects are inserted

                    break;
                case 2: //case for Java Hashtable

                    break;
                case 3: //case for exit (writing files in and close it)

                    break;
                    default:
                        System.out.println("Wrong Input! Try again.");
                        break;
            }
        } while (choiceMainMenu != 3);
    }
}
