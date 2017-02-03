package com.spring.test.service.serviceimpl;

import java.io.IOException;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
//import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.spring.test.service.HtmlParser;

@Service
public class HtmlParserImpl  implements  HtmlParser{
	
	 @Override
	public void test(){
		try {
			//String url="http://www.oschina.net";
			String keyword="av";
			String url="http://www.zhongzidi.com/list/"+keyword+"/1";
			
			Parser parser=new Parser();		
			parser.setURL(url);
			parser.setEncoding("utf-8");
			
			//NodeFilter filter = new TagNameFilter("div");
			
			//NodeFilter filter = new HasAttributeFilter("class", "ad");
			
			
			//NodeFilter filter = new TagNameFilter("tbody");
			NodeFilter filter = new TagNameFilter("tbody");
			
			//<dd class="ad">
			
			//NodeList nodes = ((Object) parser).extractAllNodeThatMatch(filter);
			
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			
			Node[] nodel= nodes.toNodeArray();
			
/*			Node alist= nodel[0];
			NodeList nl=new NodeList();
			NodeFilter filter2 = new HasAttributeFilter("class", "ad");
			
			alist.collectInto(nl, filter2);*/
			
		for(Node node:nodel){
/*				System.out.println("html"+node.toHtml());	
				System.out.println("PlainTextString"+node.toPlainTextString());	*/
				
				
				NodeFilter filter2 = new TagNameFilter("tr");
			//	node.collectInto(a, filter2);
				
				String html=node.getText();
				String html2=node.toHtml();
				String html3=node.toPlainTextString();
				String html4=node.toString();
			//	node.

				
				
				Parser parser2=new Parser();		
				parser2.setInputHTML(html);
				parser2.setEncoding("utf-8");
				
				NodeList a  = parser2.extractAllNodesThatMatch(filter2);
				
				
				
				Node[] alist = a.toNodeArray();
				//String acontent=alist[0].toPlainTextString();
				String acontent=alist[0].toHtml();
				System.out.println(acontent);
				
/*				System.out.println(node.getText());*/
			}

		} catch (ParserException e) {
			e.printStackTrace();
		}
	 }
	 
	 @Override
	public void test2(){
		 try {
			 
			 
			 
				String keyword="av";
				String url="http://www.zhongzidi.com/list/"+keyword+"/1";
			Document doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
			
			Elements elements = doc.select("tbody");
			for(Element element:elements){
				
				Element a = element.select("a").first();
				System.out.println(a.attr("href"));
				System.out.println(a.text());
			
				Elements strongs=element.select("strong");

				String createdTime = strongs.get(0).text();
				
				String size = strongs.get(1).text();
				
				String hot = strongs.get(2).text();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
