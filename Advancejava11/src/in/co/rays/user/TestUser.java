package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.marksheet.MarksheetBean;
import in.co.rays.marksheet.MarksheetModel;

public class TestUser {
	public static void main(String[] args) throws Exception {
		testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		 testSearch();
		// testAuthenticate();
	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
	
		UserBean bean = new UserBean();
		
		bean.setId(9);
		bean.setFirst_name("himanshu");
		bean.setLast_name("jain");
		bean.setLogin_id("himanshu@gmail.com");
		bean.setPassword("123");
		//bean.setDob(new Date());// add current date 
		bean.setDob(sdf.parse("19/10/1990"));
		
		bean.setAddress("bhopal");

		UserModel model = new UserModel();
		model.add(bean);

	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		
		bean.setId(1);
		bean.setFirst_name("raju");
		bean.setLast_name("xys");
		bean.setLogin_id("raju@gmail.com");
		bean.setPassword("123");
		bean.setDob(new Date());
		bean.setAddress("mp");
		
		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(2);

	}

	private static void testFindByPk() throws Exception {
		UserModel model = new UserModel();
		
		UserBean bean = model.findByPk(10);
		
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());

		} else {
			System.out.println("id not exist");
		}

	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
		UserBean bean = new UserBean();
		
		bean.setFirst_name("r");
		bean.setDob(sdf.parse("13/01/2024"));
		
		UserModel model = new UserModel();

		List list = model.search(bean,0,5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getLogin_id());
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
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLogin_id());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		}

	}
}
