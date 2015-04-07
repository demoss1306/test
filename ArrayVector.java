package allatra.test;

public class ArrayVector extends Vector {

    private double[] values;

    public ArrayVector(double[] elements) {
        values = elements;
    }

    public ArrayVector(int size) {
        this.values = new double[size];
    }

    public int size() {
        return values.length;
    }

    public double get(int index) {
        //if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        return values[index];
    }

    public void set(int index, double value) {
        values[index] = value;
    }
}


