package com.docblades.opsys.assignment1.Driver.Memory;

import java.util.ArrayList;
import java.util.List;

import com.docblades.opsys.assignment1.Exceptions.OutOfBoundsException;

public class RAM {
	private List<RAM.MemoryBlock> _memoryStorage;
	
	public RAM() {
		_memoryStorage = new ArrayList<RAM.MemoryBlock>();
	}	
	
	public void write(Integer address, Integer value){
		EnsureCorrectSize(address);
		
		_memoryStorage.get(address).store(value);		
	}
	
	public Integer read(Integer address) throws OutOfBoundsException
	{
		try
		{
			return _memoryStorage.get(address).retrieve();
		}
		catch (IndexOutOfBoundsException ex)
		{
			throw new OutOfBoundsException();
		}		
	}
	
	// helpers 
	
	private void EnsureCorrectSize(Integer address) {		
		while (_memoryStorage.size() - 1 < address) {
			_memoryStorage.add(new MemoryBlock());
		}
	}
			
	private class MemoryBlock
	{		
		private Integer storage; // 32 bit

		public MemoryBlock() {
			storage = new Integer(0);
		}						

		public void store(Integer storage) {
			this.storage = storage;
		}				

		public Integer retrieve() {
			return storage;
		}
	
	}
}
