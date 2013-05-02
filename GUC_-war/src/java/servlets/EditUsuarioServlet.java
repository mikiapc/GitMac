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

/**
 *
 * @author Naoual Amasri
 */
@WebServlet(name = "EditUsuarioServlet", urlPatterns = {"/EditUsuarioServlet"})
public class EditUsuarioServlet extends HttpServlet {

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
        
        String nif = (String)request.getParameter("nif");
        String nombre = (String)request.getParameter("nombre");
        System.out.println(nombre);
        String apellidos = (String)request.getParameter("apellidos");
        String contrasenya = (String)request.getParameter("contrasenya");
        String email = (String)request.getParameter("email");
        String direccion = (String)request.getParameter("direccion");
        String telefono = (String)request.getParameter("telefono");
        String publicable = (String)request.getParameter("publicable");
        String rol = (String)request.getParameter("rol");
        String ayuntamiento = (String)request.getParameter("ayuntamiento");
        
        List<Usuario> usuarios = usuarioFacade.findByNif(nif);
        Usuario user = usuarios.get(0);
        user.setNif(nif);
        user.setNombre(nombre);
        user.setApellidos(apellidos);
        user.setPassword(contrasenya);
        user.setCorreoE(email);
        user.setDireccion(direccion);
        user.setTelefono(telefono);
        boolean pub = true;
        if(publicable.equalsIgnoreCase("no")){
            pub = false;
        }
        user.setPublicable(pub);
        user.setRol(rol);
        List<Ayuntamiento> ayuntamientos = ayuntamientoFacade.findAll();
        Ayuntamiento ayu = null;
        for(Ayuntamiento a:ayuntamientos){
            if(ayuntamiento.equalsIgnoreCase(a.getAyuntamientoPK().getLocalidad())){
                ayu = a;
            }
        }
        user.setAyuntamiento(ayu);
        
        usuarioFacade.edit(user);
        
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/GestionUsuariosServlet");
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
