package com.facebook.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.baseTest.TestBase;
import com.facebook.pageobject.ReviewPage;
import com.facebook.pageobject.WallethubReview;

public class WallethubReviewTest extends TestBase{
	WallethubReview whreview;
	ReviewPage rpage;
	String content = "nsczxzvukrzkuvu"+
			"vykvdklafwnzepierjtkkalvcoyojicnctdiqntijzsj"+
			"celmuvhgqrwwginaiggahcejhxaamwvbgbihejayskbivav"+
			"airwmcplhfelgvjxjymdurzmltzskextwhzytlazzezorkhpwwfgxcmiejujsnvufgfmujhlauciugbzzy";

	public WallethubReviewTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("wallethuburl"));
		whreview = new WallethubReview();
		rpage=new ReviewPage();
	}
	@Test
	public void test_reviewpost() {
		whreview.wh_login(prop.getProperty("wallethubuser"), prop.getProperty("wallethubpassword"));
		whreview.selectreviewStars();
		whreview.writereview(prop.getProperty("testdata"));
		String review=rpage.reviewcheck();
		assertEquals(review, content);
		
	}
}
