package com.docblades.opsys.assignment1.Driver.Memory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.docblades.opsys.assignment1.Exceptions.PageDoesNotExistException;

class PageTable {
	private List<Page> _pageList;
	private List<UUID> _usedPages;
	
	PageTable()
	{
		_pageList = new ArrayList<Page>();
		_usedPages = new ArrayList<UUID>();
	}
	
	Page LookUpPage(Integer page) throws PageDoesNotExistException
	{
		try
		{
			return _pageList.get(page);	
		}
		catch (IndexOutOfBoundsException ex)
		{
			throw new PageDoesNotExistException();
		}				
	}
	
	void deAllocatePage(Integer page) throws PageDoesNotExistException
	{
		UUID pageId = LookUpPage(page).id;
		
		_usedPages.remove(pageId);
	}
	
	Integer allocatePage(Integer size)
	{
		Page matchedPage = findAFreePageOfSize(size);
		
		if (matchedPage == null)
		{
			Page newPage = createNewPage(size);
			_pageList.add(newPage);
			
			matchedPage = newPage;
		}
		
		_usedPages.add(matchedPage.id);
		
		Integer pageIndex = _pageList.indexOf(matchedPage);
		
		return pageIndex;		
	}

	private Page findAFreePageOfSize(Integer size) {
		Page matchedPage = null;
		
		for (Page item : _pageList)
		{
			if (_usedPages.contains(item.id))
				continue;
			
			if (item.Size < size)
				continue;
			
			matchedPage = item;
		}
		return matchedPage;
	}
	
	private Page createNewPage(Integer size)
	{
		Page newPage = new Page();
		
		newPage.id = UUID.randomUUID();
		newPage.Size = size;
		newPage.StartAddress = nextAvailableMemoryAddress();
		
		return newPage;
	}
	
	private Integer nextAvailableMemoryAddress()
	{
		Integer newStartAddr = 0;
		
		for (Page item : _pageList)
			newStartAddr = Math.max(newStartAddr, item.StartAddress + item.Size);
		
		return newStartAddr;
	}
	
}
