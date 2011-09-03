package com.docblades.opsys.assignment1.Instructions.ConditionalInstructions;

import com.docblades.opsys.assignment1.BinaryUtils;
import com.docblades.opsys.assignment1.Exceptions.InvalidOpCodeException;
import com.docblades.opsys.assignment1.Instructions.Instruction;

public abstract class ConditionalInstruction extends Instruction {
	//instruction type
	private static final byte CONDITIONALINSTRUCTION = (byte) 0x40; // 01000000
	
	//masks
	private final byte BASEREGISTERMASK        = (byte) 0xf0; // 11110000
	private final byte DESTINATIONREGISTERMASK = (byte) 0x0f; // 00001111
	
	//opcode
	private static final byte ST   = (byte) 0x02; // 00000010
	private static final byte LW   = (byte) 0x03; // 00000011
	private static final byte MOVI = (byte) 0x0b; // 00001011
	private static final byte ADDI = (byte) 0x0c; // 00001100
	private static final byte MULI = (byte) 0x0d; // 00001101
	private static final byte DIVI = (byte) 0x0e; // 00001110
	private static final byte LDI  = (byte) 0x0f; // 00001111
	private static final byte SLTI = (byte) 0x11; // 00010001
	private static final byte BEQ  = (byte) 0x15; // 00010101
	private static final byte BNE  = (byte) 0x16; // 00010110
	private static final byte BEZ  = (byte) 0x17; // 00010111
	private static final byte BNZ  = (byte) 0x18; // 00011000
	private static final byte BGZ  = (byte) 0x19; // 00011001
	private static final byte BLZ  = (byte) 0x1a; // 00011010
	
	protected byte getBaseRegister()
	{
		byte baseAndDestinationRegisters = _binary[1];
		byte baseRegister = (byte) (baseAndDestinationRegisters & BASEREGISTERMASK);
		baseRegister = (byte) (baseRegister >> 4);
		
		return baseRegister;
	}
	
	protected byte getDestinationRegister()
	{
		byte baseAndDestinationRegisters = _binary[1];
		byte destinationRegister = (byte) (baseAndDestinationRegisters & DESTINATIONREGISTERMASK);
		
		return destinationRegister;
	}
	
	protected short getAddressOrData()
	{
		byte part1 = _binary[3];
		byte part2 = _binary[4];
		short addressOrData = BinaryUtils.MakeShortFromBytes(part1, part2);
		
		return addressOrData;
	}
	
	public static boolean isMyInstructionType(byte instructionType)
	{
		return (instructionType == CONDITIONALINSTRUCTION);
	}
	
	public static ConditionalInstruction MakeConditionalInstruction(byte opCode, int thirtyTwoBitInstruction) throws InvalidOpCodeException
	{
		if (opCode == ADDI)
			return new ADDIInst(thirtyTwoBitInstruction);
		
		if (opCode == BEQ)
			return new BEQInst(thirtyTwoBitInstruction);
		
		if (opCode == BEZ)
			return new BEZInst(thirtyTwoBitInstruction);
		
		if (opCode == BGZ)
			return new BGZInst(thirtyTwoBitInstruction);
		
		if (opCode == BLZ)
			return new BLZInst(thirtyTwoBitInstruction);
		
		if (opCode == BNE)
			return new BNEInst(thirtyTwoBitInstruction);
		
		if (opCode == BNZ)
			return new BNZInst(thirtyTwoBitInstruction);
		
		if (opCode == DIVI)
			return new DIVIInst(thirtyTwoBitInstruction);
		
		if (opCode == LDI)
			return new LDIInst(thirtyTwoBitInstruction);
		
		if (opCode == LW)
			return new LWInst(thirtyTwoBitInstruction);
		
		if (opCode == MOVI)
			return new MOVIInst(thirtyTwoBitInstruction);
		
		if (opCode == MULI)
			return new MULIInst(thirtyTwoBitInstruction);
		
		if (opCode == SLTI)
			return new SLTIInst(thirtyTwoBitInstruction);
		
		if (opCode == ST)
			return new STInst(thirtyTwoBitInstruction);
		
		throw new InvalidOpCodeException();
	}
	
	public ConditionalInstruction(int thirtyTwoBitInstruction) {
		super(thirtyTwoBitInstruction);
	}
}
