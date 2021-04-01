package dog.dao;

import static dog.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dog.vo.Dog;

public class DogDAO {

	DataSource ds;
	Connection con;
	private static DogDAO dogDAO;

	private DogDAO() {

	}

	public static DogDAO getInstance(){
		if(dogDAO == null){
			dogDAO = new DogDAO();
		}
		return dogDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	public ArrayList<Dog> selectDogList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dog> dogList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM dog");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dogList = new ArrayList<Dog>();
				
				do {
					Dog dog = new Dog(rs.getInt("id"), 
									  rs.getString("kind"), 
									  rs.getInt("price"), 
									  rs.getString("image"), 
									  rs.getString("country"), 
									  rs.getInt("height"), 
									  rs.getInt("weight"), 
									  rs.getString("content"), 
									  rs.getInt("readcount")
									 );
					dogList.add(dog);
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
		}
		
		return dogList;
	}

	public Dog selectDog(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dog dog = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM dog WHERE id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dog = new Dog(
						 rs.getInt("id")
						,rs.getString("kind")
						,rs.getInt("price")
						,rs.getString("image")
						,rs.getString("country")
						,rs.getInt("height")
						,rs.getInt("weight")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return dog;
	}
	//상품 조회수 증가
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			pstmt = con.prepareStatement("UPDATE dog SET readcount = readcount + 1 WHERE id = ?");
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}

	public int insertDog(Dog dog) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement("insert into dog (`kind`, `price`, `image`, `country`, `height`, `weight`, `content`, `readcount`)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, dog.getKind());
			pstmt.setInt(2, dog.getPrice());
			pstmt.setString(3, dog.getImage());
			pstmt.setString(4, dog.getCountry());
			pstmt.setInt(5, dog.getHeight());
			pstmt.setInt(6, dog.getWeight());
			pstmt.setString(7, dog.getContent());
			pstmt.setInt(8, dog.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

}
