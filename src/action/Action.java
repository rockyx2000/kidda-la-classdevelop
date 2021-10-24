/**
 * ClassName    :    Action
 * Summary      :    KIDDA-LA WorkManageSystem Actuon Interface
 * CreatorName  :    Ohtake
 * CreateDate   :    2021/06/07
 * EditerName   :
 * EditDate     :
 */

package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
