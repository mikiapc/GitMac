/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import app.dao.UsuarioFacadeLocal;
import app.entity.Usuario;
import java.io.IOException;
import java.util.ArrayList;
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
 * @author 
 */
@WebServlet(name="GestionUsuariosServlet", urlPatterns={"/GestionUsuariosServlet"})
public class GestionUsuariosServlet extends HttpServlet {
    

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

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
        
        HttpSession session = request.getSession();
	
	if(("datos".equalsIgnoreCase((String)request.getParameter("datos")))){
            System.out.println("AKI");
            String criterio = (String)request.getAttribute("criterio");
            String campo = (String)request.getAttribute("campo");

            List<Usuario> lista = new ArrayList<Usuario>();

            if(criterio.equalsIgnoreCase("nif")){
                lista = usuarioFacade.findByNif(campo);
            }else if(criterio.equalsIgnoreCase("nombre")){
                lista = usuarioFacade.findByName(campo);
            }else if(criterio.equalsIgnoreCase("apellidos")){
                lista = usuarioFacade.findByLastName(campo);
            }else if(criterio.equalsIgnoreCase("rol")){
                lista = usuarioFacade.findByRol(campo);
            }

            request.setAttribute("usuarios", lista);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/GestionUsuarios.jsp");
            dispatcher.forward(request, response);
        }else{
            System.out.println("AKIIIII");
            List<Usuario> listaUsuarios = usuarioFacade.findAll();
            request.setAttribute("usuarios", listaUsuarios);
       
        
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AdminPrincipal.jsp");
            dispatcher.forward(request, response);
        }
        
        
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
