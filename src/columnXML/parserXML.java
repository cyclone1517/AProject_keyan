package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class parserXML {
	public String getColContent(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();  
		try {
		 Document document = reader.read(new File("WorkColumn.xml"));
		 Node node = document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]"); 
		 return node.getText();
		} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new parserXML().getColContent("201526010308", "1", "1", "1"));
	}

}
