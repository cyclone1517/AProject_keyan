package columnXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class CreatXML {
	public void createXML()
	{
		//创建Document对象,代表整个xml文档
		Document document= DocumentHelper.createDocument();
		//创建根节点
		Element rss=document.addElement("rss");
		//向rss文件中添加rss
		rss.addAttribute("version", "2.0");
		//设置生成xml的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		//生成文件
		File file=new File("WorkColumn.xml");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file),format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addTeaElement(String teaid){
		SAXReader reader = new SAXReader();
		try {
		Document document;
		document = reader.read(new File("WorkColumn.xml"));
		//Node node = document.selectSingleNode("//title");
		Element root = document.getRootElement();//根节点
		Element teacher=root.addElement("teacher");
		teacher.addAttribute("tid", teaid);
		//指定文件输出的位置
        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
        // 指定文本的写出的格式：
        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
        format.setEncoding("UTF-8");
        //1.创建写出对象
        XMLWriter writer=new XMLWriter(out,format);
        writer.setEscapeText(false);
        //2.写出Document对象
		writer.write(document);
        //3.关闭流
        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
	}
	
	public void addWorElement(String teaid,String worid,String state){
		SAXReader reader = new SAXReader();
		try {
		 Document document;
		document = reader.read(new File("WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]");
		//Iterator iter = (Iterator) list.iterator();
		 Element element=(Element)node;
		 Element work=element.addElement("work");
		 work.addAttribute("wid", worid);
		 work.addAttribute("state", state);
		//指定文件输出的位置
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
	        // 指定文本的写出的格式：
	        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
	        format.setEncoding("UTF-8");
	        //1.创建写出对象
	        XMLWriter writer=new XMLWriter(out,format);
	        writer.setEscapeText(false);
	        //2.写出Document对象
			writer.write(document);			
	        //3.关闭流
	        writer.close();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void addColElement(String teaid,String worid,String state,String colid){
		SAXReader reader = new SAXReader();
		try {
		 Document document;
		document = reader.read(new File("WorkColumn.xml"));
		Node node= document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]");
		//Iterator iter = (Iterator) list.iterator();
		 Element element=(Element)node;
		 Element column=element.addElement("column");
		 column.addAttribute("cid", colid);
		//指定文件输出的位置
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
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
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void addColContent(String teaid,String worid,String state,String colid,String content){
		SAXReader reader = new SAXReader();  
		try {
		 Document document = reader.read(new File("WorkColumn.xml"));
		 Node node = document.selectSingleNode("//teacher[@tid="+teaid+"]/work[@wid="+worid+" and @state="+state+"]/column[@cid="+colid+"]"); 
		 node.setText(content);
		 	//指定文件输出的位置
	        FileOutputStream out =new FileOutputStream("WorkColumn.xml");
	        // 指定文本的写出的格式：
	        OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
	        format.setEncoding("UTF-8");
	        //1.创建写出对象
	        XMLWriter writer=new XMLWriter(out,format);
	        writer.setEscapeText(false);
	        //2.写出Document对象
			writer.write(document);	
	        //3.关闭流
	        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new CreatXML().createXML();
		//new CreatXML().addTeaElement("201526010307");
		//new CreatXML().addWorElement("201526010307","1","1");
		//new CreatXML().addColElement("201526010307","1","1","2");
		String content="展示系统成果一”“吃的擦<sdas>-=kNullam hendrerit justo non leo aliquet imperdiet. Etiam in sagittis lectus. Suspendisse ultrices placerat accumsan. Mauris quis dapibus orci. In dapibus velit blandit pharetra tincidunt. Quisque non sapien nec lacus condimentum facilisis ut iaculis enim. Sed viverra interdum bibendum. Donec ac sollicitudin dolor. Sed fringilla vitae lacus at rutrum. Phasellus congue vestibulum ligula sed consequat.";
		new CreatXML().addColContent("201526010307","1","1","2",content);
	}

}
