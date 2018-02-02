package com.mainapp;
import java.util.Arrays;

// This algorithm is implementation of quicksort algorthim which is in use in the course datastructures and algorithms at FernUni Hagen
public class QuickSort
{
	private Integer[] initArr;

	public QuickSort(Integer[] inputArray)
	{
		this.setInitArr(inputArray);
	}

	public Integer findx(Integer inputLeftIndex, Integer RightIndex)
	{
		Integer LeftIndex = inputLeftIndex + 1;
		Integer temp = 0;
		Integer[] inputArray = this.getArr();

		while (LeftIndex.intValue() <= RightIndex.intValue()
				&& (inputArray[LeftIndex].intValue() == inputArray[LeftIndex - 1].intValue()))
		{
			LeftIndex++;
		}
		if (LeftIndex.intValue() > RightIndex.intValue())
		{
			// System.out.println("Neues maximum: " + "-1");
			return -1;
		} else if (inputArray[LeftIndex - 1] < inputArray[LeftIndex])
		{
			// System.out.println("Neues maximum: " + LeftIndex);
			return LeftIndex;
		} else
		{
			temp = LeftIndex - 1;
			// System.out.println("Neues maximum: " + temp);
			return LeftIndex - 1;
		}
	}

	public Integer[] getArr()
	{
		return initArr;
	}

	public void setInitArr(Integer[] initArr)
	{
		this.initArr = initArr;
	}

	public void swap(Integer[] arr, Integer left, Integer right)
	{
		Integer tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
		this.setInitArr(arr);
	}

	public Integer partition(Integer[] inputArray, Integer left, Integer right, Integer resultOfFindx)
	{

		while (left.intValue() < right.intValue())
		{
			while (inputArray[left].intValue() < resultOfFindx.intValue())
			{
				left++;
			}
			while (!(inputArray[right].intValue() < resultOfFindx.intValue()) && (right != 0))
			{
				right--;
			}

			if (left.intValue() < right.intValue())
			{
				swap(inputArray, left, right);
			}
		}
		return left;

	}

	public void quickSort(Integer leftIndex, Integer rightIndex)
	{
		Integer xindex;
		if (leftIndex.intValue() < rightIndex.intValue())
		{
			xindex = findx(leftIndex, rightIndex);
			printingInterimResult(xindex);
			recursiveCallToQuicksort(leftIndex, rightIndex, xindex);
		}

	}

	private void recursiveCallToQuicksort(Integer leftIndex, Integer rightIndex, Integer xindex)
	{
		Integer updateLeftIndex;
		if (xindex.intValue() != -1)
		{
			updateLeftIndex = partition(this.getArr(), leftIndex, rightIndex, this.getArr()[xindex]);
			quickSort(leftIndex, updateLeftIndex - 1);
			quickSort(updateLeftIndex, rightIndex);
		}
	}

	private void printingInterimResult(Integer xindex)
	{
		System.out.print("Max Index: " + xindex);
		System.out.println(" Field interim result: " + Arrays.toString(this.getArr()));
	}

}
