/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mutantapirestdna;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JuanJose
 */
public class DnaTest {
    
    public DnaTest() {
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
     * Test of getDna method, of class Dna.
     */
//    @Test
//    public void testGetDna() {
//        System.out.println("getDna");
//        Dna instance = new Dna();
//        String[] expResult = null;
//        String[] result = instance.getDna();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDnachr method, of class Dna.
//     */
//    @Test
//    public void testGetDnachr() {
//        System.out.println("getDnachr");
//        Dna instance = new Dna();
//        char[][] expResult = null;
//        char[][] result = instance.getDnachr();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDnachr method, of class Dna.
//     */
//    @Test
//    public void testSetDnachr() {
//        System.out.println("setDnachr");
//        char[][] dnachr = null;
//        Dna instance = new Dna();
//        instance.setDnachr(dnachr);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDna method, of class Dna.
//     */
//    @Test
//    public void testSetDna() {
//        System.out.println("setDna");
//        String[] dna = null;
//        Dna instance = new Dna();
//        instance.setDna(dna);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDnastrings method, of class Dna.
//     */
//    @Test
//    public void testGetDnastrings() {
//        System.out.println("getDnastrings");
//        Dna instance = new Dna();
//        String expResult = "";
//        String result = instance.getDnastrings();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDnastrings method, of class Dna.
//     */
//    @Test
//    public void testSetDnastrings() {
//        System.out.println("setDnastrings");
//        String dnastrings = "";
//        Dna instance = new Dna();
//        instance.setDnastrings(dnastrings);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Dna.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Dna instance = new Dna();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Dna.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object object = null;
//        Dna instance = new Dna();
//        boolean expResult = false;
//        boolean result = instance.equals(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Dna.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Dna instance = new Dna();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of isMutant method, of class Dna.
     */
    @Test
    public void testIsMutant() {
        System.out.println("isMutant");
        String[] dnaToVal = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};;
        Dna instance = new Dna();
        boolean expResult = true;
        boolean result = instance.valIsMutant(dnaToVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        /**
     * Test of isMutant method, of class Dna.
     */
    @Test
    public void testIsNOTMutant() {
        System.out.println("isNOTMutant");
        String[] dnaToVal = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = false;
        boolean result = instance.valIsMutant(dnaToVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of horizontalValidation method, of class Dna.
     */
    @Test
    public void testHorizontalValidationMutant() {
        System.out.println("horizontalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = true;
        boolean result = instance.horizontalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is a mutant.");
         
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
    }
    @Test
    public void testHorizontalValidationNOMutant() {
        System.out.println("horizontalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = false;
        boolean result = instance.horizontalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is NOT a mutant.");
         
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
    }

    /**
     * Test of verticalValidation method, of class Dna.
     */
    @Test
    public void testVerticalValidationMutant() {
        System.out.println("horizontalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = true;
        boolean result = instance.verticalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is a mutant.");
    }
    @Test
    public void testVerticalValidationNOMutant() {
        System.out.println("horizontalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = false;
        boolean result = instance.verticalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is NOT a mutant.");
    }


    /**
     * Test of convertHorizontal method, of class Dna.
     */
    @Test
    public void testConvertHorizontal() {
        System.out.println("convertHorizontal");
        String[] pdna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Dna instance = new Dna();
        String[] expResult = {"ACTACT","TATGCC","GGAACA","CTTACC","GGGGTT","ACTGAG"};
        String[] result = instance.convertHorizontal(pdna);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertirArrayStringInMatrizChar method, of class Dna.
     */
    @Test
    @SuppressWarnings("empty-statement")
    public void testConvertirArrayStringInMatrizChar() {
        System.out.println("convertirArrayStringInMatrizChar");
        String[] pdna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Dna instance = new Dna();
        char[][] expResult  ={{'A','T','G','C','G','A'},{'C','A','G','T','G','C'},{'T','T','A','T','G','T'},{'A','G','A','A','G','G'},{'C','C','C','C','T','A'},{'T','C','A','C','T','G'}};
        char[][] result = instance.convertirArrayStringInMatrizChar(pdna);
        System.out.println("La mnatriz Resultado que envia es "+result);
        char[] fila=null;
        for (int i=0; i<result.length;i++){
            fila=result[i];
            char col ='x';
            for (int j=0;j<fila.length;j++){
                col=fila[j];
                System.out.println("Elemento matriz  "+result [i][j]);
            }
        }
         assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   
    @Test
    public void testdiagonalValidationMutant() {
        System.out.println("diagonalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = true;
        boolean result = instance.diagonalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is a mutant.");
         
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
    }
    
        @Test
    public void testdiagonalValidationNOMutant() {
        System.out.println("diagonalValidation");
        String[] pdna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
        Dna instance = new Dna();
        boolean expResult = false;
        boolean result = instance.diagonalValidation(pdna);
        //assertEquals(expResult, result);
        if (result!=expResult) fail("The test case is a fail becuase de DNA is a mutant.");
         
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
    }
}
