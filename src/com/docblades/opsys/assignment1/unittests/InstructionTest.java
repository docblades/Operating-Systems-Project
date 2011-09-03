package com.docblades.opsys.assignment1.unittests;

import junit.extensions.PA;
import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import com.docblades.opsys.assignment1.Instructions.Instruction;
import com.docblades.opsys.assignment1.Instructions.InstructionType;

public class InstructionTest extends TestCase {
	
	@Test
	public void testMyTheory()
	{
		byte one = (byte) 0xf0; // 11110000
		short expected = (short) 0xf000; // 1111000000000000
		
		short actual = (short) one;
		actual = (short) (actual << 8);
		
		Assert.assertEquals(expected, actual);
		
		actual = (short) (actual | 0x0f); 
		expected = (short) 0xf00f; //1111000000001111
		
		Assert.assertEquals(expected, actual);
	}
	
	private void PrintAndFail(Exception e)
	{
		e.printStackTrace();
		Assert.fail(e.getMessage());
	}
	
	private class fakeInstruction extends Instruction
	{

		public fakeInstruction(int thirtyTwoBitInstruction) {
			super(thirtyTwoBitInstruction);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void WorkInstruction() {
			// TODO Auto-generated method stub
			
		}
	// do nothing		
	}

}
