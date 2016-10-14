package io.hextlet.ArrayListImpl;

import java.util.*;

public class ArrayList<T> extends AbstractList<T> {
    private int initialCapacity;

    private int size;

    private T[] m;


    public ArrayList() {
        this.initialCapacity = 10;
        this.size = 0;
        m = (T[]) new Object[this.initialCapacity];
    }

    public ArrayList(Collection<? extends T> c) {
        this.initialCapacity = c.size();
        this.size = c.size();
        m = (T[]) c.toArray();
    }

    public ArrayList(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.size = 0;
        m = (T[]) new Object[this.initialCapacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T t) {
        ensureCapacity();

        this.m[size++] = t;
        return true;
    }

    @Override
    public T set(int index, T element) {
        T oldValue = this.m[index];
        this.m[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity();

        System.arraycopy(this.m, index, this.m, index+1, this.size()-index);
        this.m[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        T value = this.m[index];
        System.arraycopy(this.m, index+1, this.m, index, this.size() - index - 1);
        size--;

        return value;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size(); i++ ) {
                if(this.m[i] == null) return i;
            }
        } else {
            for (int i = 0; i < this.size(); i++ ) {
                if(this.m[i] != null && this.m[i].equals(o)) return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = this.size()-1; i > -1 ; i-- ) {
                if(this.m[i] == null) return i;
            }
        } else {
            for (int i = this.size()-1; i > -1 ; i-- ) {
                if(this.m[i] != null && this.m[i].equals(o)) return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        this.m = (T[]) new Object[0];
        this.initialCapacity = 0;
        this.size = 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element : c) {
            add(index++, element);
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ArrayIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ArrayIterator(index);
    }

    private class ArrayIterator implements  ListIterator<T> {
        private int cursor;

        private int last = -1;

        ArrayIterator() {
            this.cursor = 0;
        }

        ArrayIterator(int index) {
            this.cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor < ArrayList.this.size();
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            last = cursor;
            return ArrayList.this.m[cursor++];
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public T previous() {
            if(!hasPrevious()) throw new NoSuchElementException();
            last = cursor;
            return ArrayList.this.m[--cursor];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor-1;
        }

        @Override
        public void remove() {
            if (last == -1) throw new IllegalStateException();
            ArrayList.this.remove(last);
            cursor--;
            last = -1;

        }

        @Override
        public void set(T t) {
            if (last == -1) throw new IllegalStateException();
            ArrayList.this.set(last, t);
            last = -1;
        }

        @Override
        public void add(T t) {
            if (last == -1) throw new IllegalStateException();
            ArrayList.this.add(last, t);
            cursor++;
            last = -1;
        }
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof List<?>)) return false;
        if(o == this) return true;

        ArrayList<T> tmp = (ArrayList<T>)o;

        if(this.size() == tmp.size()) {
            for(int i = 0; i < this.size(); i++ ) {
                if ( this.get(i) == null && this.get(i) != tmp.get(i)) {
                    return false;
                } else if (this.get(i) != null && !(this.get(i)).equals(tmp.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    @Override
    public T get(int index) {
        return ArrayList.this.m[index];
    }

    private void ensureCapacity() {
        if (size() >= this.initialCapacity && this.initialCapacity != 0) {
            T[] newM = this.m;
            this.initialCapacity *= 2;
            this.m = (T[]) new Object[this.initialCapacity];
            System.arraycopy(newM, 0, this.m, 0, size());

        } else if(size() >= this.initialCapacity && this.initialCapacity == 0) {
            T[] newM = this.m;
            this.initialCapacity = 10;
            this.m = (T[]) new Object[this.initialCapacity];
        }
    }
}