package register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.media.sound.RealTimeSequencerProvider;
import com.user.User;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Register() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//对于post方法提交 直接设置解码形式 
		request.setCharacterEncoding("UTF-8");
		
		//get方式乱码解决
		//String username = request.getParameter("username");//乱码
		//先用iso8859-1编码 在使用utf-8解码
		//username = new String(username.getBytes("iso8859-1"),"UTF-8")
		
		Map<String, String[]> map = request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
		
		String uid = UUID.randomUUID().toString();
		user.setUid(uid);
		try {
			regis(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void regis(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		qr.update(sql,user.getUid(),user.getName(),user.getPassword(),user.getEmail(),user.getSex(),user.getBirth(),user.getUsername());
	}

}
