public class SuperArray {

  private String[] data;
  private int size;

  //PHASE ONE
  public SuperArray() {
    data = new String [10];
    size = 0;
  }

  public SuperArray(int x) {
    data = new String [x];
    size = 0;
  }

  public void clear(){
    for (int i = 0; i > size; i ++) {
      data[i] = null;
    }
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean add(String element) {
    if (size == data.length) {
      resize();
    }
    data[size] = element;
    size++;
    return (data[size - 1] == element);
  }

  public String toString() {
    String newString = "[";
    for (int i = 0; i < size(); i ++) {
      newString = newString + data[i];
      if (i != size() - 1) {
        newString += ", ";
      }
    }
    newString = newString + "]";
    return newString;
  }

  public String toStringDebug() {
    String newString = "[";
    for (int i = 0; i < size(); i ++) {
      newString = newString + data[i];
      if (i != data.length - 1) {
        newString += ", ";
      }
    }
    for (int x = size; x < data.length; x ++) {
      newString = newString + "null";
      if (x != data.length - 1) {
        newString += ", ";
      }
    }
    newString += "]";
    return newString;
  }

  public String get(int index) {
    if (index < 0 || index >= size) {
      System.out.println ("error: index out of bounds");
      return null;
    }
    return data[index];
  }

  public String set(int index, String element) {
    if (index < 0 || index >= size) {
      System.out.println ("error: index out of bounds");
      return null;
    }
    String old = data[index];
    data[index] = element;
    return old;
  }

  //PHASE TWO

  private void resize() {
    SuperArray newArray = new SuperArray(data.length * 2);
    for (int i = 0; i < data.length; i ++) {
      newArray.data[i] = data[i];
    }
    data = newArray.data;
  }

  //PHASE THREE

  public boolean contains(String target) {
    for (int i = 0; i < size; i ++) {
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target) {
    for (int i = 0; i < size; i ++) {
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    for (int i = size - 1; i >= 0; i--) {
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }

  public void add(int index, String element) {
    if (index > 0 && index <= size) {
      if (size == data.length) {
        resize();
      }
      for (int i = size; i >= index; i--) {
        data[i] = data[i - 1];
      }
      size ++;
      set(index, element);
    }
  }

  public boolean remove(String target) {
    for (int i = 0; i < size - 1; i ++) {
      if (data[i].equals(target)) {
        for (int x = i; x < size; x ++) {
          data[x] = data [x + 1];
        }
        size--;
        return true;
      }
    }
    return false;
  }

  public String remove(int index) {
    if (index < 0 || index >= size) {
      System.out.println("error: index out of bounds");
      return null;
    }
    if (data[index] == null) {
      return null;
    }
    String s = data[index];
    for (int i = index; i < size - 1; i ++) {
      data[i] = data [i + 1];
    }
    size--;
    return s;
  }
}
