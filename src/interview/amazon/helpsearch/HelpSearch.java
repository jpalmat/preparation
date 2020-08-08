package interview.amazon.helpsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelpSearch {
    public static void main(String[] args) {
        String helpText = "Purchase Order item help can't find item item is too much part of the purchase need fix for image item delivered too fast " +
                "purchase order too big is purchase order coming? Too big why";
        List<String> wordsToExclude = Arrays.asList("help", "fix", "too", "is", "of");
        System.out.println(retrieveMostFrequentUsedWords(helpText, wordsToExclude));
    }

    public static List<String> retrieveMostFrequentUsedWords(String helpText, List<String> wordsToExclude){
        List<String> listHelpText = Arrays.stream(helpText.replaceAll("[^a-zA-Z]", " ").split(" "))
                .filter(x -> x.length()>0)
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        listHelpText.removeAll(wordsToExclude.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));

        Map<String, Integer> collect = listHelpText.parallelStream().collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: collect.entrySet()){
            if(entry.getValue()>2){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
