package Util;

import org.apache.commons.lang3.StringUtils;

public class ToStr {
	public String ToString(String url)
	{
		String url1=StringUtils.substringBefore(url, "*")+StringUtils.substringBetween(url, "*","*")+"."+StringUtils.substringAfterLast(url,"*"); 
		String url2="/upload/"+StringUtils.replace(url1, "\\", "/").substring(106);	
		return url2;
	}
}
