function isEmail(str)
{
	var len = str.length;
	if(len > 0)
	{
		if(isNaN(str.charAt(0))==false)
		{
			return false;
		}   
		else
		{
			var addressPattern = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			return addressPattern.test(str);
		} 
	}
}