import java.math.BigDecimal;

public class Main { //Main should be CompoundInterestCalc but the file has to be call that too, not Main.java
    public static BigDecimal calculate(String principle, String rate, int period, String contribution){
        //Balance(Y) = P(1+r)^Y = c[ ((1+r)^Y -1) / r ]
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(period); // (1+r)^period
//        BigDecimal b = a.multiply(new BigDecimal(period)); // (1+r)Y
        BigDecimal c = a.subtract(BigDecimal.ONE); // (1+r)^period-1)
        BigDecimal d = c.divide(new BigDecimal(rate)); // ((1+r)^period-1) / r
        BigDecimal e = d.multiply(new BigDecimal(contribution)); // c[ ((1+r)^period-1) / r ]
        BigDecimal f = a.multiply(new BigDecimal(principle)); // P(1+r)^period
        BigDecimal g = f.add(e);
        return g;
    }

    public static void main(String[] args) {
        BigDecimal balance = Main.calculate("10000", ".08", 10, "1000");
        System.out.println(balance);
    }
}