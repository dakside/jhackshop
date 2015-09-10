package dakside;

/*
 * The MIT License
 *
 * Copyright 2015 Hoang Duc Chinh <dc.hoang.vn@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Tutorial 5: Working with multiple projects
 *
 * @author HoangDucChinh <dc.hoang.vn@gmail.com>
 */
import java.util.Scanner;
import dakside.algorithms.AlgorithmFactory; 
import dakside.algorithms.AlgorithmNotFoundException;
import dakside.algorithms.sorting.SortingAlgorithm;

public class MainApp {

    /**
     * The entry point of the main app
     * @param args 
     */
    public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int[] inputArr = {1, 3, 123, 43, 5, 10, 21, 7, 89, 45, 93};
		
		String text = "";		
		
		while (!text.equalsIgnoreCase("exit")){
			System.out.println("Sorting demo!");
			System.out.println("Please select a sorting algorithm (BubbleSort or InsertionSort), type EXIT to escape");
			text= scan.nextLine();
			
			if (!text.equalsIgnoreCase("exit")){
				try{
					SortingAlgorithm sorting = new AlgorithmFactory().createSortingAlgorithm(text);
					int[] outputArr = new int[inputArr.length];
					System.arraycopy(inputArr,0,outputArr,0,outputArr.length);
					
					sorting.sort(outputArr);
					System.out.println("The unsorted array is: ");
					for (int element:inputArr){
						System.out.printf("%d ", element);
					}
					System.out.println("");
					System.out.println("The result is: ");
					for (int i = 0; i < outputArr.length; i++){
						System.out.printf("%d ", outputArr[i]);
					}
					System.out.println("");
				}
				catch (AlgorithmNotFoundException e){
					System.err.println("Error found: " + e.getMessage());
				}
			}
		}	
    }
}
