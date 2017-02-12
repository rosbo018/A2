import java.util.*;
import java.util.Random;
class Birthday {
	
	boolean searchList(List<Integer> lst, int num){
		for(int e:lst){
			if(e == num){
				return(true);
			}
		}
		return false;
	}
	protected int TestBirthdays(int setSize){
		List<Integer> set = new ArrayList<Integer>();//Dynamic list
		Random rand = new Random();
		int temp;
		int count = 0;
		while(true){
			temp = rand.nextInt(setSize);
			if (searchList(set, temp)){//searching list for same num
				//System.out.println(count);
				return count;
			}
			set.add(temp);
			count++;
		}
	}
	public static float[] runTest(int setSize, int numSets){
		int mean = 0, min = 0, max = 0, temp = 0;
		Birthday b = new Birthday();
		float stdDev = 0;
		int[] stdDevArr = new int[numSets];
		for (int i = 0; i< numSets;i++){
			temp = b.TestBirthdays(setSize);//getting birthday #
			if(temp< min || min == 0){//set min
				min = temp;
			}
			if (temp>max || max == 0){//set max
				max = temp;
			}
			mean+=temp;
			stdDevArr[i] = temp;//add numbers to arr to calc standard deviation

		}
		mean = mean/numSets;
		for (int x:stdDevArr){
			stdDev+= Math.pow((x-mean),2);//sqare of the difference
		}
		stdDev = (float)stdDev/numSets;
		stdDev = (float)Math.sqrt(stdDev);//squarroot of the mean
		float[] ret = new float[]{min, max, mean, stdDev};
		return ret;
	}
	public static void main(String[] args){
		
		float[] dataPoint; //min, max, mean, stdDeviation
		
		for (int i = Integer.parseInt(args[0]); i < Integer.parseInt(args[1]); i+=Integer.parseInt(args[0])){
			for (int j = 0; j<Integer.parseInt(args[2]); j++){
				dataPoint = runTest(i, Integer.parseInt(args[2]));
				/*System.out.println("Ran "+Integer.parseInt(args[2])+" sets, with a set size of "+ i);
				System.out.println("Min: "+dataPoint[0]);
				System.out.println("Max: "+dataPoint[1]);
				System.out.println("Mean: "+dataPoint[2]);
				System.out.println("Standard Deviation: "+ dataPoint[3]);*/
			}
		}
		
		
	}
}