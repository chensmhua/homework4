package com.biz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.entity.Student;
import com.biz.service.StudentService;

/**
 * Servlet implementation class CheckStudentServlet
 */
public class CheckStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckStudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Student student = new Student();
		StudentService studentService = new StudentService();
		//��װ����
		List<Student> students = studentService.showStudent(student);
		//��ȡsession
		HttpSession session = request.getSession();
		//�ж��ǲ���Ϊnull
		if(students!=null)
		{
			session.setAttribute("show", students);
			response.sendRedirect(".....");
		}else
		{
			session.setAttribute("show", "������˼����ѯʧ�ܣ�");
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
