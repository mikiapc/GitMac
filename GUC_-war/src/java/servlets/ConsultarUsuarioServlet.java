/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import app.dao.UsuarioFacadeLocal;
import app.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Naoual Amasri
 */
@WebServlet(name = "ConsultarUsuarioServlet", urlPatterns = {"/ConsultarUsuarioServlet"})
public class ConsultarUsuarioServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = (String)request.getParameter("do");
        
        //get the id of the request
		String id =request.getParameter("id");
                
                System.out.println("id "+id);
		
		List<Usuario> users = usuarioFacadeLocal.findByNif(id);
                
                boolean found = false;
                int i = 0;
                Usuario user = null;
                while(i<users.size() && found==false){
                    System.out.println("en el while");
                    user = users.get(i);
                    if(user.getNif().equals(id)){
                        found = false;
                    }else{
                        i++;
                    }
                }
                
                request.setAttribute("nif", user.getNif());
                request.setAttribute("nombre", user.getNombre());
                request.setAttribute("apellidos", user.getApellidos());
                request.setAttribute("direccion", user.getDireccion());
                request.setAttribute("email", user.getCorreoE());
                request.setAttribute("telefono", user.getTelefono());
                request.setAttribute("publicable", user.getPublicable());
                request.setAttribute("ayuntamiento", user.getAyuntamiento());
                request.setAttribute("rol", user.getRol());
			
			
			
		//get the request dispatcher
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultarUsuario.jsp");
		
		//forward to the jsp file to display the book list
		dispatcher.forward(request, response);	
			

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
