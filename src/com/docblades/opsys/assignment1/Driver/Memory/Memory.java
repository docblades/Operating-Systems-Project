package com.docblades.opsys.assignment1.Driver.Memory;

import com.docblades.opsys.assignment1.Exceptions.OutOfBoundsException;
import com.docblades.opsys.assignment1.Exceptions.PageDoesNotExistException;

public class Memory {
	private PageTable _pageTable;
	private RAM _ram;
	
	public Memory()
	{
		_pageTable = new PageTable();
		_ram = new RAM();
	}

	public Integer read(Integer page, Integer offset) throws OutOfBoundsException, PageDoesNotExistException
	{
		return _ram.read(mapEffectiveAddressToAbsoluteAddress(page, offset));
	}
	
	public void write(Integer page, Integer offset, Integer value) throws OutOfBoundsException, PageDoesNotExistException
	{
		_ram.write(mapEffectiveAddressToAbsoluteAddress(page, offset), value);
	}	
	
	/**
	 * @param size
	 * @return Page number
	 */
	public Integer allocateMemory(Integer size)
	{
		return _pageTable.allocatePage(size);
	}
	
	public void deAllocateMemory(Integer page) throws PageDoesNotExistException
	{
		_pageTable.deAllocatePage(page);
	}
		
	private Integer mapEffectiveAddressToAbsoluteAddress(Integer page, Integer offset) throws OutOfBoundsException, PageDoesNotExistException
	{
		Page thePage = _pageTable.LookUpPage(page);
		
		checkForOutOfBoundsIssue(thePage, offset);
		
		Integer absoluteAddr = thePage.StartAddress + offset;
		
		return absoluteAddr;
	}	
	
	private void checkForOutOfBoundsIssue(Page page, Integer offset) throws OutOfBoundsException
	{
		if (offset > page.Size){
			throw new com.docblades.opsys.assignment1.Exceptions.OutOfBoundsException();
		}		
	}
}
