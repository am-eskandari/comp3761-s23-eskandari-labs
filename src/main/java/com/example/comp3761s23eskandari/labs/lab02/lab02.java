package com.example.comp3761s23eskandari.labs.lab02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lab02
{
    // O(????)
    // check each letter from String a, compare each to string b
    static boolean anagram1(String a, String b)
    {
        StringBuilder sb = new StringBuilder(b.toLowerCase());

        if(a.length() != b.length())
            return false;

        for(char c: a.toLowerCase().toCharArray()) {
            int index = sb.indexOf(Character.toString(c));
            if(index == -1)
                return false;
            sb.deleteCharAt(index);
        }

        return sb.length() == 0;
    }

    // O(????)
    // compares 2 string after sorting a words alphabetically
    static boolean anagram2(String a, String b)
    {
        if(a.length() != b.length())
            return false;

        char[] aArray = a.toLowerCase().toCharArray();
        char[] bArray = b.toLowerCase().toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        return Arrays.equals(aArray, bArray);
    }

    // O(????)
    // checks the difference in present ascii indexes, cases ignored
    static boolean anagram3(String a, String b)
    {
        if(a.length() != b.length())
            return false;

        int[] ascii = new int[128];

        for(char c : a.toLowerCase().toCharArray())
            ascii[c]++;

        for(char c : b.toLowerCase().toCharArray())
            ascii[c]--;

        for(int i : ascii)
            if(i != 0)
                return false;

        return true;
    }

    // stores all words read in the file into an array and finds the word with max
    // anagram and its anagram count value
    static void run(String file, int option) throws FileNotFoundException
    {
        double seconds;
        int[] count;
        int max = 0;
        String firstword = "";
        double startTime,endTime;

        ArrayList<String> words = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader(file));

        while(reader.hasNext())
            words.add(reader.next().toLowerCase()); // store everything in lowercase

        count = new int[words.size()];
        startTime = System.currentTimeMillis();

        for(int i = 0; i < words.size(); i++)
            for(int j = i+1; j < words.size(); j++)
                switch(option)
                {
                    case 1:
                        if(anagram1(words.get(i), words.get(j)))
                            count[i]++;
                        break;
                    case 2:
                        if(anagram2(words.get(i), words.get(j)))
                            count[i]++;
                        break;
                    case 3:
                        if(anagram3(words.get(i), words.get(j)))
                            count[i]++;
                        break;
                    default:
                        break;
                }

        // looks for maximum number of anagrams a word has from the list
        for(int i = 0; i < count.length; i++)
            if(count[i] > max)
                max = count[i];

        endTime = System.currentTimeMillis();
        seconds = (endTime - startTime)/1000.0;

        // looks for first word with highest anagram count
        for(int i = 0; i < count.length; i++)
            if(count[i] == max)
            {
                firstword = words.get(i);
                break;
            }

        if(max > 0)
            System.out.println("Technique #" + option +" : [" + firstword
                    + "] has " + max + " anagrams. Time = "
                    + seconds + " seconds");
        else
            System.out.println("Technique #" + option + " : No anagrams found.");

        reader.close();
    }

    public static void main(String[] args)
    {
        try
        {
            run("Dict.txt", 1);
            run("Dict.txt", 2);
            run("Dict.txt", 3);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("can't find file");
        }
    }

}
