package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControllerMain", urlPatterns = {"/ControllerMain"})
public class ControllerMain extends HttpServlet {

    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }

    // ok renvoit bien la home
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String section = request.getParameter("section");
        String page = "/WEB-INF/home.jsp";
        
        
        /////// DO NOT MODIFY ABOVE THIS LINE ///////

       
        
        //--------------------------------------------------------------------------------------//
        //                                      HOME                                            //
        //--------------------------------------------------------------------------------------//
        
        if("carousel-event".equals(section)){            
            page = "/WEB-INF/includes/carouselEvent.jsp";
        }
        
        
        
        //--------------------------------------------------------------------------------------//
        //                               CONTROLEUR NAVIGATOR                                   //
        //--------------------------------------------------------------------------------------//
        
        
        //                                 Bouton Home                                          //
        
        if("home".equals(section)){            
            page = "/WEB-INF/home.jsp";
        }
        
        
        //                                 Bouton Catalogue                                          //
        
        if("catalog".equals(section)){            
            page = "/WEB-INF/catalog.jsp";
        }
        
        
        
        
        
        
        
        
        
       
        
        /*if ("book".equals(section)) {
            page = "/WEB-INF/includes/book.jsp";
        }
        
        
        if(getServletContext().getAttribute("gestionLivre") == null){
            try {
                getServletContext().setAttribute("gestionLivre", new GestionLivre());
            } catch (NamingException ex) {
                System.out.println("erreur gestionLivre");
                ex.printStackTrace();
            }
        }
        
        GestionLivre gl = (GestionLivre) getServletContext().getAttribute("gestionLivre");
        
        
        if("all-book".equals(section)){
            
            try {              
                HashMap<String, List<Book>> listeBook = gl.findBook();
                List<String> clefs = gl.getClefs();
                request.setAttribute("clefs", clefs);
                request.setAttribute("listeBook", listeBook);
                page = "/WEB-INF/catalog.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        */
        
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        

        /////// DO NOT MODIFY BELOW THIS LINE ///////
        System.out.println("--------->>> page : " + page); // DEBUG : recursive calling if displayed twice
        page = response.encodeURL(page);
        getServletContext().getRequestDispatcher(page).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
