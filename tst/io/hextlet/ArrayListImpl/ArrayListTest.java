package io.hextlet.ArrayListImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void sizeWhenEmpty() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();

        assertEquals(0, arrayList.size());
    }

    @Test
    public void sizeWhenOne() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(1);
        arrayList.add(1);

        assertEquals(1, arrayList.size());
    }

    @Test
    public void sizeWhenMoreThenOne() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);

        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);

        assertEquals(4, arrayList2.size());
    }

    @Test
    public void addToEmptyArrayList() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(5, arrayList.size());
    }

    @Test
    public void addToNotEmptyArrayList() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);

        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList1);
        arrayList2.add(5);
        arrayList2.add(6);

        assertEquals(6, arrayList2.size());
    }

    @Test
    public void removeFirstElement() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.remove(0);

        assertEquals(4, arrayList.size());
        assertFalse(arrayList.contains(1));
    }

    @Test
    public void removeMiddleElement() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.remove(2);

        assertEquals(4, arrayList.size());
        assertFalse(arrayList.contains(3));
    }

    @Test
    public void removeLastElement() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.remove(4);

        assertEquals(4, arrayList.size());
        assertFalse(arrayList.contains(5));
    }

    @Test
    public void indexOfFirst() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(5);

        assertEquals(0, arrayList.indexOf(1));
    }

    @Test
    public void indexOfMiddle() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);

        assertEquals(2, arrayList.indexOf(3));
    }

    @Test
    public void indexOfLast() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(4, arrayList.indexOf(5));
    }

    @Test
    public void indexOfWhenNoSuchElement() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(-1, arrayList.indexOf(9));
    }

    @Test
    public void indexOfWhenElementNull() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(2, arrayList.indexOf(null));
    }

    @Test
    public void lastIndexOfLast() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(null);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(4, arrayList.lastIndexOf(5));
    }

    @Test
    public void lastIndexOfFirst() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(null);
        arrayList.add(4);
        arrayList.add(5);

        assertEquals(0, arrayList.lastIndexOf(1));
    }

    @Test
    public void clearTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(null);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.clear();

        assertEquals(0, arrayList.size());
    }

    @Test
    public void addAllInTheCenter() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(42);
        arrayList2.add(22);
        arrayList2.add(72);

        arrayList1.addAll(2, arrayList2);

        assertEquals(8, arrayList1.size());
        assertTrue(arrayList1.contains(22));
        assertEquals(new Integer(42), arrayList1.get(2));
        assertNull(arrayList1.get(5));
    }

    @Test
    public void addAllInTheEnd() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(42);
        arrayList2.add(22);
        arrayList2.add(72);

        arrayList1.addAll(4, arrayList2);

        assertEquals(8, arrayList1.size());
        assertEquals(new Integer(72), arrayList1.get(6));
    }

    @Test
    public void addAllInTheBeginning() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(42);
        arrayList2.add(22);
        arrayList2.add(72);

        arrayList1.addAll(0, arrayList2);

        assertEquals(8, arrayList1.size());
        assertEquals(new Integer(42), arrayList1.get(0));
    }


    @Test
    public void equalsSameObject() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(1);
        arrayList2.add(5);
        arrayList2.add(null);
        arrayList2.add(4);
        arrayList2.add(5);

        assertTrue(arrayList1.equals(arrayList2));
        assertTrue(arrayList1.equals(arrayList1));
    }

    @Test
    public void equalsSameEqualObjects() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(1);
        arrayList2.add(5);
        arrayList2.add(null);
        arrayList2.add(4);
        arrayList2.add(5);

        assertTrue(arrayList1.equals(arrayList2));
    }

    @Test
    public void equalsDifferentSize() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(1);
        arrayList2.add(5);
        arrayList2.add(null);
        arrayList2.add(4);

        assertFalse(arrayList1.equals(arrayList2));
    }

    @Test
    public void equalsObjectNotEqual() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.add(1);
        arrayList2.add(5);
        arrayList2.add(null);
        arrayList2.add(null);
        arrayList2.add(5);
    }

    @Test
    public void equalsObjectsNotArrayList() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        String name = "Some text";

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);


        assertFalse(arrayList1.equals(name));
    }

    @org.junit.Test
    public void getArrayListTest() throws Exception {
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(null);
        arrayList1.add(4);
        arrayList1.add(5);

        assertEquals(new Integer(5), arrayList1.get(1));
        assertNull(arrayList1.get(2));
    }

}