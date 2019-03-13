import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

// combine with Ben & Matt

// TAKE PUBLIC OUT OF INNER CLASS LINKEDLISTNODE!!!!!!!!!!!!
// TAKE TOSTRING METHOD OUT TOO!

public class LinkedListJUnit2
{
   public static void main(String[] args)
   {
      org.junit.runner.JUnitCore.main("LinkedListTester");
   }
   
   //
   // MATT
   //
   
   private static LinkedList<String> testString;
   private static LinkedList<Integer> testInteger;

   @BeforeClass
      public static void setUpClass() {
      testString = new LinkedList<String>();
      testInteger = new LinkedList<Integer>();
   }
   
   @Test
   public void testConstructor() {
      assertThat(testString, notNullValue());
      assertThat(testInteger, notNullValue());
   
   }
   
   @Test
   public void testAddWithoutIndex() {
      // construct new LinkedLists
      LinkedList<String> testString1 = new LinkedList<>();
      LinkedList<Integer> testInteger1 = new LinkedList<>();
   
      // assert theyre true
      assertThat(testInteger1.add(1), equalTo(true));
      assertThat(testInteger1.add(3), equalTo(true));
      assertThat(testString1.add("firstString"), equalTo(true));
   
      // print all the elements
      for (String i :testString)
         System.out.println(i);
      for (int j : testInteger)
         System.out.println(j);
   }
   
   @Test
   public void testAddWithIndex() {
      // construct new LinkedLists
      LinkedList<String> testString2 = new LinkedList<>();
      LinkedList<Integer> testInteger2 = new LinkedList<>();
      // add some values
      testString2.add(0, "hi");
      testString2.add(1, "bye");
      testString2.add(2, "gb");
      testString2.add(3, "hll");
   
      testInteger2.add(0,0);
      testInteger2.add(1,1);
      testInteger2.add(2,2);
      testInteger2.add(3,3);
   
      // test String
      assertThat(testString2.get(0), equalTo("hi"));
      assertThat(testString2.get(1), equalTo("bye"));
      assertThat(testString2.get(2), equalTo("gb"));
      assertThat(testString2.get(3), equalTo("hll"));
      // test Integer
      assertThat(testInteger2.get(0), equalTo(0));
      assertThat(testInteger2.get(1), equalTo(1));
      assertThat(testInteger2.get(2), equalTo(2));
   }
   
   @Test
   public void addAtIndexZero() {
      LinkedList<Integer> testInt3 = new LinkedList<>();
      // add at index 0
      testInt3.add(0, 0);
      testInt3.add(1, 34);
      testInt3.add(2, 400);
      testInt3.add(0, 500);
      testInt3.add(0, 600);
      testInt3.add(0, 700);
      testInt3.add(0, 800);
      // the first should be 800 and index 2 should be 600
      assertThat(testInt3.get(0), equalTo(800));
      assertThat(testInt3.get(2), equalTo(600));
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void addOutOfRange() {
      LinkedList<String> testString4 = new LinkedList<>();
      testString4.add(500, "outRange");
   }
   
   /*
   @Test(expected = OutOfMemoryError.class)
   public void addMaxAmountPlusOne() {
      LinkedList<Integer> testInt5 = new LinkedList<>();
      for (int i = 0; i < 2147483647; i++) {
         testInt5.add(i);
      }
   }*/
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void testClear() {
      LinkedList<Integer> testInt6 = new LinkedList<>();
      for(int i = 0; i < 100; i++) {
         testInt6.add(i);
      }
      // clear the LinkedList
      testInt6.clear();
      // assert the head equals 0
      assertThat(testInt6.get(0), equalTo(null));
   }
    
   @Test
   public void testGet() {
      LinkedList<Integer> testInt7 = new LinkedList<>();
      testInt7.add(0, 0);
      testInt7.add(1, 34);
      testInt7.add(2, 400);
      testInt7.add(3, 500);
      testInt7.add(4, 600);
      testInt7.add(5, 700);
      testInt7.add(6, 800);
     
      // get specific element
      assertThat(testInt7.get(0), equalTo(0));
      assertThat(testInt7.get(1), equalTo(34));
      assertThat(testInt7.get(4), equalTo(600));
      assertThat(testInt7.get(6), equalTo(800));
   }

   
   //
   // BEN
   //
   
   @Test
   public void TestIndexOf()
   {
      LinkedList<String> list = new LinkedList<>();
      
      list.add("Thing1");
      list.add("Thing2");
      list.add("Thing3");
      
      list.remove(0);
      assertThat(list.indexOf("Thing3"), equalTo(1));
      assertThat(list.indexOf("Thing1"), equalTo(-1));
      assertThat(list.size(), equalTo(2));
      
      list.add(null);
      assertThat(list.indexOf(null), equalTo(2));
   }
   
   @Test
   public void TestIsEmpty()
   {
      LinkedList<String> list = new LinkedList<>();
      assertThat(list.isEmpty(), equalTo(true));
      for (int i = 0; i < 10; i++)
         list.add("Thing1");
      assertThat(list.isEmpty(), equalTo(false));
      for (int i = 0; i < 10; i++)
         list.remove(0);
      assertThat(list.isEmpty(), equalTo(true));
   }
   
   @Test
   public void TestRemove()
   {
      LinkedList<String> list = new LinkedList<>();
      list.add("Thing 1");
      list.add("Thing 2");
      list.add("Thing 3");
      list.add("Thing 4");
      
      // Test end
      assertThat(list.remove(3), equalTo("Thing 4"));
      // Test middle
      assertThat(list.remove(1), equalTo("Thing 2"));
      // Test beginning
      assertThat(list.remove(0), equalTo("Thing 1"));
      // Test only
      assertThat(list.remove(0), equalTo("Thing 3"));
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void TestRemoveNegative()
   {
      LinkedList<String> list = new LinkedList<>();
      list.add("Thing1");
      list.add("Thing2");
      list.remove(-1);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void TestRemoveTooMuch()
   {
      LinkedList<String> list = new LinkedList<>();
      list.add("Thing1");
      list.add("Thing2");
      list.remove(10);
   }
   
   @Test
   public void TestSet()
   {
      LinkedList<String> list = new LinkedList<>();
      
      for (int i = 0; i < 10; i++)
      {
         list.add("Thing" + (i + 1));
      }
      for (int i = 0; i < 10; i++)
      {
         list.set(i, "OtherThing" + (i + 1));
      }
      for (int i = 0; i < 10; i++)
      {
         assertThat(list.get(i), equalTo("OtherThing" + (i + 1)));
      }
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void TestSetNegative()
   {
      LinkedList<String> list = new LinkedList<>();
      list.add("Thing1");
      list.add("Thing2");
      list.set(-10000, "New Thing");
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void TestSetTooBig()
   {
      LinkedList<String> list = new LinkedList<>();
      list.add("Thing1");
      list.add("Thing2");
      list.set(10000, "New Thing");
   }
   
   @Test
   public void TestSize()
   {
      LinkedList<String> list = new LinkedList<>();
      assertThat(list.size(), equalTo(0));
      for (int i = 0; i < 10; i++)
         list.add("Thing1");
      assertThat(list.size(), equalTo(10));
      for (int i = 0; i < 10; i++)
         list.remove(0);
      assertThat(list.size(), equalTo(0));
   }
   
   @Test
   public void TestIterator()
   {
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      int j = 0;
      for (String s : list)
      {
         assertThat(s, equalTo("Thing" + j));
         j++;
      }
   }
   
   @Test
   public void TestIteratorNextAndHasNext()
   {
      LinkedList<String> list2 = new LinkedList<>();
      Iterator<String> it2 = list2.iterator();
      assertThat(it2.hasNext(), equalTo(false));
      
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      Iterator<String> it = list.iterator();
      for (int i = 0; i < 10; i++)
      {
         assertThat(it.hasNext(), equalTo(true));
         assertThat(it.next(), equalTo("Thing" + i));
      }
      assertThat(it.hasNext(), equalTo(false));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void TestIteratorNextOutOfBounds()
   {
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      Iterator<String> it = list.iterator();
      for (int i = 0; i < 10; i++)
      {
         assertThat(it.hasNext(), equalTo(true));
         assertThat(it.next(), equalTo("Thing" + i));
      }
      assertThat(it.hasNext(), equalTo(false));
      it.next();
   }
   
   @Test
   public void TestReverseIterator()
   {
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      int j = 9;
      Iterator<String> rit = list.reverseIterator();
      while (rit.hasNext())
      {
         assertThat(rit.next(), equalTo("Thing" + j));
         j--;
      }
   }
   
   @Test
   public void TestReverseIteratorNextAndHasNext()
   {
      LinkedList<String> list2 = new LinkedList<>();
      Iterator<String> it2 = list2.reverseIterator();
      assertThat(it2.hasNext(), equalTo(false));
      
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      Iterator<String> rit = list.reverseIterator();
      for (int i = 9; i >= 0; i--)
      {
         assertThat(rit.hasNext(), equalTo(true));
         assertThat(rit.next(), equalTo("Thing" + i));
      }
      assertThat(rit.hasNext(), equalTo(false));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void TestReverseIteratorNextOutOfBounds()
   {
      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < 10; i++)
         list.add("Thing" + i);
      
      Iterator<String> rit = list.reverseIterator();
      for (int i = 9; i >= 0; i--)
      {
         assertThat(rit.hasNext(), equalTo(true));
         assertThat(rit.next(), equalTo("Thing" + i));
      }
      assertThat(rit.hasNext(), equalTo(false));
      rit.next();
   }
   
   //
   // CARLEE
   //
   @Test
   public void test_LinkedListNode()
   {
      LinkedList<Integer> list = new LinkedList<>();
      LinkedList<Integer>.LinkedListNode intNode = list.new LinkedListNode();
      assertThat(intNode, instanceOf(LinkedList.LinkedListNode.class));
      
      LinkedList<String> list2 = new LinkedList<>();
      LinkedList<String>.LinkedListNode stringNode = list2.new LinkedListNode();
      assertThat(stringNode, instanceOf(LinkedList.LinkedListNode.class));
   }
   
   @Test (expected = ClassNotFoundException.class)
   public void alwaysFailsSoRememberToTakeOutPublicFromLinkedListNode()
   {
      // NOTHING! FIX YOUR CODE!
   }
   
   @Test
   public void test_getValue()
   {
      LinkedList<Integer> list = new LinkedList<>();
      LinkedList<Integer>.LinkedListNode intNode = list.new LinkedListNode(0);
      assertThat(intNode.getValue(), equalTo(0));
      
      LinkedList<String> list2 = new LinkedList<>();
      LinkedList<String>.LinkedListNode stringNode = list2.new
            LinkedListNode("Matthew Leland Klein");
      assertThat(stringNode.getValue(), equalTo("Matthew Leland Klein"));
   }
   
   @Test
   public void test_getPrevious_getNext()
   {
      LinkedList<Integer> list = new LinkedList<>();
      LinkedList<Integer>.LinkedListNode intNode1 = list.new
            LinkedListNode(1);
      LinkedList<Integer>.LinkedListNode intNode3 = list.new
            LinkedListNode(3);
      LinkedList<Integer>.LinkedListNode intNode2 = list.new
            LinkedListNode(2, intNode1, intNode3);
      assertThat(intNode2.getPrevious(), equalTo(intNode1));
      assertThat(intNode2.getNext(), equalTo(intNode3));
   }
   
   @Test
   public void test_setValue()
   {
      LinkedList<String> list = new LinkedList<>();
      LinkedList<String>.LinkedListNode stringNode = list.new
            LinkedListNode();
      stringNode.setValue("Ben");
      assertThat(stringNode.getValue(), equalTo("Ben"));
   }
   
   @Test
   public void test_setPrevious_setNext()
   {
      LinkedList<Double> list = new LinkedList<>();
      LinkedList<Double>.LinkedListNode doubNode1 = list.new
            LinkedListNode(456.7);
      LinkedList<Double>.LinkedListNode doubNode3 = list.new
            LinkedListNode(84.523);
      LinkedList<Double>.LinkedListNode doubNode2 = list.new
            LinkedListNode(2.6457, doubNode1, doubNode3);
      doubNode2.setPrevious(doubNode1);
      doubNode2.setNext(doubNode3);
      assertThat(doubNode2.getPrevious().getValue(), equalTo(456.7));
      assertThat(doubNode2.getNext().getValue(), equalTo(84.523));
   }
}
