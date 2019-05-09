import java.util.*;
public class Main {
    public static List generate_list()
    {   Random rand=new Random();
        int dimension = 10;
        List<Integer> list=new ArrayList<Integer>();
        System.out.print("Dimension of list is "+dimension+"\n");
            for (int i = 1; i <= dimension; i++) {

                list.add(i);

                System.out.print(i + " ");
            }
            Collections.shuffle(list);
        return list;
    }

    public static List<Integer> delete_element( List<Integer> list){


        int length=list.size();
        Random rand=new Random();
        int position = rand.nextInt(length);
        System.out.print("\nPosition of deleted element is "+(position+1));
        int deleted_number=list.get(position);
        list.remove(position);
        System.out.println("\nModified list : " + list);
        System.out.println("Deleted element is "+ deleted_number);


        return list;
    }
    public static void algoritm()
    {
        List<Integer> list;
        list=generate_list();
        int sum1=0;
        int size=list.size();
        sum1=(size*(size+1))/2;
        //System.out.print("suma1 "+sum1);
        int sum2=0;
        delete_element(list);
        for(int i=0;i<list.size();i++)
        {
            sum2=sum2+list.get(i);
        }
       // System.out.print("suma2 "+sum2);
        System.out.print("\nNumber deleted is: "+(sum1-sum2));
    }
    public static void main(String[] args){
        algoritm();
    }
}
