package dakside.algorithms;

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

 import dakside.algorithms.sorting.SortingAlgorithm;
 import dakside.algorithms.sorting.*;
 
/**
 * The {@link AlgorithmFactory} class provides for creating algorithm objects
 *
 * @author Hoang Duc Chinh &lt;dc.hoang.vn@gmail.com&gt;
 */
public class AlgorithmFactory {

    /**
     * Creates a sorting algorithm
     * @param algorithmName Algorithm name
	 * @return The requested algorithm if found
	 * @throws AlgorithmNotFoundException if the algorithm name cannot be found
     */
	 public SortingAlgorithm createSortingAlgorithm(String algorithmName) throws AlgorithmNotFoundException{
		 if (algorithmName == null){
			return null;
		 }
		 
		 if (algorithmName.equalsIgnoreCase("BubbleSort")){
			 return new BubbleSort();
		 } else if (algorithmName.equalsIgnoreCase("InsertionSort")){			 
			 return new InsertionSort();
		 } else {
			 throw new AlgorithmNotFoundException("Cannot find the requested algorithm: " + algorithmName);
		 }			 
	 }
}
