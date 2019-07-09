import java.util.Arrays;

public class GradeItem {
   
   // Declaration of variables.
   private String id; // Student ID associated with this GradeItem.
   private int gradeItemID; // ID given to this GradeItem.
   private String courseID; // ID given to this course.
   private String itemType; // The type of assignment.
   private String date; // Date of assignment.
   private int maxScore; // The maximum possible score.
   private int actualScore; // The score achieved.
   
   private String allowedItemTypes[] = new String[] {"HW", "Quiz",
                                           "Class Work", "Test", 
                                           "Final"}; // Array of acceptable assignment types.
  
   // Constructor for class object.
   public GradeItem(String assignment, String studentID,
                  String course, String assignmentType,
                  String dateAssigned, String pointsPossible,
                  String pointsEarned) {
      
      // Begin ensuring that each String is populated.
      if (studentID == null || studentID.length() == 0) {
         throw new IllegalArgumentException("Student ID is missing or blank.");
      }                        
      if (course == null || course.length() == 0) {
         throw new IllegalArgumentException("Course ID is missing or blank.");
      }
      if (assignmentType == null || assignmentType.length() == 0) {
         throw new IllegalArgumentException("Item Type is missing or blank.");
      }
      if (dateAssigned == null || dateAssigned.length() == 0) {
         throw new IllegalArgumentException("Assignment date is missing or blank.");
      } // Finish testing for unpopulated Strings.
      
      // Begin validating possibility of scores.
      if (Integer.parseInt(pointsPossible) <= 0) {
         throw new IllegalArgumentException(pointsPossible + " is not a valid maximum score.");
      }
      if (Integer.parseInt(pointsEarned) > Integer.parseInt(pointsPossible)) {
         throw new IllegalArgumentException(pointsEarned + "is greater than the maximum possible score.");
      } 
      if (Integer.parseInt(pointsEarned) < 0) {
         throw new IllegalArgumentException(pointsEarned + "is less than 0, the minimum allowable score.");
      } // Finished validating scores.
      
      if(assignment == null) {
         throw new IllegalArgumentException("Grade Item ID is missing or blank.");
      }
      boolean matchFound = false; // for testing assignmentType against allowableItemTypes[].
      for (int i = 0; i < allowedItemTypes.length; i++) {
         if(assignmentType.equals(allowedItemTypes[i])) {
            matchFound = true;
            break;
         }
      }
      if(!matchFound) {
         throw new IllegalArgumentException("\"" + assignmentType + "\" is not a valid " +
                                               "type of assignment.");   
      }
      
      id = studentID;
      gradeItemID = Integer.parseInt(assignment);
      courseID = course;
      itemType = assignmentType;
      date = dateAssigned;
      maxScore = Integer.parseInt(pointsPossible);
      actualScore = Integer.parseInt(pointsEarned);
      
   } // End of constructor.
//*****************************************************************************************

   /**
      * getID() - Accessor for id
      *
      * @return id - the Student's unique ID
   */   
   public String getID() {
      return id;
   } // End of getID.
//***************************************************************************************** 

   /**
      * getGradeItemID() - Accessor for gradeItemID
      *
      * @return gradeItemID - The assignment's ID
   */ 
   public int getGradeItemID() {
      return gradeItemID;
   } // End of getGradeItemID.
//*****************************************************************************************

   /**
      * getCourseID() - Accessor for courseID
      *
      * @return courseID - The course's ID
   */
   public String getCourseID() {
      return courseID;
   } // End of getCourseID.
//*****************************************************************************************

   /**
      * getItemType() - Accessor for itemType
      *
      * @return itemType - The type of assignment for categorization
   */
   public String getItemType() {
      return itemType;
   } // End of getItemType.
//*****************************************************************************************

   /**
      * getDate() - Accessor for date
      *
      * @return date - The date of assignment
   */
   public String getDate() {
      return date;
   } // End of getDate.
//*****************************************************************************************

   /**
      * getMaxScore() - Accessor for maxScore
      *
      * @return maxScore - The maximum possible score
   */
   public int getMaxScore() {
      return maxScore;
   } // End of getMaxScore.
//*****************************************************************************************

   /**
      * getActualScore() - Accessor for actualScore
      *
      * @return actualScore - The score that the student achieved
   */
   public int getActualScore() {
      return actualScore;
   } // End of getActualScore.
//*****************************************************************************************

   /**
      * equals() - Compares the Student IDs of both objects to see if they are unique
      * @param other - Refers to the "other" GradeItem object
      * @return isEqual - Returns whether or not the two ID's are equal
   */
   public boolean equals (GradeItem other) {
      int test = this.getGradeItemID();
      
      if(test == (other.getGradeItemID())) {
         return true;
      }
            
      return false;
   } // End of equals.
//*****************************************************************************************

   /**
      * toString() - Creates a printable string with variables from GradeItem object.
      * @return String - A string communicating the contents of the GrateItem object.
   */
   public String toString() {
      return "GradeItem{gradeItemID=" + gradeItemID + 
             ",id=" + id + 
             ",courseID=" + courseID + 
             ",itemType=" + itemType +
             ",date=" + date +
             ",maxScore=" + maxScore + 
             ",actualScore=" + actualScore + "}";
   } // End of toString.
   
} // End of GradeItem class.