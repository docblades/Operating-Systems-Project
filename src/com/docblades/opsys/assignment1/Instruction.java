package com.docblades.opsys.assignment1;

public abstract class Instruction {
	protected byte[] _binary = new byte[4];
	private final byte INSTRUCTIONBITMASK = (byte) 0xc0; //11000000
	private final byte ARITHMETICINSTRUCTION = (byte) 0; //00000000
	private final byte CONDITIONALINSTRUCTION = (byte) 0x40; //01000000
	private final byte JUMPINSTRUCTION = (byte) -128; //10000000
	private final byte IOINSTRUCTION = (byte) 0xc0; //11000000
	private final byte EIGHTBITMASK = (byte) 0xff; // 00...0011111111
	private final byte OPCODEBITMASK = (byte) 0x3f; // 00111111
	
	protected InstructionType getType()
	{
		byte instructionType = GetInstructionBits();

		if (instructionType == ARITHMETICINSTRUCTION)
			return InstructionType.Arithmetic;
		if (instructionType == CONDITIONALINSTRUCTION)
			return InstructionType.Conditional;
		if (instructionType == JUMPINSTRUCTION)
			return InstructionType.Jump;
		if (instructionType == IOINSTRUCTION)
			return InstructionType.IO;
		
		return null;
	}
	
	private byte GetInstructionBits()
	{
		byte instructionTypeAndOpcode = _binary[0];
		byte instructionOnly = (byte) (instructionTypeAndOpcode & INSTRUCTIONBITMASK);
		return instructionOnly;
	}
	
	protected byte GetOpCodeBits()
	{
		byte instructionTypeAndOpcode = _binary[0];
		byte opCodeOnly = (byte) (instructionTypeAndOpcode & OPCODEBITMASK);
		return opCodeOnly;
	}
	
	public static Instruction MakeInstruction(byte[] instructionBytes)
	{
		//TODO: Make an instruction
		return null;
	}
}
