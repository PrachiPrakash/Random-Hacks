/**
*This Program detects the sentence Boundary of the a fiven passage.
*This is a solution to the hacker rank problem 
*https://www.hackerrank.com/challenges/from-paragraphs-to-sentences/
*@author Prachi Prakash.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Token
{
    String value;
    char type;
    
    public Token(String value, char type)
    {
        this.value = value;
        this.type = type;
    }
    
    public String toString()
    {
        return "<"+value+", "+type+">";
    }
    
}

class Tokenizer
{
    private String text;
    int pos;
    
    public Tokenizer(String text)
    {
        this.text = text;
        pos = 0;
    }
    
    public Token getNextToken()
    {
        if(pos == text.length())
            return null;
        
        
        String tok = "";
        
        while(Character.isLetter(text.charAt(pos)) || Character.isDigit(text.charAt(pos)) ||
             text.charAt(pos) == ',' || text.charAt(pos) == '\''){
            tok = tok+text.charAt(pos);
            pos++;
        }
        
        if(!tok.equals(""))
            return new Token(tok,'w');
        
        char delim = text.charAt(pos);
        
        switch(delim){
            
            case '.':
                pos++;
                return new Token(""+delim,'p');
            case '?':
                pos++;
                return new Token(""+delim,'q');
            case '\"':
                pos++;
                return new Token(""+delim,'i');
            case '!':
                pos++;
                return new Token(""+delim,'e');
            case ' ':
                pos++;
                return new Token(""+delim,'s');
            default:
                pos++;
                return new Token(""+delim,'u');
            
        }
        
    }
    
}

public class SentenceBoundary
{

    public static void main(String[] args) 
    {
         Scanner s = new Scanner(System.in);
        
         
         Token curr = null;
         Token prev = null;
        
         String sentences[] = new String[30];
         int k=0;
         String sentence = "";
         
        String in = s.nextLine();
        Tokenizer tok = new Tokenizer(in);
        
        while((curr = tok.getNextToken()) != null){
            
            switch(curr.type){
                //for quotes
                case 'i':
                    sentence += curr.value;
                    prev = curr;
                    while((curr = tok.getNextToken()) != null && curr.type != 'i'){
                        prev = curr;
                        sentence += curr.value;
                    }
                    if(curr != null)
                        sentence += curr.value;
                    break;
                
                case 'p':
                    if(prev.type == 'w' && Character.isUpperCase(prev.value.charAt(0))
                      && prev.value.length() <= 2)
                        sentence += curr.value;
                    else{
                        sentence += curr.value;
                        sentences[k++] = sentence;
                        sentence = "";
                    }
                    prev = curr;    
                    break;
                
                case 'q':
                case 'e':
                    prev = curr;
                    sentence += curr.value;
                    sentences[k++] = sentence;
                    sentence = "";
                    break;
                
                default:
                    prev = curr;
                    sentence += curr.value;
            }
        }
        
        for(int i=0; i<k; i++)
                System.out.println(sentences[i].trim());
            
        
    }
}