package co.edu.unc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping("/home")
    public ModelAndView home() {
        Usuario u = usuarioDao.visualizaUsuario();

        ModelAndView model = new ModelAndView("home");
        model.addObject("usuario", u);
        return model;
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public ModelAndView registrar(@RequestAttribute("usuario") Usuario usuario) {
        usuarioDao.save(usuario);
        return new ModelAndView("home");
    }
}
