package poi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import information.infor;
import dao.add_dao;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
public class addContent {
	public static void main(String[] args){
		add_dao add=new add_dao();
		List<infor> informations=add.select_all();
		int leng= informations.size();
		File file = new File("src/河北省信息技术手册主体.doc");
		String str = contextOfDoc(file);
//		leng-2
		for(int i=0;i<1;i++)
		{
			infor list1=(informations.get(i+6));
			infor list2 =(informations.get(i+7 ));
			String title1=list1.getTitle();
			String title2=list2.getTitle();
			System.out.println("list1"+title1);
			System.out.println("list2"+title2);
			String[] strArray1 = str.split(title2);
	        String strnum1 = strArray1[0];
			String[] strArray2 = strnum1.split(title1);
			String content_i="";
			String cont[] = new String[100];
//			System.out.println(strArray2.length);
			for(int j=0;j<strArray2.length;j++)
			{
				if(strArray2.length==2)
				{
					add.addcontent(title1,strArray2[1]);
				}
				if(strArray2.length!=2)
				{
					if(j>1)
					{
						content_i=content_i+title1+strArray2[j];
						//System.out.println(content_i);
					}
					cont[j]=content_i;
					System.out.println(cont[strArray2.length-1]);
					if(cont[strArray2.length-1]!=null)
					{
						//add.addcontent(title1,cont[strArray2.length-1]);
					}
				}
//				System.out.println(j+strArray2[j]);



			}
//	        System.out.println(strnum1);
//	        String strnum1W = strArray1[1];
//			for(int j=0;j<strArray1.length;j++)
//			{
//		        //System.out.println(j+strArray1[j]);
//
//			}
//			String[] strArray2 = strnum1W.split(title2);
//			String strnum2 = strArray2[0];
//			System.out.println("第"+i+"段："+strnum2);
		
			
		}

	}

	public static String contextOfDoc(File file) {
		String str = "";
		try {
			FileInputStream fis = new FileInputStream(file);
			HWPFDocument doc = new HWPFDocument(fis);
			str = doc.getDocumentText();
			doc.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return str;
	

	}
}
