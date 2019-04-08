package poi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import information.infor;
import dao.add_dao;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
public class deletespace {
	public static void main(String[] args){

		add_dao dao = new add_dao();
		List<infor> informations=dao.select_all();
		for(infor infor : informations)
		{
			int id = infor.getId();
			String title = infor.getTitle();
	        title = title.replaceAll("	", ""); 
	       // System.out.println(title);
			String zhangjie = infor.getZhangjie();
	        zhangjie = zhangjie.replaceAll("	", ""); 
	       // System.out.println(zhangjie);


			String mohujiansuo = infor.getMohujiansuo();
	        mohujiansuo = mohujiansuo.replaceAll("	", ""); 
	        //System.out.println(mohujiansuo);

			String pianjie = infor.getPianjie();
	        pianjie = pianjie.replaceAll("	", ""); 
	        //System.out.println(pianjie);

	        dao.updateall(id,title,mohujiansuo,zhangjie,pianjie);
		}
	}
}
