package poi;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;


public class PJ_poi {
	
	public static void main(String[] args) {
		File file = new File("src/河北省信息技术手册主体.doc");
		String str = contextOfDoc(file);
		//System.out.println(str);
		//截取获得字符串数组
		
		
		//第一次进行切分
		String[] strArray1 = str.split("网络安全篇");
		//将第一篇内容存入strnum1P,其余篇存入strnum1PW
        String strnum1P = strArray1[0];
        String strnum1PW = strArray1[1];
        //System.out.println(strnum1P);

        
        //进行第二次切分
        String[] strArray2 = strnum1PW.split("基础篇");
        //将第二篇内容存入strnum2P,其余篇存入strnum2PW
        String strnum2P = strArray2[0];
        String strnum2PW = strArray2[1];
        // System.out.println(strnum2P);
        
        
        //进行第三次切分
        String[] strArray3 = strnum2PW.split("国家信息化政策规划篇");
        //将第三篇内容存入strnum3P,其余篇存入strnum3PW
        String strnum3P = strArray3[0];
        String strnum3PW = strArray3[1];
        //System.out.println(strnum3P);
        
        
        //进行第四次切分
        String[] strArray4 = strnum3PW.split("附录");
        //将第四篇内容存入strnum3P,其余篇存入strnum3PW
        String strnum4P = strArray4[0];
        String strnum4PW = strArray4[1];
        System.out.println(strnum4P);
        
        //将附录存入strnum4PW
        String strFL = strnum4PW;
        
        
        
        
        
        
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
