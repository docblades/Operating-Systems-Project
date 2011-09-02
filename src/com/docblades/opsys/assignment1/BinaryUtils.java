package com.docblades.opsys.assignment1;

import java.util.ArrayList;
import java.util.List;

public class BinaryUtils {
	private static final String hexPrefix = "0x";
	
	public static byte[] MakeByteArrayFromInt(int thirtyTwoBits)
	{
		byte[] result = new byte[4];
		result[0] = getPartOneFromInt(thirtyTwoBits);
		result[1] = getPartTwoFromInt(thirtyTwoBits);
		result[2] = getPartThreeFromInt(thirtyTwoBits);
		result[3] = getPartFourFromInt(thirtyTwoBits);
		
		return result;
	}
	
	private static byte getPartOneFromInt(int thirtyTwoBits)
	{
		int step1 = thirtyTwoBits & 0xff000000;
		byte part1 = (byte) (step1 >> 24);
		
		return part1;
	}
	
	private static byte getPartTwoFromInt(int thirtyTwoBits)
	{
		int step1 = thirtyTwoBits & 0xff0000;
		byte part2 = (byte) (step1 >> 16);
		
		return part2;
	}
	
	private static byte getPartThreeFromInt(int thirtyTwoBits)
	{
		int step1 = thirtyTwoBits & 0xff00;
		byte part3 = (byte) (step1 >> 8);
		
		return part3;
	}
	
	private static byte getPartFourFromInt(int thirtyTwoBits)
	{
		byte part4 = (byte) (thirtyTwoBits & 0xff);
		
		return part4;
	}
	
	public static short MakeShortFromBytes(byte firstByte, byte secondByte)
	{
		short result = (short) firstByte;
		result = (short) (result << 8);
		result = (short) (result | secondByte);
		
		return result;
	}
	
	public static int MakeIntFromBytes(byte firstByte, byte secondByte, byte thirdByte, byte fourthByte)
	{
		int result = (int) firstByte;
		result = result << 8;
		
		result = result | secondByte;
		result = result << 8;
		
		result = result | thirdByte;
		result = result << 8;
		
		result = result | fourthByte;
		
		return result;
	}
	
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
