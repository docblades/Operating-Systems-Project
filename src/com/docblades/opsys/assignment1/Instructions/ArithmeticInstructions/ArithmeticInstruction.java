package com.docblades.opsys.assignment1.Instructions.ArithmeticInstructions;

import com.docblades.opsys.assignment1.Exceptions.InvalidOpCodeException;
import com.docblades.opsys.assignment1.Instructions.Instruction;

public abstract class ArithmeticInstruction extends Instruction {
	//instruction type
	private final static byte ARITHMETICINSTRUCTION = (byte) 0x00; // 00000000

	//masks
	private final byte FIRSTSOURCEREGISTERMASK  = (byte) 0xf0; //11110000
	private final byte SECONDSOURCEREGISTERMASK = (byte) 0x0f; //00001111
	private final byte DESTINATIONREGISTERMASK  = (byte) 0xf0; // 11110000
	
	//opcodes
	private static final byte MOV = (byte) 0x04;
	private static final byte ADD = (byte) 0x05;
	private static final byte SUB = (byte) 0x06;
	private static final byte MUL = (byte) 0x07;
	private static final byte DIV = (byte) 0x08;
	private static final byte AND = (byte) 0x09;
	private static final byte OR  = (byte) 0xa0;
	private static final byte SLT = (byte) 0x10;
	
	private byte getSourceRegisters()
	{
		byte bothSourceRegisters = _binary[1];
		return bothSourceRegisters;
	}
	
	protected byte getSourceRegisterOne()
	{
		byte bothSourceRegisters = getSourceRegisters();
		byte firstSourceRegister = (byte) (bothSourceRegisters & FIRSTSOURCEREGISTERMASK);
		firstSourceRegister = (byte) (firstSourceRegister >> 4);
		
		return firstSourceRegister;
	}
	
	protected byte getSourceRegisterTwo()
	{
		byte bothSourceRegisters = getSourceRegisters();
		byte secondSourceRegister = (byte) (bothSourceRegisters & SECONDSOURCEREGISTERMASK);
		
		return secondSourceRegister; 
	}
	
	protected byte getDestinationRegister()
	{
		byte destinationRegister = _binary[3];
		destinationRegister = (byte) (destinationRegister & DESTINATIONREGISTERMASK);
		destinationRegister = (byte) (destinationRegister >> 4);
		
		return destinationRegister;
	}
	
	public static boolean isMyInstructionType(byte instructionType)
	{	
		return (instructionType == ARITHMETICINSTRUCTION);
	}
	
	public static ArithmeticInstruction MakeArithmeticInstruction(byte opCode, int thirtyTwoBitInstruction) throws InvalidOpCodeException
	{
		if (opCode == MOV)
			return new MOVInst(thirtyTwoBitInstruction);
		
		if (opCode == ADD)
			return new ADDInst(thirtyTwoBitInstruction);
		
		if (opCode == SUB)
			return new SUBInst(thirtyTwoBitInstruction);
		
		if (opCode == MUL)
			return new MULInst(thirtyTwoBitInstruction);
		
		if (opCode == DIV)
			return new DIVInst(thirtyTwoBitInstruction);
		
		if (opCode == AND)
			return new ANDInst(thirtyTwoBitInstruction);
		
		if (opCode == OR)
			return new ORInst(thirtyTwoBitInstruction);
		
		if (opCode == SLT)
			return new SLTInst(thirtyTwoBitInstruction);		
		
		throw new InvalidOpCodeException();
	}
	
	public ArithmeticInstruction(int thirtyTwoBitInstruction) {
		super(thirtyTwoBitInstruction);
	}

}