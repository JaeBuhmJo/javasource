package action;

import javax.servlet.http.HttpServletRequest;

import domain.BookDTO;
import service.BookReadService;

public class BookReadAction implements BookAction {

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		int code = Integer.parseInt(request.getParameter("code"));
		
		BookReadService service = new BookReadService();
		BookDTO dto = service.read(code);
		request.setAttribute("dto", dto);
		
		return new BookActionForward(false, "read.jsp");
	}

}
