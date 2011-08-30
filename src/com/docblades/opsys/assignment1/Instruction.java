package com.docblades.opsys.assignment1;

public abstract class Instruction {
	protected byte[] _binary = new byte[32];
	
	public byte[] GetType() 
	{
		int typeStart = 0;
		int typeEnd = 1;
		
		return GetRangeFromBinary(typeStart, typeEnd);
	}
	
	protected byte[] GetRangeFromBinary(int start, int end)
	{
		int length = end - start + 1;
		byte[] result = new byte[length];
		
		for(int i = start; i <= end; i++) 
		{
			result[i] = _binary[i];
		}
		
		return result;
	}
	
	public byte[] GetOpCode() 
	{
		int opCodeStart = 2;
		int opCodeEnd = 7;
		
		return GetRangeFromBinary(opCodeStart, opCodeEnd);
	}
}
