import java.util.ArrayList;
import java.util.Iterator;

public class ListOfWorks {
    ArrayList<String> works = new ArrayList<String>();

    public void addWork(String work){
        works.add(work);
    }

    public boolean removeWork(int index){
        if(index >= 0 && index < works.size()) {
            works.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeWork(String work){
        if(works.contains(work)){
            works.remove(work);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeWorksByKeyword(String keyword){
        Iterator<String> iterator = works.iterator();
        boolean isRemoved = false;
        while (iterator.hasNext()){
            String currentWork = iterator.next();
            if(currentWork.contains(keyword)){
                iterator.remove();
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public int size() {
        return works.size();
    }

    @Override
    public String toString(){
        return "ListOfWorks " + works;
    }

    public void printWorks(){
        System.out.println("Ваш список дел:");
        for (int i = 0; i < works.size(); i++) {
            System.out.println(i+1 + ". " + works.get(i));
        }
    }
}
