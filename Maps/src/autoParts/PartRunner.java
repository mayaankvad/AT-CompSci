package autoParts;

//Files needed
 	//Part.java
 	//PartList.java

public class PartRunner
{
	public static void main(String[] args)
	{
		final String absPath = System.getProperty("user.dir") + "\\src\\autoParts\\" + "partinfo.dat";
		
		PartList prog = new PartList(absPath);
		System.out.println(prog);

	}
}
