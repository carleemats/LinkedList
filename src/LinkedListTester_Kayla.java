import java.util.Iterator;

public class LinkedListTester_Kayla
{
   public static void main(String args[]) {
      testAdd1();
      testAdd2();
      testGet();
      testClearAndIsEmpty();
      testIndexOf();
      testRemove();
      testSize();
      //testReallyBig();
      testSet();
      testIterator();
      testReverseIterator();
   }

   
   public static void testAdd1() {
      LinkedList<String> list = new LinkedList<String>();
      boolean passed;
      String string0 = "yo";
      String string1 = "blah";
      String string2 = "hghghgh";
      String string3 = "ourrertep";
      list.add(string0);
      String get0 = list.get(0);
      list.add(string1);
      String get1 = list.get(1);
      list.add(string2);
      list.add(string3);
      String get2 = list.get(2);
      String get3 = list.get(3);
      passed = ((string0 == get0) && (string1 == get1) && (string2 == get2) && (string3 == get3));
      test(passed, "testAdd1");
   }
   
   
   private static void testAdd2() {
      LinkedList<String> list = new LinkedList<String>();
      String ben = "Ben";
      String sorrel = "Sorrel";
      String firedrake = "Firedrake";
      String barnabas = "Barnabas";
      String gilbert = "Gilbert Grauschwanz";
      String lola = "Lola";
      boolean happy1 = false;
      boolean happy2 = false;
      boolean passed;
      list.add(0, ben);
      list.add(1, sorrel);
      list.add(1, firedrake);
      list.add(barnabas);
      try {
         list.add(5, gilbert);
      }
      catch (IndexOutOfBoundsException e) {
         happy1 = true;
      }
      try {
         list.add(-1, gilbert);
      }
      catch (IndexOutOfBoundsException e) {
         happy2 = true;
      }
      list.add(0, lola);
      passed = (happy1 && happy2 && (list.get(0) == lola) && (list.get(1) == ben) && (list.get(2) == firedrake) && (list.get(3) == sorrel) && (list.get(4) == barnabas));
      test(passed, "testAdd2");
   }

   
   private static void testGet() {
      LinkedList<String> list = new LinkedList<String>();
      String ben = "Ben";
      String sorrel = "Sorrel";
      String firedrake = "Firedrake";
      String barnabas = "Barnabas";
      boolean happy1 = false;
      boolean happy2 = false;
      boolean passed;
      list.add(0, ben);
      list.add(1, sorrel);
      list.add(1, firedrake);
      list.add(3, barnabas);
      try {
         list.get(4);
      }
      catch (IndexOutOfBoundsException e) {
         happy1 = true;
      }
      try {
         list.get(-1);
      }
      catch (IndexOutOfBoundsException e) {
         happy2 = true;
      }
      passed = (happy1 && happy2 && (list.get(0) == ben) && (list.get(1) == firedrake) && (list.get(2) == sorrel) && (list.get(3) == barnabas));
      test(passed, "testGet");
   }

   private static void testClearAndIsEmpty() {
      LinkedList<String> list = new LinkedList<String>();
      String ben = "Ben";
      String sorrel = "Sorrel";
      String firedrake = "Firedrake";
      String barnabas = "Barnabas";
      String rosa = "Rosa";
      boolean happy1 = false;
      boolean happy2 = false;
      boolean happy3 = false;
      list.add(0, ben);
      list.add(1, sorrel);
      list.add(1, firedrake);
      list.add(3, barnabas);
      list.add(3, rosa);
      happy1 = ((list.get(0) == ben) && (list.get(1) == firedrake) && (list.get(2) == sorrel) && (list.get(3) == rosa) && (list.get(4) == barnabas) && (list.isEmpty() == false));
      list.clear();
      happy2 = list.isEmpty();
      list.add(sorrel);
      list.add(barnabas);
      happy3 = ((list.get(0) == sorrel) && (list.get(1) == barnabas) && (list.isEmpty() == false));
      test(happy1 && happy2 && happy3, "testClearAndIsEmpty");
   }

   private static void testIndexOf() {
      LinkedList<String> list = new LinkedList<String>();
      String rosa = "Rosaaaa";
      String sorrel = "Sorrel";
      String firedrake = "Firedrake";
      String vita = "Vita Wiesengrund";
      String maya = "Maya";
      String rosa2 = "Rosaaaa";
      String sadness = null;
      list.add(sorrel);
      list.add(vita);
      list.add(0, rosa);
      list.add(2, firedrake);
      list.add(sadness);
      list.add(rosa2);
      boolean passed = false;
      
      
      passed = ((list.indexOf(maya) == -1) && (list.indexOf(rosa) == 0)
            && (list.indexOf(sorrel) == 1) && (list.indexOf(firedrake) == 2)
            && (list.indexOf(vita) == 3) && (list.indexOf(sadness) == 4) &&
            (list.indexOf(rosa2) == 0) && (list.size() == 6));
      
      
      test(passed, "testIndexOf");
   }

   private static void testRemove() {
      LinkedList<String> list = new LinkedList<String>();
      String septimus = "Boy 412";
      String wolfBoy = "Mandy Marwick";
      String hunter = "Gerald";
      String zelda = "Keeper";
      String silas = "ordinary wizard";
      String alther = "ghost";
      list.add(wolfBoy);
      list.add(0, septimus);
      list.add(2, zelda);
      list.add(silas);
      list.add(2, hunter);
      list.add(5, alther);
      list.remove(3);
      boolean happy1 = ((list.get(0) == septimus) && (list.get(1) == wolfBoy) && (list.get(2) == hunter) && (list.get(3) == silas) && (list.get(4) == alther) && (list.size() == 5));
      list.remove(0);
      boolean happy2 = ((list.get(0) == wolfBoy) && (list.get(1) == hunter) && (list.get(2) == silas) && (list.get(3) == alther) && (list.size() == 4));
      list.remove(3);
      boolean happy3 = ((list.get(0) == wolfBoy) && (list.get(1) == hunter) && (list.get(2) == silas) && (list.size() == 3));
      list.add(silas);
      boolean happy4 = ((list.get(0) == wolfBoy) && (list.get(1) == hunter) && (list.get(2) == silas) && (list.get(3) == silas) && (list.size() == 4));
      boolean happy5 = false;
      boolean happy6 = false;
      try {
         list.remove(5);
      }
      catch (IndexOutOfBoundsException e) {
         happy5 = true;
      }
      try {
         list.remove(-1);
      }
      catch (IndexOutOfBoundsException e) {
         happy6 = true;
      }
      list.remove(0);
      list.remove(0);
      list.remove(0);
      list.remove(0);
      boolean happy7 = list.isEmpty();
      list.add(silas);
      boolean happy8 = (list.size() == 1);
      test(happy1 && happy2 && happy3 && happy4 && happy5 && happy6 && happy7 && happy8, "testRemove");
   }

   private static void testSize() {
      LinkedList<String> list = new LinkedList<String>();
      String marcia = "Extra-Ordinary Wizard";
      String beetle = "Cheif Front Office and Inspection Clerk";
      String sam = "Sam";
      String simon = "Simon";
      String edd = "Edd";
      String erik = "Erik";
      boolean happy = true;
      happy &= (list.size() == 0);
      list.add(sam);
      happy &= (list.size() == 1);
      list.add(0, beetle);
      list.add(0, marcia);
      happy &= (list.size() == 3);
      list.add(edd);
      list.add(list.size(), erik);
      list.add(3, simon);
      happy &= ((list.size() == 6) && (list.get(0) == marcia) && (list.get(1) == beetle) && (list.get(2) == sam) && (list.get(3) == simon) && (list.get(4) == edd) && (list.get(5) == erik));
      list.remove(list.indexOf(simon));
      happy &= (list.size() == 5);
      test(happy, "testSize");
   }

   private static void testSet() {
      LinkedList<String> list = new LinkedList<String>();
      String ellis = "Ellis Crackle";
      String terry = "Terry Tarsal";
      String alice = "Alice Nettles";
      String barney = "Barney Pott";
      String hugo = "Hugo";
      String syrah = "Syrah Syara";
      list.add(ellis);
      list.add(terry);
      list.add(alice);
      boolean happy1 = ((list.size() == 3) && (list.get(0) == ellis) && (list.get(1) == terry) && (list.get(2) == alice));
      list.set(1, barney);
      boolean happy2 = ((list.size() == 3) && (list.get(0) == ellis) && (list.get(1) == barney) && (list.get(2) == alice));
      list.set(0,  hugo);
      boolean happy3 = ((list.size() == 3) && (list.get(0) == hugo) && (list.get(1) == barney) && (list.get(2) == alice));
      list.set(2, syrah);
      boolean happy4 = ((list.size() == 3) && (list.get(0) == hugo) && (list.get(1) == barney) && (list.get(2) == syrah));
      test(happy1 && happy2 && happy3 && happy4, "testSet");
   }

   private static void testIterator() {
      LinkedList<String> list = new LinkedList<String>();
      String morwenna = "Morwenna Mould";
      String marissa = "Marissa";
      String jojo = "Jo-Jo";
      String nicko = "Nik";
      String together = morwenna + marissa + jojo + nicko;
      String makeTogether = "";
      list.add(morwenna);
      list.add(marissa);
      list.add(jojo);
      list.add(nicko);
      Iterator<String> iter = list.iterator();
      while (iter.hasNext()) {
         makeTogether = makeTogether + iter.next();
      }
      boolean passed = makeTogether.equals(together);
      test(passed, "testIterator");
   }

   private static void testReverseIterator() {
      LinkedList<String> list = new LinkedList<String>();
      String betty = "Betty Crackle";
      String domDaniel = "DomDaniel";
      String larde = "Umbrella?";
      String sally = "Sally Mullin";
      String together = sally + larde + domDaniel + betty;
      String makeTogether = "";
      list.add(betty);
      list.add(domDaniel);
      list.add(larde);
      list.add(sally);
      Iterator<String> iter = list.reverseIterator();
      while (iter.hasNext()) {
         makeTogether = makeTogether + iter.next();
      }
      boolean passed = makeTogether.equals(together);
      test(passed, "testReverseIterator");
   }

   private static void testReallyBig() {
      LinkedList<String> list = new LinkedList<String>();
      for (int i = 0; i < Integer.MAX_VALUE - 10000; i++) {
         list.add(null);
      }
   }

   private static void test(boolean passed, String testName) {
      if (passed) {
         System.out.println(testName + " passed! :)");
      }
      else {
         System.out.println(testName + " failed!!!! :( :( :(");
      }
   }
}
