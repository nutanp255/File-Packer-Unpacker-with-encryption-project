//
import java.util.*;
import java.lang.*;
import java.io.*;

class Unpacker
{
	public static void main(String arg[])
	{
		try
		{
			Scanner sobj=new Scanner(System.in);
		
			System.out.println("Enter packed file name:");
			String packFileName=sobj.nextLine();
		
			File fobj=new File(packFileName);
		
			FileInputStream fiobj=new FileInputStream(fobj);
			byte Headerarray[]=new byte[100];
		
			String HeaderString=null;
			String tokens[];
			int ret=0;
			
			while((ret=fiobj.read(Headerarray,0,100))>0)
			{
				HeaderString=new String(Headerarray);
				tokens=HeaderString.split(" ");
				
				File fobjNew=new File(tokens[0]);
				boolean bobj=fobjNew.createNewFile();
				
				int size=Integer.parseInt(tokens[1]);
				byte dataarray[]=new byte[size];
				
				fiobj.read(dataarray,0,size);
				
				FileOutputStream fos=new FileOutputStream(fobjNew);
				fos.write(dataarray,0,size);
			}
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}
}