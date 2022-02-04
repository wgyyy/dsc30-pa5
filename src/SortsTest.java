import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortsTest {

    @org.junit.Test
    public void insertionSort() {
        Sorts test=new Sorts();
        ArrayList test1 = new ArrayList();
        test1.add("A");
        test1.add("C");
        test1.add("B");
        test.InsertionSort(test1,0,2);
        ArrayList expected = new ArrayList();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        assertEquals(expected,test1);
        ArrayList test2 = new ArrayList();
        test2.add(1);
        test2.add(9);
        test2.add(2);
        test2.add(7);
        test2.add(3);
        test2.add(4);
        test2.add(8);
        test2.add(10);
        test2.add(5);
        test2.add(6);
        test.InsertionSort(test2,0,9);
        expected.clear();
        for (int i=1;i<11;i++){
            expected.add(i);
        }
        assertEquals(expected,test2);
        ArrayList test3 = new ArrayList();
        for (int i=20;i>0;i--){
            test3.add(i);
        }
        expected.clear();
        for (int i=1;i<=20;i++){
            expected.add(i);
        }
        test.InsertionSort(test3,0,19);
        assertEquals(expected,test3);

    }

    @org.junit.Test
    public void mergeSort() {
    }

    @org.junit.Test
    public void quickSort() {
        Sorts test=new Sorts();
        ArrayList test1 = new ArrayList();
        test1.add(6);
        test1.add(2);
        test1.add(1);
        test1.add(3);
        test1.add(9);
        test.QuickSort(test1,0,4);
        ArrayList expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);
        expected.add(9);
        assertEquals(expected,test1);
        ArrayList test2 = new ArrayList();
        test2.add(1);
        test2.add(2);
        test2.add(7);
        test2.add(4);
        test2.add(8);
        test2.add(10);
        test2.add(6);
        test.QuickSort(test2,0,6);
        expected.clear();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(10);
        assertEquals(expected,test2);
        ArrayList test3 = new ArrayList();
        for (int i=20;i>0;i--){
            test3.add(i);
        }
        expected.clear();
        for (int i=1;i<=20;i++){
            expected.add(i);
        }
        test.QuickSort(test3,0,19);
        assertEquals(expected,test3);
    }

    @org.junit.Test
    public void modified_QuickSort() {
        Sorts test=new Sorts();
        ArrayList test1 = new ArrayList();
        test1.add(1);
        test1.add(3);
        test1.add(5);
        test1.add(2);
        test1.add(4);
        test.Modified_QuickSort(test1,0,4,2);
        ArrayList expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        assertEquals(expected,test1);
        ArrayList test2 = new ArrayList();
        test2.add(1);
        test2.add(9);
        test2.add(2);
        test2.add(7);
        test2.add(3);
        test2.add(4);
        test2.add(8);
        test2.add(10);
        test2.add(5);
        test2.add(6);
        test.Modified_QuickSort(test2,0,9,2);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        assertEquals(expected,test2);
        ArrayList test3 = new ArrayList();
        for (int i=20;i>0;i--){
            test3.add(i);
        }
        for (int i=11;i<=20;i++){
            expected.add(i);
        }
        test.Modified_QuickSort(test3,0,19,2);
        assertEquals(expected,test3);
    }

    @org.junit.Test
    public void cocktailSort() {
        Sorts test=new Sorts();
        ArrayList test1 = new ArrayList();
        test1.add(1);
        test1.add(-1);
        test1.add(100);
        test1.add(0);
        test.cocktailSort(test1,0,2);
        ArrayList expected = new ArrayList();
        expected.add(-1);
        expected.add(1);
        expected.add(100);
        expected.add(0);
        assertEquals(expected,test1);
        ArrayList test2 = new ArrayList();
        test2.add(-1);
        test2.add(-2);
        test2.add(-3);
        test2.add(-4);
        test2.add(-5);
        test.cocktailSort(test2,0,4);
        expected.clear();
        expected.add(-5);
        expected.add(-4);
        expected.add(-3);
        expected.add(-2);
        expected.add(-1);
        assertEquals(expected,test2);
        ArrayList test3 = new ArrayList();
        for (int i=100;i>0;i--){
            test3.add(i);
        }
        expected.clear();
        for (int i=1;i<=100;i++){
            expected.add(i);
        }
        test.cocktailSort(test3,0,99);
        assertEquals(expected,test3);
    }
}