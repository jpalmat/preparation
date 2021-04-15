import java.util.*;

public class AA{
    public static void main(String[] args) {
//        float a = 3.533f;
//        String st = new String(String.valueOf(a));
//        String[] ar = st.split("\\.");
//        System.out.println(ar[0]);

        int sortParameter =1;
        int sortOrder= 0;//des , 0=>asc

        List<String> a = Arrays.asList("Item1", "45", "22");
        List<String> b = Arrays.asList("Item2", "98", "32");
        List<String> c = Arrays.asList("Item3", "12", "322");

        List<List<String>> al = Arrays.asList(a, b, c);


//       Comparator cs= Comparator.comparing((String entry1, String entry2) -> {
////                    if (sortOrder == 0) {
////                        return entry1.get(sortParameter).compareTo(entry2.get(sortParameter));
////                    }
////                    return entry2.get(sortParameter).compareTo(entry1.get(sortParameter));
//           return 0;
//                });

       Comparator<List<String>> aa= new Comparator<List<String>>() {
           @Override
           public int compare(List<String> entry1, List<String> entry2) {
               if(sortParameter ==0) {
                   if (sortOrder == 0) {
                       return entry1.get(sortParameter).compareTo(entry2.get(sortParameter));
                   }
                   return entry2.get(sortParameter).compareTo(entry1.get(sortParameter));
               }
               else{
                   if (sortOrder == 0) {
                       return Integer.parseInt(entry1.get(sortParameter)) -Integer.parseInt(entry2.get(sortParameter));
                   }
                   return Integer.parseInt(entry2.get(sortParameter))- Integer.parseInt(entry1.get(sortParameter));
               }
           }
       };

        Collections.sort(al,aa);

        for(List<String> s: al){
            System.out.println(s);
        }

//            }
//            if(sortParameter == 1){
//                if(sortOrder == 0){
//                    return (int)entry1.getValue().getKey() - (int)entry2.getValue().getKey();
//                }
//                return (int)entry2.getValue().getKey() - (int)entry1.getValue().getKey();
//            }
//            if(sortParameter == 2){
//                if(sortOrder == 0){
//                    return (int)entry1.getValue().getValue() - (int)entry2.getValue().getValue();
//                }
//                return (int)entry2.getValue().getValue() - (int)entry1.getValue().getValue();
//            }
          //  return 0;
 //       });


    }

}



