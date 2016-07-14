package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Valida
 */
public class Valida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(Valida.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valida() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user;		//usuario
        String userReceived;//usuario que ingreso el cliente
        String pass;		//contraseña
        String passReceived;//contraseña que ingreso el cliente
        user="alfredo";		//Se define el nombre del usuario
        pass="password";	//Se define la contraseña
        userReceived=request.getParameter("user");	//Se reciben los valores de la solicitud
        passReceived=request.getParameter("pass");
        
        if(userReceived.equals(user) && passReceived.equals(pass)){
            log.info("Info : El Usuario= "+userReceived+" accedio correctamente");
            request.getRequestDispatcher("accesocorrecto.jsp").forward(request, response); //Redirecciona a la pagina de acceso correcto
        }else{
            log.warn("Warning : El usuario="+userReceived+" intento acceder sin exito");
            request.getRequestDispatcher("error.jsp").forward(request, response); //Redirecciona a la pagina de error
        }
	}

}
