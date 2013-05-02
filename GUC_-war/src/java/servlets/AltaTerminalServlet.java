/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

//import app.dao.TerminalFacade;
import app.dao.TerminalFacadeLocal;
import app.entity.Terminal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miki
 */
@WebServlet(name = "AltaTerminalServlet", urlPatterns = {"/AltaTerminal"})
public class AltaTerminalServlet extends HttpServlet {

    @EJB
    private TerminalFacadeLocal facade;
    
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



        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String StringTipo = request.getParameter("tipo");
        char t;
        if(StringTipo.equalsIgnoreCase("f")){
             t = 'f';
        }else{
             t = 'm';
        }

            
        String ubicacion = request.getParameter("ubicacion");
        
        
        Terminal terminal = new Terminal();
        terminal.setMarca(marca);
        terminal.setModelo(modelo);
        terminal.setTipo(t);
        terminal.setAsignado(false);
        if(terminal.getTipo()=='f'){
           terminal.setUbicacion(ubicacion);
        }
  

        System.out.println(terminal.toString());

        facade.create(terminal);
       
        RequestDispatcher rd;
         rd = this.getServletContext().getRequestDispatcher("/GestionTerminalesServlet");
        
         rd.forward(request, response);
        
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
