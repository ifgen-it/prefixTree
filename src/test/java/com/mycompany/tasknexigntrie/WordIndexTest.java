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
        System.out.println("loadFile");
        String filename = ".\\testFile\\file.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexes4Word method, of class WordIndex.
     */
    
    @Test
    public void testGetIndexes4Word() {
        System.out.println("getIndexes4Word");
        String searchWord = "hi";
        
        String filename = ".\\testFile\\file.txt";
        WordIndex instance = new WordIndex();
        instance.loadFile(filename);
        
        Set<Integer> expResult = new TreeSet<>(Arrays.asList(1, 2, 15));
        Set<Integer> result = instance.getIndexes4Word(searchWord);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
