import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Trie<Value> {
    public int count;
    private static final int R = 256; 
    private Node root = new Node();

    public Trie(int count){
        this.count=count;
    }

    private static class Node { 
        private Object value; 
        private Node[] next = new Node[R];
     }


    List<String>[] prefixLists;
    List<String> shortesPrefix = new ArrayList<>();   


    public void Search(String key) {  
        if(get(key) != null){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
            }
     public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }



    public Value get(String key) { 
          Node x = get(root, key, 0); 
         if (x == null) return null;
          return (Value)x.value; } 
                  
    private Node get(Node x, String key, int d) {
      if (x == null) return null;
      if (d == key.length()) 
      return x; 
        char c = key.charAt(d); 
     return get(x.next[c], key, d+1); }

     public String getKey(Object value) {
        return getKey(root, value, "");
    }

    private String getKey(Node x, Object value, String currentKey) {
        if (x == null) {
            return null;
        }
        if (x.value != null && x.value.equals(value)) {
            return currentKey; 
        }
        for (char c = 0; c < R; c++) {
            String nextKey = getKey(x.next[c], value, currentKey + (char) c);
            if (nextKey != null) {
                return nextKey;
            }
        }
        return null;
    }

    public void ShortestUniquePrefix(){
        List<String> listOfWords= new ArrayList<>(count);
        for(int j=0;j<=count;j++){
                listOfWords.add(getKey(j));
            }
            listOfWords.remove(0);
            List<String> listOfTempWords=new ArrayList<>(listOfWords);
            boolean unique=false;
            boolean check=false;
            while(!listOfWords.isEmpty()){
               String value= listOfWords.remove(0);
               String valueP;
               unique=false;
               check=false;

                for(int i=1;i<=value.length();i++){
                    if(unique)
                    break;
                    valueP=value.substring(0, i);
                    for(int j=0;j<listOfTempWords.size();j++){
                        if(listOfTempWords.get(j).contains(valueP)&&valueP.length()==value.length()&&!listOfTempWords.get(j).equals(valueP)&&!unique){
                             System.out.println(value+":"+" not exists");
                             check=true;
                             break;
                        }
                        else if(listOfTempWords.get(j).contains(valueP)&&!listOfTempWords.get(j).equals(value)){
                            unique=false;
                            break;
                        }else if(valueP.length()<=value.length()&&!listOfTempWords.get(j).contains(valueP)){
                            unique=true;
                            continue;
                        }
                        
                    
                }
                if(unique)  System.out.println(value+": "+valueP);
                if(!unique&&valueP.length()==value.length()&&!check){
                            System.out.println(value+":"+" not exists");
                             break;
                        }
            }
        }

              
    }
    public void LongestCommonPrefix(){
 List<String> listOfWords= new ArrayList<>(count);
 String common="not exists";
        for(int j=0;j<=count;j++){
                listOfWords.add(getKey(j));
            }
            listOfWords.remove(0);
            List<String> listOfTempWords=new ArrayList<>(listOfWords);
            boolean notunique=false;
            while(!listOfWords.isEmpty()){
               String value= listOfWords.remove(0);
               String valueP;
               notunique=false;

                for(int i=1;i<=value.length();i++){
                  
                    valueP=value.substring(0, i);
                    for(int j=0 ;j<listOfTempWords.size();j++){
                      if(listOfTempWords.get(j).contains(valueP)){
                        notunique=true;
                        continue;
                      }else if(!listOfTempWords.get(j).contains(valueP)){
                        notunique=false;     
                        break;
                    }  
                }
                if(notunique){
                    common=valueP;
                }

            }
        }
        System.out.println(common);

    }

    public void reverseFind(String suffix){
 List<String> listOfWords= new ArrayList<>(count);
        for(int j=0;j<=count;j++){
                listOfWords.add(getKey(j));
            }
            Collections.sort(listOfWords);
            for(String string:listOfWords){
                if(string.endsWith(suffix)){
                    System.out.println(string);
                }
            }

    }

     public void countPrefix(){
    prefixLists=(List<String>[]) new List[count+1];
        for(int k=0;k<count+1;k++){
            prefixLists[k]=new ArrayList();
        }
        List<String> listOfWords= new ArrayList<>(count);
        for(int j=0;j<=count;j++){
                listOfWords.add(getKey(j));
                Collections.sort(listOfWords);
            }
                Collections.sort(listOfWords);
       for(int i=1;i<=count;i++){
        String current = listOfWords.get(i);
            for(int j=1;j<=count;j++){
                if(listOfWords.get(j).contains(current)){
                    prefixLists[i].add(current);
                }
            }
            if(i==0)
            continue;
            int size=prefixLists[i].size()-1;
            System.out.println(current+":"+size );
       }

    }
}
