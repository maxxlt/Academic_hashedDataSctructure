# Academic_hashedDataSctructure
 This is an academic project covering Hashed Data Structure
## Objectives:
* Know how to read the information of the object from an input file, place to the data structure
* Know how to store the informationof all nodes in data structure back to the text file before terminating the
program
* Implement the Linear Quotient (LQHashed) data structure: understand Insert, Fetch, Delete and update algorithm
of the LQhashed structure
* Recognize the LQHashed data structure is encapsulated
* Know how to display all the nodes in the LQHashed data structure on the screen
* Review the concept of Hashtable data structures
* Know how to implement the Java Hashtable class: use functions, put, get, remove, etc.
* Know how to display all the nodes in the Hashtable on the screen
## UML
Candidate_Chan |
------------ |
+name:String +ID:String +phone:String +degree:String |
+Candidate_Chan() +getName() +getID() +getPhone() +getDegree() +toString() +DeepCopy() +compareTo() +setPhone() +setID() +fileString() |

ExperienceCandidate_Chan |
------------ |
-expYear:int -lastSalary:double |
+ExperienceCandidate_Chan() +getLastSalary() +getExpYear() +toString() +deepCopy() +fileString() |
## Pseudocode
<dl>
 <dt>Creating public static void main class</dt>
  <dd>declare String file that contains the directory of the file</dd>
  <dd>declare object to LQHashed class, Hashtable class, Scanner class, 2 ArrayList classes to hold keys</dd>
  <dd>loop keys to store it in Hashtable and LQHashed</dd>
  <dd>do-while loop the main menu, switch statement to let user choose options</dd>
  <dd>case1: case for LQHashed: show all the data stored in structure for verification, calling menu1 function</dd>
  <dd>public static void menu1: declaring necessary local variables, displaying menu for operations over data, switch statement for user: insert, fetch, encapsulation, update, delete, showAll, exit/write file cases.</dd>
  <dd>Case2: case for Hashtable: declare Set<String> object and assign it using method keyset() to store all the keys, loop the keys and display all the data, call menu2 function and repeat procedures like in menu1 (but changing some lines as Hashtable is a little different from LQHash)</dd>
  <dd>Case3: exit case, exit do-while loop, end of program.</dd>
 <dt>public static ArrayList<Candidate_Chan> readfile(String file) class that reads the file, loop the text line by line, split the line using delimiter into array, if-else the length of array to determine if it’s Candidate or Candidate with experience, assign each array cell to specific local variable, and then add it in the ArrayList. Return ArrayList.</dt>
 <dt>public static void displayMenu() class that display operation menu (insert, fetch, blabla…)</dt>
 <dt>public static void menu1</dt>
 <dt>public static void menu2</dt>
</dl>
