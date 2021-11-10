package com.example;

// for now in fully implemented method input comes from frontend input!
import java.util.Scanner;

// basic: input = some input query
// output: rating of closeness to defaults and return value of closest or return error if all 0%
public class Search{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        Query search = new Query(sc.next());
        System.out.println("your query: "+search.getQuery());
        System.out.println("in list: "+search.isEqual());
        sc.close();
    }
}
class Query{
    String q;
    // to be replaced with compiled database
    String[] searchParams = {
        "apple", 
        "banana", 
        "cherry", 
        "orange", 
        "mango"
    };
    // is query a default searchParams?
    Boolean recarrSearch(String[] arr, int beg, int end, String toFind){
        if(end < beg){
            return false;
        }
        if((arr[beg]).equals(toFind)){
            return true;
        }
        return recarrSearch(arr, beg+1, end, toFind);
    }
    // constructor
    public Query(String q){
        this.q = q;
    }
    // getter()
    public String getQuery(){
        return this.q;
    }
    // determines query existence in searchParams using recursive search
    public Boolean isEqual(){
        return recarrSearch(searchParams, 0, (searchParams.length-1), this.q);
    }
}
