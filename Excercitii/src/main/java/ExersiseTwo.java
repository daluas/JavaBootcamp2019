import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ExersiseTwo {

    public static Map<String,BiFunction<String,Double,Grades>> factory = new HashMap<>();
    static
    {
        factory.put("Grades",Grades::new);
    }
    public static Random rand = new Random(47);
    public static List<Integer> getDivisors(int x)
    {

       if(x<0)
       {
           x=-x;
       }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=x;i++)
        {
            if(x%i==0)
            {
                list.add(i);
            }
        }
        if(list.isEmpty())
        {
            return null;
        }
        else
        {
            return list;
        }


    }
    public static void numberWithSquare(int first,int second)
    {

        if(first>second)
        {
            System.out.println("Bounds error");
        }
        List<Integer> list;
        int sum;
        int counter=0;
        for(int i=first;i<=second;i++)
        {
            if((list=getDivisors(i))!=null)
            {
               sum = list.stream().mapToInt(x->x*x).sum();
               if(Math.sqrt(sum)==(int)Math.sqrt(sum))
               {
                   System.out.println(i);
                   counter++;
               }

            }
        }
        System.out.println("We found "+counter+" numbers");


    }
public static void verify(List<Student> list)
{

}

    public static void main(String[] args) {


        //TODO NumberWithSquareSumOfSquareDivisorsFinder
        /// Given the limits of an interval, find all numbers in that interval for which the sum of the square of it's divisors is a perfect square
        /// The interval is closed on both ends (the limits should also be checked)
        /// Example:
        /// The divisors of 42 are [1, 2, 3, 6, 7, 14, 21, 42]
        /// The divisors squared are [1, 4, 9, 36, 49, 196, 441, 1764]
        /// The sum of the squared divisors is 2500 which is the perfect square of 50
        /// This means 42 respects the rule

        List<Student> students = new ArrayList<>();

        Student student1 = new Student(22, "Ionel", "Popescu");
        Student student2 = new Student(18, "Mihai", "Ionescu");
        Student student3 = new Student(21, "Ghita", "Muresan");
        Student student4 = new Student(17, "Dorel", "Constructor");

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //TODO Sort the students by age
        //TODO Display only the students that are above 20 years
        //TODO Display only the students that have their lastname ending in escu
        //TODO Create a new Class named Grades with the following members: score and disciplineName. Each Student can have one or more grades at a certain discipline
        //TODO Add grades to the students
        //TODO Create a method that displays the the lastName of the students that have no grade lower than 5.

        System.out.println("======TODO0=====");
        numberWithSquare(-100,-7);

        System.out.println("======TODO1=====");
        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println("======TODO2=====");
        students.stream().filter(student->student.getAge()>20).forEach(System.out::println);
        System.out.println("======TODO3=====");
        students.stream().filter(student -> student.getLastName().matches("[A-Za-z]*escu")).forEach(System.out::println);
        System.out.println("======TODO4=====");


        for(Student stud : students)
        {
            stud.insertGrade(factory.get("Grades").apply("Matematica",(double)rand.nextInt(10)));
        }
        for(Student stud : students)
        {
            stud.insertGrade(factory.get("Grades").apply("Matematica",(double)rand.nextInt(10)));
        }
        System.out.println(students);


        System.out.println("======TODO5=====");


        students.stream().filter(stud->stud.getGradesList().stream().allMatch(grade->grade.getScore()<5)).map(Student::getLastName).forEach(System.out::println);


    }
}