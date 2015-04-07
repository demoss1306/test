package allatra.test;

public abstract class Vector {


    abstract public int size();

    abstract public double get(int index);

    abstract public void set(int index, double value);

    public int indexOf(double value) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == value) return i;
        }
        return -1;
    }

    public void add(Vector vector) {
        if (this.size() != vector.size()) throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < size(); i++)
            set(i, this.get(i) + vector.get(i));
    }

    public void subtract(Vector vector) {
        if (this.size() != vector.size()) throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < size(); i++)
            set(i, this.get(i) - vector.get(i));
    }

    public void multiply(Vector vector) {
        if (this.size() != vector.size()) throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < size(); i++)
            set(i, this.get(i) * vector.get(i));
    }

    public void sort() {
        double tempValue;
        for (int i = 0; i < size() - 1; i++)
            for (int j = 0; j < size() - i - 1; j++)
                if (get(j) > get(j + 1)) {
                    tempValue = get(j);
                    set(j, get(j + 1));
                    set(j + 1, tempValue);
                }
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < size(); i++)
            sum += get(i);
        return sum / size();
    }

    public double minimum() {
        if (size() == 0) throw new ArrayIndexOutOfBoundsException();
        double minValue = get(0);
        for (int i = 1; i < size(); i++)
            if (minValue > get(i)) minValue = get(i);
        return minValue;
    }

    public double maximum() {
        if (size() == 0) throw new ArrayIndexOutOfBoundsException();
        double maxValue = get(0);
        for (int i = 1; i < size(); i++)
            if (maxValue < get(i)) maxValue = get(i);
        return maxValue;
    }
}

