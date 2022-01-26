package com.example;

import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;
// for now in fully implemented method input comes from frontend input!
import java.util.Scanner;

// basic: input = some input query
// output: similarity
public class Search{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        Query search = new Query(sc.next());
        System.out.println("your query: "+search.getQuery());
        System.out.println("in list: "+search.isEqual());
        search.rank();
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
        "mango",
        "shoe",
        "school",
        "canada",
        "canadian cherry", 
        "solid works autocad",
        "school is really cool"
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
    //
    public void rank(){
        for(int i = 0; i < searchParams.length; i++){
            SimilarityStrategy strategy = new JaroWinklerStrategy();
            StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
            double score = service.score(this.q, searchParams[i]); // Score is 0.90
            System.out.println("Similarity of "+ this.q +" to "+ searchParams[i] + ": "+ score);
        }
    }
}
