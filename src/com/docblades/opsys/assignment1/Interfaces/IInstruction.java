package com.docblades.opsys.assignment1.Interfaces;

public interface IInstruction {
	public void setBinary(byte[] bin);
	public byte[] getFormat();
	public byte[] getOpCode();
}
