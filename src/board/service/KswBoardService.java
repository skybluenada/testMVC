package a.b.c.com.mvc.board.service;

import java.util.ArrayList;

import a.b.c.com.mvc.board.vo.KswBoardVO;

public interface KswBoardService {
	public ArrayList kswBoardSelectAll();
	public ArrayList kswBoardSelect(KswBoardVO kvo);
	public boolean kswBoardInsert(KswBoardVO kvo);
	public boolean kswBoardUpdate(KswBoardVO kvo);
	public boolean kswBoardDelete(KswBoardVO kvo);
}
