package in.co.rays.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public void add(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into user values (?,?,?,?,?,?,?)");

		int pk = nextPk();
		ps.setInt(1, pk);

		// ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirst_name());
		ps.setString(3, bean.getLast_name());
		ps.setString(4, bean.getLogin_id());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());

		int i = ps.executeUpdate();
		System.out.println("data inserted=" + i);
	}

	public void update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update user set first_name=?,last_name=?,login_id=?,password=?,dob=?,address=? where id=?");

		ps.setString(1, bean.getFirst_name());
		ps.setString(2, bean.getLast_name());
		ps.setString(3, bean.getLogin_id());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data updated=" + i);
	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from user where id=?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println("data deleted=" + i);
	}

	public List search(UserBean bean,int pageNo,int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1 = 1");

		if (bean != null) {
			if (bean.getFirst_name() != null && bean.getFirst_name().length() > 0) {
			
			sql.append(" and first_name like '" + bean.getFirst_name() + "%'");
		}
		if (bean.getDob() != null && bean.getDob().getTime() > 0) {
			
			sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + " %'");
		}
	}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql.........." + sql);
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		
			list.add(bean);
		}
		return list;

	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
		
			
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		return bean;
	}

	public UserBean authenticate(String login_id, String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user where login_id=? and password=?");
		
		ps.setString(1, login_id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));

		}
		return bean;
	}

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}
}
