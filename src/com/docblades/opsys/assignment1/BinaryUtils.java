package com.docblades.opsys.assignment1;

import java.util.ArrayList;
import java.util.List;

public class BinaryUtils {
	private static final String hexPrefix = "0x";
	
	public static Byte[] HexToByteArray(String hex)
	{
		String cleanInput = StripHexHeader(hex);
		List<String> hexNibbles = MakeListOfHexNibbles(cleanInput);
		
		return MakeByteArrayFromListOfHexNibbles(hexNibbles);	
	}

	private static Byte[] MakeByteArrayFromListOfHexNibbles(
			List<String> hexNibbles) {
		List<Byte> listOfBytes = new ArrayList<Byte>();
		
		for (String nibble : hexNibbles)
		{
			byte result = BinaryUtils.GetByteFromHexNibble(nibble);
			listOfBytes.add(result);
		}
		
		int arrayLength = listOfBytes.size();
		Byte[] byteArray = new Byte[arrayLength];
		listOfBytes.toArray(byteArray);
		return byteArray;
	}
	
	private static List<String> MakeListOfHexNibbles(String hexIn)
	{
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < hexIn.length(); i += 2)
		{
			result.add(hexIn.substring(i, i+2));
		}
		
		return result;
	}
	
	private static String StripHexHeader(String hexIn)
	{
		if (hexIn.startsWith(hexPrefix)) 			
			return hexIn.substring(hexPrefix.length());		
		
		return hexIn;		
	}
	
	private static byte GetByteFromHexNibble(String hexIn)
	{
		Integer hexAsInt = Integer.parseInt(hexIn, 16);
		return hexAsInt.byteValue();
	}
	
}
