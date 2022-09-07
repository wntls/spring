package q.q.crawling;

public class executeCrawling {
	
	public static void main(String[] args) {
		
		AladinCrawler aladin = new AladinCrawler();
		
//		for (int i = 1; i <= 100; i++)
		aladin.crawling("https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=" + 298570092);
		
	}
}
