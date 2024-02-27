import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count=sc.nextInt();
    Trie trie = new Trie<String>(count);

    for(int i=0;i<=count;i++){
        String arg=sc.nextLine();
        trie.put(arg, i);
    }
    
    for(int i=0;i>-1;i++){
    System.out.println("Enter Operation Code:");
int opcode=sc.nextInt();
        switch(opcode){
    
    case 1: 
    String s =sc.next();
    trie.Search(s);
    break;
    case 2:  
    trie.countPrefix();
    break;
    case 3: 
    String ss=sc.next();
    trie.reverseFind(ss);
    break;
    case 4:  
    trie.ShortestUniquePrefix();
    break;
    case 5:
    trie.LongestCommonPrefix();
    break;
    case 6:  System.exit(0);

        }
        





    }



    }
}
