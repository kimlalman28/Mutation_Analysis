import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Mutation_Analysis {

	public static void main(String[] args){
		int programRuns = 100; //how many times to run analysis
		int[] numOfMutations = new int[programRuns]; //array that will hold # of mutations in the last gen
		
		for(int i=0; i<programRuns; i++){ //for loop to run gen array creation 
			numOfMutations[i] = createArrays(); //createArrays returns number of last gen mutations
		}
	
		sort(numOfMutations);
		for(int i=0; i <numOfMutations.length; i++){
			System.out.print(numOfMutations[i] + " ");
		}
		//graph(numOfMutations); //graph frequency of mutations
		getFreq(numOfMutations);
		
	}
	
	public static void initialize(int[] arr){
		Random rand = new Random();
		for(int i=0; i<arr.length; i++){ //for loop to go see if mutation will occur 
			int thing = 0; // no mutation
			if(arr[i]==1) continue; //if there was a previous mutation in slot, continue to next element
			else if(rand.nextDouble() <= .01){ //see if element falls into probability of mutation
				thing = 1; //mutation occurred 
			}
			arr[i] = thing; //set element equal to mutation/ non-mutation
		}
	}
	
	public static int createArrays(){ //create generation array function: this creates 10 generation plus the initial generation
		int[] gen0 = new int[(int) Math.pow(2,0)]; //size of array is based on exponential growth by generation number
			initialize(gen0); //function to mutate
		int[] gen1 = new int[(int) Math.pow(2,1)];
			checkMutations(gen0, gen1); //checks for previous generation mutations
			initialize(gen1);
		int[] gen2 = new int[(int) Math.pow(2,2)];
			checkMutations(gen1, gen2);
			initialize(gen2);
		int[] gen3 = new int[(int) Math.pow(2,3)];
			checkMutations(gen2, gen3);
			initialize(gen3);
		int[] gen4 = new int[(int) Math.pow(2,4)];
			checkMutations(gen3, gen4);
			initialize(gen4);
		int[] gen5 = new int[(int) Math.pow(2,5)];
			checkMutations(gen4, gen5);
			initialize(gen5);
		int[] gen6 = new int[(int) Math.pow(2,6)];
			checkMutations(gen5, gen6);
			initialize(gen6);
		int[] gen7 = new int[(int) Math.pow(2,7)];
			checkMutations(gen6, gen7);
			initialize(gen7);
		int[] gen8 = new int[(int) Math.pow(2,8)];
			checkMutations(gen7, gen8);
			initialize(gen8);
		int[] gen9 = new int[(int) Math.pow(2,9)];
			checkMutations(gen8, gen9);
			initialize(gen9);
		int[] gen10 = new int[(int) Math.pow(2,10)];
			checkMutations(gen9, gen10);
			initialize(gen10);
			
			return totalMutations(gen10);
	
	}
	
	public static void checkMutations(int arr1[], int arr2[]){
		//this function will check to see how many mutations occurred in the previous generation
		//based on the number of mutations, double that amount of mutations will carry over into
		//the current generation 
		int childrenMutation = 0;
		for(int i=0; i<arr1.length; i++){
			if (arr1[i]==1){
				childrenMutation++;
			}
		}
			if(childrenMutation > 0){
				childrenMutation = childrenMutation*2;
			}
		for(int i=0; i<childrenMutation; i++){
			arr2[i] = 1;
		}
		
	}
	
	public static int totalMutations(int[] gen10){
		//function totals the number of mutations that occurred in the final generation 
		int total = 0;
		for (int i=0; i<gen10.length; i++){
			if(gen10[i]==1){
				total++;
			}
		}
		return total;
	}
	
	public static void graph(int[] data) {
		 // Create a simple XY chart
		 XYSeries series = new XYSeries("Random");
		 
		 int freq = 1;
		 for(int i=0; i<data.length-1; i++){
			 if(i==data.length-1){
				 series.add(data[i], freq);
				 System.out.println(data[i]);
				 System.out.println("z");
			 }
			 
			 if(data[i]==data[i+1]){ freq++;
			 System.out.println(data[i]);
			 System.out.println("x");
			 }
			 	else{
			 		series.add(data[i], freq);
			 		freq=1;
			 		System.out.println(data[i]);
			 		System.out.println("y");
			 	}
			 
			 
		 }
	
		 // Add the series to your data set
		 XYSeriesCollection dataset = new XYSeriesCollection();
		 dataset.addSeries(series);
		 // Generate the graph
		 JFreeChart chart = ChartFactory.createXYLineChart(
		 "Mutation Analysis", // Title
		 "Frequency of Mutations", // x-axis Label
		 "# of Mutations", // y-axis Label
		 dataset, // Dataset
		 PlotOrientation.VERTICAL, // Plot Orientation
		 true, // Show Legend
		 true, // Use tooltips
		 false // Configure chart to generate URLs?
		 );
		 try {
			 ChartUtilities.saveChartAsJPEG(new File("C:\\chart.jpg"), chart, 500, 300);
		 } catch (IOException e) {
			 System.err.println("Problem occurred creating chart.");
		 }
	}
	
	public static void sort(int[] arr){
		int temp;
		for(int i=0; i<arr.length; i++){
			for(int j=1; j<arr.length-i; j++)
			if(arr[j-1] > arr[j]){
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
			
		}
	}
		
		public static void getFreq(int[] array){
			int tempYcounter=0;
			int[] tempX= new int[array.length];
			int[] tempY= new int[array.length];
			
			for(int i=0; i<array.length-1; i++){
				
				if(array[i]==array[i+1]){
					tempX[tempYcounter]+=1;
				}
				
				if(array[i]!=array[i+1])
				{
					tempY[tempYcounter++]=array[i];
				}
				
				if((i+1)==array.length-1){
					tempY[tempYcounter]=array[i+1];
					break;
				}
			}
			System.out.println();
			for (int i=0; i<=tempYcounter;i++){
				tempX[i]+=1;
				System.out.print(tempY[i]+" : ");
				System.out.print(tempX[i]);
				System.out.println();
			}
			
			
			
			
			
			//return freq;
			
	}
	
}
