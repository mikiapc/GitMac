/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import app.dao.AyuntamientoFacadeLocal;
import app.dao.UsuarioFacadeLocal;
import app.entity.Ayuntamiento;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Naoual Amasri
 */
@WebServlet(name = "OpcionesUsuarioServlet", urlPatterns = {"/OpcionesUsuarioServlet"})
public class OpcionesUsuarioServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    @EJB
    private AyuntamientoFacadeLocal ayuntamientoFacade;
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
        
        //get session of the request
	HttpSession session = request.getSession();
		

        String action = request.getParameter("do");
        String nif = request.getParameter("nif");
	
        if(action.equalsIgnoreCase("edit")){
            
            List<Usuario> lista = usuarioFacade.findByNif(nif);
            System.out.println(lista.toString());
            Usuario user = lista.get(0);
            
            List<Ayuntamiento> ayuntamientos = ayuntamientoFacade.findAll();
            System.out.println(ayuntamientos.toString());
            
            List<Usuario> jefes = usuarioFacade.findByRol("Jefe de servicio");
            System.out.println(jefes.toString());
            
            request.setAttribute("usuario", user);
            request.setAttribute("ayuntamientos", ayuntamientos);
            request.setAttribute("jefes", jefes);
          
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditarUsuarioJsp.jsp");
            dispatcher.forward(request, response);	
        }else if(action.equalsIgnoreCase("delete")){
            List<Usuario> lista = usuarioFacade.findByNif(nif);
            Usuario user = lista.get(0);
            
            usuarioFacade.remove(user);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionUsuariosServlet");
            dispatcher.forward(request, response);
        }
        
        
        
        
		
		//forward to the jsp file to display the book list
		

		/*
		//redirect to the book list servlet 
		response.sendRedirect(request.getContextPath() + "/BookList");*/
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
