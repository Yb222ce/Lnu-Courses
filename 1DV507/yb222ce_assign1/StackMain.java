package yb222ce_assign1;

public class StackMain {
	public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Hello");
        test.push("World");

        System.out.println("PEEK: "+test.peek());
        System.out.println(" The size of it:" + test.size());
        String last = test.pop();
            System.out.println(" The size of it:" + test.size());
        System.out.println("PEEK after pop: "+test.peek());
        System.out.println("LAST: "+last);
        System.out.println(test.toString());
    }

}
