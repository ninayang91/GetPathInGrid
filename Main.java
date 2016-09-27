import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
	
	public static void main(String[] args){
		int[] temp=new int[50];
		//System.out.println(countDP(3,temp));
		print(getPath(3,3));
	}
	
	public static ArrayList<Point> getPath(int x, int y){
		ArrayList<Point> path =new ArrayList<Point>();
		boolean success=getPath(x,y,path);
		if(success) return path;
		return null;
	}
	
	public static boolean getPath(int x, int y, ArrayList<Point> path){
		Point p=new Point(x,y);
		if(x==0&&y==0){path.add(p);return true;}
		boolean success=false;
		if(x>=1 && isFree(x-1,y)){
			success=getPath(x-1,y,path);
		}
		if(!success && y>=1 && isFree(x,y-1)){
			success=getPath(x,y-1,path);
		}
		if(success)path.add(p);
		return success;
	}
	
	public static boolean getPathDP(int x, int y, ArrayList<Point> path,Hashtable<Point, Boolean> cache){
		Point p=new Point(x,y);
		if(cache.containsKey(p))return cache.get(p);//Already visited this cell
		if(x==0&&y==0){path.add(p);return true;}
		boolean success=false;
		if(x>=1 && isFree(x-1,y)){
			success=getPathDP(x-1,y,path,cache);
		}
		if(!success && y>=1 && isFree(x,y-1)){
			success=getPathDP(x,y-1,path,cache);
		}
		if(success)path.add(p);
		cache.put(p, success);
		return success;
	}
	
	public static void print(ArrayList<Point> path){
		for(Point p:path){
			System.out.print("("+p.x+","+p.y+"); ");
		}
		System.out.println();
	}
	
	public static boolean isFree(int x, int y){
		if(x==1&&y==1){return false;}
		if(x==0&&y==2){return false;}
		return true;
	}

}
