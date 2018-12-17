package eu.georgiospapadopoulos;
/*
Challenge info:
Write a method named canPack with 3 parameters of type int named bigCount, smallCount and
goal.
The parameter bigCount represents the count of big flour bags (5 kilo each).
The parameter smallCount represents the count of small flour bags (1 kilo each).
The parameter goal represents the goal amount of kilos needed to assemble a package.
Therefore, the sum of the kilos of bigCount and smallCount must be at least equal to the
value of goal. The method should return true if it is possible to make a package with
goal kilos of flour.

If the sum is greater than goal, ensure that only full bags are used towards the amount.
For example, if goal = 9 , bigCount =2 and smallCount = 0, the method should return false
because each bigCount bag is 5 kilos and can not be divided. However, if goal =9,
bigCount = 1 and smallCount = 5, the method should return true because 1 full bigCount
bag and 4 full smallCount bags equal goal , and its ok if there are additional bags
left over.
If any of the parameters are negative, return false;
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 12));
        System.out.println(canPack(-3, 2, 12));
    }

    /**
     * Receives count of flour bags of various sizes
     * and calculates if it can create a package of flour, the size of goal.
     *
     * @param bigCount   (int) Number of big flour bags. Each one counts as 5 kilos.
     * @param smallCount (int) Number of small flour bags. Each one counts as 1 kilo.
     * @param goal       (int) Number of flour kilos needed to create a package.
     * @return true if we can create a package of goal kilos, false if not
     * or if a negative number was passed.
     */
    private static boolean canPack(int bigCount, int smallCount, int goal) {

//Check if all parameters are in valid range
        if (bigCount < 0 || smallCount < 0 || goal < 0)
            return false;

        int pack = 0;

        //While we haven't created a pack
        while (pack < goal) {
            //see if a big flour bag can fit in the package
            if (bigCount > 0 && (pack + 5) <= goal) {
                bigCount--;
                pack += 5;

            }
            //see there is a small flour bag left, to add to the package
            else if (smallCount > 0) {
                smallCount--;
                pack += 1;
            }
            //if a big bag won't fit (or doesnt exist) and we dont have enough small bags
            else
                return false;
        }
        return (pack == goal);
    }
}
