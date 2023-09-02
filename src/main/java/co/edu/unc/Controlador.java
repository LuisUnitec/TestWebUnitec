package co.edu.unc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping("/home")
    public ModelAndView home() {
        List<Usuario> listaUsuarios = usuarioDao.findAll();

        ModelAndView model = new ModelAndView("home");
        model.addObject("listaUsuarios", listaUsuarios);
        return model;
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("datosUsuario") Usuario usuario) {
        usuarioDao.save(usuario);
        return new ModelAndView("home");
    }
}
