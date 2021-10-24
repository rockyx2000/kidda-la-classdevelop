/**
 * ClassName    :    FrontController
 * Summary      :    KIDDA-LA WorkManageSystem Controller Servlet
 * CreatorName  :    Ohtake
 * CreateDate   :    2021/06/07
 * EditerName   :
 * EditDate     :
 */

package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class FrontController
 * @author rocky
 *
 */
@WebServlet("/FrontController")

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//フォワード先を変数で指定
		String forwardPath = null;

		//動作を決定する
		String command = request.getParameter("command");

		//コマンド指定がない場合のフォワード先はメインメニューに
		if(command == null) {
			forwardPath = "/WEB-INF/view/MainMenuFrame.jsp";
		}

		//フォワード処理
		RequestDispatcher dispather = request.getRequestDispatcher(forwardPath);
		dispather.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//フォワード先を変数で指定
		String forwardPath = null;

		//動作を決定する
		String command = request.getParameter("command");

		//デバッグ用としてコンソールに出力する
		System.out.println("command = " + command);

		//command指定によってフォワード先を決定する
		if(command == null) {
			//指定がないのでメインメニューへ
			forwardPath = "/WEB-INF/view/CustomerSearchFrame.jsp";
		}
		else if(command.equals("OrderControl")){
			//顧客情報検索画面へフォワードする
			//セッション情報の削除
			HttpSession session = request.getSession(true);
			session.removeAttribute("customerList");
			forwardPath = "/WEB-INF/view/CustomerSearchFrame.jsp";
		}
		else if(command.equals("CustomerSearch")) {
			//顧客情報検索後に顧客情報検索画面へフォワードする
			CustomerSearchAction csa = new CustomerSearchAction();
			try {
				csa.execute(request,response);
			}catch(Exception e) {
				System.out.println(e);
				throw new IOException("顧客情報検索に失敗しました");
			}

			forwardPath = "/WEB-INF/view/CustomerSearchFrame.jsp";

		}
		else if(command.equals("OrderFrame")) {
			//注文画面へフォワードする
			CustomerSearchAction csa = new CustomerSearchAction();
			try {
				csa.execute(request, response);
			}catch(Exception e) {
				System.out.println(e);
				throw new IOException("顧客情報検索に失敗しました");
			}

			//商品一覧を検索する
			ItemInfoAction iia = new ItemInfoAction();
			try {
				iia.execute(request, response);
				}catch(Exception e) {
					System.out.println(e);
					throw new IOException("商品情報検索に失敗しました");
				}

			forwardPath = "/WEB-INF/view/OrderFrame.jsp";
		}else if(command.equals("CustomerEdit")){
			//顧客情報変更画面へフォワードする
			forwardPath = "/WEB-INF/view/CustomerEditFrame.jsp";
		}else if(command.equals("CustomerUpdate")){
			//顧客情報更新後に注文画面へフォワードする

			//顧客情報を更新する
			CustomerUpdateAction cua = new CustomerUpdateAction();
			try{
				cua.execute(request, response);
			}catch (Exception e){
				System.out.println(e);
				throw new IOException("顧客情報更新に失敗しました");
			}
			forwardPath = "/WEB-INF/view/OrderFrame.jsp";
		}


		//フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request,response);

	}

}
