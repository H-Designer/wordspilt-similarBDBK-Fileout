package Similar;

import java.util.ArrayList;
import java.util.List;

import dao.add_dao;
import information.infor;

public class comparisontwodocTest {
        public static void main(String[] args) {
        	List<infor> list = new ArrayList<infor>();
        	add_dao dao = new add_dao();
        	list = dao.select_all();
        	int len = list.size();
        	//System.out.println("大小是"+len);
        	String []content = new String[len];
        	String []title = new String[len];
        	for(int i=0;i<len;i++) {
        		//System.out.println(list.get(i).getTitle());
        		if(list.get(i).getTitle().contains("（")) {
        			String[] split = list.get(i).getTitle().split("（");
        			title[i] = split[0];
        			//System.out.println(title[i]);
        		}else {
        			title[i] = list.get(i).getTitle();
        		}
    			//System.out.println(title[i]);
        	}
        	for(int i=0;i<len;i++) {
        		 content[i]  = JsoupUtil.URLLoader("https://baike.baidu.com/item/"+title[i]);
        	     if(content[i]==null) {
        	    	 content[i] = list.get(i).getKeyword();
        	     }
        		System.out.println("查询到的结果是"+content[i]);
        	}
        	for(int i=0;i<len;i++) {
        		double result = CosineSimilarAlgorithm.cosSimilarityByString(content[i],list.get(i).getContent());
        		list.get(i).setSimilar(String.valueOf(result));
        		System.out.println(result);
        		String similar=list.get(i).getSimilar();
        		System.out.println(similar);
        		dao.AddSimilar(title[i],similar);
        	}
		}
}
