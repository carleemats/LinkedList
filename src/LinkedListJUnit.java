import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//Jack's test but changed

public class LinkedListJUnit
{

   public static void main(String[] args)
   {
      LinkedList<Integer> list = new LinkedList<>();
      
      // run tests
      org.junit.runner.JUnitCore.main("LinkedListJUnit");
   }
   
   @Test
   public void testNewLinkedList()
   {
       LinkedList<String> StringList = new LinkedList<>();
       LinkedList<Integer> IntegerList = new LinkedList<>();

       assertThat(StringList, notNullValue());
       assertThat(StringList, instanceOf(LinkedList.class));
       assertThat(IntegerList, notNullValue());
       assertThat(IntegerList, instanceOf(LinkedList.class));
   }

   @Test
   public void testNewLinkedList_givenCapacity()
   {
       // Requires working size() method
       int size = 4;
       LinkedList<String> StringList = new LinkedList<>();

       assertThat(StringList, notNullValue());
       assertThat(StringList, instanceOf(LinkedList.class));
       assertThat(0, equalTo(StringList.size()));
   }

   /*@Test (expected = IllegalArgumentException.class)
   public void testNewLinkedList_givenNegativeCapacity()
   {
       new LinkedList<String>(-2);
   } */

   @Test
   public void testAdd_element_index()
   {
       // Requires working size() method
       int size;

       String s1 = "";
       String s2 = "hgr";
       String s3 = "gfsd";

       LinkedList<String> l = new LinkedList<>();

       size = l.size();
       l.add(0, s1);
       assertThat(size + 1, equalTo(l.size()));

       size = l.size();
       l.add(1, s2);
       assertThat(size + 1, equalTo(l.size()));

       size = l.size();
       l.add(1, s3);
       assertThat(size + 1, equalTo(l.size()));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testAdd_element_negIndex()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add(-1, "string");
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testAdd_element_indexTooBig()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add(10, "string");
   }

   @Test
   public void testAdd_multiplier_initialSizeZero()
   {
       // Requires working size() method
       LinkedList<String> l = new LinkedList();

       assertThat(l.size(), equalTo(0));

       l.add("");

       assertThat(l.size(), equalTo(1));
   }

   @Test
   public void testAdd_allowsNullElement()
   {
       LinkedList<Object> l = new LinkedList<>();

       l.add(null);
       l.add(0, null);
   }

   @Test
   public void testClear()
   {
       // Requires working size() method
       LinkedList<String> l = new LinkedList<>();

       l.add("");
       l.add("");
       l.add("");

       assertThat(l.size(), equalTo(3));

       l.clear();

       assertThat(l.size(), equalTo(0));
   }

   @Test
   public void testGet()
   {
       String s0 = "tf";
       String s1 = "hge";
       String s2 = "hrte";

       LinkedList<String> l = new LinkedList<>();

       l.add(s0);
       l.add(s1);
       l.add(s2);

       assertThat(s0, equalTo(l.get(0)));
       assertThat(s1, equalTo(l.get(1)));
       assertThat(s2, equalTo(l.get(2)));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testGet_negativeIndex()
   {
       LinkedList<String> l = new LinkedList<>();

       l.get(-1);
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testGet_indexOutOfBounds()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("g");

       l.get(1);
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testGet_emptyArray()
   {
       LinkedList<String> l = new LinkedList<>();

       l.get(0);
   }

   @Test
   public void testIndexOf()
   {
       LinkedList<Integer> l = new LinkedList<>();

       for (int i = 0; i < 10000; i++)
       {
           l.add(i);
           assertThat(l.indexOf(i), equalTo(i));
       }
   }

   @Test
   public void testIndexOf_elementNotFound()
   {
       LinkedList<Integer> l = new LinkedList<>();

       for (int i = 0; i < 1000; i ++)
       {
           l.add(i);
       }

       int index = l.indexOf(1001);

       assertThat(index, equalTo(-1));
   }

   @Test
   public void testIndexOf_allowsNullElementSearch()
   {
       LinkedList<Integer> l = new LinkedList<>();

       l.add(1);

       assertThat(l.indexOf(null), equalTo(-1));
   }

   @Test
   public void testIndexOf_allowsNullElementFound()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.add(null);

       l.add("gf");

       assertThat(l.indexOf(null), equalTo(1));
   }

   @Test
   public void testIsEmpty()
   {
       // Requires working add function
       LinkedList<String> l = new LinkedList<>();

       assertTrue(l.isEmpty());

       l.add("");

       assertFalse(l.isEmpty());
   }

   @Test
   public void testRemove()
   {
       // Requires working add() and size() methods
       LinkedList<String> l = new LinkedList<>();
       int size;

       l.add("");

       size = l.size();

       l.remove(0);

       assertThat(size, equalTo(1));
       assertThat(l.size(), equalTo(0));
       assertTrue(l.size() < size);
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testRemove_negativeIndex()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.remove(-1);
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testRemove_indexTooBig()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.remove(1);
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testRemove_emptyArray()
   {
       LinkedList<String> l = new LinkedList<>();

       l.remove(0);
   }

   @Test
   public void testSet()
   {
       // Requires working add() and get() methods
       LinkedList<String> l = new LinkedList<>();
       int size;

       l.add("543");
       l.add("ytr");
       l.add("654");

       String t = "t";
       size = l.size();

       l.set(1, t);

       assertThat(t, equalTo(l.get(1)));
       assertThat(size, equalTo(l.size()));
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testSet_negativeIndex()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.set(-1, "");
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testSet_indexTooBig()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.set(1, "hgfd");
   }

   @Test (expected = IndexOutOfBoundsException.class)
   public void testSet_emptyArray()
   {
       LinkedList<Integer> l = new LinkedList<>();

       l.set(0, 0);
   }

   @Test
   public void testSet_allowsNullElement()
   {
       LinkedList<String> l = new LinkedList<>();

       l.add("");

       l.set(0, null);
   }

   @Test
   public void testSize()
   {
       // Requires working add() method
       LinkedList<Integer> l = new LinkedList<>();

       for (int i = 0; i < 10000; i ++)
       {
           assertThat(l.size(), equalTo(i));

           l.add(i);
       }
   }

}
