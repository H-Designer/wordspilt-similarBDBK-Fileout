package poi;
import java.io.File;
import java.io.FileInputStream;
import dao.add_dao;
import org.apache.poi.hwpf.HWPFDocument;
public class ML_poi {
	public static void main(String[] args) {
		File file = new File("src/河北省信息技术手册目录.doc");
		String str = contextOfDoc(file);
		add_dao add_dao=new add_dao();
		
		String[] strArray1 = str.split("第二篇	网络安全篇");
        String strnum1P = strArray1[0];
        String strnum1PW = strArray1[1];
        

	        String[] strArrayZ1 = strnum1P.split("第一章");
	        String strnum0Z = strArrayZ1[0];
	        String num_oneP_name = strnum0Z;//��һƪƪ��
	        String strnum0ZW = strArrayZ1[1];
	        //System.out.println(num_oneP_name);
	        //System.out.println(strnum0ZW);
	        
	  
	        String[] strArrayZ2 = strnum0ZW.split("第二章");
	        String strnum1Z = strArrayZ2[0];
	        String strnum1ZW = strArrayZ2[1];
	        strnum1Z=strnum1Z.replaceAll("\\d+","");
	        //System.out.println(strnum1Z);
	        String[] num1Z=strnum1Z.split("\r|\n");
	        for(int i=0;i<num1Z.length;i++)
	        {
	        	String zhangjie=num1Z[0];
	        	if(i!=0)
	        	{
	        		add_dao.addtitle(num1Z[i],zhangjie);
	        	}
	        }
	        
	        String[] strArrayZ3 = strnum1ZW.split("第三章");
	        String strnum2Z = strArrayZ3[0];
	        String strnum2ZW = strArrayZ3[1];
	        strnum2Z=strnum2Z.replaceAll("\\d+","");
	        //System.out.println(strnum2Z);
	        String[] num2Z=strnum2Z.split("\r|\n");
	        for(int i=0;i<num2Z.length;i++)
	        {
	        	String zhangjie=num2Z[0];
	        	if(i!=0)
	        	{
	        		//add_dao.addtitle(num2Z[i],zhangjie);
	        	}
	        }
	        
	       
	        String[] strArrayZ4 = strnum2ZW.split("第四章");
	        String strnum3Z = strArrayZ4[0];
	        String strnum3ZW = strArrayZ4[1];
	        strnum3Z=strnum3Z.replaceAll("\\d+","");
	        //System.out.println(strnum3Z);
	        String[] num3Z=strnum3Z.split("\r|\n");
	        for(int i=0;i<num3Z.length;i++)
	        {
	        	String zhangjie=num3Z[0];
	        	if(i!=0)
	        	{
	        		//add_dao.addtitle(num3Z[i],zhangjie);
	        	}
	        }
	        
	        
	        String[] strArrayZ5 = strnum3ZW.split("第五章");
	        String strnum4Z = strArrayZ5[0];
	        String strnum4ZW = strArrayZ5[1];
	        strnum4Z=strnum4Z.replaceAll("\\d+","");
	        //System.out.println(strnum4Z);
	        String[] num4Z=strnum4Z.split("\r|\n");
	        for(int i=0;i<num4Z.length;i++)
	        {
	        	String zhangjie=num4Z[0];
	        	if(i!=0)
	        	{
	        		//add_dao.addtitle(num4Z[i],zhangjie);
	        	}
	        }
	        
	        
	        String[] strArrayZ6 = strnum4ZW.split("第六章");
	        String strnum5Z = strArrayZ6[0];
	        String strnum5ZW = strArrayZ6[1];
	        strnum5Z=strnum5Z.replaceAll("\\d+","");
	        //System.out.println(strnum5Z);
	        String[] num5Z=strnum5Z.split("\r|\n");
	        for(int i=0;i<num5Z.length;i++)
	        {
	        	String zhangjie=num5Z[0];
	        	if(i!=0)
	        	{
	        		//add_dao.addtitle(num5Z[i],zhangjie);
	        	}
	        }
	        
	        
	        
	        String[] strArrayZ7 = strnum5ZW.split("第七章");
	        String strnum6Z = strArrayZ7[0];
	        String strnum6ZW = strArrayZ7[1];
	        strnum6Z=strnum6Z.replaceAll("\\d+","");
	        //System.out.println(strnum6Z);
	        String[] num6Z=strnum6Z.split("\r|\n");
	        for(int i=0;i<num6Z.length;i++)
	        {
	        	String zhangjie=num6Z[0];
	        	if(i!=0)
	        	{
	        		add_dao.addtitle(num6Z[i],zhangjie);
	        	}
	        }
	        
	        
	        String strnum7Z = strnum6ZW;
	        strnum7Z=strnum7Z.replaceAll("\\d+","");
	        //System.out.println(strnum7Z);
	        String[] num7Z=strnum7Z.split("\r|\n");
	        for(int i=0;i<num7Z.length;i++)
	        {
	        	String zhangjie=num7Z[0];
	        	if(i!=0)
	        	{
	        		//add_dao.addtitle(num7Z[i],zhangjie);
	        	}
	        }
	        

	        //进行第二次切分
        String[] strArray2 = strnum1PW.split("第三篇	基础篇");
        //���ڶ�ƪ���ݴ���strnum2P,����ƪ����strnum2PW
        String strnum2P = strArray2[0];
        String strnum2PW = strArray2[1];
        //System.out.println("strnum2P"+strnum2P);

        String[] strArrayZ8 = strnum2P.split("第八章");
        //String num_twoP_name = strnum0Z;//�ڶ�ƪƪ��
        String strnum8ZW1 = strArrayZ8[1];
        

  
        String[] strArrayZ9 = strnum8ZW1.split("第九章");
        String strnum8Z = strArrayZ9[0];
        String strnum8ZW = strArrayZ9[1];
        strnum8Z=strnum8Z.replaceAll("\\d+","");
        //System.out.println(strnum1Z);
        String[] num8Z=strnum8Z.split("\r|\n");
        for(int i=0;i<num8Z.length;i++)
        {
        	String zhangjie=num8Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num8Z[i],zhangjie);
        	}
        }
        
        String[] strArrayZ10 = strnum8ZW.split("第十章");
        String strnum9Z = strArrayZ10[0];
        String strnum9ZW = strArrayZ10[1];
        strnum9Z=strnum9Z.replaceAll("\\d+","");
        //System.out.println(strnum2Z);
        String[] num9Z=strnum9Z.split("\r|\n");
        for(int i=0;i<num9Z.length;i++)
        {
        	String zhangjie=num9Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num9Z[i],zhangjie);
        	}
        }
        
       
        String[] strArrayZ11 = strnum9ZW.split("第十一章");
        String strnum10Z = strArrayZ11[0];
        String strnum10ZW = strArrayZ11[1];
        strnum10Z=strnum10Z.replaceAll("\\d+","");
        //System.out.println(strnum3Z);
        String[] num10Z=strnum10Z.split("\r|\n");
        for(int i=0;i<num10Z.length;i++)
        {
        	String zhangjie=num10Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num10Z[i],zhangjie);
        	}
        }
        
        String strnum11Z = strnum10ZW;
        strnum11Z=strnum11Z.replaceAll("\\d+","");
        //System.out.println(strnum7Z);
        String[] num11Z=strnum11Z.split("\r|\n");
        for(int i=0;i<num11Z.length;i++)
        {
        	String zhangjie=num11Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num11Z[i],zhangjie);
        	}
        }
        
        
        
        
      
        
        
        
        //3
        String[] strArray3 = strnum2PW.split("第四篇	国家信息化政策规划篇");
        String strnum3P = strArray3[0];
        String strnum3PW = strArray3[1];
        
        String[] strArrayZ12 = strnum3P.split("第十二章");
        //String num_twoP_name = strnum0Z;//�ڶ�ƪƪ��
        String strnum12ZW1 = strArrayZ12[1];
        

  
        String[] strArrayZ13 = strnum12ZW1.split("第十三章");
        String strnum12Z = strArrayZ13[0];
        String strnum12ZW = strArrayZ13[1];
        strnum12Z=strnum12Z.replaceAll("\\d+","");
        //System.out.println(strnum1Z);
        String[] num12Z=strnum12Z.split("\r|\n");
        for(int i=0;i<num12Z.length;i++)
        {
        	String zhangjie=num12Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num12Z[i],zhangjie);
        	}
        }
        
        String[] strArrayZ14 = strnum12ZW.split("第十四章");
        String strnum13Z = strArrayZ14[0];
        String strnum13ZW = strArrayZ14[1];
        strnum13Z=strnum13Z.replaceAll("\\d+","");
        //System.out.println(strnum2Z);
        String[] num13Z=strnum13Z.split("\r|\n");
        for(int i=0;i<num13Z.length;i++)
        {
        	String zhangjie=num13Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num13Z[i],zhangjie);
        	}
        }
        
        String[] strArrayZ15 = strnum13ZW.split("第十五章");
        String strnum14Z = strArrayZ15[0];
        String strnum14ZW = strArrayZ15[1];
        strnum14Z=strnum14Z.replaceAll("\\d+","");
        //System.out.println(strnum2Z);
        String[] num14Z=strnum14Z.split("\r|\n");
        for(int i=0;i<num14Z.length;i++)
        {
        	String zhangjie=num14Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num14Z[i],zhangjie);
        	}
        }
        
       
       
        
        String strnum15Z = strnum14ZW;
        strnum15Z=strnum15Z.replaceAll("\\d+","");
        //System.out.println(strnum7Z);
        String[] num15Z=strnum15Z.split("\r|\n");
        for(int i=0;i<num15Z.length;i++)
        {
        	String zhangjie=num15Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num15Z[i],zhangjie);
        	}
        }
        
        
      
        
        //
        String[] strArray4 = strnum3PW.split("附录");
        //������ƪ���ݴ���strnum3P,����ƪ����strnum3PW
        String strnum4P = strArray4[0];
        String strnum4PW = strArray4[1];
        
        String[] strArrayZ16 = strnum4P.split("第十六章");
        //String num_twoP_name = strnum0Z;//�ڶ�ƪƪ��
        String strnum16ZW1 = strArrayZ16[1];
        

  
        String[] strArrayZ17 = strnum16ZW1.split("第十七章");
        String strnum16Z = strArrayZ17[0];
        String strnum16ZW = strArrayZ17[1];
        strnum16Z=strnum16Z.replaceAll("\\d+","");
        //System.out.println(strnum1Z);
        String[] num16Z=strnum16Z.split("\r|\n");
        for(int i=0;i<num16Z.length;i++)
        {
        	String zhangjie=num16Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num16Z[i],zhangjie);
        	}
        }
        
        
        
        String strnum17Z = strnum16ZW;
        strnum17Z=strnum17Z.replaceAll("\\d+","");
        //System.out.println(strnum7Z);
        String[] num17Z=strnum17Z.split("\r|\n");
        for(int i=0;i<num17Z.length;i++)
        {
        	String zhangjie=num17Z[0];
        	if(i!=0)
        	{
        		//add_dao.addtitle(num17Z[i],zhangjie);
        	}
        }
        
        
          
        
            /*
        //����¼����strnum4PW
        System.out.println("strnum4PW"+strnum4PW);
        
        
     */   
     
        
        
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