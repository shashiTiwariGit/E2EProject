package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	private static ExtentReports extent;
	public static ExtentReports getReporterObject(){
		
		String path=System.getProperty("user.dir")+"\\reports\\result.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		extent=new ExtentReports();
		reporter.config().setReportName("E2E Project Report");
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shashi" );
		return extent;
	}
	

}
