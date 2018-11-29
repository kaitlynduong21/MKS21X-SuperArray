public class SuperArray {

  private String[] data;
  private int size;

  //PHASE ONE
  public SuperArray() {
    data = new String [10];
    size = 0;
  }

  public SuperArray(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException ();
    }
    data = new String [initialCapacity];
    size = 0;
  }

  public void clear(){
    data = new String[10];
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
      throw new IndexOutOfBoundsException ();
    }
    return data[index];
  }

  public String set(int index, String element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException ();
    }
    String old = data[index];
    data[index] = element;
    return old;
  }

  //PHASE TWO

  private void resize() {
    String[] newArray = new String[data.length * 2 + 1];
    for (int i = 0; i < data.length; i ++) {
      newArray[i] = data[i];
    }
    data = newArray;
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
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException ();
    }
    if (size == data.length) {
        resize();
    }
    for (int i = size; i > index; i--) {
        data[i] = data[i -1];
      }
      size ++;
      data[index] = element;
  }

  public boolean remove(String target) {
    if (contains(target)) {
      remove(indexOf(target));
      return true;
    }
    return false;
  }

  public String remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException ();
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
