package a.b.c.com.mvc.board.service;

import java.util.ArrayList;

import a.b.c.com.mvc.board.dao.KswBoardDAO;
import a.b.c.com.mvc.board.dao.KswBoardDAOImpl;
import a.b.c.com.mvc.board.vo.KswBoardVO;
import a.b.c.com.mvc.mem.dao.KswMemberDAO;
import a.b.c.com.mvc.mem.dao.KswMemberDAOImpl;

public class KswBoardServiceImpl implements KswBoardService {

	@Override
	public ArrayList kswBoardSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardServiceImpl kswBoardSelectAll() 진입 #####");
		KswBoardDAO kdao = new KswBoardDAOImpl();
		return kdao.kswBoardSelectAll();
	}

	@Override
	public ArrayList kswBoardSelect(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardServiceImpl kswBoardSelect(KswBoardVO) 진입 #####");
		KswBoardDAO kdao = new KswBoardDAOImpl();
		return kdao.kswBoardSelect(kvo);
	}

	@Override
	public boolean kswBoardInsert(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardServiceImpl kswBoardInsert(KswBoardVO) 진입 #####");
		KswBoardDAO kdao = new KswBoardDAOImpl();
		return kdao.kswBoardInsert(kvo);
	}

	@Override
	public boolean kswBoardUpdate(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kswBoardDelete(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		return false;
	}

}
