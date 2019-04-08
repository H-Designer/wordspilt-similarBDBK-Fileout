package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.dbutil;
import java.sql.Statement;
import information.infor;




public class add_dao {
	
	public void addtitle(String title,String zhangjie) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		String sql = "insert into words(title) values(?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,title);
			
//		String sql = "insert into word(title,mohujiansuo,zhangjie) values(?,?,?)";
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1,title);
//			preparedStatement.setString(2,title);
//			preparedStatement.setString(3,zhangjie);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	public void addpian(String pianjie) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "insert into word(pianjie) values(?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,pianjie);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	public void update() {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "update word t set t.pianjie = '' where t.id <'673' and t.id>='585'";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	public void updateall(int id,String title,String mohujiansuo,String zhangjie,String pianjie ) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "update word set title=?,mohujiansuo=?,zhangjie=?,pianjie=?  where id=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,title);
			preparedStatement.setString(2,mohujiansuo);
			preparedStatement.setString(3,zhangjie);
			preparedStatement.setString(4,pianjie);
			preparedStatement.setInt(5,id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	//添加内容信息
	public void addcontent(String title,String content ) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "update word set content=?  where title=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,content);
			preparedStatement.setString(2,title);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	//添加相似度
	public void AddSimilar(String title,String similar ) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "update word set similar=?  where title=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,similar);
			preparedStatement.setString(2,title);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	//添加关键字
	public void addKeyword(String title ,List<String> keywordList) {
		PreparedStatement preparedStatement = null;
		//	ResultSet resultSet = null;
		Connection connection = dbutil.getConnection();
		
		String sql = "update word set keyword=?  where title=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,keywordList.toString());
			preparedStatement.setString(2,title);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
	}
	
	
	public List<infor> select_all(){
		List<infor> infor = new ArrayList<infor>();
		String sql="select * from word";
		PreparedStatement preparedStatement = null;
		Connection connection = dbutil.getConnection();
		ResultSet resultSet=null;
		infor information =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				information = new infor();
				information.setContent(resultSet.getString("content"));
				information.setId(resultSet.getInt("id"));
				information.setMohujiansuo(resultSet.getString("mohujiansuo"));
				information.setPianjie(resultSet.getString("pianjie"));
				information.setTitle(resultSet.getString("title"));
				information.setZhangjie(resultSet.getString("zhangjie"));
				information.setKeyword(resultSet.getString("keyword"));
				information.setSimilar(resultSet.getString("similar"));
				infor.add(information);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			dbutil.close(resultSet);
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
		return infor;
	}
	
	public List<infor> select(String title){
		List<infor> infor = new ArrayList<infor>();
		String sql="select * from word where title=?";
		PreparedStatement preparedStatement = null;
		Connection connection = dbutil.getConnection();
		ResultSet resultSet=null;
		infor information =null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,title);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				information = new infor();
				information.setContent(resultSet.getString("content"));
				information.setId(resultSet.getInt("id"));
				information.setMohujiansuo(resultSet.getString("mohujiansuo"));
				information.setPianjie(resultSet.getString("pianjie"));
				information.setTitle(resultSet.getString("title"));
				information.setZhangjie(resultSet.getString("zhangjie"));
				information.setKeyword(resultSet.getString("keyword"));
				information.setSimilar(resultSet.getString("similar"));
				infor.add(information);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			dbutil.close(resultSet);
			dbutil.close(preparedStatement);
			dbutil.close(connection);
		}
		return infor;
	}
	
	
}
