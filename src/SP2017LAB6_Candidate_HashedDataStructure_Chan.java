import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class SP2017LAB6_Candidate_HashedDataStructure_Chan {
    public static ArrayList<Candidate_Chan> readFile(String file){//read file function
        ArrayList<Candidate_Chan> list = new ArrayList<>();
        String name, ID, degree, phone;
        int  expYear;
        double lastSalary;
        //C:\Users\Max\OneDrive - Dallas County Community College District\Github\academicProjects\Academic_hashedDataSctructure\src\
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
               String line;
               String[] ss;
                while ((line = br.readLine()) != null) {//loop until till the end of the file
                    ss = line.split("-");
                    if (ss.length <= 4){//if length is less than 4 on the line, it means we spotted an entry-level Candidate
                        name = ss[0];
                        ID = ss[1];
                        phone = ss[2];
                        degree = ss[3];
                        list.add(new Candidate_Chan(name, ID, phone, degree));//add in our list
                    }
                    else {//otherwise it's Candidate with experience
                        name = ss[0];
                        ID = ss[1];
                        phone = ss[2];
                        degree = ss[3];
                        expYear = Integer.parseInt(ss[4]);
                        lastSalary = Double.parseDouble(ss[5]);
                        list.add(new ExperienceCandidate_Chan(name, ID, phone, degree, expYear, lastSalary));
                    }
                }
                br.close();
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
        System.out.println("7. Exit and Update Changes");
        System.out.print("Choice: ");
    }
    public static void menu1(LQHashed_Chan datastr, String file, ArrayList<String> keys){
        Scanner keyboard = new Scanner(System.in);
        String name, ID, phone, degree;
        int choice, expYear;
        double salary;
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
                    case 1: //case for Candidate
                        keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a name of the candidate]: ");
                        name = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter an ID of the candidate]: ");
                        ID = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a phone number of the candidate]: ");
                        phone = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a degree of the candidate]: ");
                        degree = keyboard.nextLine();
                        System.out.println();
                        keys.add(ID);
                        datastr.insert(new Candidate_Chan(name, ID, phone, degree));
                        break;
                    case 2: //case for Experienced Candidate
                        keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a name of the candidate]: ");
                        name = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter an ID of the candidate]: ");
                        ID = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a phone number of the candidate]: ");
                        phone = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a degree of the candidate]: ");
                        degree = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter experience year of the candidate]: ");
                        expYear = keyboard.nextInt();
                        System.out.println();
                        System.out.print("[Please enter last salary of the candidate]: ");
                        salary = keyboard.nextDouble();
                        System.out.println();
                        keys.add(ID);
                        datastr.insert(new ExperienceCandidate_Chan(name, ID, phone, degree, expYear, salary));
                        break;
                        default:
                            System.out.println("Wrong Input.");
                            break;
                }
                break;
            case 2: //fetch case
                System.out.print("[Please enter an ID of the candidate to fetch]: ");
                System.out.println();
                keyboard.nextLine();
                String userKey = keyboard.nextLine();
                Candidate_Chan fetchedCand = datastr.fetch(userKey);
                if (fetchedCand == null) {
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                System.out.println(fetchedCand.toString());
                break;
            case 3: //encapsulation check case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID = keyboard.nextLine();
                Candidate_Chan foundCand = datastr.fetch(keyID);
                System.out.println();
                if (foundCand == null) {
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                else {
                    System.out.print("[Please enter a new phone number of a candidate to test encapsulation]: ");
                    String newPhone = keyboard.nextLine();
                    foundCand.setPhone(newPhone);
                    System.out.println();
                    Candidate_Chan dataCand = datastr.fetch(keyID);
                    if (foundCand.getPhone().equals(dataCand.getPhone()))
                        System.out.println("LQHashed data structure is not encapsulated");
                    else
                        System.out.println("LQHashed data structure is encapsulated");
                }
                break;
            case 4: //update case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID1 = keyboard.nextLine();
                Candidate_Chan foundCand1 = datastr.fetch(keyID1);
                System.out.println();
                if (foundCand1 == null) {
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                else {
                    System.out.print("[Please enter a new degree of candidate to update]: ");
                    String newDegree = keyboard.nextLine();
                    foundCand1.setDegree(newDegree);
                    System.out.println();
                    if (datastr.update(keyID1,foundCand1)) {
                        System.out.println("Candidate successfully updated.");
                        System.out.println(datastr.fetch(keyID1).toString());
                    }
                    else
                        System.out.println("Failed to update candidate");
                }
                break;
            case 5: //delete case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID2 = keyboard.nextLine();
                Candidate_Chan foundCand2 = datastr.fetch(keyID2);
                System.out.println();
                if (foundCand2 == null) {
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                else {
                    if (datastr.delete(keyID2)) {
                        keys.remove(keyID2);
                        System.out.println("Candidate successfully deleted.");
                    }
                    else
                        System.out.println("Failed to delete a candidate");
                }
                break;
            case 6:
                datastr.showAll();
                break;
            case 7: //exit case (updating our file case)
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                    FileWriter fwriter = new FileWriter(file,true); //add true will append the new data
                    for(int i = 0; i < keys.size(); i++) {
                        fwriter.write(datastr.fetch(keys.get(i)).fileString()+"\n");
                    }
                    fwriter.close();
                }
                catch (Exception e){
                    System.out.println("File not found.");
                }
                break;
                default:
                    System.out.println("Wrong Input");
                    break;
        }
    }
    public static void menu2 (Hashtable<String,Candidate_Chan> datastr, String file, Set<String> keys){
        Scanner keyboard = new Scanner(System.in);
        String name, ID, phone, degree;
        int choice, expYear;
        double salary;
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
                    case 1://candidate case
                        keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a name of the candidate]: ");
                        name = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter an ID of the candidate]: ");
                        ID = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a phone number of the candidate]: ");
                        phone = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a degree of the candidate]: ");
                        degree = keyboard.nextLine();
                        System.out.println();
                        datastr.put(ID,new Candidate_Chan(name, ID, phone, degree));
                        break;
                    case 2://cand w experience case
                        keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a name of the candidate]: ");
                        name = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter an ID of the candidate]: ");
                        ID = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a phone number of the candidate]: ");
                        phone = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter a degree of the candidate]: ");
                        degree = keyboard.nextLine();
                        System.out.println();
                        System.out.print("[Please enter experience year of the candidate]: ");
                        expYear = keyboard.nextInt();
                        System.out.println();
                        System.out.print("[Please enter last salary of the candidate]: ");
                        salary = keyboard.nextDouble();
                        System.out.println();
                        datastr.put(ID,new ExperienceCandidate_Chan(name, ID, phone, degree, expYear, salary));
                        break;
                    default:
                        System.out.println("Wrong Input.");
                        break;
                }
                break;
            case 2://fetch case
                System.out.print("[Please enter an ID of the candidate to fetch]: ");
                System.out.println();
                keyboard.nextLine();
                String userKey = keyboard.nextLine();
                Candidate_Chan fetchedCand = datastr.get(userKey);
                if (fetchedCand == null) {
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                System.out.println(fetchedCand.toString());
                break;
            case 3://encapsulation case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID = keyboard.nextLine();
                System.out.println();
                try{
                    Candidate_Chan foundCand = datastr.get(keyID).deepCopy();//getting a deep copy of data, shallow copy would change the data (non-encapsulated)
                    System.out.print("[Please enter a new phone number of a candidate to test encapsulation]: ");
                    String newPhone = keyboard.nextLine();
                    foundCand.setPhone(newPhone);//changing phone in it
                    System.out.println();
                    Candidate_Chan dataCand = datastr.get(keyID);
                    if (foundCand.getPhone().equals(dataCand.getPhone()))//and see if it's encapsulated properly
                        System.out.println("LQHashed data structure is not encapsulated");
                    else
                        System.out.println("LQHashed data structure is encapsulated");
                }
                catch (Exception e){
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                break;
            case 4://update case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID1 = keyboard.nextLine();
                System.out.println();
                try{
                    Candidate_Chan foundCand1 = datastr.get(keyID1).deepCopy();
                    System.out.print("[Please enter a new degree of candidate to update]: ");
                    String newDegree = keyboard.nextLine();
                    foundCand1.setDegree(newDegree);
                    System.out.println();
                    datastr.put(keyID1,foundCand1);
                    if(foundCand1 == datastr.get(keyID1))
                        System.out.println("Candidate successfully updated.");
                    else
                        System.out.println("Failed to update candidate");
                }
                catch (Exception e){
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                break;
            case 5://delete case
                System.out.print("[Please enter ID of the candidate]: ");
                keyboard.nextLine();
                String keyID2 = keyboard.nextLine();
                System.out.println();
                try{
                    datastr.remove(keyID2);
                    if (datastr.get(keyID2) == null)
                        System.out.println("Candidate successfully deleted.");
                    else
                        System.out.println("Failed to delete a candidate");
                }
                catch (Exception e){
                    System.out.println("The candidate cannot be found.");
                    break;
                }
                break;
            case 6://show all case
                for (String key: keys)
                    System.out.println(datastr.get(key).toString());
                break;
            case 7://write a file/exit case
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                    FileWriter fwriter = new FileWriter(file,true); //add true will append the new data
                    for(String key:keys) {//loop through keys
                        fwriter.write(datastr.get(key).fileString()+"\n");
                    }
                    fwriter.close();
                }
                catch (Exception e){
                    System.out.println("File not found.");
                }
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }
    public static void main(String[] args) {
        String file = "/Users/maxxlt/Desktop/academicProjects/Academic_hashedDataSctructure/src/CandidateInfo.txt";
        LQHashed_Chan testStruct = new LQHashed_Chan(20);
        Hashtable<String,Candidate_Chan> hashtable = new Hashtable<>();
        Scanner keyboard = new Scanner(System.in);
        int choiceMainMenu;
        ArrayList<Candidate_Chan> hashlist = readFile(file);//pull info from the file
        ArrayList<String> LQkeys = new ArrayList<>();//declaring arrayList to store keys
        for (int i = 0; i < hashlist.size(); i++){ //inserting info from file to data structure
            hashtable.put(hashlist.get(i).getID(),hashlist.get(i));
        }
        for (int i = 0; i < hashlist.size(); i++){ //inserting info from file to data structure
            testStruct.insert(hashlist.get(i));
            LQkeys.add(hashlist.get(i).getID());
        }
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
                    testStruct.showAll(); // showAll to prove that all objects are inserted
                    menu1(testStruct, file, LQkeys);
                    break;
                case 2: //case for Java Hashtable
                    Set<String> keys = hashtable.keySet();
                    for (String key: keys)
                        System.out.println(hashtable.get(key).toString()); // display all to prove that all objects are inserted
                    menu2(hashtable,file,keys);
                    break;
                case 3:
                    System.out.println("Thanks for using my app :)");
                    break;
                    default:
                        System.out.println("Wrong Input! Try again.");
                        break;
            }
        } while (choiceMainMenu != 3);
    }
}
