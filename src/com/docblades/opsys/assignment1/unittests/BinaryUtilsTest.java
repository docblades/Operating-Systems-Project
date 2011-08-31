package com.docblades.opsys.assignment1.unittests;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import junit.extensions.PA;
import junit.framework.Assert;
import org.junit.Test;
import com.docblades.opsys.assignment1.BinaryUtils;


public class BinaryUtilsTest {
	@SuppressWarnings("unchecked")
	@Test
	public void TestMakeListOfHexNibbles()
	{
		final String hexString = "C050005C";
		List<String> result = null;
		
		try {
			result = (List<String>)PA.invokeMethod(BinaryUtils.class, "MakeListOfHexNibbles(java.lang.String)", hexString);
		} catch (IllegalArgumentException e) {
			PrintAndFail(e);
		} catch (IllegalAccessException e) {
			PrintAndFail(e);
		} catch (InvocationTargetException e) {
			PrintAndFail(e);
		} catch (NoSuchMethodException e) {
			PrintAndFail(e);
		}
		
		Assert.assertNotNull(result);
		Assert.assertEquals(4, result.size());
		Assert.assertEquals(2, result.get(0).length());
		printListToConsole(result);		
	}
	
	private void printListToConsole(List<String> nibbles)
	{
		StringBuilder result = new StringBuilder();
		
		result.append("[");
		for (String x : nibbles)
			result.append(String.format("%s, ", x));
		result.append("]");
		
		System.out.printf("%s", result.toString());
	}
	
	@Test
	public void testStripHexHeader_WithHeader()
	{
		final String testString = "0xC050005C";
		String result = new String();
		
		try {
			result = (String)PA.invokeMethod(BinaryUtils.class, "StripHexHeader(java.lang.String)", testString);
		} catch (IllegalArgumentException e) {
			PrintAndFail(e);
		} catch (IllegalAccessException e) {
			PrintAndFail(e);
		} catch (InvocationTargetException e) {
			PrintAndFail(e);
		} catch (NoSuchMethodException e) {
			PrintAndFail(e);
		}
		
		final String expected = "C050005C";
		
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void testStripHeader_WithoutHeader()
	{
		final String testString = "C050005C";
		String result = new String();
		
		try {
			result = (String)PA.invokeMethod(BinaryUtils.class, "StripHexHeader(java.lang.String)", testString);
		} catch (IllegalArgumentException e) {
			PrintAndFail(e);
		} catch (IllegalAccessException e) {
			PrintAndFail(e);
		} catch (InvocationTargetException e) {
			PrintAndFail(e);
		} catch (NoSuchMethodException e) {
			PrintAndFail(e);
		}
		
		Assert.assertEquals(testString, result);
	}
	
	private void PrintAndFail(Exception e)
	{
		e.printStackTrace();
		Assert.fail(e.getMessage());
	}
	
	//@Test
	public void testGetByteFromHexNibble()
	{
		final String testHex = "ff";
		final byte[] expected = new byte[] {0xf, 0xf};
		byte[] actual = new byte[2];
		
		try {
			actual = (byte[])PA.invokeMethod(BinaryUtils.class, "GetBytesFromHexNibble(java.lang.String)", testHex);
		} catch (IllegalArgumentException e) {
			PrintAndFail(e);
		} catch (IllegalAccessException e) {
			PrintAndFail(e);
		} catch (InvocationTargetException e) {
			PrintAndFail(e);
		} catch (NoSuchMethodException e) {
			PrintAndFail(e);
		}
		
		Assert.assertEquals(expected, actual);
		
	}

}