package com.filme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.filme.model.Filme;
import com.filme.repository.FilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmeRepository filmeR;
	
	@RequestMapping(value="/cadastrarfilme", method=RequestMethod.GET)
	public String form() {
		return "filmes/formFilme";
	}
	
	@RequestMapping(value="/cadastrarfilme", method=RequestMethod.POST)
	public String form(Filme filme) {
		
		filmeR.save(filme);
		
		return "redirect:/cadastrarfilme";
	}
	
	@RequestMapping("/filmes")
	public ModelAndView listaFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filme> filme = filmeR.findAll();
		mv.addObject("filmes", filme);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesFilme(@PathVariable("codigo") long codigo) {
		
		Filme filme = filmeR.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("filmes/detalhesFilme");
		mv.addObject("filme", filme);
		return mv;
		
		
		
	}
	

}
