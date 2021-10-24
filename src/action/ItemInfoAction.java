package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ItemControlDBAccess;
import model.Item;

public class ItemInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ArrayList<Item> itemList = null;

		request.setCharacterEncoding("UTF-8");

		ItemControlDBAccess dao = new ItemControlDBAccess();

		itemList = (ArrayList<Item>) dao.findAll();

		HttpSession session = request.getSession();

		session.setAttribute("itemList", itemList);
	}

}
