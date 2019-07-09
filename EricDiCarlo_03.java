import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class EricDiCarlo_03 {

   private static List listOfStudents;   // A list for all valid Student objects.
   private static List listOfGradeItems; // A list for all valid GradeItem objects.
   private static final String INPUT_FILE = "Project_03_Input01.txt";   // Input file to be fed into lists.
   private static final String OUTPUT_FILE = "Project_03_Output01.txt"; // Output file for lists.
   
//****************************************************************************************

   public static void main(String[] args) throws IOException {
   
   listOfStudents   = new List(); // The Linked List of Student Objects.
   listOfGradeItems = new List(); // The Linked List of GradeItem Objects.
      
      System.out.println("Reading data from file Project_03_Input01.txt");
      processInput();
      System.out.print("Generating report to file Project_03_Output01.txt... ");
      generateReport();
      System.out.print("done");
      
   } // End of main.
//*****************************************************************************************
   
   /**
      * processInput() - Processes the data from the input file and directs it depening on object type.
   */
   public static void processInput() throws IOException {
   
      File inputFile = new File(INPUT_FILE);
      Scanner input = new Scanner(inputFile);
      
      while (input.hasNext()) {
         String tempString = input.nextLine();
         String[] tempArray = tempString.split(",");
      
         if (tempArray[0].equals("STUDENT")) {
            processStudentData(tempArray);
         }
         else if (tempArray[0].equals("GRADE ITEM")) {
            processGradeItemData(tempArray);
         }
         else {
            throw new IllegalArgumentException(tempString + "is not the required \"STUDENT\" " +
                                               "or \"GRADE ITEM\".");
         }
      }
   } // End of processInput.
//*****************************************************************************************   
   
   /**
      * processStudentData() - Sends input though the Student constructor and into listOfStudents.
      * @param data - The array holding the data for the student object.
   */   
   public static void processStudentData(String[] data) {
      if (data[1].equals("ADD")) {
         Student student = new Student(data[2], data[3], data[4], data[5]);
         if (listOfStudents.contains(student)) {
            throw new IllegalArgumentException("The entered Student ID already exists.");  
         }
         else {
            try {
               listOfStudents.add(student);
               System.out.println("Student with Student ID " + student.getId() + " was added to the list.");
            }
            catch (IllegalArgumentException e) {
               System.err.println("The student could not be added to the list.");
            }
         }         
      }
      else if (data[1].equals("DEL")) {
         Student student = new Student(data[2], data[3], data[4], data[5]);
         try {
            listOfStudents.remove(student);
            System.out.println("Student with Student ID " + student.getId() + " was removed from the list.");
         }
         catch (IllegalArgumentException e) {
            System.err.println("The student requested does not exist in the list.");
         }
      }
      else {
         throw new IllegalArgumentException(data[1] + " is not a valid operation for this program.");
      }
   } // End of processStudentData.
//*****************************************************************************************   
   
   /**
      * processGradeItemData() - Sends input though the GradeItem constructor and into listOfGradeItems.
      * @param data - The array holding the data for gradeItem.
   */      
   public static void processGradeItemData(String[] data) {
      if (data[1].equals("ADD")) {
         GradeItem gradeItem = new GradeItem(data[2], data[3], data[4], data[5],
                                             data[6], data[7], data[8]);
         if (listOfGradeItems.contains(gradeItem)) {
            throw new IllegalArgumentException("The entered Student ID already exists.");  
         }
         else {
            try {
               listOfGradeItems.add(gradeItem);
               System.out.println("Assignment with GradeItem ID " + gradeItem.getGradeItemId() +
                                  " was added to the list.");
            }
            catch (IllegalArgumentException e) {
               System.err.println("The GradeItem could not be added to the list.");
            }
         }         
      }
      else if (data[1].equals("DEL")) {
         GradeItem gradeItem = new GradeItem(data[2], data[3], data[4], data[5],
                                             data[6], data[7], data[8]);
         try {
            listOfGradeItems.remove(gradeItem);
            System.out.println("Assignment with GradeItem ID " + gradeItem.getGradeItemId() + 
                               " was removed from the list.");
         }
         catch (IllegalArgumentException e) {
            System.err.println("The GradeItem requested does not exist in the list.");
         }
      }
      else {
         throw new IllegalArgumentException(data[1] + " is not a valid operation for this program.");
      }
   } // End of processGradeItemData.
//*****************************************************************************************

   /**
       * Generates a report based on arrays from both Lists.
       *
       * param OUTPUT_FILE - the file that the report will be written upon.
       */ 
   public static void generateReport() throws IOException {
      
      PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE));
      
      Object[] studentList = listOfStudents.toArray();
      Object[] gradeItemList = listOfGradeItems.toArray();
      
      DecimalFormat pointZero = new DecimalFormat("##0.0%");
      
      int sumTotal    = 0;   // The sum of possible points for the Student.
      int sumAchieved = 0;   // The sum of actual points for the Student.
      double percent =  0.0; // The percentage of points earned out of possible.
      String idOne;          // Holds student.getID()
      String idTwo;          // Holds gradeItem.getID()
      String insert = ("=========================================================");
      
      for (int i = 0; i < studentList.length; i++) {
         Student student = (Student)studentList[i];
         idOne = student.getId();
         output.println(student.getId() + "  " + student.getFirstName() + " " +
                        student.getLastName() + " " + student.getEmail());
         output.println("   Grade Items");
         for (int j = 0; j < gradeItemList.length; j++) {
            GradeItem gradeItem = (GradeItem)gradeItemList[j];
            idTwo = gradeItem.getId();
            
            if (idOne.equals(idTwo)) {
               sumTotal += gradeItem.getMaxScore();
               sumAchieved += gradeItem.getActualScore();
               
               output.print("   " + gradeItem.getGradeItemId() + "   " +
                              gradeItem.getCourseId() + "   ");
                              
               if ((gradeItem.getItemType()).equals("HW")) {
                  output.print(gradeItem.getItemType() + "           ");
               }
               else if ((gradeItem.getItemType()).equals("Class Work")) {
                  output.print(gradeItem.getItemType() + "   ");
               }
               else if ((gradeItem.getItemType()).equals("Test")) {
                  output.print(gradeItem.getItemType() + "         ");
               }
               else if ((gradeItem.getItemType()).equals("Final")) {
                  output.print(gradeItem.getItemType() + "        ");
               }
               else if ((gradeItem.getItemType()).equals("Quiz")) {
                  output.print(gradeItem.getItemType() + "         ");
               }
               output.print(gradeItem.getDate() + "   " + gradeItem.getMaxScore());
               
               if (gradeItem.getActualScore() < 100) {
                  output.print("    " + gradeItem.getActualScore() + "\n");
               }
               else if (gradeItem.getActualScore() > 99) {
                  output.print("   " + gradeItem.getActualScore() + "\n");
               }
            }
         }
         if (sumTotal != 0) {
            percent = (double)sumAchieved / sumTotal;
         }
         else {
            percent = 0.0;
         }
         
         output.println(insert);         
         output.println("   Total                               " + sumTotal +
                        "   " + sumAchieved + "    " + pointZero.format(percent));
         output.println("");
         
         sumTotal = 0;
         sumAchieved = 0;
      }
      output.close();
   } // End of generateReport. 
} // End of EricDiCarlo_03 class.