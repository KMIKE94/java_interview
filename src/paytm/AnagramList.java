package paytm;

import java.util.*;

/**
 * Given a list of strings
 * return a list of list of strings containing the anagrams
 *
 * input: [ate, tea, nat, eat, tan, bat]
 * output:
 * [
 *  [ate, tea, eat],
 *  [nat, tan],
 *  [bat]
 * ]
 */
public class AnagramList {

    public static void main(String args[]) {
        AnagramList anagramList = new AnagramList();

        List<String> testInput = new ArrayList<>();
        testInput.add("ate");
        testInput.add("tea");
        testInput.add("nat");
        testInput.add("eat");
        testInput.add("tan");
        testInput.add("bat");

        List<List<String>> output = anagramList.getAnagramList(testInput);
        output.forEach(list -> {
            list.forEach(str -> {
                System.out.print(str + " ");
            });
            System.out.println();
        });
    }

    private List<List<String>> getAnagramList(List<String> input) {
        List<List<String>> outputList = new ArrayList<>();
        HashMap<String, List<String>> dictionary = new HashMap<>();

        /*
        thinking I can sort the value as I get it
        add to hashset
            if hashset not empty then we found anagram
            add to a list
            at the end add to list of lists
         */
        for(int i=0;i<input.size();i++){
            if(dictionary.isEmpty()) {
                String sortedString = getSortedString(input.get(i).toCharArray());
                dictionary.put(sortedString, new ArrayList<>(List.of(input.get(i))));
            } else {
                String sortedStr = getSortedString(input.get(i).toCharArray());
                if(dictionary.containsKey(sortedStr)) {
                    List<String> dictionaryList = dictionary.get(sortedStr);
                    if(!dictionaryList.contains(input.get(i))) {
                        dictionaryList.add(input.get(i));
                    }
                } else {
                    dictionary.put(sortedStr, new ArrayList<>(List.of(input.get(i))));
                }
            }
        }

        for(Map.Entry<String, List<String>> entries : dictionary.entrySet()) {
            outputList.add(entries.getValue());
        }

        return outputList;
    }

    private String getSortedString(char[] input) {
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();
        for(char c : input) {
            sb.append(c);
        }

        return sb.toString();
    }

}
