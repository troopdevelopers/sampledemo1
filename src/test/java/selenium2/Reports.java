package selenium2;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	ScreenRecorder sr;
	boolean recordVideo=false;

	@BeforeClass

	public void testlaunch() throws MalformedURLException, InterruptedException {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Extent.html");
		extent = new ExtentReports();

		// htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "Tvisha tech");
		extent.setSystemInfo("Environment", "Live");
		extent.setSystemInfo("User Name", "Rakesh");
		extent.setSystemInfo("Tool used", "Selenium");

		htmlReporter.config().setDocumentTitle("Extent report");
		htmlReporter.config().setReportName("TimeDynamo Login");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	if(recordVideo) {
//		 sr=new ScreenRecorder();
//		 sr.startRecording("rec");

	}
	}

	 @AfterMethod
	public void getResult(ITestResult result) throws IOException, InterruptedException {
		System.out.println("after method===============");

		if (result.getStatus() == ITestResult.FAILURE) {
			if(recordVideo) {
			Thread.sleep(3000);
			sr.stopRecording();
			logger.log(Status.ERROR,
					"<video width=\"320\" height=\"240\" controls>\n" + " <source src=\"./mp4Result/" + "rec"
							+ sr.videoName + "\" type=\"video/mp4\">\n"
							+ "Your browser does not support the video tag.\n" + "</video>");
			}
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			if(recordVideo) {
			Thread.sleep(3000);
			sr.stopRecording();
			logger.log(Status.SKIP,
					"<video width=\"320\" height=\"240\" controls>\n" + " <source src=\"./mp4Result/" + "rec"
							+ sr.videoName + "\" type=\"video/mp4\">\n"
							+ "Your browser does not support the video tag.\n" + "</video>");
			}
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			if(recordVideo) {
			Thread.sleep(5000);
			sr.stopRecording();
			logger.log(Status.INFO,
					"<video width=\"320\" height=\"240\" controls>\n" + " <source src=\"./mp4Result/" + "rec"
							+ sr.videoName + "\" type=\"video/mp4\">\n"
							+ "Your browser does not support the video tag.\n" + "</video>");
			}
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}

	}

	 @AfterTest
	public void endReport() {
		// driver.close();
		extent.flush();

	}

}
