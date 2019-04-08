package Java2Word.Jacob;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobPattern {
 public static void main(String args[]) {
  ActiveXComponent wordApp = new ActiveXComponent("Word.Application"); // 启动word
  // Set the visible property as required.
  Dispatch.put(wordApp, "Visible", new Variant(true));// //设置word可见
  Dispatch docs = wordApp.getProperty("Documents").toDispatch();
  // String inFile = "d:\\test.doc";
  // Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
  // new Object[] { inFile, new Variant(false), new Variant(false)},//参数３,false:可写，true:只读
  // new int[1]).toDispatch();//打开文档
  Dispatch document = Dispatch.call(docs, "Add").toDispatch();// create new document

  String userName = wordApp.getPropertyAsString("Username");// 显示用户信息
  System.out.println("用户名:" + userName);
  // 文档对齐，字体设置////////////////////////
  Dispatch selection = Dispatch.get(wordApp, "Selection").toDispatch();
  Dispatch align = Dispatch.get(selection, "ParagraphFormat")
    .toDispatch(); // 行列格式化需要的对象
  Dispatch font = Dispatch.get(selection, "Font").toDispatch(); // 字型格式化需要的对象
  // 标题处理////////////////////////
  Dispatch.put(align, "Alignment", "1"); // 1:置中 2:靠右 3:靠左
  Dispatch.put(font, "Bold", "1"); // 字型租体
  Dispatch.put(font, "Color", "1,0,0,0"); // 字型颜色红色
  Dispatch.call(selection, "TypeText", "Word文档处理"); // 写入标题内容
  Dispatch.call(selection, "TypeParagraph"); // 空一行段落
  Dispatch.put(align, "Alignment", "3"); // 1:置中 2:靠右 3:靠左
  Dispatch.put(selection, "Text", "        ");
  Dispatch.call(selection, "MoveDown"); // 光标标往下一行
  //表格处理////////////////////////
  Dispatch tables = Dispatch.get(document, "Tables").toDispatch();
  Dispatch range = Dispatch.get(selection, "Range").toDispatch();
  Dispatch table1 = Dispatch.call(tables, "Add", range, new Variant(3),
    new Variant(2), new Variant(1)).toDispatch(); // 设置行数,列数,表格外框宽度
  // 所有表格
  Variant tableAmount = Dispatch.get(tables, "count");
  System.out.println(tableAmount);
  // 要填充的表格
  Dispatch t1 = Dispatch.call(tables, "Item", new Variant(1))
    .toDispatch();
  Dispatch t1_row = Dispatch.get(t1, "rows").toDispatch();// 所有行
  int t1_rowNum = Dispatch.get(t1_row, "count").getInt();
  Dispatch.call(Dispatch.get(t1, "columns").toDispatch(), "AutoFit");// 自动调整
  int t1_colNum = Dispatch.get(Dispatch.get(t1, "columns").toDispatch(),
    "count").getInt();
  System.out.println(t1_rowNum + " " + t1_colNum);
  for (int i = 1; i <= t1_rowNum; i++) {
   for (int j = 1; j <= t1_colNum; j++) {
    Dispatch cell = Dispatch.call(t1, "Cell", new Variant(i),
      new Variant(j)).toDispatch();// 行，列
    Dispatch.call(cell, "Select");
    Dispatch.put(selection, "Text", "cell" + i + j); // 写入word的内容
    Dispatch.put(font, "Bold", "0"); // 字型租体(1:租体 0:取消租体)
    Dispatch.put(font, "Color", "1,1,1,0"); // 字型颜色
    Dispatch.put(font, "Italic", "1"); // 斜体 1:斜体 0:取消斜体
    Dispatch.put(font, "Underline", "1"); // 下划线
    Dispatch Range = Dispatch.get(cell, "Range").toDispatch();
    String cellContent = Dispatch.get(Range, "Text").toString();
    System.out.println((cellContent.substring(0, cellContent
      .length() - 1)).trim());
   }
   Dispatch.call(selection, "MoveDown"); // 光标往下一行(才不会输入盖过上一输入位置)
  }
  //合并单元格////////////////////////
  Dispatch.put(selection, "Text", "        ");
  Dispatch.call(selection, "MoveDown"); // 光标标往下一行
  Dispatch range2 = Dispatch.get(selection, "Range").toDispatch();
  Dispatch table2 = Dispatch.call(tables, "Add", range2, new Variant(8),
    new Variant(4), new Variant(1)).toDispatch(); // 设置行数,列数,表格外框宽度
  Dispatch t2 = Dispatch.call(tables, "Item", new Variant(2))
    .toDispatch();
  Dispatch beginCell = Dispatch.call(t2, "Cell", new Variant(1),
    new Variant(1)).toDispatch();
  Dispatch endCell = Dispatch.call(t2, "Cell", new Variant(4),
    new Variant(4)).toDispatch();
  Dispatch.call(beginCell, "Merge", endCell);

  for (int row = 1; row <= Dispatch.get(
    Dispatch.get(t2, "rows").toDispatch(), "count").getInt(); row++) {
   for (int col = 1; col <= Dispatch.get(
     Dispatch.get(t2, "columns").toDispatch(), "count").getInt(); col++) {

    if (row == 1) {
     Dispatch cell = Dispatch.call(t2, "Cell", new Variant(1),
       new Variant(1)).toDispatch();// 行，列
     Dispatch.call(cell, "Select");
     Dispatch.put(font, "Color", "1,1,1,0"); // 字型颜色
     Dispatch.put(selection, "Text", "merge Cell!");
    } else {
     Dispatch cell = Dispatch.call(t2, "Cell", new Variant(row),
       new Variant(col)).toDispatch();// 行，列
     Dispatch.call(cell, "Select");
     Dispatch.put(font, "Color", "1,1,1,0"); // 字型颜色
     Dispatch.put(selection, "Text", "cell" + row + col);
    }
   }
   Dispatch.call(selection, "MoveDown");
  }
  //Dispatch.call(selection, "MoveRight", new Variant(1), new Variant(1));// 取消选择
  // Object content = Dispatch.get(doc,"Content").toDispatch();
  // Word文档内容查找及替换////////////////////////
  Dispatch.call(selection, "TypeParagraph"); // 空一行段落
  Dispatch.put(align, "Alignment", "3"); // 1:置中 2:靠右 3:靠左
  Dispatch.put(font, "Color", 0);
  Dispatch.put(selection, "Text", "欢迎，Hello，world!");
  Dispatch.call(selection, "HomeKey", new Variant(6));// 移到开头
  Dispatch find = Dispatch.call(selection, "Find").toDispatch();// 获得Find组件
  Dispatch.put(find, "Text", "hello"); // 查找字符串"hello"
  Dispatch.put(find, "Forward", "True");// 向前查找
  // Dispatch.put(find, "Format", "True");// 设置格式
  Dispatch.put(find, "MatchCase", "false");// 大小写匹配
  Dispatch.put(find, "MatchWholeWord", "True"); // 全字匹配
  Dispatch.call(find, "Execute"); // 执行查询
  Dispatch.put(selection, "Text", "你好");// 替换为"你好"
  //使用方法传入的参数parameter调用word文档中的MyWordMacro宏//
  //Dispatch.call(document,macroName,parameter);
  //Dispatch.invoke(document,macroName,Dispatch.Method,parameter,new int[1]);
  //页眉，页脚处理////////////////////////
  Dispatch ActiveWindow = wordApp.getProperty("ActiveWindow")
    .toDispatch();
  Dispatch ActivePane = Dispatch.get(ActiveWindow, "ActivePane")
    .toDispatch();
  Dispatch View = Dispatch.get(ActivePane, "View").toDispatch();
  Dispatch.put(View, "SeekView", "9"); //9是设置页眉
  Dispatch.put(align, "Alignment", "1"); // 置中
  Dispatch.put(selection, "Text", "这里是页眉"); // 初始化时间
  Dispatch.put(View, "SeekView", "10"); // 10是设置页脚
  Dispatch.put(align, "Alignment", "2"); // 靠右
  Dispatch.put(selection, "Text", "这里是页脚"); // 初始化从1开始
  //书签处理(打开文档时处理)////////////////////////
  //Dispatch activeDocument = wordApp.getProperty("ActiveDocument").toDispatch();
  Dispatch bookMarks = Dispatch.call(document, "Bookmarks").toDispatch();
  boolean isExist = Dispatch.call(bookMarks, "Exists", "bookMark1")
    .getBoolean();
  if (isExist == true) {
   Dispatch rangeItem1 = Dispatch.call(bookMarks, "Item", "bookMark1")
     .toDispatch();
   Dispatch range1 = Dispatch.call(rangeItem1, "Range").toDispatch();
   Dispatch.put(range1, "Text", new Variant("当前是书签１的文本信息!"));
   String bookMark1Value = Dispatch.get(range1, "Text").toString();
   System.out.println(bookMark1Value);
  } else {
   System.out.println("当前书签不存在,重新建立!");
   Dispatch.call(bookMarks, "Add", "bookMark1", selection);
   Dispatch rangeItem1 = Dispatch.call(bookMarks, "Item", "bookMark1")
   .toDispatch();
   Dispatch range1 = Dispatch.call(rangeItem1, "Range").toDispatch();
   Dispatch.put(range1, "Text", new Variant("当前是书签１的文本信息!"));
   String bookMark1Value = Dispatch.get(range1, "Text").toString();
   System.out.println(bookMark1Value);

  }
  //保存操作////////////////////////
  Dispatch.call(document, "SaveAs", "D:/wordOperate.doc");
  //Dispatch.invoke((Dispatch) doc, "SaveAs", Dispatch.Method, new Object[]{htmlPath, new Variant(8)}, new int[1]);   //生成html文件
  // 0 = wdDoNotSaveChanges
  // -1 = wdSaveChanges
  // -2 = wdPromptToSaveChanges
  //Dispatch.call(document, "Close", new Variant(0));
  // // worddoc.olefunction("protect",2,true,"");
  // // Dispatch bookMarks = wordApp.call(docs,"Bookmarks").toDispatch();
  // // System.out.println("bookmarks"+bookMarks.getProgramId());
  // //Dispatch.call(doc, "Save"); //保存
  // // Dispatch.call(doc, "Close", new Variant(true));
  // //wordApp.invoke("Quit",new Variant[]{});
  // wordApp.safeRelease();//Finalizers call this method
 }
 }