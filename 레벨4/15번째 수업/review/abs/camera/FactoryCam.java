package review.abs.camera;

public class FactoryCam extends Camera{
	
	@Override
	public void showMainFeature() {
		System.out.println("화재 감지");
	}
	
	public void setDetector(Detectable detector) {
		detector.detect();
	}
	
	public void setReporter(Reportable reporter) {
		reporter.report();
	}
}
