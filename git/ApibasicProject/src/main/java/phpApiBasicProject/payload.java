package phpApiBasicProject;

public class payload {
	
	public static String postpayload() {
		
		String post= "{\r\n" + 
		"         \"title\": \"edwin\",\r\n" + 
		"        \"body\": \"b10\",\r\n" + 
		"        \"author\": \"c10\"\r\n" + 
		"    }";
		return post;
			

}
public static String putpayload() {
	return "{\"id\":67,\r\n" + 
			"\"title\":\"author\"\r\n" + 
			"}";
}

public static String deletepayload() {
	return "{\"id\":65}";
}


public static String datadriven_post(String title,String body,String author) {
	String post1=  "{\r\n" + 
			"         \"title\": \""+title+"\",\r\n" + 
			"        \"body\": \""+body+"\",\r\n" + 
			"        \"author\": \""+author+"\"\r\n" + 
			"    }";
			return post1;
				

}
}
