package test;
import java.util.List;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;

public class HanlpTest {
	public static void main(String args[])
	{
		//分词
		List<Term> termList = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
		System.out.println(termList);
		//关键字
//		String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//		List<String> keywordList = HanLP.extractKeyword(content1, 1);
//		System.out.println(keywordList);
	}

}
