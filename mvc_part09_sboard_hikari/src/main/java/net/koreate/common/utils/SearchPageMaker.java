package net.koreate.common.utils;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchPageMaker extends PageMaker{

	@Override
	public String makeQuery(int page) {
		SearchCriteria sCriteria = (SearchCriteria)super.getCri();
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum",sCriteria.getPerPageNum())
				.queryParam("searchType",sCriteria.getSearchType())
				.queryParam("keyword",sCriteria.getKeyword()).build();
		String query = uri.toUriString();
		System.out.println(query);
		return query;
	}
	
	
	
}
