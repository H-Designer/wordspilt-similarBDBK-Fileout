package Java2Word.Jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 使用jacob操作word文档
 * @author MrChen
 *
 */
public class JacobTest{

    
    private ActiveXComponent MSWordApp = null;    //声明一个word对象
    private Dispatch document = null;


    /**
     * 打开word文档
     * @param makeVisible    是否以可读写方式打开
     */
    public void  openWord( boolean makeVisible) {
        if( MSWordApp == null ) {
            MSWordApp = new ActiveXComponent("Word.Application");
        }
        //设置visible
        Dispatch.put(MSWordApp,"Visible",new Variant(makeVisible));

    }
    
    /**
     * 新建word文档
     */
    public void createNewDocument() {
        //获取文档集合
        Dispatch documents = Dispatch.get(MSWordApp, "Documents").toDispatch();
        //调用add方法向文档集合中添加一个新的Word文件
        document = Dispatch.call(documents, "Add").toDispatch();
    }
    
    /**
     * 向word中写入字符串
     * @param text
     */
    public void insertBKText(String txt) {
        //获取当前执行写入的位置，如果是新word文件操作位置为文档开始
        Dispatch selection = Dispatch.get(MSWordApp, "Selection").toDispatch();
        //将字符串写入
        Dispatch align = Dispatch.get(selection, "ParagraphFormat").toDispatch(); // 行列格式化需要的对象
        Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
        Dispatch.put(align, "Alignment", "3"); // 1:置中 2:靠右 3:靠左
        Dispatch.put(font, "Color", "1,0,0,0"); // 字型颜色红色
        Dispatch.put(selection, "Text", txt);

    }
    
    public void insertTitle(String title) {
    	//获取当前执行写入的位置，如果是新word文件操作位置为文档开始
    	Dispatch selection = Dispatch.get(MSWordApp, "Selection").toDispatch();
    	//将字符串写入
    	  Dispatch align = Dispatch.get(selection, "ParagraphFormat").toDispatch(); // 行列格式化需要的对象
		  Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
		  Dispatch.put(align, "Alignment", "1"); // 1:置中 2:靠右 3:靠左
		  Dispatch.put(font, "Bold", "1"); // 字型租体
		  Dispatch.call(selection, "TypeText", title+"查重报告文档"); // 写入标题内容
		  Dispatch.call(selection, "TypeParagraph"); // 空一行段落
    }
    public void insertSimilar(String similar) {
    	//获取当前执行写入的位置，如果是新word文件操作位置为文档开始
    	Dispatch selection = Dispatch.get(MSWordApp, "Selection").toDispatch();
    	//将字符串写入
    	Dispatch align = Dispatch.get(selection, "ParagraphFormat").toDispatch(); // 行列格式化需要的对象
    	Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
    	Dispatch.put(align, "Alignment", "1"); // 1:置中 2:靠右 3:靠左
    	Dispatch.put(font, "Bold", "1"); // 字型租体
    	Dispatch.call(selection, "TypeText", similar+"相似度"); // 写入标题内容
    	Dispatch.call(selection, "TypeParagraph"); // 空一行段落
    }
    public void insertYWTitle(String title) {
    	//获取当前执行写入的位置，如果是新word文件操作位置为文档开始
    	Dispatch selection = Dispatch.get(MSWordApp, "Selection").toDispatch();
    	//将字符串写入
    	Dispatch align = Dispatch.get(selection, "ParagraphFormat").toDispatch(); // 行列格式化需要的对象
    	Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
    	Dispatch.put(align, "Alignment", "3"); // 1:置中 2:靠右 3:靠左
    	Dispatch.call(selection, "TypeText", title); // 写入标题内容
    	Dispatch.call(selection, "TypeParagraph"); // 空一行段落
    }
    public void insertOperator(String title) {
    	//获取当前执行写入的位置，如果是新word文件操作位置为文档开始
    	Dispatch selection = Dispatch.get(MSWordApp, "Selection").toDispatch();
    	//将字符串写入
    	Dispatch align = Dispatch.get(selection, "ParagraphFormat").toDispatch(); // 行列格式化需要的对象
    	Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
    	Dispatch.put(align, "Alignment", "2"); // 1:置中 2:靠右 3:靠左
    	Dispatch.call(selection, "TypeText", title); // 写入标题内容
    	Dispatch.call(selection, "TypeParagraph"); // 空一行段落
    }


    
    /**
     * 另存为
     * @param fileName
     */
    public void saveFileAs(String fileName) {
        Dispatch.call(document, "SaveAs",fileName);
    }
    
    /**
     * 打印
     */
    public void printFile() {
        //采用默认打印机打印
        Dispatch.call(document, "PrintOut");
    }
    
    /**
     * 关闭文档
     * @param     type
     *             0:    关闭文档不改变保存信息
     *             -1:    关闭文档改变保存信息
     *             -2:    关闭文档提示是否保存改变信息，请求确认
     */
    public void closeDocument(Integer type) {
        //如果关闭类型不正确，则默认为
        if((type!=0 && type!=-1 && type != -2) || type == null){
            type = -2;
        }
        Dispatch.call(document, "Close", new Variant(type));
        document = null;
    }
    
    /**
     * 退出
     */
    public void closeWord() {
        Dispatch.call(MSWordApp, "Quit");
        MSWordApp = null;
        document = null;
    }
}