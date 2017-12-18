package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class parserXML {
	public String getColContent(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();  
		int result=0;
		try {
		 Document document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/"
		 		+ "WorkColumn.xml"));
		 Node node = document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]"); 
		 return node.getText();
		} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=1;
		}	
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new parserXML().getColContent("201526010307", "13", "0", "12"));
	}

}
