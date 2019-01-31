import java.util.ArrayList;
            import java.util.Arrays;
            import java.util.HashMap;
            import java.util.LinkedList;
            import java.util.Map;
            import java.util.Random;

public class Main {
   private static Map<Integer, Person> people = new HashMap<>();

   public static void main(String[] args) {
      people.put(1, new Person("a", "b"));
      people.put(2, new Person("c", "d"));
      people.put(3, new Person("e", "f"));
      people.put(4, new Person("g", "h"));
      people.put(5, new Person("i", "j"));
      people.put(6, new Person("k", "l"));
      people.put(7, new Person("m", "n"));
      people.put(8, new Person("o", "p"));
      people.put(9, new Person("q", "r"));
      people.put(10, new Person("s", "t"));


      int m = 3;
      int n = people.size() / m;

      ArrayList<ArrayList<Person>> groups = new ArrayList<>(n);
      createGroup(groups, n, m);
      printGroup(groups);

   }

   private static void printGroup(ArrayList<ArrayList<Person>> groups) {
      for (int i = 0; i < groups.size(); i++) {
         System.out.println("");
         System.out.println("\nGroup " + (i + 1) + ":");
         for (int j = 0; j < groups.get(i).size(); j++) {
            System.out.println(groups.get(i).get(j));
         }
      }
   }

   private static void createGroup(ArrayList<ArrayList<Person>> groups, int n, int m) {
      if (people.isEmpty()) {
         throw new RuntimeException("invalid input");
      }
      LinkedList<Object> keys = new LinkedList<>(Arrays.asList(people.keySet().toArray()));
      ArrayList<Person> p = null;
      int index = -1;
      for (int i = 0; i < n; i++) {
         p = new ArrayList<>();
         for (int j = 0; j < m; j++) {
            index = new Random().nextInt(keys.size());
            p.add(people.get(keys.get(index)));
            keys.remove(index);
         }
         groups.add(p);
      }
      while (keys.size() != 0) {
         p = new ArrayList<>();
         index = new Random().nextInt(keys.size());
         Object key = keys.get(index);
         groups.get(new Random().nextInt(n - 1)).add(people.get(key));
         keys.remove(index);
      }

   }
}

class Person {
   private String firstName;
   private String lastName;

   public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   @Override
   public String toString() {
      return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
   }
}
