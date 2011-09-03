package com.docblades.opsys.assignment1.Instructions.JumpInstructions;

import com.docblades.opsys.assignment1.BinaryUtils;
import com.docblades.opsys.assignment1.Exceptions.InvalidOpCodeException;
import com.docblades.opsys.assignment1.Instructions.Instruction;

public abstract class JumpInstruction extends Instruction {
	//type
	private static final byte JUMPINSTRUCTION = (byte) 0x80; // 10000000
	
	//opcodes
	private static final byte JMP = (byte) 0x14; // 00010100
	private static final byte HLT = (byte) 0x12; // 00010010
	
	protected int getAddress()
	{
		byte firstByte = (byte) 0xff;
		byte secondByte = _binary[1];
		byte thirdByte = _binary[2];
		byte fourthByte = _binary[3];
		
		int result = BinaryUtils.MakeIntFromBytes(firstByte, secondByte, thirdByte, fourthByte);
		
		return result;		
	}
	
	public static boolean isMyInstructionType(byte instructionType)
	{	
		return (instructionType == JUMPINSTRUCTION);
	}
	
	public static JumpInstruction MakeJumpInstruction(byte opCode, int thirtyTwoBitInstruction) throws InvalidOpCodeException
	{	
		if (opCode == HLT)
			return new HLTInst(thirtyTwoBitInstruction);
		
		if (opCode == JMP)
			return new JMPInst(thirtyTwoBitInstruction);
		
		throw new InvalidOpCodeException();
	}
	
	public JumpInstruction(int thirtyTwoBitInstruction) {
		super(thirtyTwoBitInstruction);
	}
}
