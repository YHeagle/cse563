import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
public class Dbscan {
    private ArrayList<Point> gridPoint;
    private Random rand;
    private float minDistance;

    public Dbscan(ArrayList<Point> points, float minDistance){
        this.gridPoint = points;
        this.rand = new Random();
        this.minDistance = minDistance;

    }
    public void setGridPoint(ArrayList<Point> gridPoint){
        this.gridPoint = gridPoint;
    }
    public ArrayList<ArrayList<Pair>> runDbscan(){
        ArrayList<ArrayList<Pair>> result = new ArrayList<>();
        ArrayList<Point> tempGridPoint=gridPoint;

        int i =0;
        while(tempGridPoint.size()!=0){
            int index = getRandomNumber(tempGridPoint.size());
            ArrayList<Pair> nearestNeighbours = getNearestScannedNeighbours(tempGridPoint , index);
            removeVisitedElements(tempGridPoint, nearestNeighbours);
            result.add(nearestNeighbours);
            i++;
        }
        return result;
    }
    private ArrayList<Pair> getNearestScannedNeighbours(ArrayList<Point> tempGridPoint, int index){
        PriorityQueue<Pair > queue=new PriorityQueue<Pair>();
        queue.add(new Pair(0,tempGridPoint.get(index),null));
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Point,Integer> visited = new HashMap<>();

        while(!queue.isEmpty()){
            Pair p = queue.remove();

            if(visited.containsKey(p.point1)){
                continue;
            }
            if (p.point2!=null){
                result.add(p);
            }
            visited.put(p.point1,1);
            for (Point point : tempGridPoint) {

                if (point == p.point1)
                    continue;
                float distance = calculateDistance(point, p.point1);
                if (distance < minDistance) {
                    queue.add(new Pair(distance, point, p.point1));
                }
            }
        }
        return result;
    }
    private void removeVisitedElements(ArrayList<Point> tempGridPoint, ArrayList<Pair> nearestNeighbours ){
        for (Pair pair : nearestNeighbours) {
            for(int i=0;i<tempGridPoint.size();i++){
                if (pair.point2== tempGridPoint.get(i) || pair.point1== tempGridPoint.get(i)) {
                    tempGridPoint.remove(i);
                    i--;
                }
            }
        }
    }
    private float calculateDistance(Point p1,Point p2){
        return (p1.getX()-p2.getX())*(p1.getX()-p2.getX()) + (p1.getY()-p2.getY())*(p1.getX()-p2.getX());
    }
    private int getRandomNumber(int size){
        return rand.nextInt(size);
    }
}
