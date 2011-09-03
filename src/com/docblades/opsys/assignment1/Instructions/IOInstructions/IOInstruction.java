package com.docblades.opsys.assignment1.Instructions.IOInstructions;

import com.docblades.opsys.assignment1.BinaryUtils;
import com.docblades.opsys.assignment1.Exceptions.InvalidOpCodeException;
import com.docblades.opsys.assignment1.Instructions.Instruction;

public abstract class IOInstruction extends Instruction {
	//type
	private static final byte IOINSTRUCTION = (byte) 0xc0; // 11000000
	
	//opcodes
	private final byte FIRSTREGISTERMASK = (byte) 0xf0; //11110000
	private final byte SECONDREGISTERMASK = (byte) 0x0f; //00001111
	
	//opcodes
	private static final byte RD = (byte) 0x00; // 00000000
	private static final byte WR = (byte) 0x00; // 00000000
	
	private byte getBothRegisters()
	{
		byte bothRegisters = _binary[1];
		
		return bothRegisters;
	}
	
	protected byte getFirstRegister()
	{
		byte bothRegisters = getBothRegisters();
		byte firstRegister = (byte) (bothRegisters & FIRSTREGISTERMASK);
		firstRegister = (byte) (firstRegister >> 4);
		
		return firstRegister;
	}
	
	protected byte getSecondRegister()
	{
		byte bothRegisters = getBothRegisters();
		byte secondRegister = (byte) (bothRegisters & SECONDREGISTERMASK);
		
		return secondRegister;		
	}
	
	protected short getAddress()
	{
		byte part1 = _binary[2];
		byte part2 = _binary[3];
		short result = BinaryUtils.MakeShortFromBytes(part1, part2);
		
		return result;		
	}
	
	public static boolean isMyInstructionType(byte instructionType)
	{
		return (instructionType == IOINSTRUCTION);
	}
	
	public static IOInstruction MakeIOInstruction(byte opCode, int thirtyTwoBitInstruction) throws InvalidOpCodeException
	{
		if (opCode == RD)
			return new RDInst(thirtyTwoBitInstruction);
		
		if (opCode == WR)
			return new WRInst(thirtyTwoBitInstruction);
		
		throw new InvalidOpCodeException();
	}
	
	public IOInstruction(int thirtyTwoBitInstruction) {
		super(thirtyTwoBitInstruction);
	}
}
