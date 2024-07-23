package review.abs;

import review.abs.camera.AdvancedFireDetector;
import review.abs.camera.FactoryCam;
import review.abs.camera.FireDetector;
import review.abs.camera.NormalReporter;
import review.abs.camera.VideoReporter;

public class Interface {
	public static void main(String[] args) {
		NormalReporter nr = new NormalReporter();
		nr.report();
		VideoReporter vr = new VideoReporter();
		vr.report();
		System.out.println("---------------------");
		FireDetector fd = new FireDetector();
		fd.detect();
		AdvancedFireDetector afd = new AdvancedFireDetector();
		afd.detect();
		System.out.println("---------------------");
		FactoryCam fc = new FactoryCam();
		fc.setDetector(afd);
		fc.setReporter(vr);
		
	}
}
