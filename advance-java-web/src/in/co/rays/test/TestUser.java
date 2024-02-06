package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		//testAdd();
		// testUpdate();
		// testDelete();
		//testSearch();
		// testFindByPk();
		// testAuthenticate();

	}

	private static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
	
		bean.setId(20);
		bean.setFirstName("shichen");
		bean.setLasName("star");
		bean.setLoginId("shinchen@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("01/01/1999"));
		bean.setAddress("banglore");
		
		model.add(bean);

	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		bean.setId(14);
		bean.setFirstName("shichen");
		bean.setLasName("star");
		bean.setLoginId("shinchen@gmail.com");
		bean.setPassword("123");
		bean.setDob(sdf.parse("12/12/2000"));
		bean.setAddress("banglore");
		
		model.update(bean);

	}

	private static void testDelete() throws Exception {
		UserModel model = new UserModel();
		
		model.delete(14);

	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		UserBean bean = new UserBean();
		
		//bean.setFirst_name("s");
		//bean.setDob(sdf.parse("12/01/2024"));
	
		UserModel model = new UserModel();

		List list = model.search(bean,1,5);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
		
			System.out.print("" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLasName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}

	}

	private static void testAuthenticate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.authenticate("sagar@gmail.com", "123");
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLasName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		} else {
			System.out.println("id not exist");
		}

	}

	private static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(12);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLasName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		} else {
			System.out.println("id not exist");
		}

	}

}
