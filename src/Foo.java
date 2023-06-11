import java.io.Serializable;

public class Foo implements Serializable {
    private int _a;
    private String _b;
    private int[] _c;

    public Foo(int a, String b, int[] c) {
        System.out.println("Constructor");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

        _a = a;
        _b = b;
        _c = c;
    }

    public void print() {
        System.out.println("a: " + _a);
        System.out.println("b: " + _b);
        for (int i = 0; i < _c.length; i++) {
            System.out.println("c[" + i + "]: " + _c[i]);
        }
    }

    public int[] get_c() {
        return _c;
    }

    public String get_b() {
        return _b;
    }

    public int get_a() {
        return _a;
    }
}
