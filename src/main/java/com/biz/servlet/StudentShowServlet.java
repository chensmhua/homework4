package com.biz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.entity.Student;
import com.biz.redis.PagesUtil;
import com.biz.service.StudentRedisService;

/**
 * Servlet implementation class StudentShowServlet
 */
public class StudentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String strNumber = request.getParameter("pageNumber");
		//�жϵ�ǰҳ��
		int number = 1;
		if(strNumber!=null&&!strNumber.trim().equals(""))
		{
			number=Integer.parseInt(strNumber);
				
		}
		//���÷�����
		StudentRedisService studentRedisService  = new StudentRedisService();
		List<Student>  students = studentRedisService.QueryStudentByPages(number);
		//������ҳ����
		Long maxPage = PagesUtil.pagesUtil();
		//��ȡsession
		//HttpSession session = request.getSession();
		request.setAttribute("CURRENT", number);//��ǰҳ
		request.setAttribute("ADD", students);//����
		request.setAttribute("MAX", maxPage);//���ҳ
		//ʵ����ת
		//response.sendRedirect("ShowStudent.jsp");
		request.getRequestDispatcher("ShowStudent.jsp").forward(request, response);
		
				
		
		
		
		
		
		
//		Student student = new Student();
//		StudentRedisService studentRedisService  = new StudentRedisService();
//		List<Student>  students = studentRedisService.QueryStudent(student);		
//		//��ȡsession
//		HttpSession session = request.getSession();
//		session.setAttribute("ADD", students);
//		response.sendRedirect("ShowStudent.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
