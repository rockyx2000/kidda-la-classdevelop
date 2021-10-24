/**
 * ClassName    :    CustomerSearchAction
 * Summary      :    KIDDA-LA WorkManageSystem CustomerInformation Search Action
 * CreatorName  :    Ohtake
 * CreateDate   :    2021/06/07
 * EditerName   :
 * EditDate     :
 */

package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerControlDBAccess;
import model.Customer;

public class CustomerSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

		//検索結果を格納する変数の生成
		ArrayList<Customer> customerList = null;

		//リクエストパラメータから検索する電話番号とカナを取得する
		request.setCharacterEncoding("UTF-8");
		String s_tel = request.getParameter("s_tel");
		String s_kana = request.getParameter("s_kana");
		String s_custId = request.getParameter("s_custId");

		//文字化け対策
		s_kana = new String(s_kana.getBytes("ISO-8859-1"),"UTF-8");

		System.out.println("s_tel = " + s_tel);
		System.out.println("s_kana = " + s_kana);
		System.out.println("s_custId = " + s_custId);

		//顧客情報に関するDAOの生成
		CustomerControlDBAccess dao = new CustomerControlDBAccess();

		//IDで顧客情報を検索する
		if(s_custId != null) {
			Customer customer = dao.searchCustomerById(Integer.parseInt(s_custId));
			System.out.println("顧客IDで検索");
			//セッション用スコープの準備
			HttpSession session = request.getSession();
			//セッションスコープに引き渡し
			session.setAttribute("customer", customer);
			return;
		}

		//電話番号で顧客情報を検索する
		else if(! s_tel.equals("")) {
			customerList = dao.searchCustomerByTel(s_tel);
			System.out.println("検索結果 = " + customerList.size() + "件");
		}

		//カナで顧客情報を検索する
		else if(! s_kana.equals("")) {
			customerList = dao.searchCustomerByKana(s_kana);
			System.out.println("検索結果 = " + customerList.size() + "件");
		}

		//セッションスコープの準備
		HttpSession session =  request.getSession();

		//引き渡し
		session.setAttribute("customerList", customerList);



	}

}
