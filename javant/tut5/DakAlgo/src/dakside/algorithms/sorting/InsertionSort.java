package dakside.algorithms.sorting;

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
 * The {@link InsertionSort} class implements {@link SortingAlgorithm} interface with the Insertion Sort algorithm
 *
 * @author HoangDucChinh {@literal <dc.hoang.vn@gmail.com>}
 */
public class InsertionSort implements SortingAlgorithm {

    /**
     * Sort an array of integers from smallest number to largest number
     * @param inputs Unsorted array
	 * @return Sorted array
     */
	@Override
    public int[] sort(int[] inputs){
		int temp;		
		int i;
		int j;
		
		/* 
		 * Shift the element to the right position in the sorted part of the array
		 * which is in the front (left) of it
		 */
		for (i = 1; i < inputs.length; i++){
			temp = inputs[i];
			j = i;
			while (j>0 && inputs[j-1]>temp){
				inputs[j] = inputs[j-1];
				j--;
			}
			inputs[j]=temp;
		}
		return inputs;
	}
}