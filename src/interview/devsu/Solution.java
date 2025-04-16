package interview.devsu;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Tracks changes between consecutive versions of a document.
     *
     * @param versions An array of document versions (strings) in chronological order.
     * @return An array of change summaries.
     */
    public String[] trackChanges(String[] versions) {
        List<String> summary = new ArrayList<>();
        for (int i = 0; i < versions.length - 1; i++) {
            String v1 = versions[i];
            String v2 = versions[i + 1];

            if (v1.equals(v2)) {
                summary.add("No changes");
            } else {
                String diff = findDifference(v1, v2);
                summary.add(diff);
            }
        }
        return summary.toArray(new String[0]);
    }

    private String findDifference(String s1, String s2) {
        int i = 0;
        int j = 0;
        StringBuilder added = new StringBuilder();
        StringBuilder removed = new StringBuilder();

        while (i < s1.length() || j < s2.length()) {
            if (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else if (i < s1.length() && (j == s2.length() || s1.substring(i + 1).startsWith(s2.substring(j)))) {
                removed.append(s1.charAt(i));
                i++;
            } else if (j < s2.length() && (i == s1.length() || s2.substring(j + 1).startsWith(s1.substring(i)))) {
                added.append(s2.charAt(j));
                j++;
            } else if (i < s1.length() && j < s2.length()) {
                // Handle cases where a simple prefix match doesn't work, indicating both add and remove
                int k = i;
                StringBuilder removedSegment = new StringBuilder();
                while (k < s1.length() && j < s2.length() && s1.charAt(k) != s2.charAt(j)) {
                    removedSegment.append(s1.charAt(k));
                    k++;
                }
                removed.append(removedSegment);

                int l = j;
                StringBuilder addedSegment = new StringBuilder();
                while (l < s2.length() && i < s1.length() && s2.charAt(l) != s1.charAt(i)) {
                    addedSegment.append(s2.charAt(l));
                    l++;
                }
                added.append(addedSegment);

                i = k;
                j = l;
            } else {
                // Should not happen with the problem constraints
                break;
            }
        }

        if (removed.length() > 0 && added.length() > 0) {
            return "-" + removed.toString() + "+" + added.toString();
        } else if (removed.length() > 0) {
            return "-" + removed.toString();
        } else if (added.length() > 0) {
            return "+" + added.toString();
        } else {
            return "No changes"; // Should not reach here if versions are different
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] versions1 = {"abc", "abcd", "abcde", "abcde"};
        String[] changes1 = solution.trackChanges(versions1);
        System.out.print("Input: [");
        for (int i = 0; i < versions1.length; i++) {
            System.out.print("\"" + versions1[i] + "\"");
            if (i < versions1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\nOutput: [");
        for (int i = 0; i < changes1.length; i++) {
            System.out.print("\"" + changes1[i] + "\"");
            if (i < changes1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Expected: ["+d", "+e", "No changes"]

        String[] versions2 = {"hello world", "hello", "hello there"};
        String[] changes2 = solution.trackChanges(versions2);
        System.out.print("Input: [");
        for (int i = 0; i < versions2.length; i++) {
            System.out.print("\"" + versions2[i] + "\"");
            if (i < versions2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\nOutput: [");
        for (int i = 0; i < changes2.length; i++) {
            System.out.print("\"" + changes2[i] + "\"");
            if (i < changes2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Expected: ["- world", "+ there"]
    }
}