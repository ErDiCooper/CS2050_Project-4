public class List<T> implements MyCollectionInterfaceProject04<T> {

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
    * Adds a new entry at a specifc location within this collection.
    * 
    * @param newItem The object to be added to the collection.
    * @param position The location where the object is supposed to go.
    * @return True if the addition is successful, or false if not.
    */
   public boolean add(T newItem, int position) {
      if ((position >= 1) && (position <= numberOfEntries + 1)) {
         Node newNode = new Node(newItem);
         if (position == 1) {
            newNode.setNext(firstNode);
            firstNode = newNode;
         }
         else {
            Node nodeBefore = getNodeAt(position - 1);
            Node nodeAfter = getNodeAt(position + 1);
            newNode.setNext(nodeAfter);
            nodeBefore.setNext(newNode);
         }
         numberOfEntries++;
         return true;
      }
      else {
         throw new IndexOutOfBoundsException ("Illegal position given to add operation.");
      }
   } // End of add.
   
//*****************************************************************************************
   
   /**
    * Adds a new entry to this collection.
    * 
    * @param newItem The object to be added to the collection.
    * @return True if the addition is successful, or false if not.
    */
   public boolean add(T data) {
      Node newNode = new Node(data);
      Node currentNode = firstNode;
      
      if (firstNode == null) {
         firstNode = newNode;
         numberOfEntries++;
         return true;
      }
      else {
         while (currentNode.next != null) {
            currentNode = currentNode.getNext();
         }
         currentNode.setNext(newNode);
         numberOfEntries++;
         return true;
      }
   } // End of add.

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
      firstNode = null;
   } // End of clear.

//*****************************************************************************************

   /**
    * Gets the current number of entries in this collection.
    *
    * @return numberOfEntries - The integer number of entries currently in the collection.
    */
   public int getCurrentSize() {
      return numberOfEntries;
   } // End of getCurrentSize.

//*****************************************************************************************
   
   /**
    * Gets the node in the list that corresponds with the position provided by the user.
    *
    * @param position - an location that has been proven valid by add() and getCurrentSize().
    * @return currentNode - The node that corresponds with the position provided.
    */
   public Node getNodeAt(int position) {
      Node currentNode = firstNode;
      for (int i = 1; i < position; i++) {
         currentNode = currentNode.getNext();
      }
      return currentNode;
   } // End of getNodeAt.

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