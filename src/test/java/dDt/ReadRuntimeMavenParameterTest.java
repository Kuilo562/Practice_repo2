package dDt;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {

	@Test
	public void runtimParameterTest() {
		System.out.println("test ng test");
		String url = System.getProperty("url");
		String Browser = System.getProperty("browser");
		String Username = System.getProperty("username");
		String Pwd = System.getProperty("password");
		System.out.println("Env Data==>URL++>"+Browser);
		System.out.println("Env Data==>URL++>"+Username);
		System.out.println("Env Data==>URL++>"+Pwd);
	}
}
