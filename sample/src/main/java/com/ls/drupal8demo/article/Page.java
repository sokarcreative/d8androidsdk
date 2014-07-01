package com.ls.drupal8demo.article;

import com.ls.drupal.AbstractDrupalArrayEntity;
import com.ls.drupal.DrupalClient;
import com.ls.http.base.BaseRequest.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class Page extends AbstractDrupalArrayEntity<ArticlePreview>
{

	transient private int pageNumber;
	transient private String categoryId;

	public Page(DrupalClient client, int thePageNumber,String theCategoryId)
	{
		super(client, 5);
		this.pageNumber = thePageNumber;
		this.categoryId = theCategoryId;
	}

	@Override
	protected String getPath()
	{
		if(categoryId == null)
		{
			return "blog-rest";
		}else{
			return "category/"+categoryId;
		}
	}

	@Override
	protected Map<String, String> getItemRequestPostParameters()
	{
		return null;
	}

	@Override
	protected Map<String, String> getItemRequestGetParameters(RequestMethod method)
	{
		switch (method) {
		case GET:
			Map<String, String> result = new HashMap<String, String>();
			result.put("page", Integer.toString(pageNumber));
			return result;
		default:
			return null;
		}
	}

	public int getPageNumber()
	{
		return pageNumber;
	}

}