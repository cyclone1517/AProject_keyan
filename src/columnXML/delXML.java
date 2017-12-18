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

public class delXML {
	public void delTeaElement(String teaid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]");
		node.getParent().remove(node);
		//指定文件输出的位置
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
        // 指定文本的写出的格式：
        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
        format.setEncoding("UTF-8");
        //1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        //2.写出Document对象
		writer.write(document);			
        //3.关闭流
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delWorElement(String teaid,String worid,String state){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]");
		node.getParent().remove(node);
		//指定文件输出的位置
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
        // 指定文本的写出的格式：
        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
        format.setEncoding("UTF-8");
        //1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        //2.写出Document对象
		writer.write(document);			
        //3.关闭流
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delColElement(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]");
		node.getParent().remove(node);
		//指定文件输出的位置
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
        // 指定文本的写出的格式：
        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
        format.setEncoding("UTF-8");
        //1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        //2.写出Document对象
		writer.write(document);			
        //3.关闭流
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delColContent(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]");
		node.setText("");
		//指定文件输出的位置
        FileOutputStream out =new FileOutputStream("D:/eclipseworkplace/AProject_keyan/WorkColumn.xml");
        // 指定文本的写出的格式：
        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
        format.setEncoding("UTF-8");
        //1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        //2.写出Document对象
		writer.write(document);			
        //3.关闭流
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new delXML().delTeaElement("201526010307");
		new delXML().delColContent("201526010308","1","1","1");
	}

}
