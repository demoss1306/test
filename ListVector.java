package allatra.test;


public class ListVector extends Vector {

    public Node firstNode;

    public ListVector(int size) {
        if (size <= 0) {
            firstNode = null;
            return;
        }
        Node lastNode = firstNode = new Node();
        for (int i = 0; i < size - 1; i++) {
            lastNode.next = new Node();
            lastNode = lastNode.next;
        }
    }

    public ListVector(double[] elements) {
        Node lastNode = firstNode = new Node();
        for (int i = 0; i < elements.length; i++) {
            lastNode.value = elements[i];
            if (i < elements.length - 1) {
                lastNode.next = new Node();
                lastNode = lastNode.next;
            }
        }
    }
    
    @Override
    public int hashCode (){
        final int constant = 7;
        int result = 7;
        result = result * constant + (firstNode == null ? 0 : fistNode.hashCode());
        return result;
    }
    
    @Override
    public boolean equals (Object otherObject){
        if (this == otherObject) return true;
        if ((otherObject == null) || (getClass() != otherObject.getClass())) return false;
        ListVector otherVector = (ListVector)otherObject;
        if (firstNode.equals(otherVector.firstNode)) return true;
        else return false;
    }
    
    @Override
    public String toString(){
        String vectorName = this.name + " {";
        for (i = 0; i < size(); i++)
            vectorName +=  getValue(i) + " ";
        return  vectorName + "}";
    }
    
    @Override
    public ListVector clone() throws CloneNotSupportedException {
        ListVector vector = (ListVector)super.clone();
        vector.produced = produced.clone();
        return vector;
    }
    
    public int size() {
        Node tempNode = firstNode;
        for (int size = 0; ; size++)
            if (tempNode == null) return size;
            else tempNode = tempNode.next;
    }

    public double get(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        Node tempNode = firstNode;
        for (int j = 0; j < index; j++)
            tempNode = tempNode.next;
        return tempNode.value;
    }

    public void set(int index, double value) {
        Node tempNode = firstNode;
        for (int j = 0; j < index; j++) {
            tempNode = tempNode.next;
        }
        tempNode.value = value;
    }

    public void insert(int index, double value) {
        if (index < 0 || index > size()) throw new ArrayIndexOutOfBoundsException();
        Node tempNode;
        if (index == 0) {
            tempNode = new Node();
            tempNode.value = value;
            tempNode.next = firstNode;
            firstNode = tempNode;
        } else {
            tempNode = firstNode;
            for (int j = 0; j < index - 1; j++)
                tempNode = tempNode.next;
            Node newNode = new Node();
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.value = value;
        }
    }

    public double remove(int index) {
        if (index < 0 || index > size()) throw new ArrayIndexOutOfBoundsException();
        double value;
        if (index == 0) {
            value = firstNode.value;
            firstNode = firstNode.next;
            return value;
        } else {
            Node tempNode = firstNode;
            for (int j = 0; j < index - 1; j++)
                tempNode = tempNode.next;
            value = tempNode.next.value;
            tempNode.next = tempNode.next.next;
            return value;
        }
    }

    private class Node {
        private double value;
        private Node next;
    }
}
