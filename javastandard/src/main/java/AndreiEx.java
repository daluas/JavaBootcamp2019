import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AndreiEx {

    // Ex. 1
    private static int numberNearestTen(int x, int y) {
        int nearX = Math.abs(x - 10);
        int nearY = Math.abs(y - 10);
        if(nearX < nearY) {
            return x;
        } else if (nearX > nearY) {
            return y;
        }
        return 0;
    }

    // Ex. 2
    private static String largerString(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for(int i = 0; i < n - 1; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    // Ex. 3
    private static String removeXExceptBeginAndEnd(String string) {
        String substring = string.substring(1, string.length() - 1).replace("x", "");
        return String.valueOf(string.charAt(0)) +
                substring +
                string.charAt(string.length() - 1);
    }

    private static List<Integer> generateList(int size) {
        List<Integer> indexes;
        List<Integer> result;
        Random random = new Random();

        indexes = generateIndexesList(size);

        result = createRandomList(size, indexes, random);

        return result;
    }

    private static List<Integer> generateIndexesList(int size) {
        List<Integer> indexes = new LinkedList<>();
        for(int i = 1; i <= size; i++) {
            indexes.add(i);
        }
        return indexes;
    }

    private static List<Integer> createRandomList(int size, List<Integer> indexes, Random random) {
        List<Integer> result = new ArrayList<>();
        int sizeArray = indexes.size();
        for(int i = 1; i <= size - 1; i++) {
            int index = random.nextInt(sizeArray);
            result.add(indexes.get(index));
            indexes.remove(index);
            sizeArray--;
        }
        return result;
    }

    // Ex. 4
    private static int findMissingInteger(int size) {
        List<Integer> randomNumbers = generateList(size);
        System.out.println("Generated List: " + randomNumbers);
        int missingNumber = size * (size + 1)/2;
        for(int number : randomNumbers) {
            missingNumber -= number;
        }

        return missingNumber;
    }

    // Ex. 5 palindrom
    private static boolean isPalindrom(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(string.length() - i - 1));
        }
        System.out.println("String: " + string + " ---> " + stringBuilder.toString());
        return stringBuilder.toString().equals(string);
    }

    public static void main(String[] args) {
        System.out.println("Ex1: \n" + numberNearestTen(5, 17) + '\n' +
                numberNearestTen(10, -10) + '\n');
        System.out.println("Ex2: \n" + largerString("Hi", 1)  + '\n' +
                largerString("Hello", 3) + '\n');
        System.out.println("Ex3: \n" + removeXExceptBeginAndEnd("xxHxix") + '\n' +
                removeXExceptBeginAndEnd("abxxxcd") + '\n' +
                removeXExceptBeginAndEnd("xabxxxcdx") + '\n');
        System.out.println("Ex4: \n" + findMissingInteger(10) + '\n' +
                findMissingInteger(100) + '\n');
        System.out.println("Ex5: \n" + isPalindrom("aba") + '\n' +
                isPalindrom("abc") + '\n');
    }
}
