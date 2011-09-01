package com.docblades.opsys.assignment1.unittests;

import org.junit.Test;

import junit.extensions.PA;
import junit.framework.Assert;
import junit.framework.TestCase;
import com.docblades.opsys.assignment1.*;

public class InstructionTest extends TestCase {
	
	@Test
	public void testGetType()
	{
		//TODO real test
		
		
	}
	
	@Test
	public void testGetTypeStress()
	{
		byte[] binary = new byte[4];
		Instruction inst = new fakeInstruction();
		
		for (int i = 0; i < 256; i++) 
		{
			binary[0] = (byte) i;

			try {
				PA.setValue(inst, "_binary", binary);
				InstructionType foo = (InstructionType) PA.invokeMethod(inst, "getType()");
			} catch (Exception e) {
				PrintAndFail(e);
			}
		}
	}
	
	private void PrintAndFail(Exception e)
	{
		e.printStackTrace();
		Assert.fail(e.getMessage());
	}
	
	private class fakeInstruction extends Instruction
	{
	// do nothing		
	}

}
