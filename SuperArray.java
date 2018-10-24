public class SuperArray {

  private String[] data;
  private int size;

  public SuperArray() {
     data = new String [10];
     size = 0;
  }

  public SuperArray(int x) {
     data = new String [x];
     size = 0;
  }

  public void clear(){
    size = 0;
  }

  public int size() {
    for (int i = 0; i < data.length; i++) {
      if (data[i] != null) {
        size++;
      }
      if (data[i] == null) {
        return size;
      }
    }
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean add(String element) {
    /*if (size == data.length) {
      resize();
    }*/
    size();
    data[size] = element;
    return (data[size] == element);
  }

  public String toString() {
    String newString = "[";
    for (int i = 0; i < size - 1; i ++) {
      newString = newString + data[i] + ", ";
    }
    if (size != 0) {
      newString = newString + data[size - 1] + "]";
    } else {
      newString += "]";
    }
    return newString;
  }

  public String toStringDebug() {
    String newString = "[";
    for (int i = 0; i < size; i ++) {
      newString = newString + data[i] + ", ";
    }
    for (int i = size; i < data.length - 1; i ++) {
      newString = newString + "null, ";
    }
    newString += "null]";
    return newString;
  }

  public String get(int index) {
    if (index < 0 || index >= size) {
      return "null";
    }
    return data[index];
  }

  public String set(int index, String element) {
    if (index < 0 || index >= size) {
      return "null";
    }
    String old = data[index];
    data[index] = element;
    return old;
  }

  private void resize() {
    SuperArray newdata = new SuperArray(data.length * 2);
    for (int i = 0; i < data.length; i ++) {
      newdata.data[i] = data[i];
    }
  }
}
