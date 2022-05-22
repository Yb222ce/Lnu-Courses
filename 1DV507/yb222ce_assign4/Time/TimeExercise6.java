package yb222ce_assign4.Time;

public class TimeExercise6 {
	public static void main(String[] args) {
        ConcatenationS();

        ConcatenationL();

        appendS();

        appendL();
    }
    public static void ConcatenationS(){
        String s = "";
        long before = System.currentTimeMillis();
        while (System.currentTimeMillis() - before < 1000){
            s = s + "a";
        }
        long estimatedTime = (System.currentTimeMillis()-before)/1000;
        System.out.println("In "+estimatedTime+" second, string concatenation short string appends "
                +s.length()+" times and the length is " +
                s.length());
    }

    public static void ConcatenationL(){
        String s = "";
        long before = System.currentTimeMillis();
        while (System.currentTimeMillis() - before < 1000){
            s = s + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
        long estimatedTime = (System.currentTimeMillis()-before)/1000;
        System.out.println("In "+estimatedTime+" second string concatenation long string appends "
                +s.length()/80+" times and the length is " +
                s.length());
    }
    private static void appendS() {
        StringBuilder stringBuilder = new StringBuilder();
        long before = System.currentTimeMillis();
        while (System.currentTimeMillis() - before < 1000){
            stringBuilder.append("a");
        }
        String s = stringBuilder.toString();
        long estimatedTime = (System.currentTimeMillis()-before)/1000;
        System.out.println("In "+estimatedTime+" second second string append short string appends "
                +s.length()+" times and the length is " +
                s.length());

    }

    public static void appendL(){
        StringBuilder stringBuilder = new StringBuilder();
        long before = System.currentTimeMillis();
        while (System.currentTimeMillis() - before < 1000){
            stringBuilder.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }
        String s = stringBuilder.toString();
        long estimatedTime = (System.currentTimeMillis()-before)/1000;
        System.out.println("In "+estimatedTime+" second second string append long string appends "
                +s.length()/80+" times and the length is " +
                s.length());
    }

}


