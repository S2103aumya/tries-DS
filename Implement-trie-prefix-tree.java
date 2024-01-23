import java.util.*;
public class Main
{
    public static class Trie {
        public static class Node{
            Node children[]=new Node[26];
            boolean eow;
        }
    
        static Node root=new Node();
        public static void insert(String word) {
            Node temp=root;
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(temp.children[idx]==null){
                    temp.children[idx]=new Node();
                }
                if(i==word.length()-1){
                    temp.children[idx].eow=true;
                }
                temp=temp.children[idx];
            }
        }
        
        public static boolean search(String word) {
            Node temp=root;
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(temp.children[idx]==null){
                    return false;
                }
                if(i==word.length()-1 && temp.children[idx].eow==false){
                    return false;
                }
                temp=temp.children[idx];
            }
            return true;
        }
        
        public static boolean startsWith(String prefix) {
            Node temp=root;
            for(int i=0;i<prefix.length();i++){
                int idx=prefix.charAt(i)-'a';
                if(temp.children[idx]==null){
                    return false;
                }
                temp=temp.children[idx];
            }
            return true;
        }
    }

	public static void main(String[] args) {
		Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");

        // Search for words in the Trie
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'apricot': " + trie.search("apricot")); // true
        System.out.println("Search 'orange': " + trie.search("orange")); // false

        // Check if prefixes exist in the Trie
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
        System.out.println("StartsWith 'ban': " + trie.startsWith("ban")); // true
        System.out.println("StartsWith 'pear': " + trie.startsWith("pear")); // false
    }
}
