import java.util.*;
public class Main
{
    public  static class Node{
        Node children[]=new Node[26];
        boolean eow;
    }
    static Node root=new Node();
    public static String replaceWords(String []dictionary, String sentence) {
        for(String word:dictionary){
            insert(word);
        }
        StringBuilder sb=new StringBuilder();
        String arr[]=sentence.split("\\s+");
        for(String word:arr){
            if(search(word).equals("")){
                sb.append(word);
            } else {
                sb.append(search(word));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
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
    public static String search(String key){
        Node temp=root;
        String d="";
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(temp.children[idx]==null){
                break;
            }
            temp=temp.children[idx];
            d+=key.charAt(i);
            if(temp.eow){
                return d;
            }
        }
        return "";
    }

	public static void main(String[] args) {
		String dictionary[] = {"cat","bat","rat"};
		String sentence = "the cattle was rattled by the battery";
		System.out.print(replaceWords(dictionary,sentence));
	}
}
