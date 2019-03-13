// cmatsunaga17@georgefox.edu
// Program 6
// 2018-10-27


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a LinkedList class that represents a doubly-linked list of
 * LinkedListNode. It permits all elements including null. A node
 * (represented in the inner class LinkedListNode) contains a reference
 * to an object of type E. This class maintains a head (reference to
 * the first node), a tail (reference to the last node), and a size
 * (the amount of objects in a list). Each node should maintain a 
 * previous (reference to previous node) and a next (reference to next
 * node). This class also supports forward and reverse iteration by
 * implementing the Iterable interface.
 *
 * @author cmatsunaga17@georgefox.edu
 *
 * @param <E> E is a general type used as a parameterized type to allow
 *            the user to specify the type of object each instance of
 *            the class should contain
 */
public class LinkedList<E> implements Iterable<E>
{

   private static final int DOES_NOT_CONTAIN_ELEMENT = -1;

   private int _size;
   private LinkedListNode _head;    // reference to first node
   private LinkedListNode _tail;    // reference to last node

   /**
    * Constructs a new empty LinkedList.
    */
   public LinkedList()
   {
      _size = 0;
      _head = null;
      _tail= null;
   }

   /**
    * Inserts the specified element at the specified position in the
    * list. Shifts the element currently at that position (if any) and
    * any subsequent elements to the right, therefore also adding one
    * to their indices. Adds one to the size of the list as well.
    *
    * The method is split up into various cases. The getNodeAtIndex
    * private helper method is used to find the node at the specified
    * index. Cases are split up (also commented) whether the node
    * is inserted at the beginning, end, or middle of the list. Element
    * can also be inserted if the list is empty.
    *
    * @param index Position at which the specified element is to be
    *              inserted
    * @param element Element to be inserted into the list
    * @throws IndexOutOfBoundsException Throws exception if the index
    *         is negative or larger than the size of the list
    * @throws OutOfMemoryError Throws exception if the size of the list
    *         gets too large
    */
   public void add(int index, E element)
   {
      LinkedListNode added = new LinkedListNode(element);
      LinkedListNode newNext = null;
      LinkedListNode newPrevious = null;

      if (index < 0 || index > size())
      {
         throw new IndexOutOfBoundsException("Really? Just think a "
               + "little...");
      }

      // if not at beginning, get the node before it
      if (index > 0)
      {
         newPrevious = getNodeAtIndex(index - 1);
      }
      // if not at end, get the node after it
      if (index < size())
      {
         newNext = getNodeAtIndex(index);
      }

      // add node to end of list
      if (newNext == null)
      {
         _tail = added;
      }
      // new next is not null
      else
      {
         newNext.setPrevious(added);
         added.setNext(newNext);
      }

      // add node to beginning of list
      if (newPrevious == null)
      {
         _head = added;
      }
      // new previous is not null
      else
      {
         newPrevious.setNext(added);
         added.setPrevious(newPrevious);
      }

      if (Integer.MAX_VALUE == size())
      {
         throw new OutOfMemoryError("Getting too big, my friend.");
      }
      _size++;
   }

   /**
    * Appends the specified element to the end of the list. Adds one
    * to the size of the list. The element to be added in the list
    * becomes the new tail (last reference in the list).
    *
    * @param element Specified element to be appended to the list
    * @return boolean Always returns true
    * @throws OutOfMemoryError Throws exception if the size of the list
    *         gets too large
    */
   public boolean add(E element)
   {
      LinkedListNode added = new LinkedListNode(element);

      // list is empty, head becomes node created
      if (_head == null)
      {
         _head = added;
      }
      // if list is not empty, adding to end
      if (_tail != null)
      {
         _tail.setNext(added);
      }
      added.setPrevious(_tail);
      _tail = added;

      if (Integer.MAX_VALUE == size())
      {
         throw new OutOfMemoryError("Getting too big, my friend.");
      }
      _size++;
      return true;
   }

   /**
    * Removes all the elements from the list. List will be empty. Size
    * is reset back to 0, and the head and tail do not reference
    * anything (null). Method does not have to go through each element
    * to set to null, only have to set first and last reference to null.
    */
   public void clear()
   {
      _head = null;
      _tail = null;
      _size = 0;
   }
   
   /*
    * Returns the element at the specified position in this list. Makes
    * use of the private helper method getNodeAtIndex to find the node
    * at the specified index.
    *
    * @param index Specified index of element to return
    * @return E The element at the specified index in the list
    * @throws IndexOutOfBoundsException Throws exception if the index
    *         is negative or greater than or equal to the size
    */
   public E get(int index)
   {
      LinkedListNode node = null;

      if (index < 0 || index >= size())
      {
         throw new IndexOutOfBoundsException("Come on now...");
      }

      node = getNodeAtIndex(index);
      return node.getValue();
   }

   /**
    * Returns the index of the first occurrence of the specified
    * element in the list. Returns -1 if the list does not contain the
    * specified element.
    *
    * Starts at the head and works way through the list until the
    * element is either found or the last node is reached. Element
    * passed into method can be null.
    *
    * @param element Specified element to find index of
    * @return int The index of the first occurrence of the element OR
    *         -1 if the list does not contain the element
    */
   public int indexOf(E element)
   {
      // constant of -1 if the list does not contain the element
      int index = DOES_NOT_CONTAIN_ELEMENT;
      LinkedListNode current = _head;
      
      for (int i = 0; i < size(); i++)
      {
         if (current.getValue() == null)
         {
            if (element == null)
            {
               index = i;
            }
         }
         else
         {
            if (current.getValue().equals(element))
            {
               index = i;
               i = size();
            }
         }
         current = current.getNext();
      }
      return index;
   }

   /**
    * Returns true if the size of the list is 0.
    *
    * @return true If the size of the list is 0, false otherwise
    */
   public boolean isEmpty()
   {
      return size() == 0;
   }

   /**
    * Removes the element at the specified index in the list. Shifts
    * any subsequent elements to the left, therefore also subtracting
    * one from their indices. Returns the element removed from the list.
    * Size of the list also decreases by one.
    *
    * The method is split up into various cases. The getNodeAtIndex
    * private helper method is used to find the node at the specified
    * index. Cases are split up (also commented) whether the node
    * is removed from the beginning, end, or middle of the list.
    *
    * @param index The specified position to remove the element from
    * @return E The element removed from the list
    * @throws IndexOutOfBoundsException Throws exception if the index
    *         is negative or greater than or equal to the size
    */
   public E remove(int index)
   {
      LinkedListNode removed = null;

      if (index < 0 || index >= size())
      {
         throw new IndexOutOfBoundsException("You're incompetent...");
      }

      removed = getNodeAtIndex(index);

      // removed at beginning of list
      if (removed.getPrevious() == null)
      {
         _head = removed.getNext();
      }
      // remove.getPrevious() != null
      // not at beginning, might be at the end or not
      else
      {
         removed.getPrevious().setNext(removed.getNext());
      }

      // removed at end of list
      if (removed.getNext() == null)
      {
         _tail = removed.getPrevious();
      }
      // remove.getNext() != null
      // not at end, might be at the beginning or not
      else
      {
         removed.getNext().setPrevious(removed.getPrevious());
      }

      _size--;
      return removed.getValue();
   }

   /**
    * Replaces the element at the specified index in the list with the
    * specified element. Returns the element that was previous stored
    * at the specified index.
    *
    * Make sure to store the old value (the element to return) before
    * replacing it with the specified element. Makes use of the
    * getNodeAtIndex private helper method to find the node at the
    * specified index.
    *
    * @param index Index of element to replace
    * @param element Element to be stored at specified index
    * @return E The element previously stored at the specified
    *         index
    * @throws IndexOutOfBoundsException Throws exception if the index
    *         is negative or greater than or equal to the size
    */
   public E set(int index, E element)
   {
      E oldValue = null;
      LinkedListNode node = null;

      if (index < 0 || index >= size())
      {
         throw new IndexOutOfBoundsException("Wowwwww...");
      }

      node = getNodeAtIndex(index);
      oldValue = node.getValue();
      node.setValue(element);
      return oldValue;
   }

   /**
    * Returns the number of elements in the list or the size.
    *
    * @return int The number of elements in the list (size).
    */
   public int size()
   {
      return _size;
   }

   /**
    * Returns a new constructed iterator with the boolean false. False
    * indicates that the iterator to be returned is not a reverse
    * iterator.
    *
    * @return Newly constructed iterator (forward iteration)
    */
   public Iterator<E> iterator()
   {
      return new LinkedListIterator(false);
   }

   /**
    * Returns a new constructed iterator with the boolean true. True
    * indicates that the iterator to be returned is a reverse iterator.
    *
    * @return Newly constructed iterator (reverse iteration)
    */
   public Iterator<E> reverseIterator()
   {
      return new LinkedListIterator(true);
   }

   /**
    * This LinkedListNode class is an inner class, meaning that the
    * LinkedList class contains this LinkedListNode class.
    */
   class LinkedListNode
   {
      private LinkedListNode _previous;
      private LinkedListNode _next;
      private E _value;

      /**
       * Constructs a new LinkedListNode with all null parameters.
       * Previous, next, and value are all null.
       */
      public LinkedListNode()
      {
         this(null, null, null);
      }

      /**
       * Constructs a new LinkedListNode with one parameter, sets
       * other two to null. Value has a value, while previous and next
       * are null.
       *
       * @param value The value assigned to the node
       */
      public LinkedListNode(E value)
      {
         this(value, null, null);
      }

      /**
       * Constructs a new LinkedListNode with three parameters. None
       * of the parameters are set to null.
       *
       * @param value The value assigned to the node
       * @param prev The previous node of the current node
       * @param next The next node of the current node
       */
      public LinkedListNode(E value, LinkedListNode prev,
                            LinkedListNode next)
      {
         _value = value;
         _previous = prev;
         _next = next;

         // if there is a node before this constructed node
         if (_previous != null)
         {
            _previous.setNext(this);
         }
         // if there is a node after this constructed node
         if (_next != null)
         {
            _next.setPrevious(this);
         }
      }

      /**
       * Returns the value of the current node.
       *
       * @return E The value of the current node
       */
      public E getValue()
      {
         return _value;
      }

      /**
       * Returns the previous node of the current node.
       *
       * @return LinkedListNode The previous node of the current node
       */
      public LinkedListNode getPrevious()
      {
         return _previous;
      }

      /**
       * Returns the next node of the current node.
       *
       * @return LinkedListNode The next node of the current node
       */
      public LinkedListNode getNext()
      {
         return _next;
      }

      /**
       * Sets the value for the node on the one called upon.
       *
       * @param value The value of the current node
       */
      public void setValue(E value)
      {
         _value = value;
      }

      /**
       * Sets the previous node to the node called upon.
       *
       * @param prev The previous node
       */
      public void setPrevious(LinkedListNode prev)
      {
         _previous = prev;
      }

      /**
       * Sets the next node to the node called upon.
       *
       * @param next The next node
       */
      public void setNext(LinkedListNode next)
      {
         _next = next;
      }
   }

   /**
    * This LinkedListIterator class is another inner class. The
    * LinkedList class contains the LinkedListIterator class.
    * Implements the Iterator interface.
    */
   class LinkedListIterator implements Iterator<E>
   {
      // keeping track of current node
      private LinkedListNode _current;
      private boolean _reverse;

      /**
       * Constructs a new LinkedListIterator with the current node
       * set to the tail (last node) if it is reverse, otherwise the
       * current node remains at the head (first node).
       *
       * @param reverse True if it is a reverse iterator,
       *                False if is is a forward iterator
       */
      public LinkedListIterator(boolean reverse)
      {
         _reverse = reverse;

         if (_reverse)
         {
            _current = _tail;
         }
         else
         {
            _current = _head;
         }
      }

      /**
       * Returns true if the iteration has more elements. If the
       * current node is not null, the list has more elements left.
       *
       * @return boolean True if the iteration has more nodes,
       *                 False if the iteration has no more nodes
       */
      public boolean hasNext()
      {
         return _current != null;
      }

      /**
       * Returns the next element in the iteration.
       *
       * If the iteration is going in reverse, iterate backwards, and
       * the new current node becomes the prior node to the current
       * node. If using forward iteration, iterate forwards, and the
       * new current node becomes the next node of the current node.
       *
       * @return E The next element in the iteration
       * @throws NoSuchElementException if hasNext() is not true,
       *         meaning the iteration has no more elements
       */
      public E next()
      {
         E nextElement = null;

         if (!hasNext())
         {
            throw new NoSuchElementException("There is not an element"
                  + "for this position.");
         }
         else
         {
            nextElement = _current.getValue();
         }

         if (_reverse)
         {
            _current = _current.getPrevious();
         }
         else
         {
            _current = _current.getNext();
         }
         return nextElement;
      }
   }

   /**
    * Private helper method returns the node at the specified index.
    *
    * Starts at head and goes through the list until the node at the
    * specified index is found.
    *
    * @param index The specified index of the node
    * @return LinkedListNode The node at the specified index
    * @throws IndexOutOfBoundsException Throws exception if the index
    *         is negative or greater than or equal to the size
    */
   private LinkedListNode getNodeAtIndex(int index)
   {
      LinkedListNode currentNode = _head;

      if (index < 0 || index >= size())
      {
         throw new IndexOutOfBoundsException("I thought you were"
               + "better than this.");
      }

      for (int i = 0; i < index; i++)
      {
         currentNode = currentNode.getNext();
      }
      return currentNode;
   }
}