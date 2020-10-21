package ser04.ex01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
	String user_id;
	String user_pw;
	static int total_user =0;
	public LoginImpl()
	{
		
	}
    public LoginImpl(String user_id , String user_pw) {
        this.user_id = user_id;
        this.user_pw = user_pw;
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("Access User");
         ++total_user;
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event)  { 
         System.out.println("User Logout");
         total_user--;
    }
	
}
