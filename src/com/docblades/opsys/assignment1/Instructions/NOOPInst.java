package com.docblades.opsys.assignment1.Instructions;

public class NOOPInst extends Instruction {

	public NOOPInst(int thirtyTwoBitInstruction) {
		super(thirtyTwoBitInstruction);
	}

	@Override
	public void WorkInstruction() {
		// Do nothing (No Operation)
	}

}
