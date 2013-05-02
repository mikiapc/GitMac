/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import app.dao.PerfilgastoFacadeLocal;
import app.entity.Perfilgasto;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Juanito
 */
@WebServlet(name = "GestionPerfilServlet", urlPatterns = {"/GestionPerfil"})
public class GestionPerfilServlet extends HttpServlet {
    
    @EJB
    private PerfilgastoFacadeLocal pgl;
    
    

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
        
        List<Perfilgasto> listaPerfiles = pgl.findAll();
        /*
        if(("datos".equalsIgnoreCase((String)request.getParameter("datos")))){
            
            String criterio = (String)request.getAttribute("criterio");
            String campo = (String)request.getAttribute("campo");

            

            if(criterio.equalsIgnoreCase("Perfil")){
                Integer pg = Integer.parseInt(campo);
                listaPerfiles = pgl.findByIdPerfilGasto(pg);
            }else if(criterio.equalsIgnoreCase("Gasto")){
                listaPerfiles = pgl.findByTipoSaldo(campo);
            
            }

            request.setAttribute("perfiles", listaPerfiles);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/GestionPerfil.jsp");
            dispatcher.forward(request, response);
        }else{*/
            
            
            request.setAttribute("perfiles", listaPerfiles);
       
        
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/GestionPerfil.jsp");
            dispatcher.forward(request, response);
        //}
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
