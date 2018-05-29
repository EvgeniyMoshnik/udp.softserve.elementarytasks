package elementarytasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Validator {

    static int[] toIntArraySizeBoard(String[] args) throws NumberFormatException {
        int[] arrayArgs = new int[2];
        for (int i = 0; i < args.length; i++) {
            arrayArgs[i] = Integer.parseInt(args[i]);
        }
        return arrayArgs;
    }

    static boolean isSize(int width, int height) {
        return  (width <= 0 || height <= 0);
    }

    static double toDoubleParameter(Scanner scanner, String help) {
        double result;
        scanner.useDelimiter("\n");
        while (!scanner.hasNextDouble()) {
            if (scanner.hasNext("")) {
                System.out.println(help + "\n" +
                        "Please enter again parameter.");
            } else {
                System.out.println("Parameter should be number! \n" +
                        "Please enter again parameter.");
            }
            scanner.next();
        }
        result = scanner.nextDouble();
        return result;
    }

    static boolean isNumberDouble(String number) {
        try {
             Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isNumberInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isContinue(String appContinue) {
        return  (appContinue.equalsIgnoreCase("y") ||
                appContinue.equalsIgnoreCase("yes"));

    }

    static boolean isTriangle(double sideOne, double sideTwo, double sideThree) {
        boolean isTriangle = false;
        if ((sideOne + sideTwo > sideThree) && (sideOne + sideThree > sideTwo && sideTwo + sideThree > sideOne)) {
            isTriangle = true;
        } else {
            System.out.println("This triangle does not exist!");
        }
        return isTriangle;
    }

    static boolean isParamsForTriangle(List<String> params) {
        if (params.size() < 4) {
            return false;
        }
        return  (isNumberDouble(params.get(1)) &&
                isNumberDouble(params.get(2)) &&
                isNumberDouble(params.get(3)));
    }

    static boolean isParams(List<String> params, String help, int notCountParams) {
        if (params.size() <= notCountParams) {
            System.out.println(help);
            return false;
        }
        return true;
    }

}
