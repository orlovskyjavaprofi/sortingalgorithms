package com.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mainapp.QuickSort;

class QuickSortTest
{
	QuickSort quickSortObj;
	Integer[] inputArray;

	@BeforeAll
	public static void epxectedResult()
	{
		System.out.println("Given: 4, 6, 42, 10, 5, 15, 11, 24, 1 "+"\nStarting to sort the given array!!!!\n");
	}

	@BeforeEach
	public void setup()
	{
		inputArray = new Integer[] { 4, 6, 42, 10, 5, 15, 11, 24, 1 };
		quickSortObj = new QuickSort(inputArray);
	}

	@Test
	public void checkIfQuickSortObjectExist()
	{
		assertNotNull(quickSortObj, "check if the QuckSortObj was created");
	}

	@Test
	public void checkfindX()
	{
		Integer arrayLength = inputArray.length;
		Integer expectedValue = 1;
		Integer actualValue = quickSortObj.findx(0, arrayLength - 1);

		assertEquals(expectedValue.intValue(), actualValue.intValue(), "check if max in array is found");
	}

	@Test
	public void checkIfObjectInitialised()
	{
		Integer[] actualArr = quickSortObj.getArr();

		Assert.assertArrayEquals(inputArray, actualArr);
	}

	@Test
	public void checkswap()
	{
		Integer[] expectedArray = new Integer[] { 6, 4, 42, 10, 5, 15, 11, 24, 1 };
		quickSortObj.swap(quickSortObj.getArr(), 0, 1);
		Integer[] actualArrayResult = quickSortObj.getArr();

		assertArrayEquals(expectedArray, actualArrayResult);
	}

	@Test
	public void checkPartition()
	{
		Integer left, right, resultOfFindx;
		left = 0;

		Integer arrayLength = quickSortObj.getArr().length;
		right = arrayLength - 1;

		Integer[] stateOfArray = quickSortObj.getArr();
		resultOfFindx = quickSortObj.findx(left, right);

		Integer actualResult = quickSortObj.partition(stateOfArray, left, right, resultOfFindx);
		Integer ExpectedResult = 0;

		assertEquals(ExpectedResult, actualResult, "check if partition is ok");
	}

	@Test
	public void checkQuickSort()
	{
		Integer[] expectedArray = new Integer[] { 1, 4, 5, 6, 10, 11, 15, 24, 42 };
		Integer rightIndex = quickSortObj.getArr().length;
		Integer leftIndex = 0;

		quickSortObj.quickSort(leftIndex, rightIndex - 1);
		Integer[] actualArr = quickSortObj.getArr();
		printingFinalResult(actualArr);

		assertArrayEquals(expectedArray, actualArr);

	}

	private void printingFinalResult(Integer[] actualArr)
	{
		System.out.println("\n\t\t\tFinal Result:");
		System.out.println("====================================");
		System.out.println(Arrays.toString(actualArr));
		System.out.println("====================================");
	}

}
