package com.will1184.cursospring.controller;

import com.will1184.cursospring.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cursosspring")
public class IndexController {
    @Value("Hola Spring Framework Con model desde Properties!")
    private  String textoIndex;
    @Value("Perfil del usuario")
    private String textoPerfil;
    @Value("Listado de usuario desde textos.properties")
    private String textoListar;

    @GetMapping({"index","/","home"})
    public String index(Model model){
        model.addAttribute("titulo","Spring Framework");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Brandon");
        usuario.setApellido("Gomez");
        usuario.setEmail("Brandon@correo.com");

        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }
    @RequestMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo",textoListar);
        return "listar";
    }
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Brandon","Gomez","emai@email.com"),
                new Usuario("John","Doe","johnemail@email.com"),
                new Usuario("Jane","Doe","janeemail@email.com"),
        new Usuario("Tornado","Roe","roeemail@email.com")
        );
        return usuarios;
    }
}
