/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tasknexigntrie;

import java.io.*;
import java.util.*;

class Node {

    private String word;
    private ArrayList<Integer> entries;
    private HashMap<String, Node> childs;

    public Node() {
        word = "";
        entries = null;
        childs = null;
    }

    public void addWord(String str, int pos) {

        String first = str.substring(0, 1);
        Node child = null;

        if (childs == null) {
            childs = new HashMap<String, Node>();
            child = new Node();
            child.word = this.word + first;
            childs.put(first, child);

        } else { // childs is not null

            if (childs.containsKey(first)) {
                child = childs.get(first);

            } else { // has no key = first
                child = new Node();
                child.word = this.word + first;
                childs.put(first, child);
            }
        }

        if (str.length() == 1) {
            if (child.entries == null) {
                child.entries = new ArrayList<Integer>();
                child.entries.add(new Integer(pos));
            } else {
                child.entries.add(new Integer(pos));
            }

            return;
        }

        //  recursive call
        String rest = str.substring(1, str.length());
        child.addWord(rest, pos);

    }

    public ArrayList<Integer> getIndexes4Word(String searchWord) {

        Node curNode = this;

        if (searchWord == null || searchWord.equals("") || childs == null) {
            return null;
        }
        String sW = searchWord;

        for (int i = 0; i < sW.length(); i++) {
            //  System.out.println("Word: " + curNode.word);
            String ch = sW.substring(i, i + 1);
            //   System.out.println(ch + " " + sW.length());

            if (curNode.childs == null) {
                //    System.out.println("childs = null");
                return null;
            }

            boolean haveCh = curNode.childs.containsKey(ch);
            //    System.out.println("haveCh: " + haveCh);
            if (!haveCh) {
                return null;
            }

            curNode = curNode.childs.get(ch);
            if (i == sW.length() - 1 && curNode.entries != null) {
                return curNode.entries;

            }

        }

        return new ArrayList<>();
    }

    public void print() {

        if (entries != null) {
            System.out.print(word + " : ");
            System.out.println(entries);
            //System.out.println(this.hashCode());
        }

        /*  else{
      System.out.print(word + " " + word.length() + " : ");
      System.out.println(this.hashCode());
    }
         */
        if (childs != null) {
            Set<String> keys = childs.keySet();
            ArrayList<String> lKeys = new ArrayList<String>(keys);

            for (String key : lKeys) {
                Node temp = childs.get(key);
                temp.print();
            }
        }

    }

}

/**
 *
 * @author ifgen
 */
public class WordIndex {

    private Node root;

    public WordIndex() {
        root = null;
    }

    public void loadFile(String filename) {

        ArrayList<String> inStr = new ArrayList<>();
        System.out.println("Begin loading: " + filename);
        try {
            //String path = "file.txt";
            String path = filename;

            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);
            System.out.println("File loaded");

            // System.out.println("input:");
            while (true) {
                if (sc.hasNext()) {
                    String temp = sc.next().trim();
                    //System.out.println("temp word: " + temp);
                    byte[] bText = temp.getBytes();

                    String value = new String(bText, "UTF-8");
                    //System.out.println("value word: " + value);
                    //System.out.println("-----------------");

                    inStr.add(value);
                } else {
                    break;
                }
            }

            sc.close();
            fr.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        //  System.out.println(inStr);
        // WORKING
        root = new Node();

        for (int i = 0; i < inStr.size(); i++) {
            String str = inStr.get(i);
            // System.out.println((i+1) + " : " + str);
            root.addWord(str, i + 1);
        }
        System.out.println("Trie was built");

        //System.out.println();
        //root.print();
        //String sWord = "hi";
        //System.out.println("\nSearch word: " + sWord);
        //System.out.println(root.getIndexes4Word(sWord));
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        System.out.println("--> getIndexes4Word");
        System.out.println("Search word: " + searchWord);
        ArrayList<Integer> result = root.getIndexes4Word(searchWord);
        System.out.println("Result: " + result);

        if (result == null) {
            return null;
        }
        Set<Integer> setResult = new TreeSet<>(result);

        return setResult;
    }
}
