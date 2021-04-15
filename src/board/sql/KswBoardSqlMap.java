package a.b.c.com.mvc.board.sql;

public abstract class KswBoardSqlMap {
	public static String getKswBoardChabunQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT /*+ INDEX_DESC(A SYS_C0011097)*/				\n");
		sb.append(" 	 NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 COMMNO		\n");
		sb.append("FROM  MVC_BOARD A 			 						\n");
		return sb.toString();
	}
	
	public static String getKswBoardSelectAllQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT									\n");
		sb.append(" 					BNUM, 			\n");
		sb.append(" 					BSUBJECT, 		\n");
		sb.append(" 					BWRITER, 			\n");
		sb.append(" 					BPW, 				\n");
		sb.append(" 					BMEMO, 			\n");
		sb.append(" 					BPHOTO, 			\n");
		sb.append(" 					DELETEYN, 		\n");
		sb.append(" 					INSERTDATE,		\n");
		sb.append(" 					UPDATEDATE  		\n");
		sb.append(" FROM MVC_BOARD A		 				\n");
		sb.append(" WHERE A.DELETEYN = 'Y'					\n");
		return sb.toString();
	}
	public static String getKswBoardSelectQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT									\n");
		sb.append(" 					BNUM, 			\n");
		sb.append(" 					BSUBJECT, 		\n");
		sb.append(" 					BWRITER, 			\n");
		sb.append(" 					BPW, 				\n");
		sb.append(" 					BMEMO, 			\n");
		sb.append(" 					BPHOTO, 			\n");
		sb.append(" 					DELETEYN, 		\n");
		sb.append(" 					INSERTDATE,		\n");
		sb.append(" 					UPDATEDATE  		\n");
		sb.append(" FROM MVC_BOARD A		 				\n");
		sb.append(" WHERE									\n");
		sb.append(" 		A.BNUM = ?						\n");
		sb.append(" AND	    A.DELETEYN = 'Y'				\n");
		sb.append("	ORDER BY 1 								\n");
		return sb.toString();
	}
	public static String getKswBoardInsertQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO 							\n");
		sb.append(" 	MVC_BOARD 							\n");
		sb.append(" 			 ( 							\n");
		sb.append(" 					BNUM, 				\n");
		sb.append(" 					BSUBJECT, 			\n");
		sb.append(" 					BWRITER, 			\n");
		sb.append(" 					BPW, 				\n");
		sb.append(" 					BMEMO, 				\n");
		sb.append(" 					BPHOTO, 			\n");
		sb.append(" 					DELETEYN, 			\n");
		sb.append(" 					INSERTDATE,			\n");
		sb.append(" 					UPDATEDATE  		\n");
		sb.append(" 		 	) 							\n");
		sb.append(" 	VALUES 								\n");
		sb.append(" 			 ( 							\n");
		sb.append(" 					?, 					\n"); // BNUM			placeholder 1,  parameterIndex 1
		sb.append(" 					?, 					\n"); // BSUBJECT		placeholder 2,  parameterIndex 2
		sb.append(" 					?, 					\n"); // BWRITER 		placeholder 3,  parameterIndex 3
		sb.append(" 					?, 					\n"); // BPW	 		placeholder 4,  parameterIndex 4
		sb.append(" 					?,	 				\n"); // BMEMO			placeholder 5,  parameterIndex 5
		sb.append(" 					?,	 				\n"); // BPHOTO			placeholder 6,  parameterIndex 6
		sb.append(" 					'Y', 				\n"); 
		sb.append(" 					SYSDATE,			\n"); 
		sb.append(" 					SYSDATE 			\n"); 
		sb.append(" 		 	) 							\n");
		return sb.toString();
	}
	// 아직 안함.
	public static String getKswBoardUpdateQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE											\n");
		sb.append(" 		MVC_BOARD SET							\n");
		sb.append(" 				BSUBJECT 			= ?, 		\n"); // 1
		sb.append(" 				BWRITER 			= ?, 		\n"); // 2
		sb.append(" 				BPW					= ?, 		\n"); // 3
		sb.append(" 				BMEMO				= ?, 		\n"); // 4
		sb.append(" 				BPHOTO				= ?,	 	\n"); // 5
		sb.append(" 				UPDATEDATE			= SYSDATE	\n");
		sb.append(" WHERE											\n");
		sb.append(" 				MNUM 				= ?			\n"); // 6
		sb.append(" AND	   			DELETEYN 			= 'Y'		\n");
		return sb.toString();
	}
	// 아직 안함.
	public static String getKswBoardDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE											\n");
		sb.append(" 		MVC_BOARD SET							\n");
		sb.append(" 				DELETEYN 			= 'N', 		\n");
		sb.append(" 				UPDATEDATE 			= SYSDATE	\n");
		sb.append(" WHERE											\n");
		sb.append(" 				MNUM 				= ?			\n"); // 1
		sb.append(" AND	   			DELETEYN			= 'Y'		\n");
		return sb.toString();
	}
}
