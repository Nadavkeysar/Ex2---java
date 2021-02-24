package homework;

public class M_2 {

		//part1
		public static int[] primeFactors(int num) { //Part A
			//variables
			int indexArr = 0;
			//array
			int []deviders = new int [num+1];//prime
			int []record = new int [num+1];//recording the primes
			for (int i = 2; i <deviders.length; i++) {//putting 1 in every cell
				deviders[i]=1;
			}
			for (int i = 2; i <num+1; i++) {//changing to 0 if not prime
				if(deviders[i]==1) {
					int j=2*i;
					while(j<num+1) {
						deviders[j]=0;
						j+=i;
					}
				}
			}//array prime have 1 when prime
			for (int i = 2; i < deviders.length; i++) {//i=2 , indexArr=0
				if(deviders[i]==1) {//prime index
					while(num%i==0) {
						record[indexArr]=i;//record[indexArr]=i=2
						indexArr++;//indexArr =1
						num=num/i;
					}
				}	
			}//array full of prime that devides the original num
			for (int i = 0; i < record.length; i++) {//printing the record array
				if(record[i]!=0)
				System.out.print(record[i]+" ");
			}return record;
		}
	//part2
		public static boolean isHammingNumber (int k) {//הפונקציה מקבלת מספר טבעי ומחזירה אמת אם המספר המינג
			int []prime_record = new int [k];
			prime_record = primeFactors(k);
			if(k==1||k==2||k==3||k==5)
				return true;
			else {
				for (int i = 0; i < prime_record.length; i++) {
					if(prime_record[i]!= 0 && prime_record[i]!=2 && prime_record[i]!=3 && prime_record[i]!=5) {
						return false;
					}
				}
			}return true;
		}

		public static int [] hammingNumbers(int num) { //הפונקציה מקבלת מספר טבעי ומחזירה מערך המינג 
			int [] pelet = new int[num];
			int counter = num-1;//בשביל לשים לב באיזה מיקום אנחנו במערך
			int hashod = 0;
			int x = num;
			while (x > 1){
				while (x % 2 == 0) {
					pelet[counter]=x;
					x /= 2;
					counter--;
				}
				while (x % 3 == 0) {
					pelet[counter]=x;
					x /= 3;
					counter--;
				}
				while (x % 5 == 0) {
					pelet[counter]=x;
					x /= 5;
					counter--;
				}
				if (x == 1) {
					pelet[counter]=x;
				counter--;
				}	
			   if(counter==0) 
				   num = 0;
			   if(x%2!=0&&x%3!=0&&x%5!=0)
				   x--;
			}
			
		return pelet;
	}	
			


		public static int [] humming_num(int num){
			int temp = 0;
			int[]array = new int[(int)Math.pow(num, 2)/2];
			boolean flag = false;
			int counter = 0;
			for (int i = 1; i < array.length; i++) {
				array[i]=0;
			}
			for (int i = 1; i < array.length; i++) {
				temp = i;
				while(temp!=1) {
					if(temp%2==0) {
						temp/=2;
					}else if(temp%3==0) {
						temp/=3;
					}else if(temp%5==0) {
						temp/=5;
					}else if(temp%2!=0 || temp%3!=0 || temp%5!=0) {
						flag = false;
						break;
					}
				}
				if(temp==1) {
					flag =true;
				}
				if(flag==false)
					array[i]=0;
				else {
					array[i]=1;
					counter++;
				}
			}
			int []result_humming = new int [num+1];
			int index_result = 0;
			for (int i = 1; i < array.length; i++) {
				if(index_result>=result_humming.length) {
					i=array.length;
				}else if(array[i]==1) {
					result_humming[index_result]=i;
					index_result++;
				}
			}
			
			return result_humming;
		}		
			//part_3
			public static int binary2int (int []b ) {//פונקציה שממירה מערך בינארי למספר רגיל
				int sum = 0;
				for (int i = 0; i < b.length; i++) {
					sum = sum + (b[i]*(int)Math.pow(2, i));
				}
				return sum;
			}
			
			public static int[] int2Binary (int n){	//הפונקציה מקבלת מספר שלם ומחזירה מערך המייצג את המספר בצורה בינארית
				int counter = 0;
				int original = n;
				while(n!=0) {
					n/=2;
					counter++;
				}
				int []bin = new int [counter];
				for (int i = 0; i < bin.length; i++) {
					bin[i]=original%2;
					original/=2;
				}return bin;
			}
			
			public static boolean isBinaryArray (int []b) {// פונקציה שמקבלת מערך וובודקת אם המערך  מורכב מאפסים ואחדות
				for (int i = 0; i < b.length; i++) {
					if(b[i]!=0&&b[i]!=1)
						return false;
				}return true;
			}
			
			
		public static void main(String[] args) {
		}
				
	}


