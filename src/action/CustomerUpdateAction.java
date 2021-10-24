/**
 * クラス名     :       CUstomerUpdateAction
 * 概要         :       KIDDA-LA業務管理システムの顧客情報検索アクション
 * 作成者名     :       大嵩
 * 作成日       :       2021/07/26
 * 修正者名     :
 * 修正日       :
 */

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerControlDBAccess;
import model.Customer;

public class CustomerUpdateAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //TODO自動生成されたメソッド・スタブ
        //DAOを生成する

        //リクエストパラメータから検索する電話番号とカナを取得する
        request.setCharacterEncoding("UTF-8");
        int s_custId = Integer.parseInt(request.getParameter("s_custId"));
        String s_name = request.getParameter("s_name");
        String s_kana = request.getParameter("s_kana");
        String s_tel = request.getParameter("s_tel");
        String s_address = request.getParameter("s_address");

        //文字化け対策
        s_kana = new String(s_kana.getBytes("ISO-8859-1"), "UTF-8");
        s_name = new String(s_name.getBytes("ISO-8859-1"), "UTF-8");
        s_address = new String(s_address.getBytes("ISO8859-1"), "UTF-8");

        //デバック用
        System.out.println("s_custId = "+s_custId);
        System.out.println("s_name = "+s_name);
        System.out.println("s_kana = "+s_kana);
        System.out.println("s_tel = "+s_tel);
        System.out.println("s_address = "+s_address);

        //更新情報を格納する変数の生成
        Customer customer = new Customer(s_custId, s_name, s_kana, s_tel, s_address);

        //顧客情報に関するDAOの生成
        CustomerControlDBAccess dao = new CustomerControlDBAccess();

        //顧客情報の更新
        dao.modifyCustomer(customer);

        //セッション用スコープの準備
        HttpSession session = request.getSession();
        //セッションスコープに値引き渡し
        session.setAttribute("customer", customer);
    }
}
