package yb222ce_assign1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StringStack implements StringStackInterface {
	private String[] data;

    StringStack() {
        data = new String[0];
    }

    // Current stack size
    public int size() {
        return data.length;
    }

    // true if stack is empty
    public boolean isEmpty() {
        return data.length == 0;
    }

    // Add element at top of stack
    public void push(String element) {
        String [] tmp = this.data;
        this.data = Arrays.copyOf(tmp, data.length+1); //  new String [];
        this.data[data.length-1] = element;
    }

    // Return and remove top element,
    public String pop() {
        if(data.length == 0) {
            throw new EmptyStackException();
        } else {
            String tmp = data[data.length-1];
            this.data = Arrays.copyOf(data, data.length-1);
            return tmp;
        }
    }

    // Return (without removing) top element,
    // exception if stack is empty.
    public String peek() {
        if(data.length == 0) {
            throw new EmptyStackException();
        } else {
            return data[data.length-1];
        }
    }

    @Override
    public String toString() {
        String aux = "[";
        for(String elem: data) {
            aux +=" "+elem+",";
        }
        if(data.length>0) {
            aux = aux.substring(0, aux.length() - 1);
        }
        return aux+" ]";
    }



}
