/*
EricDiCarlo_01 
Eric DiCarlo
Project 1
Windows 10, jGrasp
asunder - adv - apart; divided.
“I regret nothing: it was worth it for the hats alone.” - Sarah Gailey (Birth year cannot be found)
*/

public class Student {
   
   // Declaration of variables.
   private String id;        // Student ID for Student object.
   private String firstName; // Student's first name.
   private String lastName;  // Student's last name.
   private String email;     // Student's email address.
  
   // Constructor for class object.
   public Student(String studentID,
                  String studentFirst,
                  String studentLast,
                  String studentEmail) {
      
      // Begin ensuring that each String is populated.            
      if (studentID == null || studentID.length() == 0) {
         throw new IllegalArgumentException("Student ID is missing or blank.");
      }      
      if (studentFirst == null || studentFirst.length() == 0) {
         throw new IllegalArgumentException("Student's first name is missing or blank.");
      }
      if (studentLast == null || studentLast.length() == 0) {
         throw new IllegalArgumentException("Student's last name is missing or blank.");
      }
      if (studentEmail == null || studentEmail.length() == 0) {
         throw new IllegalArgumentException("Student's email is missing or blank.");
      } // Finish testing for unpopulated Strings.
      
      if (!studentEmail.contains("@")) { // Ensure that the email is properly formatted.
         throw new IllegalArgumentException("\"" + studentEmail + "\" is missing the " +
                                            "necessary @ symbol.");
      }
      
      id = studentID;
      firstName = studentFirst;
      lastName = studentLast;
      email = studentEmail;
   } // End of constructor.
//*****************************************************************************************

   /**
      * getID() - Accessor for id
      *
      * @return id - The Student's unique ID number
   */
   public String getID() {
      return id;
   } // End of getID.
//***************************************************************************************** 

   /**
      * getFirstName() - Accessor for firstName 
      *
      * @return firstName - The Student's first name
   */ 
   public String getFirstName() {
     return firstName;
   } // End of getFirstName.
//*****************************************************************************************

   /**
      * getLastName() - Accessor for lastName 
      *
      * @return lastName - The Student's last name
   */ 
   public String getLastName() {
      return lastName;
   } // End of getLastName.
//*****************************************************************************************

   /**
      * getEmail() - Accessor for email
      *
      * @return email - The Student's email address
   */ 
   public String getEmail() {
      return email;
   } // End of getEmail.
//*****************************************************************************************
   
   /**
      * equals() - Compares both objects to see if they are unique
      * @param other - Refers to the "other" Student object
      * @return isEquals - Whether or not the two ID's are equal
   */
   public boolean equals (Student other) {
      if (this.getID().equals(other.getID())) {
         return true;
      }
      
      return false;
   } // End of equals.
//*****************************************************************************************

   /**
      * toString() - Creates a printable string with variables from Studen object.
      * @return String - A string communicating the contents of the Student object.
   */
   public String toString() {
      return "Student{id=" + id + 
             ",firstName=" + firstName + ",lastName=" + lastName + 
             ",emailAddress=" + email + "}";
   } // End of toString.
} // End of Student class.