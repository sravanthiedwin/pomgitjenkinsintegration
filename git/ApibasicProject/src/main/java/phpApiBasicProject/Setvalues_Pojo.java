package phpApiBasicProject;

public class Setvalues_Pojo {
	
	public pojoClass setvalues() {
		pojoClass p=new pojoClass();
		p.setTitle("agama1");
		p.setBody("c");
		p.setAuthor("b");
		return p ;
		
	}
	
	public pojoClass setvalues_put() {
		pojoClass p=new pojoClass();
		p.setId("23");
		p.setAuthor("b12");
		return p ;
		
	}
	
	public pojoClass setvalues_delete() {
		pojoClass p=new pojoClass();
		p.setId("23");
		
		return p ;
		
	}
	public pojoClass setvalues_datadriven(String t,String b,String a) {
		pojoClass p=new pojoClass();
		p.setTitle(t);
		p.setBody(b);
		p.setAuthor(a);
		return p ;
		
	}
	public pojoClass setvalues_putdatadriven(String i,String au) {
		pojoClass p=new pojoClass();
		p.setId(i);
		p.setAuthor(au);
		return p ;
		
	}
	

}
