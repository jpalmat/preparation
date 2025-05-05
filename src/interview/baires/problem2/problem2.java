package interview.baires.problem2;

public class problem2 {
    public static String transformDurationToText(int totalSeconds) {
        if (totalSeconds == 0) {
            return "now";
        }

        int[] timeUnits = {365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1};
        String[] unitNames = {"year", "day", "hour", "minute", "second"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < timeUnits.length; i++) {
            int unitValue = timeUnits[i];
            int numberOfUnits = totalSeconds / unitValue; 
            totalSeconds %= unitValue;                   

            if (numberOfUnits > 0) {
                result.append(numberOfUnits).append(" ").append(unitNames[i]);
                if (numberOfUnits > 1) {
                    result.append("s");
                }

                if (totalSeconds > 0) {
                    if (i < timeUnits.length - 2) {
                        result.append(", "); 
                    } else {
                        result.append(" and "); 
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(transformDurationToText(62));
    }
}
