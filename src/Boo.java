import java.io.Serializable;
import java.util.Arrays;

public class Boo implements Serializable {
    private Foo[] _foos;

    public Boo(Foo[] _foos) {
        this._foos = _foos;
    }

    public Foo[] get_foos() {
        return _foos;
    }

    public void print() {
        System.out.println("Boo");
        for (int i = 0; i < _foos.length; i++) {
            System.out.println("Foo[" + i + "]:");
            _foos[i].print();
        }
    }
}
