package board.service;

import board.domain.BoardDTO;
import board.persistence.BoardDAO;

public class BoardWriteService {
	public boolean insert(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		return dao.insertArticle(dto);
	}
}
