package com.docblades.opsys.assignment1.Instructions;

import com.docblades.opsys.assignment1.BinaryUtils;
import com.docblades.opsys.assignment1.Exceptions.InvalidInstructionTypeException;
import com.docblades.opsys.assignment1.Exceptions.InvalidOpCodeException;
import com.docblades.opsys.assignment1.Instructions.ArithmeticInstructions.ArithmeticInstruction;
import com.docblades.opsys.assignment1.Instructions.ConditionalInstructions.ConditionalInstruction;
import com.docblades.opsys.assignment1.Instructions.IOInstructions.IOInstruction;
import com.docblades.opsys.assignment1.Instructions.JumpInstructions.JumpInstruction;

public abstract class Instruction {
	protected byte[] _binary = new byte[4];
	
	//masks
	private static final byte INSTRUCTIONBITMASK = (byte) 0xc0; // 11000000
	private static final byte OPCODEBITMASK      = (byte) 0x3f; // 00111111
	
	//opcodes
	private final static byte NOOP = (byte) 0x13; // 00010011
	
	protected static byte GetInstructionBits(byte instructionTypeAndOpcode)
	{
		byte instructionOnly = (byte) (instructionTypeAndOpcode & INSTRUCTIONBITMASK);
		
		return instructionOnly;
	}
	
	protected static byte GetOpCodeBits(byte[] binaryInstruction)
	{
		byte instructionTypeAndOpcode = binaryInstruction[0];
		byte opCodeOnly = (byte) (instructionTypeAndOpcode & OPCODEBITMASK);
		
		return opCodeOnly;
	}
	
	private static byte GetInstructionTypeBits(byte[] binaryInstruction)
	{
		byte instructionTypeAndOpCode = binaryInstruction[0];
		byte instructionType = (byte) (instructionTypeAndOpCode & INSTRUCTIONBITMASK);
		
		return instructionType;
	}
	
	private static boolean isNOOP(byte opCode)
	{
		return opCode == NOOP;
	}
	
	public Instruction(int thirtyTwoBitInstruction)
	{
		_binary = BinaryUtils.MakeByteArrayFromInt(thirtyTwoBitInstruction);
	}
	
	public abstract void WorkInstruction();
	
	public static Instruction MakeInstruction(int thirtyTwoBitInstruction) throws InvalidInstructionTypeException, InvalidOpCodeException
	{
		byte[] instructionBytes = BinaryUtils.MakeByteArrayFromInt(thirtyTwoBitInstruction);
		byte opCode = GetOpCodeBits(instructionBytes);
		byte instructionType = GetInstructionTypeBits(instructionBytes);
		
		if (isNOOP(opCode))
			return new NOOPInst(thirtyTwoBitInstruction);
		
		if (ArithmeticInstruction.isMyInstructionType(instructionType))
			return ArithmeticInstruction.MakeArithmeticInstruction(opCode, thirtyTwoBitInstruction);
		
		if (IOInstruction.isMyInstructionType(instructionType))
			return IOInstruction.MakeIOInstruction(opCode, thirtyTwoBitInstruction);
		
		if (ConditionalInstruction.isMyInstructionType(instructionType))
			return ConditionalInstruction.MakeConditionalInstruction(opCode, thirtyTwoBitInstruction);
		
		if (JumpInstruction.isMyInstructionType(instructionType))
			return JumpInstruction.MakeJumpInstruction(opCode, thirtyTwoBitInstruction);
		
		throw new InvalidInstructionTypeException();
	}
}
