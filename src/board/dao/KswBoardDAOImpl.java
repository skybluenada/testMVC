package a.b.c.com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.mvc.board.sql.KswBoardSqlMap;
import a.b.c.com.mvc.board.vo.KswBoardVO;
import a.b.c.com.mvc.common.ConnProperty;
import a.b.c.com.mvc.common.KswChabun;
import a.b.c.com.mvc.mem.sql.KswMemberSqlMap;

public class KswBoardDAOImpl implements KswBoardDAO {

	@Override
	public ArrayList kswBoardSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardDAOImpl kswBoardSelectAll() 진입 #####");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<KswBoardVO> aList = null;
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(KswBoardSqlMap.getKswBoardSelectAllQuery());
			rsRs = pstmt.executeQuery();
			if(rsRs != null){
				aList = new ArrayList<KswBoardVO>();
				while(rsRs.next()){
					KswBoardVO kvo = new KswBoardVO();
					kvo.setBnum(rsRs.getString("BNUM"));				// 1
					kvo.setBsubject(rsRs.getString("BSUBJECT"));		// 2
					kvo.setBwriter(rsRs.getString("BWRITER"));			// 3
					kvo.setBpw(rsRs.getString("BPW"));					// 4
					kvo.setBmemo(rsRs.getString("BMEMO"));				// 5
					kvo.setBphoto(rsRs.getString("BPHOTO"));				// 6
					kvo.setDeleteyn(rsRs.getString("DELETEYN"));		// 7
					kvo.setInsertdate(rsRs.getString("INSERTDATE"));	// 8
					kvo.setUpdatedate(rsRs.getString("UPDATEDATE"));	// 9
					aList.add(kvo);					
				}
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		} catch (Exception e) {
			System.out.println("KswBoardDAOImpl kswBoardSelectAll() 실패 >>> " + e.getMessage());
		} finally{
			try {
				ConnProperty.conClose(conn, pstmt, rsRs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return aList;
	}

	@Override
	public ArrayList kswBoardSelect(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardDAOImpl kswBoardSelect(KswBoardVO) 진입 #####");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<KswBoardVO> aList = null;
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(KswBoardSqlMap.getKswBoardSelectQuery());
			pstmt.clearParameters();
			pstmt.setString(1, kvo.getBnum());
			rsRs = pstmt.executeQuery();
			if(rsRs != null){
				aList = new ArrayList<KswBoardVO>();
				while(rsRs.next()){
					KswBoardVO _kvo = new KswBoardVO();
					_kvo.setBnum(rsRs.getString("BNUM"));				// 1
					_kvo.setBsubject(rsRs.getString("BSUBJECT"));		// 2
					_kvo.setBwriter(rsRs.getString("BWRITER"));			// 3
					_kvo.setBpw(rsRs.getString("BPW"));					// 4
					_kvo.setBmemo(rsRs.getString("BMEMO"));				// 5
					_kvo.setBphoto(rsRs.getString("BPHOTO"));			// 6
					_kvo.setDeleteyn(rsRs.getString("DELETEYN"));		// 7
					_kvo.setInsertdate(rsRs.getString("INSERTDATE"));	// 8
					_kvo.setUpdatedate(rsRs.getString("UPDATEDATE"));	// 9
					aList.add(_kvo);
				}
			}else{
				System.out.println("조회할 데이터가 없습니다.");
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		} catch (Exception e) {
			System.out.println("KswBoardDAOImpl kswMemSelect(KswBoardVO) 실패 >>> " + e.getMessage());
		} finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public boolean kswBoardInsert(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswBoardDAOImpl kswBoardInsert() 진입 #####");
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(KswBoardSqlMap.getKswBoardInsertQuery());
			pstmt.clearParameters();
			kvo.setBnum(KswChabun.bNum());
			pstmt.setString(1, kvo.getBnum());
			pstmt.setString(2, kvo.getBsubject());			
			pstmt.setString(3, kvo.getBwriter());
			pstmt.setString(4, kvo.getBpw());
			pstmt.setString(5, kvo.getBmemo());
			pstmt.setString(6, kvo.getBphoto());
			
			nCnt = pstmt.executeUpdate();
			if(nCnt == 1){
				System.out.println("KswBoardDAOImpl kswBoardInsert(KswBoardVO) 성공");
				bool = true;
			}
			else{
				System.out.println("KswBoardDAOImpl kswBoardInsert(KswBoardVO) 실패");
			}
			
		} catch (Exception e) {
			System.out.println("KswBoardDAOImpl kswBoardInsert(KswBoardVO) >>> " + e.getMessage() );
		}
		
		return bool;
	}

	@Override
	public boolean kswBoardUpdate(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswMemberDAOImpl kswMemUpdate(KswMemberVO) 진입 #####");
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(KswMemberSqlMap.getKswMemUpdateQuery());
			pstmt.clearParameters();
			pstmt.setString(1, kvo.getBsubject());
			pstmt.setString(2, kvo.getBwriter());			
			pstmt.setString(3, kvo.getBpw());			
			pstmt.setString(4, kvo.getBmemo());			
			pstmt.setString(5, kvo.getBphoto());			
			pstmt.setString(6, kvo.getBnum());			
			nCnt = pstmt.executeUpdate();
			if(nCnt == 1){
				System.out.println("KswMemberDAOImpl kswMemUpdate(KswMemberVO) 성공");
				bool = true;
			}
			else{
				System.out.println("KswMemberDAOImpl kswMemUpdate(KswMemberVO) 실패");
			}
			
		} catch (Exception e) {
			System.out.println("KswMemberDAOImpl kswMemUpdate(KswMemberVO) >>> " + e.getMessage() );
		}
		
		return bool;
	}

	@Override
	public boolean kswBoardDelete(KswBoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("##### KswMemberDAOImpl kswMemDelete(KswMemberVO) 진입 #####");
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(KswMemberSqlMap.getKswMemDeleteQuery());
			pstmt.clearParameters();
			pstmt.setString(1, kvo.getBnum());

			nCnt = pstmt.executeUpdate();
			if(nCnt >= 1){
				System.out.println("KswMemberDAOImpl kswMemDelete(KswMemberVO) 성공");
				bool = true;
			}
			else{
				System.out.println("KswMemberDAOImpl kswMemDelete(KswMemberVO) 실패");
			}
		} catch (Exception e) {
			System.out.println("KswMemberDAOImpl kswMemDelete(KswMemberVO) >>> " + e.getMessage() );
		}
		return bool;
	}

}
