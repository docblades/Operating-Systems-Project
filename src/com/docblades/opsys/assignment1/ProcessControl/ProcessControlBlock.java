package com.docblades.opsys.assignment1.ProcessControl;

public class ProcessControlBlock {
	public Integer cpuID;
	ProcessStatus status;
	
	// memory
	public Integer page;	
	public Integer programOffset;	
	public Integer dataOffset;
	
	// registers
	public Integer programCounter;
	
	

}
