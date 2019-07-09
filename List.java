public class List<T> implements MyCollectionInterface<T> {

   private Node firstNode;      // The starting point of the List.
   private int numberOfEntries; // The number nodes in the list.
   
   public List() {
      initializeDataFields();
   } // End of List constructor.

//*****************************************************************************************

   public void initializeDataFields() {
      firstNode = null;
      numberOfEntries = 0;
   } // End of initializeDataFields.
   

//*****************************************************************************************
   
   /**
    * Adds a new entry to this collection if one already exists.
    * 
    * @param newItem The object to be added to the collection.
    * @return True if the addition is successful, or false if not.
    */
   public boolean add(T newItem) {
      Node newNode = new Node(newItem);
      Node currentNode = firstNode;
      if (firstNode == null) {
         addAtFirst(newItem);
         return true;
      }
      else {
         while (currentNode.next != null) {
            currentNode = currentNode.getNext();
         }
            currentNode.setNext(newNode);
            return true;
      }
   } // End of add.
   
//*****************************************************************************************
   
   /**
    * Adds a new entry to this collection.
    * 
    * @param newItem The object to be added to the collection.
    * @return True if the addition is successful, or false if not.
    */
   public void addAtFirst(T data) {
      Node newNode = new Node(data);
      firstNode = newNode;
   } // End of addAtFirst.

//*****************************************************************************************

   /**
    * Removes one occurrence of a given entry from this collection.
    *
    * @param anEntry The entry to be removed.
    * @return matchFound - true if the removal was successful, false if not.
    */
   public boolean remove(T anEntry) {
      Node currentNode = firstNode;
      Node previousNode = firstNode;
      Node toRemove = new Node(anEntry);
      
      boolean matchFound = false;
      
      do {
         if ((currentNode.getData()).equals(toRemove.getData())) {
            matchFound = true;
            break;
         }
         else {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
         }
      } while (currentNode.getNext() != null);
      
      if (matchFound) {
         if (currentNode == firstNode) {
            firstNode = firstNode.getNext();
            return matchFound;
         }
         else {
            previousNode.setNext(currentNode.getNext());
            return matchFound;
         }
      }
      throw new IllegalArgumentException("The data to be removed could not be found.");
   } // End of remove.
   
//*****************************************************************************************

   /**
    * Removes all entries from this collection.
    */
   public void clear() {
      if (!isEmpty()) {
         System.out.println("The List is already empty.");
      }
      firstNode.next = null;
      firstNode = null;
   } // End of clear.

//*****************************************************************************************

   /**
    * Gets the current number of entries in this collection.
    *
    * @return counter - The integer number of entries currently in the collection.
    */
   public int getCurrentSize() {
      int counter = 0;
      Node currentNode = firstNode;
      
      if (firstNode == null) {
         return counter;
      }
      if (firstNode.getNext() == null) {
         return 1;
      }
      
      while (currentNode != null) {
         counter++;
         currentNode = currentNode.getNext();
      }
      
      return counter;
   } // End of getCurrentSize.

//*****************************************************************************************

   /**
    * Check to see if the collection is empty.
    *
    * @return True if the collection is empty, or false if not.
    */
   public boolean isEmpty() {
      return getCurrentSize() == 0;      
   } // End of isEmpty.

//*****************************************************************************************

   /**
    * Counts the number of times a given entry appears in this collection.
    *
    * @param anEntry The entry to be counted.
    * @return counter - The number of times anEntry appears in the collection.
    */
   public int getFrequencyOf(T anEntry) {
      int counter = 0;
      Node currentNode = firstNode;
      
      while (currentNode != null) {
         if (currentNode.getData().equals(anEntry)) {
            counter++;
         }
         currentNode = currentNode.getNext();
      }
      
      return counter;
   } // End of getFrequencyOf.
   
//*****************************************************************************************   
   
   /**
    * Tests whether this collection contains a given entry.
    *
    * @param anEntry The entry to locate.
    * @return True if the collection contains anEntry, or false if not.
    */
   public boolean contains (T anEntry) {
      if (firstNode == null) {
         return false;
      }
      Node currentNode = firstNode;
      
      while (currentNode != null) {
         if (currentNode.getData().equals(anEntry)) {
            return true;
         } else {
            currentNode = currentNode.getNext();
         }
      }
       return false;   
   } // End of contains.

//*****************************************************************************************

   /**
    * Retrieves all entries that are in this collection.
    *
    * @return result - A newly allocated array of all the entries in the collection. 
    * Note: If the collection is empty, the returned array is empty.
    */
   public Object[] toArray () {
   
      @SuppressWarnings("unchecked")
      int size = getCurrentSize();
      Object[] result = new Object[size];
      int index = 0;
      
      Node currentNode = firstNode;
      while (currentNode != null) {
         result[index] = currentNode.getData();
         currentNode = currentNode.getNext();
         index++;
      }
      
      return result;
   } // End of toArray.
   
//*****************************************************************************************
//*****************************************************************************************

   private class Node<T> {
      private T    data;
      private Node<T> next; // Reference to next node in the List.
   
      private Node(T dataPortion) {
         this(dataPortion, null);
      } // End of first Node constructor.
      
      private Node(T dataPortion, Node<T> nextNode) {
         data = dataPortion;
         next = nextNode;
      } // End of second Node constructor.   
      
//*****************************************************************************************
      
      /**
       * Gets data from the Node
       *
       * @return data
       */
      private T getData() {
         return data;
      } // End of getData.
      
//*****************************************************************************************

      /**
       * Sets new data for the node
       *
       * param newData - newData for the Node
       */
      private void setData(T newData) {
         data = newData;
      } // End of setData.
      
//*****************************************************************************************

      /**
       * Gets the next Node.
       *
       * @return next
       */
      private Node getNext() {
         return next;
      } // End of getNext.
      
//*****************************************************************************************

      /**
       * Sets a new next Node.
       *
       * @param nextNode - the new next Node.
       */
      private void setNext(Node<T> nextNode) {
         next = nextNode;
      } // End of setNext.
      
   } // End of Node class.

} // End of List class.