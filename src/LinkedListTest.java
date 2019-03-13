

public class LinkedListTest
{

   public static void main(String[] args)
   {
      LinkedList<String> list = new LinkedList<>();
      /*for (int i = 0; i <= 10; i++)
      {
         list.add(i);
      } */
      
      // adding when there is nothing
      //list.add(0, 9);
      //System.out.println(list);
      
      // adding to end
      list.add("Lydia");
      list.add("Lydia");
      list.add("Ben");
      list.add("Matt");
      list.add("Carlee");
      list.add("Joseph");
      list.add("Lydia");
      System.out.println(list);
      
      // list.set(2, 16);
      // System.out.println(list.get(0));
      
      list.remove(0);
      System.out.println(list);
      
      //System.out.println(list);
      
      // adding to middle
      /*list.add(2, 2);
      list.add(2, 16);
      
      adding to beginning
      list.add(0, -145);
      list.add(0, 32); */
      
      //System.out.println("Before removal: " + list);
      
      // remove from beginning
      // list.remove(0);
      // list.remove(0);
      
      // remove from end
      // list.remove(6);
      // list.remove(5);
      
      // remove from middle
      //list.remove(4);
      
      //System.out.println("After removal: " + list);
      
      /*LinkedList<Integer> list2 = new LinkedList<>();
      // null pointer exception when there's nothing in it
      list2.remove(0);
      
      System.out.println(list2); */
      
      
      // TO STRING METHOD
      /*public String toString()
      {
         String listString = "";
         LinkedListNode current = _head;
         while (current != null)
         {
            listString += current.getValue();
            if (current.getNext() != null)
            {
               listString += ", ";
            }
            current = current.getNext();
         }
         return listString; 
      } */
      
   }
   
   // ASK ABOUT node variable in set method
}
