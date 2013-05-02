package servlets;



import app.dao.AyuntamientoFacadeLocal;
import app.dao.UsuarioFacadeLocal;
import app.dao.UsuarioFacade;
import app.entity.Ayuntamiento;
import app.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

@WebServlet(name = "AltaUsuarioServlet", urlPatterns = {"/AltaUsuario"})
public class AltaUsuarioServlet extends HttpServlet {


    
    @EJB 
    private UsuarioFacadeLocal user;
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
        RequestDispatcher rd;
        HttpSession sesion = request.getSession();
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String nif = request.getParameter("nif");
        String rol = request.getParameter("rol");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String publicable = request.getParameter("publicable");
        String ayuntamiento = request.getParameter("ayuntamiento");
        String jefe = request.getParameter("jefe");
        
        boolean pub = true;
        if(publicable.equalsIgnoreCase("no")){
            pub = false;
        }

        PasswordGenerator pwd = null; 
        String password = pwd.getPassword();
        
        
        Usuario usuario = new Usuario(nif, nombre, apellidos, direccion, telefono, email, pub, rol, password, false);
        
        List<Ayuntamiento> ayuntamientos = ayuntamientoFacade.findAll();
        Ayuntamiento a = new Ayuntamiento("Málaga", "malaga");
        for(Ayuntamiento ayu:ayuntamientos){
            if(ayu.getAyuntamientoPK().getLocalidad().equalsIgnoreCase(ayuntamiento)){
               a = new Ayuntamiento(ayu.getAyuntamientoPK().getLocalidad(),ayu.getAyuntamientoPK().getDireccion());
            }
        }
        usuario.setAyuntamiento(a);
        List<Usuario> jefes = user.findByRol("jefe de servicio");
        Usuario j = null;
        for(Usuario jef:jefes){
            if((jef.getNombre()+jef.getApellidos()).equalsIgnoreCase(jefe)){
                j = jef;
            }
        }
        usuario.setJefeservicio(j);
        user.create(usuario);
        
        
        
        EnviarEmail enviar = new EnviarEmail();
        enviar.enviar(email, nif, password);
  
        
        
        rd = this.getServletContext().getRequestDispatcher("/GestionUsuariosServlet");
        
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


/*
package servlets;

import app.dao.UsuarioFacade;
import app.dao.UsuarioFacadeLocal;
import app.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig
/**
 *
 * @author Naoual Amasri
 */
/*
@WebServlet(name = "AltaUsuarioServlet", urlPatterns = {"/AltaUsuario"})
public class AltaUsuarioServlet extends HttpServlet {
    
    @PersistenceContext
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
 
    @EJB
    private UsuarioFacadeLocal userFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
/*    @Override
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
   /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   /* @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
*/