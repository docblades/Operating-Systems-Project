package com.docblades.opsys.assignment1.ProcessControl;

import java.util.UUID;

public class ProcessControlBlock implements Comparable<ProcessControlBlock> {
	public UUID processId;
	
	public Integer cpuID;
	public ProcessStatus status;
	
	// memory
	public Integer page;	
	public Integer programOffset;	
	public Integer dataOffset;
	
	// registers
	public Registers registers;

	@Override
	public int compareTo(ProcessControlBlock arg0) {
		return processId.compareTo(arg0.processId);		
	}
}
