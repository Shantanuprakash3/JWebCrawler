import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Consumer {

	
	public void Start(){
		crawl();
	}
	
	
	
	private void crawl(){
		String crawlUrl = this.getCrawlUrl();
		
		HashSet<String> anchors = new HashSet<String>();
		
	
		try {
			Document doc;
			doc = Jsoup.connect(crawlUrl).get();
		 
		Elements hrefs = doc.select("a");
		
		for(Element e: hrefs){
			String anchor = e.attr("href").trim();
			anchors.add(anchor);
			System.out.println(anchor);}
	}
	
	catch (IOException ex) {
		// TODO Auto-generated catch block
		Logger.getLogger(Webcrawler.class.getName()).log(Level.SEVERE, null, ex);
	}
		System.out.println("---------------");
		for(String s:anchors){
			System.out.println(s);
		}
	
	}
	private String getCrawlUrl(){
		String url="http://www.jsoup.org/";
		return url;
	}
	
}
