import java.util.*;

class Result {

    /*
     * Complete the 'extractErrorLogs' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY logs as parameter.
     */

    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
        List<List<String>> filteredLogs = new ArrayList<>();

        // Step 1: Filter logs with "ERROR" or "CRITICAL" status
        for (List<String> log : logs) {
            String status = log.get(2);  // Status is the 3rd element (0-indexed, split on spaces)
            if (status.equals("ERROR") || status.equals("CRITICAL")) {
                filteredLogs.add(log);
            }
        }

        // Step 2: Sort logs by date and time
        Collections.sort(filteredLogs, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> log1, List<String> log2) {
                // Compare date (format: DD-MM-YYYY)
                String[] date1 = log1.get(0).split("-");
                String[] date2 = log2.get(0).split("-");

                // Compare year, month, and day
                for (int i = 2; i >= 0; i--) {
                    int diff = Integer.parseInt(date1[i]) - Integer.parseInt(date2[i]);
                    if (diff != 0) {
                        return diff;
                    }
                }

                // Compare time (format: HH:MM)
                String[] time1 = log1.get(1).split(":");
                String[] time2 = log2.get(1).split(":");

                int hourDiff = Integer.parseInt(time1[0]) - Integer.parseInt(time2[0]);
                if (hourDiff != 0) {
                    return hourDiff;
                }

                // Compare minutes
                return Integer.parseInt(time1[1]) - Integer.parseInt(time2[1]);
            }
        });

        return filteredLogs;
    }
}