import java.util.Random;


public class Mutation_Analysis {

	public static void main(String[] args){
		int programRuns = 100;
		int[] numOfMutations = new int[programRuns];
		
		for(int i=0; i<programRuns; i++){
			numOfMutations[i] = createArrays();
			System.out.println(numOfMutations[i]);
		}
		
	}
	
	public static void initialize(int[] arr){
		Random rand = new Random();
		for(int i=0; i<arr.length; i++){
			int thing = 0;
			if(arr[i]==1) continue;
			else if(rand.nextDouble() <= .1){
				thing = 1;
			}
			arr[i] = thing;
		}
//		for(int i=0; i<arr.length; i++){
//			System.out.print(arr[i]);
//		}
//		System.out.println();
	}
	
	public static int createArrays(){
		int[] gen0 = new int[(int) Math.pow(2,0)];
			initialize(gen0);
		int[] gen1 = new int[(int) Math.pow(2,1)];
			checkMutations(gen0, gen1);
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
		int total = 0;
		for (int i=0; i<gen10.length; i++){
			if(gen10[i]==1){
				total++;
			}
		}
		return total;
	}
	
}
