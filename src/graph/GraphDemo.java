package graph;

public class GraphDemo {
	private int vertexSize;
	private int[] vertexs;
	private int[][] matrix;
	private static final int MAX_WEIGHT = 1000;
	
	public GraphDemo(int vertices){
		this.vertexSize = vertices;
		matrix = new int[vertexSize][vertexSize];
		vertexs = new int[vertexSize];
		for(int i = 0; i < vertexSize; i++){
			vertexs[i] = i; 
		}
	}

	public int[] getVertexs() { 
		return vertexs;
	}

	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}
	
	public static void main(String [] args){
		GraphDemo graph = new GraphDemo(5);
		
		int[] a0 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 6};
		int[] a1 = new int[]{9, 0, 3, MAX_WEIGHT, MAX_WEIGHT};
		int[] a2 = new int[]{2, MAX_WEIGHT, 0, 5, MAX_WEIGHT};
		int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0,1};
		int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT,MAX_WEIGHT, 0};
		graph.matrix[0] = a0;
		graph.matrix[1] = a1;
		graph.matrix[2] = a2;
		graph.matrix[3] = a3;
		graph.matrix[4] = a4;
		
//		int outDegree = graph.getOutDegree(0); 
//		System.out.println("Out degree of v0: "+outDegree);//print 1
		int weight = graph.getWeight(0, 4);
		System.out.println("The weight from v0 to v4 is: "+weight);
	}
	
	public int getOutDegree(int index){
		int degree = 0;
		for(int j = 0; j<  matrix[index].length; j++){
			int weight = matrix[index][j];
			if(weight != 0 && weight != MAX_WEIGHT){
				degree++;
			}
		}
		return degree;
	}
	

	public int getWeight(int v1, int v2){
		int weight = matrix[v1][v2];
		//if weight is 1000, shows -1. 
		return weight==0? 0:(weight == MAX_WEIGHT? -1: weight);
		
	}
}
