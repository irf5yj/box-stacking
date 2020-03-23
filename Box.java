package boxstacking;

public class Box implements Comparable<Box>{
	int height;
	int width;
	int depth;
	public Box(int height, int width, int depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
	}
	
	public int getH() {
		return height;
	}
	
	public int getW() {
		return width;
	}
	
	public int getD() {
		return depth;
	}
	
	public int compareTo(Box o) {
		int area = o.depth*o.width;
		int thisArea = this.depth*this.width;
		
		return area - thisArea;
	}
	
}
