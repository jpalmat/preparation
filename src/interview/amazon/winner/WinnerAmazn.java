package interview.amazon.winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinnerAmazn {

    /*
    Amazon Fresh is running a promotion in which customers receive prizes for purchasing a secret combination of fruits. The combination will change each day, and the team running the promotion
wants to use a code list to make it easy to change the combination. The code list contains groups of fruits. Both the order of the groups within the code list and the order of the fruits within
the groups matter. However, between the groups of fruits, any number, and type of fruit is allowable. The term "anything" is used to allow for any type of fruit to appear in that location
within the group

Consider the following secret code list [[apple, apple]. [banana, anything, banana]].
Based on the above secret code list, a customer who made either of the following purchases would win the prize

orange, apple apple, banana, orange, banana
apple apple orange orange banana, apple, banana, banana

Write an algorithm to output 1 If the customers a winner else output 0

Input

The input to the function/method consists of two arguments:
codelist, a list of lists of strings representing the order and grouping of specific fruits that must be purchased in order to win the prize for the day.
shopping Cart, a list of strings representing the order in which a customer purchases fruit.

Output
Return an integer 1 if the customer is a winner else return 0

Note

"anything" in the code is represents that any fruit can be ordered in place of anything the group.
"anything" has to be something I cannot be nothing.
"anything" must represent one and only one fruit.
If secret code list is empty then it is assumed that the customer is a winner.

Examples

Example1

Input:
codeList= [[apple, apple], [banana, anything, banana]]
shopping Cart= [orange apple apple, banana, orange, banana]

Output:
1

Explanation
codelist contains two groups - [apple, apple] and [banana, anything, banana].
The second group contains "anything" so any fruit can be ordered in place of "anything" in the shopping Cart.
The customer is a winner as the customer has added fruits in the order of fruits in the group and the order of groups in the codeList is also maintained in the shopping Cart

Example2

Input:
codeList= [[apple, apple], [banana, anything, banana]]
shopping Cart= [banana, orange, banana, apple, apple]

Output
0

Explanation:
The customer is not a winner as the customer has added the fruits in order of groups but group [banana, orange, banana] is not following the group [apple, apple] in the codeList
     */

    public static void main(String[] args) {

//        List<String> lis1 = Arrays.asList("a", "b", "c", "a", "e");
//        List<String> list2 = Arrays.asList("b", "a", "c");
//        System.out.println(lis1.indexOf("a"));
        List<List<String>> codeList = new ArrayList<>();
        codeList.add(Arrays.asList("apple", "apple"));
        codeList.add(Arrays.asList("banana", "anything", "banana"));

        System.out.println(checkWinner(codeList, Arrays.asList("orange", "apple", "apple", "apple", "banana", "orange", "banana")));

    }

    private static boolean itemsMatch(String code, String item){
        if("anything".equals(code)) return true;
        else if(item.equals(code)) return true;
        else return false;
    }
    public static int checkWinner(List<List<String>> codes, List<String> shoppingCart) {
        int listIndex = 0;
        int listItemIndex = 0;
        boolean currListMatches = false;
        List<String> currList = codes.get(listIndex++);
        for(String item:shoppingCart){
            String code = currList.get(listItemIndex);
            if(currListMatches && !itemsMatch(code, item)){
                listItemIndex = 0; //reset to current code list starting position
            }else if(itemsMatch(code, item)){
                currListMatches = true;
                listItemIndex++;
                if(listItemIndex==currList.size()){
                    if(listIndex==codes.size()){
                        return 1; //all the codes matched
                    }
                    currList = codes.get(listIndex++); //move on to next code list
                    currListMatches = false;
                    listItemIndex = 0;
                }
            }
        }
        return 0;
//        List<String> codeListU = codeList.stream().flatMap(List::stream).collect(Collectors.toList());
//        int[] indexes;
//        int result = 1;
//        if(shoppingCart.size()<codeListU.size()){
//            return 0;
//        } else {
//            String first = codeListU.get(0);
//            indexes = IntStream.range(0, shoppingCart.size()).filter(i -> shoppingCart.get(i).equals(first)).toArray();
//            List<String> subListShoppingCart;
//
//            for(int i = 0; i < indexes.length; i++){
//                result = 1;
//                if(indexes[i]+codeListU.size() > shoppingCart.size()){
//                    result = 0;
//                    break;
//                }
//                subListShoppingCart = shoppingCart.subList(indexes[i], indexes[i] + codeListU.size());
//                for(int j = 0; j < subListShoppingCart.size(); j++){
//                    if(codeListU.get(j).equals("anything")) {
//                        continue;
//                    }
//                    if(!subListShoppingCart.get(j).equals(codeListU.get(j))) {
//                        result = 0;
//                        break;
//                    }
//                }
//            }
//        }
//         return result;
        //////////////////////////////
//        List<String> codeListU = codeList.stream().flatMap(List::stream).collect(Collectors.toList());
//        int position = 0;
//
////        codeListU.stream()
//////                .peek(x -> position[0]++)  // increment every element encounter
////                .filter(x -> !x.equals("anything"))
////                .findFirst()
////                .get();
//        int index = shoppingCart.indexOf(codeListU.get(position++));
//        for(int i = index+1; i<shoppingCart.size(); i++){
//            if(codeListU.get(position).equals("anything")){
//                position++;
//                continue;
//            }
//            if(!shoppingCart.get(i).equals(codeListU.get(position++))){
//                return 0;
//            }
//        }
//        return position==codeListU.size() ? 1 : 0;


        //Maryam
//        List<String> newList = codeList.stream().flatMap(Collection::stream).collect(Collectors.toList());
//        int length = shoppingCart.size() - newList.size();
//        if (length < 0) {
//            return 0;
//        } else if (length == 0) {
//            for (int i = 0; i < newList.size(); ++i) {
//                if (!newList.get(i).equals(shoppingCart.get(i)) && !newList.get(i).equals("anything")) {
//                    return 0;
//                }
//            }
//            return 1;
//        } else {//different >0
//            boolean flag1 = true, flag2 = true;
//            List<String> shopingCart1 = shoppingCart.subList(0, shoppingCart.size() - length - 1);
//            List<String> shopingCart2 = shoppingCart.subList(length, shoppingCart.size() - 1);
//            for (int i = 0; i < newList.size(); ++i) {
//                if (!newList.get(i).equals(shopingCart1.get(i))) {
//                    flag1 = false;
//                }
//            }
//            for (int i = 0; i < newList.size(); ++i) {
//                if (!newList.get(i).equals(shopingCart2.get(i))) {
//                    flag2 = false;
//                }
//            }
//            return (flag1 || flag2) ? 1 : 0;
//
//        }
    }
}
