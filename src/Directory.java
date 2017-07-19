public class Directory {

	public static void main(String[] args) {

    final Shell shell = new Shell();
		assert shell.path().equals("/");

		shell.cd("/");
		assert shell.path().equals("/");

		shell.cd("usr/..");
		assert shell.path().equals("/");

		shell.cd("usr").cd("local");
		
		shell.cd("../local").cd("./");
		assert shell.path().equals("/usr/local");

		shell.cd("..");
		assert shell.path().equals("/usr");

		shell.cd("//lib///");
		assert shell.path().equals("/lib");
		
		shell.cd("big/writ");
		assert shell.path().equals("/lib/big/writ");
	}
}