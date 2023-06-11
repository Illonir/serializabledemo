import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Foo f1 = new Foo(1, "abc", new int[]{1,2,3});

        System.out.println("\tf1:");
        f1.print();

        if (save_foo(f1, "f1.bin")) {
            System.out.println("f1 saved");
        } else {
            System.out.println("Error while saving f1");
        }

        System.out.println("\tf1:");
        f1.print();

        Foo nf1 = load_foo("f1.bin");
        if (nf1 != null) {
            System.out.println("nf1 loaded");
            System.out.println("\tnf1:");
            nf1.print();
        } else {
            System.out.println("Error while loading f1");
        }

        Foo f2 = new Foo(2, "def", new int[]{4,5,6});


        Boo b1 = new Boo(new Foo[]{f1, f2});
        System.out.println("\tb1:");
        b1.print();

        if (save_boo(b1, "b1.bin")) {
            System.out.println("b1 saved");
        } else {
            System.out.println("Error while saving b1");
        }

        Boo nb1 = load_boo("b1.bin");
        if (nb1 != null) {
            System.out.println("nb1 loaded");
            System.out.println("\tnb1:");
            nb1.print();
        } else {
            System.out.println("Error while loading b1");
        }




    }

    public static boolean save_foo(Foo f, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(f);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }

    public static Foo load_foo(String filename) {
        Foo f = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            f = (Foo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Foo class not found");
            c.printStackTrace();
            return null;
        }
        return f;
    }

    public static boolean save_boo(Boo b, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(b);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }

    public static Boo load_boo(String filename) {
        Boo b = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            b = (Boo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Boo class not found");
            c.printStackTrace();
            return null;
        }
        return b;
    }
}