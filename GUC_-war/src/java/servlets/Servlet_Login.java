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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Naoual Amasri
 */
@WebServlet(name = "Servlet_Login", urlPatterns = {"/Servlet_Login"})
public class Servlet_Login extends HttpServlet {

    
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
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
            List<Usuario> listaUsuarios;
            String rutaRequest = null;
            if ("LOG IN".equals(request.getParameter("LOG IN"))) {
                //Recojemos datos de entrada en login
                String dni = request.getParameter("dni");
                String contrasenya = request.getParameter("contrasenya");
                //Busqueda en la base de datos
                listaUsuarios = usuarioFacade.findByNif(dni);
                if (listaUsuarios.isEmpty()) {//Si el usuario no existe
                    rutaRequest = "/AgregarAyuntamiento.jsp";
                } else {//Si no esta vacia solo habra uno por eso usamos el 0
                    if (listaUsuarios.get(0).getPassword().equals(contrasenya)) {
                        String rol = listaUsuarios.get(0).getRol();
                        //request.setAttribute("usuario",sesion.getAttribute("nombreUsuario"));
                        if (rol.equals("administrador")) {
                            rutaRequest = "/GestionUsuariosServlet";
                            //sesion.setAttribute("id_admin", listaUsuarios.get(0).getNif());
                            //sesion.setAttribute("nombreUsuario", listaUsuarios.get(0));
                            //request.setAttribute("usuario",listaUsuarios.get(0));
                        }
                    } else {
                        rutaRequest = "/GestionUsuariosServlet";
                        }
                }
            }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher(rutaRequest);
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
