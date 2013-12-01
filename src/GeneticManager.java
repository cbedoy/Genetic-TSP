import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneticManager {
	
	// The input file is a SPACE delimited distance matrix
	// For this implementation, the triangle inequality does not need to be satisfied
	public static final String INPUT_FILE = "input1.txt";
	public static final int POPULATION_SIZE = 10;
	
	// Input data
	public static int[][] matrix;
	public static int numCities;
	
	// Genetic Algorithm Paramaters
	public static boolean keepBestFit = true; // The best individual will always survive to the next population
	
	public static void main(String[] args) {
		GeneticManager gm = new GeneticManager();
		try {
			gm.readDistanceMatrix();
		} catch (IOException e) {
			System.err.println(e);
		}
		Population pop = new Population(numCities);
		pop.initializePopulationRandomly(POPULATION_SIZE);
		System.out.println(pop.getBestIndividual());
		
	}
		
	public GeneticManager() {
		
	}
	
	public void initializePopulation() {
		
	}
	
	public void readDistanceMatrix() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
		
		StringBuilder build = new StringBuilder();
		// Find out how many cities there are in the file
		numCities = 0;
		while (!build.append(br.readLine()).toString().equalsIgnoreCase("null")) {
			numCities++;
			build.setLength(0); // Clears the buffer
		}
		matrix = new int[numCities][numCities];
		// Reset reader to the start of the file
		br = new BufferedReader(new FileReader(INPUT_FILE));
		// Populate the distance matrix
		int currentCity = 0;
		build = new StringBuilder();
		while (!build.append(br.readLine()).toString().equalsIgnoreCase("null")) {
			String[] tokens = build.toString().split(" ");
			for (int i = 0; i < numCities; i++) {
				matrix[currentCity][i] = Integer.parseInt(tokens[i]);
			}
			currentCity++;
			build.setLength(0); // Clears the buffer
		}
	}
	
	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
