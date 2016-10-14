package io.hextlet.ArrayListImpl;

import org.junit.Test;

import java.util.ListIterator;

import static org.junit.Assert.*;

public class ArrayIteratorTest {
    @Test
    public void hasNextTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListIterator<Integer> iter = arrayList.listIterator();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertTrue(iter.hasNext());
    }

    @Test
    public void nextTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListIterator<Integer> iter = arrayList.listIterator();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(new Integer(1), iter.next());
        assertEquals(new Integer(2), iter.next());
    }

    @Test
    public void testNextOnEmptyArrayList() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);

        ListIterator<Integer> iter = arrayList.listIterator();

        iter.next();
        iter.remove();
        iter.next();
        iter.remove();

        try {
            iter.next();
            fail("next do not throw the Exception when no more elements");
        } catch (java.util.NoSuchElementException e) {}
    }


    @Test
    public void hasPreviousTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListIterator<Integer> iter = arrayList.listIterator(2);

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertTrue(iter.hasPrevious());
    }

    @Test
    public void previousTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListIterator<Integer> iter = arrayList.listIterator(3);

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(new Integer(3), iter.previous());
        assertEquals(new Integer(2), iter.previous());
    }

    @Test
    public void testHasPreviousWhenIteratorAtTheEndOfTheCollection() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        listIterator.next();

        assertTrue(listIterator.hasPrevious());
    }

    @Test
    public void testPreviousIndexWhenItEqualsTo1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        listIterator.next();
        listIterator.next();

        assertEquals(1, listIterator.previousIndex());
    }

    @Test
    public void testSetWhenNeitherNextNorPreviousHaveBeenCalled() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        ListIterator<Integer> listIterator = arrayList.listIterator();

        try {
            listIterator.set(null);
            fail("set method do not throw IllegalStateException the if neither next nor previous have been called");
        } catch (IllegalStateException e){}
    }

    @Test
    public void testSet() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        listIterator.next();
        listIterator.set(2);
        assertEquals((Integer)2, arrayList.get(0));
    }

    @Test
    public void testPreviousOnCollectionWithOneElement() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        Integer next = listIterator.next();
        Integer previous = listIterator.previous();

        assertEquals(next, previous);
    }

    @Test
    public void testPreviousIndex() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        listIterator.next();

        assertEquals(0, listIterator.previousIndex());
    }

    @Test
    public void testPreviousIndexWhenEmptyCollection() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        ListIterator<Integer> listIterator = arrayList.listIterator();

        assertEquals(-1, listIterator.previousIndex());
    }

    @Test
    public void testPreviousWhenEmptyCollection() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        ListIterator<Integer> listIterator = arrayList.listIterator();

        try {
            listIterator.previous();
            fail("list iterator do not throw the Exception when called previous method on empty collection");
        } catch (java.util.NoSuchElementException e) {}
    }

    @Test
    public void testHasPreviouseWhenEmptyCollection() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        ListIterator<Integer> listIterator = arrayList.listIterator();

        assertFalse(listIterator.hasPrevious());
    }

    @Test
    public void testRemoveTwoTimeInTheRow() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        ListIterator<Integer> iter = arrayList.listIterator();
        iter.next();
        iter.remove();
        assertEquals("Expected collection size is 1, however actual is not", 1, arrayList.size());
        try {
            iter.remove();
            fail("remove do not throw the Exception when called twice");
        } catch (IllegalStateException e) {}
    }

}