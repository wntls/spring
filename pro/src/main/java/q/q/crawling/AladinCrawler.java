package q.q.crawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AladinCrawler implements Crawler {
	
	@Override
	public void crawling(String url) {
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements e = doc.select("div.tlist");
		Elements e1 = doc.select("div.Ere_prod_mconts_box");
		
		System.out.println("================================");
		
		Iterator<Element> ie1 = e.select("a.Ere_sub2_title:first-of-type").iterator();
		Iterator<Element> bPupItr = e.select("a.Ere_sub2_title:last-of-type").iterator();
		Iterator<Element> codeItr = e1.select("div.conts_info_list1 li:nth-child(5)").iterator();
		Iterator<Element> bPupdateItr = e.select("li.Ere_sub2_title").iterator();
		Iterator<Element> bPageItr = e1.select("div.conts_info_list1 li:nth-child(2)").iterator();
		Iterator<Element> bOverViewItr = e1.select("div.Ere_prod_mconts_R"
				+ "").iterator();
		while (codeItr.hasNext()) {
			String code = codeItr.next().text();
			System.out.println(code);			
		}
		
		System.out.println("===============================");
		
		while (ie1.hasNext()) {
			System.out.println(ie1.next().text());
		}
		
		System.out.println("===============================");
		while (bPupItr.hasNext()) {
			String bPup = bPupItr.next().text();
			System.out.println(bPup);
			
		}
		
		System.out.println("===============================");
		while (bPupdateItr.hasNext()) {
			String bPupdate = bPupdateItr.next().text();
			System.out.println(bPupdate);
			
		}
		
		System.out.println("===============================");
		while (bPageItr.hasNext()) {
			String bPage = bPageItr.next().text();
			System.out.println(bPage);
			
		}
		
		System.out.println("===============================");
		while (bOverViewItr.hasNext()) {
			String bOverView = bOverViewItr.next().text();
			System.out.println(bOverView);
			
		}
		
		
		
		
		System.out.println("===============================");		
	}
}
