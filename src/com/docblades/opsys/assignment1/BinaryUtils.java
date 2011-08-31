package com.docblades.opsys.assignment1;

import java.util.ArrayList;
import java.util.List;

public class BinaryUtils {
	private static final String hexPrefix = "0x";
	
	public static byte[] HexToByteArray(String hex)
	{
		return new byte[2];
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
	
	private static byte[] GetBytesFromHexNibble(String hexIn)
	{
		byte byte1 = Byte.parseByte(hexIn.substring(0, 1), 16);
		byte byte2 = Byte.parseByte(hexIn.substring(1, 2), 16);
		
		return new byte[] {byte1, byte2};
	}
}
