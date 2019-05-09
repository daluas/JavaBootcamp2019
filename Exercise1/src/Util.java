import java.util.Optional;

public class Util {

    public static String getNameWithouthLambda(A a) {
        if (a!= null && a.getB() != null && a.getB().getC() != null && a.getB().getC().getD() != null) {
            return a.getB().getC().getD().getName();
        }
        return null;
    }

    public static String getNameWithLambda(A a) {
        return Optional.ofNullable(a)
                .map(A::getB)
                .map(B::getC)
                .map(C::getD)
                .map(D::getName)
                .orElse(null);
    }
}
