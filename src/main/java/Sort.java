import java.util.Comparator;
import java.util.List;

public class Sort {
    public  static void sort(List<User> list){
        int length=list.size();

        for (int i = 1; i <length; i++) {
            int j=i-1;
            User p=list.get(i);
            for (; j >=0&&(p.name.compareTo(list.get(j).name)<0) ; j--) {
                list.set(j+1,list.get(j));

            }
            list.set(j+1,p);
        }
    }
}
