/*
 * Please solve the following puzzle.
 * Be succinct yet readable. Shoot for 200 lines.
 * Consider adding comments and asserts to help the understanding.
 * Code can be compiled with javac Directory.java
 * Code should be executed as: java -ea Directory (-ea option it's to enabled the assert)
 */


/**
 * change the code here.
 */
class Shell {
	
	private String compiledPath = "/"; //initial value

	Shell cd(final String path) {
		
		//Assumption: "//XXX///" takes you to /XXX
		if(path.length() > 2 && path.substring(0,2).equals("//")) { 
			compiledPath = "/";
			for(int i = 2; i < path.length(); i++) {
				if (path.charAt(i) != '/') {
					compiledPath += path.charAt(i);
				}
			}
		}
		
		if(path.equals("..")) { //up one folder level
			upOneDirectory(compiledPath); //see helper function
		}
		
		if(path.length() > 2 && path.substring(0,3).equals("../")) {
			upOneDirectory(compiledPath); //up one folder level
			cd(path.substring(3, path.length())); //recurse on everything else
		}
		
		if(path.equals("usr/..")) { //go back to root. Reset to '/'
			compiledPath = "/";
		}
		
		if(isFolderName(path)) { //see helper function
			if(compiledPath.charAt(compiledPath.length() - 1) != '/') {
				compiledPath += '/'; //prime the String compiledPath if needed
			}
			compiledPath += path;
		}
		
		if(path.equals("/")) { //do nothing. Here for readability.
		}
		
		return this;
	}
	
	private void upOneDirectory(String input) { //remove the last folder name from the compiled path
		while(compiledPath.charAt(compiledPath.length() - 1)!= '/') {
			compiledPath = compiledPath.substring(0, compiledPath.length() - 1);
		}
		if(compiledPath.charAt(compiledPath.length() - 1) == '/') {
			compiledPath = compiledPath.substring(0, compiledPath.length() - 1);
		}
	}

	//Assumption: folder names are the only cd inputs that don't begin/end with '.' or '/'
	private Boolean isFolderName(String input) {
		if(input.charAt(0) != '/' 
				&& input.charAt(0) != '.'
				&& input.charAt(input.length() - 1) != '/'
				&& input.charAt(input.length() - 1) != '.') {
			return true;
		} else {
			return false;
		}
	}
	
	public String path() {
		//System.out.println(compiledPath); //used for debugging
		return compiledPath;
	}
}

