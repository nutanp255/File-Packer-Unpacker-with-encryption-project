
import java.util.*;
import java.lang.*;
import java.io.*;

class Packer
{
	public static void main(String arg[])throws Exception
	{
		Scanner sobj=new Scanner(System.in);
		
		System.out.println("Enter Directory/folder name: ");
		String Foldername=sobj.nextLine();
		
		File dobj=new File(Foldername);
		
		File allfiles[]=dobj.listFiles();
		String name;
		
		System.out.println("please packed file name:");
		String packfilename=sobj.nextLine();
		
		File fobj=new File(packfilename);
		boolean bobj=fobj.createNewFile();
		FileOutputStream writeobj=new FileOutputStream(fobj);
		
		FileInputStream readerobj=null;
		byte buffer[]=new byte[100];
		int ret=0;
		
		for(int i=0;i<allfiles.length;i++)
		{
			name=allfiles[i].getName();
			
			if(name.endsWith(".txt"))
			{
				name=name+" "+(allfiles[i].length());
				
				for(int j=name.length();j<100;j++)
				{
					name=name+" ";
				}
					byte namearray[]=name.getBytes();									
					writeobj.write(namearray,0,namearray.length);
				
					readerobj=new FileInputStream(allfiles[i]);
		
					while((ret=readerobj.read(buffer))!=-1)
					{
						writeobj.write(buffer,0,ret);
					}
					readerobj.close();
			}
		}
	}
}