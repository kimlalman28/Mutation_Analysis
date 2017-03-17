import java.util.Random;

public class Mutation_Analysis {

	public static int programRuns = 1000; //how many times to run through the analysis
	public static int[] numOfMutations = new int[programRuns]; //numOfMutations that will hold # of total mutations
	public static int[] tempX= new int[numOfMutations.length]; //array that holds frequency of the # of mutations
	public static int[] tempY= new int[numOfMutations.length]; //array that holds different numbers of mutations that occur every time program is executed
	
	
	public static void main(String[] args){
		for(int i=0; i<programRuns; i++){ //for loop to run gen numOfMutations creation 
			numOfMutations[i] = createnumOfMutationss(); //createnumOfMutationss returns number of total mutations
		}
	
		sort(numOfMutations); //sort array
		
		for(int i=0; i <numOfMutations.length; i++){
			System.out.print(numOfMutations[i] + " ");
		}
		getFreq(); //find the frequency of the number of mutations that occur
		
	}
	
	public static void mutate(int[] arr){
		Random rand = new Random();
		for(int i=0; i<arr.length; i++){ //for loop to go see if mutation will occur 
			int thing = 0; // no mutation
			if(arr[i]==1) continue; //if there was a previous mutation in slot, continue to next element
			else if(rand.nextFloat() <= .004f){ //see if element falls into probability of mutation
				thing = 1; //mutation occurred 
			}
			arr[i] = thing; //set element equal to mutation/ non-mutation
		}
	}
	
	public static int createnumOfMutationss(){ //create generation numOfMutations function: this creates 10 generation plus the initial generation
		int totalMut = 0;
		
		int[] gen0 = new int[(int) Math.pow(2,0)]; //size of numOfMutations is based on exponential growth by generation number
			mutate(gen0); //function to mutate
			totalMut = totalMut + totalMutations(gen0);
		int[] gen1 = new int[(int) Math.pow(2,1)];
			checkMutations(gen0, gen1); //checks for previous generation mutations
			mutate(gen1);
			totalMut = totalMut + totalMutations(gen1);
		int[] gen2 = new int[(int) Math.pow(2,2)];
			checkMutations(gen1, gen2);
			mutate(gen2);
			totalMut = totalMut + totalMutations(gen2);
		int[] gen3 = new int[(int) Math.pow(2,3)];
			checkMutations(gen2, gen3);
			mutate(gen3);
			totalMut = totalMut + totalMutations(gen3);
		int[] gen4 = new int[(int) Math.pow(2,4)];
			checkMutations(gen3, gen4);
			mutate(gen4);
			totalMut = totalMut + totalMutations(gen4);
		int[] gen5 = new int[(int) Math.pow(2,5)];
			checkMutations(gen4, gen5);
			mutate(gen5);
			totalMut = totalMut + totalMutations(gen5);
		int[] gen6 = new int[(int) Math.pow(2,6)];
			checkMutations(gen5, gen6);
			mutate(gen6);
			totalMut = totalMut + totalMutations(gen6);
		int[] gen7 = new int[(int) Math.pow(2,7)];
			checkMutations(gen6, gen7);
			mutate(gen7);
			totalMut = totalMut + totalMutations(gen7);
		int[] gen8 = new int[(int) Math.pow(2,8)];
			checkMutations(gen7, gen8);
			mutate(gen8);
			totalMut = totalMut + totalMutations(gen8);
		int[] gen9 = new int[(int) Math.pow(2,9)];
			checkMutations(gen8, gen9);
			mutate(gen9);
			totalMut = totalMut + totalMutations(gen9);
		int[] gen10 = new int[(int) Math.pow(2,10)];
			checkMutations(gen9, gen10);
			mutate(gen10);
			totalMut = totalMut + totalMutations(gen10);
			
			return totalMut;
	
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
	
	public static int totalMutations(int[] gen){
		//function totals the number of mutations that occurred in the final generation 
		int total = 0;
		for (int i=0; i<gen.length; i++){
			if(gen[i]==1){
				total++;
			}
		}
		return total;
	}
	

	public static void sort(int[] arr){ 
		//method that will sort the array that holds the number of mutations that occurred during every execution
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
		
		public static void getFreq(){
			int tempYcounter=0;
			
			for(int i=0; i<numOfMutations.length-1; i++){
				
				if(numOfMutations[i]==numOfMutations[i+1]){
					tempX[tempYcounter]+=1;
				}
				
				if(numOfMutations[i]!=numOfMutations[i+1])
				{
					tempY[tempYcounter++]=numOfMutations[i];
				}
				
				if((i+1)==numOfMutations.length-1){
					tempY[tempYcounter]=numOfMutations[i+1];
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
	}
	
}
