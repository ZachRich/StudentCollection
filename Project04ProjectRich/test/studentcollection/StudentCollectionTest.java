package studentcollection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import student.Student;
import studentcollection.StudentCollectionSpec.StudentCollectionException;
import studentspec.StudentSpec;
import studentspec.StudentSpec.StudentSpecException;

import static studentcollection.StudentCollectionSpec.fileExists;

/**
 *
 * @author joe
 */
public class StudentCollectionTest
{

    public StudentCollectionTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {

    }

    @AfterClass
    public static void tearDownClass()
    {

    }

    @Before
    public void setUp()
    {

    }

    @After
    public void tearDown()
    {

    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(20); // 20 seconds

    /**
     * Test of getCapacity method, of class StudentCollection.
     */
    @Test
    public void testGetCapacity()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(2);
        StudentSpec student = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        StudentCollection.StudentCollectionException thrownException;

        //getCapacity - Empty
        int expected1 = 2;
        int actual1 = instance.getCapacity();
        int expected2 = 2;
        int actual2 = instance.getSpacesRemaining();

        assertNotNull(instance);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

        //getCapacity - Non Empty
        instance.addStudent(student);
        int expected3 = 2;
        int actual3 = instance.getCapacity();
        int expected4 = 1;
        int actual4 = instance.getSpacesRemaining();

        assertNotNull(instance);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);

    }

    /**
     * Test of reset method, of class StudentCollection.
     */
    @Test
    public void testReset()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(2);

        //reset - Empty
        instance.reset();
        boolean expected1 = true;
        boolean actual1 = instance.isEmpty();
        int expected2 = 0;
        int actual2 = instance.getStudentCount();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertNotNull(instance);
        assertFalse(instance.isFull());

        //reset - Non Empty
        StudentSpec aStudent = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent);
        instance.reset();
        boolean expected3 = true;
        boolean actual3 = instance.isEmpty();
        int expected4 = 0;
        int actual4 = instance.getStudentCount();

        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertNotNull(instance);
        assertFalse(instance.isFull());

    }

    /**
     * Test of isFull method, of class StudentCollection.
     */
    @Test
    public void testIsFull()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(2);

        //isFull - Empty Collection
        boolean expected1 = false;
        boolean actual1 = instance.isFull();

        assertEquals(expected1, actual1);
        assertNotNull(instance);
        assertTrue(instance.isEmpty());

        //isFull - Non Full Collection
        StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent1);
        int expected2 = 1;
        int actual2 = instance.getStudentCount();

        assertEquals(expected2, actual2);
        assertNotNull(instance);
        assertFalse(instance.isEmpty());

        //isFull - Full Collection
        StudentSpec aStudent2 = Student.create("0176441", "Test", "T", "Test", "CSC");
        instance.addStudent(aStudent2);
        boolean expected3 = true;
        boolean actual3 = instance.isFull();
        int expected4 = 2;
        int actual4 = instance.getStudentCount();

        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertNotNull(instance);
        assertFalse(instance.isEmpty());
        assertTrue(instance.isFull());
    }

    /**
     * Test of isEmpty method, of class StudentCollection.
     */
    @Test
    public void testIsEmpty()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(2);

        //isEmpty - Empty Collection
        boolean expected1 = true;
        boolean actual1 = instance.isEmpty();
        assertEquals(expected1, actual1);
        assertNotNull(instance);

        //isEmpty - Non Full Collection
        StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent1);
        boolean expected2 = false;
        boolean actual2 = instance.isEmpty();
        int expected3 = 1;
        int actual3 = instance.getStudentCount();
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

        //isEmpty - Full Collection
        StudentSpec aStudent2 = Student.create("0176441", "Test", "T", "Test", "CSC");
        instance.addStudent(aStudent2);
        boolean expected4 = false;
        boolean actual4 = instance.isEmpty();
        int expected5 = 2;
        int actual5 = instance.getStudentCount();
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }

    /**
     * Test of getStudentCount method, of class StudentCollection.
     */
    @Test
    public void testGetStudentCount() //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(3);

        //getStudentCount - Empty
        int expected1 = 0;
        int actual1 = instance.getStudentCount();

        assertEquals(expected1, actual1);
        assertFalse(instance.isFull());
        assertTrue(instance.isEmpty());

        //getStudentCount - Non Empty
        StudentSpec aStudent = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent);
        int expected2 = 1;
        int actual2 = instance.getStudentCount();

        assertNotNull(instance);
        assertNotNull(aStudent);
        assertEquals(expected2, actual2);
        assertFalse(instance.isFull());

    }

    /**
     * Test of addStudent method, of class StudentCollection.
     * This Test is adding a student to an empty collection
     */
    @Test
    public void testAddStudent()  //Complete - 100%
    {
        StudentCollectionSpec instance = StudentCollection.createStudentCollection(2);
        StudentCollectionSpec.StudentCollectionException thrownException;

        //addStudent - Empty collection
        instance.reset();
        int expected1 = 0;
        int actual1 = instance.getStudentCount();
        int expected2 = 2;
        int actual2 = instance.getSpacesRemaining();

        assertNotNull(instance);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertTrue(instance.isEmpty());

        //addStudent - NonEmpty Collection
        StudentSpec aStudent2 = Student.create("0176441", "Aria", "L", "Keiras", "CSC");
        StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent2);
        instance.addStudent(aStudent1);
        int expected3 = 2;
        int actual3 = instance.getStudentCount();
        int expected4 = 0;
        int actual4 = instance.getSpacesRemaining();

        assertNotNull(aStudent2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertFalse(instance.isEmpty());

        //addStudent - Full Collection Exception Thrown
        StudentSpec aStudent3 = Student.create("0176442", "Isabella", "L", "Gentille", "BIS");

        try
        {
            instance.addStudent(aStudent3);
            thrownException = null;
        }
        catch ( StudentCollectionException anException )
        {
            thrownException = anException;
        }
        assertNotNull(thrownException);

        //addStudent - Null Handle Supplied
        instance.reset();
        StudentSpec aStudent4 = null;

        try
        {
            instance.addStudent(aStudent4);
            thrownException = null;
        }
        catch ( StudentCollectionException anException2 )
        {
            thrownException = anException2;
        }

        assertNull(aStudent4);
        assertNotNull(instance);
        assertNotNull(thrownException);

    }

    /**
     * Test of retrieveStudentBySID method, of class StudentCollection.
     */
    @Test
    public void testRetrieveStudentBySID()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(3);

        //retrieveStudentBySID - Empty Collection
        String searchKey1 = "1010101";
        String expected1 = null;
        StudentSpec actual1 = instance.retrieveStudentBySID(searchKey1);

        assertNotNull(instance);
        assertTrue(instance.isEmpty());
        assertEquals(expected1, actual1);

        //retrieveStudentBySID - Non Empty Collection
        String searchKey2 = "0176440";
        StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent1);
        StudentSpec expected2 = aStudent1;
        StudentSpec actual2 = instance.retrieveStudentBySID(searchKey2);
        int expected3 = 2;
        int actual3 = instance.getSpacesRemaining();

        assertNotNull(instance);
        assertNotNull(aStudent1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

        //retrieveStudentBySID - Null Search Key
        String searchKey3 = null;
        StudentSpec actual4 = instance.retrieveStudentBySID(searchKey3);
        StudentSpec expected4 = null;

        assertEquals(expected4, actual4);

        //retrieveStudentBySID - Invalid Search Key
        String searchKey4 = "INVALID_KEY";
        StudentSpec actual5 = instance.retrieveStudentBySID(searchKey3);
        StudentSpec expected5 = null;

        assertEquals(expected5, actual5);

    }

    @Test
    public void testRemoveStudentBySID()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(3);

        //removeStudentBySID - Empty Collection
        String searchKey1 = "1010101";
        String expected1 = null;
        StudentSpec actual1 = instance.removeStudentBySID(searchKey1);

        assertNotNull(instance);
        assertTrue(instance.isEmpty());
        assertEquals(expected1, actual1);

        //removeStudentBySID - Non Empty Collection
        String searchKey2 = "0176440";
        StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        instance.addStudent(aStudent1);
        StudentSpec expected2 = aStudent1;
        StudentSpec actual2 = instance.removeStudentBySID(searchKey2);
        int expected3 = 3;
        int actual3 = instance.getSpacesRemaining();

        assertNotNull(instance);
        assertNotNull(aStudent1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

        //removeStudentBySID - Null Search Key
        String searchKey3 = null;
        StudentSpec actual4 = instance.removeStudentBySID(searchKey3);
        StudentSpec expected4 = null;

        assertEquals(expected4, actual4);

        //removeStudentBySID - Invalid Search Key
        String searchKey4 = "INVALID_KEY";
        StudentSpec actual5 = instance.removeStudentBySID(searchKey3);
        StudentSpec expected5 = null;

        assertEquals(expected5, actual5);
    }

    /**
     * Test of toString method, of class StudentCollection.
     */
    @Test
    public void testToString()  //Complete - 100%
    {

        StudentCollectionSpec instance = StudentCollection.createStudentCollection(4);

        //toString - Empty Collection
        String expected1 = "empty collection";
        String actual1 = instance.toString();
        assertEquals(expected1, actual1);

        //toString - Non Empty Collection
        StudentSpec student1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        StudentSpec student2 = Student.create("0176441", "Aria", "L", "Keiras", "CSC");
        instance.addStudent(student1);
        instance.addStudent(student2);
        String expected2 = student1 + "&" + student2;
        String actual2 = instance.toString();
        assertEquals(expected2, actual2);
    }

    @Test
    public void createStudentCollection() //Complete - 100%
    {

        StudentCollectionSpec.StudentCollectionException thrownException;
        int DEFAULT_COLLECTION_SIZE = 5000;

        //createStudentCollection - Default Size (5000)
        try
        {
            StudentCollectionSpec instance = StudentCollection.createStudentCollection();
            thrownException = null;
            int expected1 = DEFAULT_COLLECTION_SIZE;
            int actual1 = instance.getCapacity();
            int expected2 = 0;
            int actual2 = instance.getStudentCount();

            assertNotNull(instance);
            assertTrue(instance.isEmpty());
            assertFalse(instance.isFull());
            assertNull(thrownException);
            assertEquals(expected1, actual1);
            assertEquals(expected2, actual2);
            assertEquals(DEFAULT_COLLECTION_SIZE, instance.getSpacesRemaining());
        }
        catch ( StudentCollectionException exception1 )
        {
            thrownException = exception1;
        }
        assertNull(thrownException);

        //createStudentCollection - size 0
        try
        {
            StudentCollectionSpec instance3 = StudentCollection.createStudentCollection(0);
            thrownException = null;
        }
        catch ( StudentCollectionException exception1 )
        {
            thrownException = exception1;
        }
        assertNotNull(thrownException);

        //createStudentCollection - size 1
        try
        {
            StudentCollectionSpec instance = StudentCollection.createStudentCollection(1);
            StudentSpec aStudent1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
            instance.addStudent(aStudent1);
            thrownException = null;
            int expected1 = 1;
            int actual1 = instance.getCapacity();
            int expected2 = 1;
            int actual2 = instance.getStudentCount();

            assertNotNull(instance);
            assertTrue(instance.isFull());
            assertNull(thrownException);
            assertEquals(expected1, actual1);
            assertEquals(expected2, actual2);
            assertEquals(0, instance.getSpacesRemaining());
        }
        catch ( StudentCollectionException exception1 )
        {
            thrownException = exception1;
        }
        assertNull(thrownException);

        //createStudentCollection - size -1
        try
        {
            StudentCollectionSpec instance3 = StudentCollection.createStudentCollection(0);
            thrownException = null;
        }
        catch ( StudentCollectionException exception1 )
        {
            thrownException = exception1;
        }
        assertNotNull(thrownException);
    }

    /**
     * Test of createIterator method, of class StudentCollection.
     */
    @Test
    public void testCreateIterator() 
    {

        //createIterator - Empty Collection
        StudentCollectionSpec referenceCollection1 = StudentCollection.createStudentCollection(4);
        ArrayList<StudentSpec> checklistCollection1 = new ArrayList<>(4);

        Iterator<StudentSpec> iterator1 = referenceCollection1.createIterator();
        int counter1 = 0;

        while ( iterator1.hasNext() )
        {
            checklistCollection1.remove(0);
            counter1++;
            iterator1.next();
        }

        //createIterator - Non Empty Collection
        StudentCollectionSpec referenceCollection2 = StudentCollection.createStudentCollection(4);
        ArrayList<StudentSpec> checklistCollection2 = new ArrayList<>(4);

        StudentSpec student2 = Student.create("0183746", "John", "I", "Dep", "Art", 10, 12);
        checklistCollection2.add(student2);
        referenceCollection2.addStudent(student2);

        student2 = Student.create("0000002", "Allison", "N", "Dakota", "The", 14, 16);
        checklistCollection2.add(student2);
        referenceCollection2.addStudent(student2);

        student2 = Student.create("0000003", "luis", "J", "King", "CSC", 2, 2);
        referenceCollection2.addStudent(student2);
        checklistCollection2.add(student2);

        student2 = Student.create("1040004", "Princess", "G", "Leia", "The", 15, 16);
        referenceCollection2.addStudent(student2);
        checklistCollection2.add(student2);

        Iterator<StudentSpec> iterator2 = referenceCollection2.createIterator();
        int counter2 = 0;

        while ( iterator2.hasNext() )
        {
            checklistCollection2.remove(0);
            counter2++;
            iterator2.next();
        }

        assertEquals(counter2, referenceCollection2.getStudentCount());
        assertTrue(checklistCollection2.isEmpty());
        assertFalse(iterator2.hasNext());
        // Assert NoSuchElementException

        //createIterator - remove exception
        StudentCollectionSpec referenceCollection4 = StudentCollection.createStudentCollection(4);
        ArrayList<StudentSpec> checklistCollection4 = new ArrayList<>(4);

        Iterator<StudentSpec> iterator4 = referenceCollection4.createIterator();
        int counter4 = 0;
        try
        {
            while ( iterator4.hasNext() )
            {
                checklistCollection4.remove(0);
                counter4++;
                iterator4.next();

            }
        }
        catch ( UnsupportedOperationException exception1 )
        {

        }

    }

    /**
     * Test of getSpacesRemaining method, of class StudentCollection.
     */
    @Test
    public void testGetSpacesRemaining() //Complete - 100%
    {
        //getSpacedRemaining - Empty Collection
        StudentCollectionSpec instance = StudentCollection.createStudentCollection();
        int expected = 5000;
        int actual = instance.getSpacesRemaining();
        assertEquals(expected, actual);
        
        //getSpacesRemaining - Non Empty Collection
        StudentCollectionSpec instance2 = StudentCollection.createStudentCollection(10);

        StudentSpec student1 = Student.create("0176440", "Zachary", "T", "Rich", "CSC");
        StudentSpec student2 = Student.create("0176441", "Aria", "L", "Keiras", "CSC");
        instance2.addStudent(student1);
        instance2.addStudent(student2);

        int expected2 = 8;
        int actual2 = instance2.getSpacesRemaining();
        assertEquals(expected2, actual2);
    }

    /**
     * Test of writeCollectionToDisk method, of class StudentCollection.
     */
    @Test
    public void testWriteCollectionToDisk()
    {
        Exception thrownException;

        //writeCollectionToDisk - writeToDisk
        String targetFileName = "testFile";
        StudentCollectionSpec referenceCollection = StudentCollection.createStudentCollection(10);
        StudentCollectionSpec checklistCollection = StudentCollection.createStudentCollection(10);

        StudentSpec student = Student.create("6005001", "John", "nnnnnnn", "Cena", "Art", 10, 12);
        referenceCollection.addStudent(student);
        checklistCollection.addStudent(student);

        student = Student.create("2070802", "Alfred", "Nerd", "Dork", "The", 14, 16);
        referenceCollection.addStudent(student);
        checklistCollection.addStudent(student);

        referenceCollection.writeCollectionToDisk(targetFileName);
        boolean expectedFile = StudentCollectionSpec.fileExists(targetFileName);
        assertTrue(expectedFile);

        StudentCollectionSpec retrievedCollection = StudentCollection.createStudentCollection(10);
        retrievedCollection.retrieveCollectionFromDisk(targetFileName);
        Iterator<StudentSpec> iterator = retrievedCollection.createIterator();
        int counter = 0;

        while ( iterator.hasNext() )
        {
            student = iterator.next();
            checklistCollection.removeStudentBySID(student.getSID());
            counter++;
        }
        int expectedStudents = referenceCollection.getStudentCount();
        int retrievedStudents = retrievedCollection.getStudentCount();

        assertEquals(expectedStudents, retrievedStudents);
        assertEquals(0, checklistCollection.getStudentCount());
        assertEquals(counter, retrievedStudents);

        //writeCollectionToDisk - fileName cant be null
        String targetFileName2 = null;
        System.out.println(targetFileName2);
        StudentCollectionSpec referenceCollection2 = StudentCollection.createStudentCollection(10);
        StudentCollectionSpec checklistCollection2 = StudentCollection.createStudentCollection(10);

        StudentSpec student2 = Student.create("6005001", "John", "nnnnnnn", "Cena", "Art", 10, 12);
        referenceCollection2.addStudent(student2);
        checklistCollection2.addStudent(student2);

        student2 = Student.create("2070802", "Alfred", "Nerd", "Dork", "The", 14, 16);
        referenceCollection2.addStudent(student2);
        checklistCollection2.addStudent(student2);

        StudentCollectionSpec retrievedCollection2 = StudentCollection.createStudentCollection(10);

        assertNull(targetFileName2);

        try
        {

            thrownException = null;
            referenceCollection.writeCollectionToDisk(targetFileName2);

        }
        catch ( IllegalArgumentException exception2 )
        {
            thrownException = exception2;
        }

        assertTrue(thrownException instanceof IllegalArgumentException);

        //writeCollectionToDisk - fileName cant be empty String
        String targetFileName3 = "";
        StudentCollectionSpec referenceCollection3 = StudentCollection.createStudentCollection(10);
        StudentCollectionSpec checklistCollection3 = StudentCollection.createStudentCollection(10);

        StudentSpec student3 = Student.create("6005001", "John", "nnnnnnn", "Cena", "Art", 10, 12);
        referenceCollection3.addStudent(student3);
        checklistCollection3.addStudent(student3);

        student3 = Student.create("2070802", "Brahim", "Bro", "Azeni", "The", 14, 16);
        referenceCollection2.addStudent(student3);
        checklistCollection2.addStudent(student3);

        StudentCollectionSpec retrievedCollection3 = StudentCollection.createStudentCollection(10);

        assertEquals(targetFileName3.length(), 0);

        try
        {

            thrownException = null;
            referenceCollection3.writeCollectionToDisk(targetFileName3);

        }
        catch ( IllegalArgumentException exception3 )
        {
            thrownException = exception3;
        }

        assertTrue(thrownException instanceof IllegalArgumentException);

        //writeCollectionToDisk - writeToDisk
        String targetFileName4 = "testFile";
        StudentCollectionSpec referenceCollection4 = StudentCollection.createStudentCollection(10);
        StudentCollectionSpec checklistCollection4 = StudentCollection.createStudentCollection(10);

        StudentSpec student4 = Student.create("6005001", "John", "nnnnnnn", "Cena", "Art", 10, 12);
        referenceCollection4.addStudent(student4);
        checklistCollection4.addStudent(student4);

        student4 = Student.create("2070802", "Alfred", "Nerd", "Dork", "The", 14, 16);
        referenceCollection4.addStudent(student4);
        checklistCollection4.addStudent(student4);

        referenceCollection4.writeCollectionToDisk(targetFileName);
        boolean expectedFile4 = StudentCollectionSpec.fileExists(targetFileName4);
        assertTrue(expectedFile4);

        StudentCollectionSpec retrievedCollection4 = StudentCollection.createStudentCollection(10);

        try
        {
            thrownException = null;
            retrievedCollection4.retrieveCollectionFromDisk(targetFileName4);
        }
        catch ( StudentCollectionException exception4 )
        {
            thrownException = exception4;
        }

        Iterator<StudentSpec> iterator4 = retrievedCollection4.createIterator();
        int counter4 = 0;

        while ( iterator4.hasNext() )
        {
            student4 = iterator4.next();
            checklistCollection4.removeStudentBySID(student4.getSID());
            counter4++;
        }
        int expectedStudents4 = referenceCollection.getStudentCount();
        int retrievedStudents4 = retrievedCollection.getStudentCount();

        assertEquals(expectedStudents4, retrievedStudents4);
        assertEquals(0, checklistCollection4.getStudentCount());
        assertEquals(counter4, retrievedStudents4);
        assertTrue(fileExists(targetFileName4));
        assertNull(thrownException);

    } //Not Complete

    /**
     * Test of fileExists method, of class StudentCollection.
     */
    @Test
    public void testFileExists() //Complete - 100%
    {
     
        //fileExists
        String fileName = "a";
        StudentCollectionSpec instance = StudentCollection.createStudentCollection();
        boolean actual = StudentCollectionSpec.fileExists(fileName);
        instance.writeCollectionToDisk(fileName);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /**
     * Test of retrieveCollectionFromDisk method, of class StudentCollection.
     */
    @Test
    public void testRetrieveCollectionFromDisk() 
    {
        
        Exception thrownException;
        
        //retrieveCollectionFromDisk - Valid File
        String fileName = "testFile";

        StudentCollectionSpec referenceCollection = StudentCollection.createStudentCollection(5);
        StudentCollectionSpec checklistCollection = StudentCollection.createStudentCollection(5);

        StudentSpec student = Student.create("0000001", "John", "nnnnnnn", "Cena", "SMS", 10, 12);
        referenceCollection.addStudent(student);
        checklistCollection.addStudent(student);

        student = Student.create("0000002", "Alfred", "Nerd", "Dork", "The", 14, 16);
        referenceCollection.addStudent(student);
        checklistCollection.addStudent(student);

        assertNotNull(fileName);
        referenceCollection.writeCollectionToDisk(fileName);
        boolean expectedFile = StudentCollectionSpec.fileExists(fileName);
        assertTrue(expectedFile);

        StudentCollectionSpec retrievedCollection = StudentCollection.createStudentCollection(10);
        retrievedCollection.retrieveCollectionFromDisk(fileName);
        Iterator<StudentSpec> iterator = retrievedCollection.createIterator();
        int counter = 0;

        while ( iterator.hasNext() )
        {
            student = iterator.next();
            checklistCollection.removeStudentBySID(student.getSID());
            counter++;
        }
        int expectedStudents = referenceCollection.getStudentCount();
        int retrievedStudents = retrievedCollection.getStudentCount();

        assertEquals(expectedStudents, retrievedStudents);
        assertEquals(0, checklistCollection.getStudentCount());
        assertEquals(counter, retrievedStudents);

        //retrieveCollectionFromDisk - null File Name
        String fileName2 = null;


        StudentCollectionSpec retrievedCollection2 = StudentCollection.createStudentCollection(10);
        
        try
        {
            assertNull(fileName2);
            retrievedCollection2.retrieveCollectionFromDisk(fileName2);
            thrownException = null;
        }
        catch(IllegalArgumentException exception2)
        {
            thrownException = exception2;
        }

        assertTrue(thrownException instanceof IllegalArgumentException);
        
        
        //retrieveCollectionFromDisk - empty String File Name
        String fileName3 = "";

        StudentCollectionSpec retrievedCollection3 = StudentCollection.createStudentCollection(10);
        
        try
        {
            retrievedCollection3.retrieveCollectionFromDisk(fileName3);
            thrownException = null;
        }
        catch(IllegalArgumentException exception3)
        {
            thrownException = exception3;
        }

        assertTrue(thrownException instanceof IllegalArgumentException);
        
        
        //retrieveCollectionFromDisk - fileName must exist
        String fileName4 = "randomfile";

        StudentCollectionSpec retrievedCollection4 = StudentCollection.createStudentCollection(10);
        
        try
        {
            retrievedCollection4.retrieveCollectionFromDisk(fileName4);
            thrownException = null;
        }
        catch(StudentCollectionException exception4)
        {
            thrownException = exception4;
        }

        assertTrue(thrownException instanceof StudentCollectionException);
        
        
        //retrieveCollectionFromDisk - file Exists but no serializable content
        String fileName5 = "testFile.docx";

        StudentCollectionSpec retrievedCollection5 = StudentCollection.createStudentCollection(10);
        
        try
        {
            retrievedCollection5.retrieveCollectionFromDisk(fileName5);
            thrownException = null;
        }
        catch(StudentCollectionException exception5)
        {
            thrownException = exception5;
        }

        assertTrue(thrownException instanceof StudentCollectionException);
        
        
        //retrieveCollectionFromDisk - Serializable content from another class
        student = Student.create("2070802", "Brahim", "m", "Azeni", "The", 14, 16);
        
        
        
        //retrieveCollectionFromDisk - SVUID differs from current SVUID
        
        
    }

    @Test(expected = StudentSpecException.class)
    public void testStudentSpecException()
    {
        System.out.println("|TEST: testStudentSpecValidation");

        StudentSpec student = Student.create("0176440", "Zachary", "T", "Rich", "CSC");

        String theFirstName = "";

        student.setFirstName(theFirstName);

    }

}
