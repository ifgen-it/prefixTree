/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tasknexigntrie;


import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ifgen
 */
public class WordIndexTest {

    public WordIndexTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loadFile method, of class WordIndex.
     */

    @Test
    public void testLoadFile() {
        System.out.println("\nloadFile");
        String filename = ".\\testFile\\fileUtf-8.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexes4Word method, of class WordIndex.
     */



    @Test
    public void testGetIndexes4Word1() {
        System.out.println("\ngetIndexes4Word1");
        String searchWord = "прив";

        String filename = ".\\testFile\\fileUtf-8.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);

        Set<Integer> expResult = new TreeSet<>(Arrays.asList(1, 2));
        Set<Integer> result = instance.getIndexes4Word(searchWord);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetIndexes4Word2() {
        System.out.println("\ngetIndexes4Word2");
        String searchWord = "словаНет";

        String filename = ".\\testFile\\fileUtf-8.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);

        Set<Integer> expResult = null;
        Set<Integer> result = instance.getIndexes4Word(searchWord);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetIndexes4Word3() {
        System.out.println("\ngetIndexes4Word3");
        String searchWord = null;

        String filename = ".\\testFile\\fileUtf-8.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);

        Set<Integer> expResult = null;
        Set<Integer> result = instance.getIndexes4Word(searchWord);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetIndexes4Word4() {
        System.out.println("\ngetIndexes4Word4");
        String searchWord = "English";

        String filename = ".\\testFile\\fileUtf-8.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);

        Set<Integer> expResult = new TreeSet<>(Arrays.asList(7, 14, 24));
        Set<Integer> result = instance.getIndexes4Word(searchWord);
        assertEquals(expResult, result);

    }
}
