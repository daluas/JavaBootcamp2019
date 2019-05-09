import java.util.*;
public class Divisor {

    public static List divisor(int number) {

        List<Integer> lista = new ArrayList<Integer>();
        System.out.print("\n" + number + ": ");
        for (int divisors = 1; divisors <= number; divisors++) {

            if (number % divisors == 0) {
                lista.add(divisors);
                System.out.print(divisors + " ");
            }
        }
        return lista;
    }

    public static void calculate_sum(int x, int y){
        List<Integer> divisors_list = new ArrayList<Integer>();
        double square=0;
        for (int i = x; i <= y; i++) {
            divisors_list = divisor(i);
            int sum=0;
            for(int j=0;j<divisors_list.size();j++){

                sum=sum+divisors_list.get(j)*divisors_list.get(j);

            }
            System.out.print("\nSum of the squared divisors for "+i+" is "+sum);
            square=Math.sqrt(sum);
            if(square - Math.floor(square) == 0) System.out.print("\nnumber "+i+" respects the rule");
        }
    }


    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int x = in.nextInt();
         int y = in.nextInt();
         System.out.println("limitele intervalului sunt " + x + " si " + y);
         calculate_sum(x,y);
        }

    }
