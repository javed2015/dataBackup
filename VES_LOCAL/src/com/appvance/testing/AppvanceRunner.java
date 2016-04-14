package com.appvance.testing;

import javax.swing.JTextField;

public class AppvanceRunner {
	public String mainTest(String urlTest) throws Exception {
		JTextField myOutput = new JTextField(1600);
		System.out.println(urlTest + "from runner");
		AppvanceRestClient arc = new AppvanceRestClient(urlTest);
		arc.logIn("appvance", "appvance");
		arc.startScenario("C:/VOTSH/zeptoh.scenario");
		Thread.sleep(10000);
		System.out.println(arc.isRunning());
		while (arc.isRunning()) {
			System.out.print(arc.getNextOutput());
			Thread.sleep(1000);
		}
		System.out.println(arc.getReportURL());
		return arc.getReportURL();
	}
}
