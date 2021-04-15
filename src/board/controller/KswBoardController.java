package a.b.c.com.mvc.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import a.b.c.com.mvc.board.service.KswBoardService;
import a.b.c.com.mvc.board.service.KswBoardServiceImpl;
import a.b.c.com.mvc.board.vo.KswBoardVO;
import a.b.c.com.mvc.common.CommonUtils;

/**
 * Servlet implementation class KswBoardController
 */
@WebServlet("/kswBoardController")
public class KswBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");
		if(isudType != null){
			isudType.toUpperCase();
		}
		String remoteIP = request.getRemoteAddr();
		String method = request.getMethod();
		
		System.out.println("isudType >>> : " + isudType);
		System.out.println("method >>> : " + method);		
		System.out.println("remoteIP >>> : " + remoteIP);
		
		
		if(isudType != null && isudType.length() > 0){
			// SELECT ALL
			if("SALL".equals(isudType.toUpperCase())){
				KswBoardService ks = new KswBoardServiceImpl();
				KswBoardVO kvo = new KswBoardVO();
				ArrayList<KswBoardVO> aList = ks.kswBoardSelectAll();
				if(aList != null && aList.size() > 0){
					request.setAttribute("aListAll", aList);
					RequestDispatcher rd = request.getRequestDispatcher("/model2mvc/board/boardSelectAll.jsp");
					rd.forward(request, response);
				}else{
					out.println("<script>");					
					out.println("location.href='/testMVC/kswBoardController?isud_type=I'");
					out.println("</script>");
				}
			}
			// SELECT 
			if("S".equals(isudType.toUpperCase())){
				KswBoardService ks = new KswBoardServiceImpl();
				KswBoardVO kvo = new KswBoardVO();
				String bnum = request.getParameter("chkInBnum");
				kvo.setBnum(bnum);
				ArrayList<KswBoardVO> aList = ks.kswBoardSelect(kvo);
				if(aList != null && aList.size() > 0){
					request.setAttribute("aListS", aList);
					RequestDispatcher rd = request.getRequestDispatcher("/model2mvc/board/boardSelect.jsp");
					rd.forward(request, response);
				}else{
					out.println("<script>");					
					out.println("location.href='/testMVC/kswBoardController?isud_type=SALL'");
					out.println("</script>");
				}
			}
			
			if("I".equals(isudType)){
				boolean fileUploadBool = false;
				if(request.getContentType() != null){
					fileUploadBool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				}		
				System.out.println("fileUploadBool >>> : " + fileUploadBool);
				if (fileUploadBool){
					
					System.out.println(" 파일 업로드 루틴 >>> : ");
					
					String uploadPath = CommonUtils.IMG_B_UPLOAD_PATH;
					int maxSize = CommonUtils.IMG_B_FILE_SIZE;
					String encode = CommonUtils.EN_B_CODE;
					
					try {
						MultipartRequest mr = new MultipartRequest(  request
											                        ,uploadPath
											                        ,maxSize
											                        ,encode
											                        ,new DefaultFileRenamePolicy());
						String bnum = mr.getParameter("bnum");
						String bsubject = mr.getParameter("bsubject");
						String bwriter = mr.getParameter("bwriter");
						String bpw = mr.getParameter("bpw");
						String bmemo = mr.getParameter("bmemo");
						
						// 사진
						Enumeration<String> e = mr.getFileNames();
						String imgName = e.nextElement();
						String bphoto = mr.getFilesystemName(imgName);
						
						System.out.println("bnum 				>>> : " + bnum);
						System.out.println("bsubject 				>>> : " + bsubject);
						System.out.println("bwriter 				>>> : " + bwriter);
						System.out.println("bpw 			>>> : " + bpw);
						System.out.println("bmemo 				>>> : " + bmemo);
						System.out.println("bphoto 				>>> : " + bphoto);
						
						// 서비스 호출 
						KswBoardService ks = new KswBoardServiceImpl();
						KswBoardVO kvo = null;
						kvo = new KswBoardVO();
						
						kvo.setBnum(bnum);
						kvo.setBsubject(bsubject);
						kvo.setBwriter(bwriter);
						kvo.setBpw(bpw);
						kvo.setBmemo(bmemo);
						kvo.setBphoto(bphoto);						
						
						boolean bool = ks.kswBoardInsert(kvo);
						
						if (bool) {							
							request.setAttribute("bool", new Boolean(bool));					
							
							RequestDispatcher rd= request.getRequestDispatcher("/model2mvc/board/boardInsert.jsp");
							rd.forward(request, response);
							
						}else {
							out.println("<script>");					
							out.println("location.href='/testMVC/model2mvc/board/board.html'");
							out.println("</script>");
						}
						
					}catch(Exception e){
						System.out.println("게시판 입력에서 에러 >>> : " + e);
					}	
				}
			}
			
			if("U".equals(isudType.toUpperCase())){
				System.out.println("여기오는지");
				KswBoardService ks = new KswBoardServiceImpl();
				KswBoardVO kvo = new KswBoardVO();
				
				String bnum = request.getParameter("bnum");
				String bsubject = request.getParameter("bsubject");
				String bwriter = request.getParameter("bwriter");				
				String bpw = request.getParameter("bpw");
				String bmemo = request.getParameter("bmemo");
				String bphoto = request.getParameter("bphoto");
				
				
				kvo.setBnum(bnum);
				kvo.setBsubject(bsubject);
				kvo.setBwriter(bwriter);
				kvo.setBpw(bpw);
				kvo.setBmemo(bmemo);
				kvo.setBphoto(bphoto);
				
				boolean bool = ks.kswBoardUpdate(kvo);
				
				if(bool){
					request.setAttribute("bool", new Boolean(bool));
					RequestDispatcher rd = request.getRequestDispatcher("/model2mvc/board/boardUpdate.jsp");
					rd.forward(request, response);
				}else{
					out.println("<script>");					
					out.println("location.href='/testMVC/kswBoardController?isud_type=SALL'");
					out.println("</script>");
				}
			}
			
			if("D".equals(isudType.toUpperCase())){
				
				KswBoardService ks = new KswBoardServiceImpl();
				KswBoardVO kvo = new KswBoardVO();
				String bnum = request.getParameter("chkInBnum");
				if(bnum == null) {
					bnum = request.getParameter("bnum");
				}
				kvo.setBnum(bnum);
				
				boolean bool = ks.kswBoardDelete(kvo);
				if(bool){
					request.setAttribute("bool", new Boolean(bool));
					RequestDispatcher rd = request.getRequestDispatcher("/model2mvc/board/boardDelete.jsp");
					rd.forward(request, response);
				}else{
					out.println("<script>");					
					out.println("location.href='/testMVC/kswBoardController?isud_type=SALL'");
					out.println("</script>");
				}
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
