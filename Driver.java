import java.util.ArrayList;

public class Driver {
  public static void main(String[] args) {

ArrayList<String> key = new ArrayList<>();
    SuperArray ans = new SuperArray();
    for(int i = 0; i < 1000;i++){
      ans.add(""+i);
      key.add(""+i);
      ans.add(0,""+i);
      key.add(0,""+i);
      System.out.println(i);
    }
    boolean workLeft = true;
    int count = 0;
    for(int i = 0; i < 100 && ans.indexOf(""+i) == key.indexOf(""+i);i++){
      count++;
    }
    //printResults(count == 100,test,"indexOf "+count);
    System.out.println(ans);
    System.out.println(key);
  }
}
