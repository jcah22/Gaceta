package com.jcah.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jcah.models.entity.Area;
import com.jcah.models.entity.Usuario;
import com.jcah.models.service.IAreaService;
import com.jcah.models.service.IUsuarioService;

@Controller
public class IndexController {

	Date date = new Date();
	Calendar calendar = Calendar.getInstance();

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IAreaService areaService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("titulo", "- Home villalpando -");
		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);
		return "index";
	}

	@GetMapping("/nosotros")
	public String nosotros(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		model.addAttribute("titulo", "- Nosotros -");

		return "nosotros";
	}

	@GetMapping("/directorio")
	public String directorio(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		List<Usuario> listadoUsuarios = usuarioService.listarTodos();
		model.addAttribute("titulo", "- Directorio de Usuarios -");
		model.addAttribute("usuarios", listadoUsuarios);

		return "directorio";
	}

	@GetMapping("/premio")
	public String premio(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		model.addAttribute("titulo", "- Premio Semanal -");

		return "premio";
	}

	@GetMapping("/cumple")
	public String cumple(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		return "cumple";
	}

	@GetMapping("/aniversarios")
	public String aniversarios(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		return "aniversarios";

	}

	@GetMapping("/listar")
	public String listar(Model model) {

		calendar.setTime(date);
		int dateYear = calendar.get(Calendar.YEAR);

		model.addAttribute("fecha", dateYear);

		List<Usuario> listardoUsuarios = usuarioService.listarTodos();
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", listardoUsuarios);

		return "listar";

	}

	@GetMapping("/crear")
	public String crear(Model model) {

		Usuario usuario = new Usuario();
		List<Area> listareas = areaService.listaAreas();

		model.addAttribute("titulo", " Nuevo Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("areas", listareas);
		return "nuevo";
	}

	@PostMapping("/save")
	public String guardar(@RequestParam(name = "file", required = false) MultipartFile foto,
			@ModelAttribute Usuario usuario, RedirectAttributes flash) {

		if (!foto.isEmpty()) {

			String ruta = "C://Temp//uploads";

			try {

				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				usuario.setFoto(foto.getOriginalFilename());

			} catch (Exception e) {
				// TODO: handle exception
			}

			usuarioService.guardar(usuario);
			System.out.println("Usuario Guardado con Exito");
			flash.addFlashAttribute("success", "Foto subida!!");
		}

		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idUsuario, Model model) {

		Usuario usuario = usuarioService.buscarPorId(idUsuario);

		List<Area> listareas = areaService.listaAreas();

		model.addAttribute("titulo", "Editar Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("areas", listareas);
		return "/nuevo";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idUsuario) {

		usuarioService.eliminar(idUsuario);
		System.out.println("Registro Eliminado con Exito.");
		return "redirect:/listar";
	}

}
