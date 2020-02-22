package com.wanchopi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wanchopi.models.Player;
import com.wanchopi.repositories.PlayerRepository;
import com.wanchopi.repositories.TeamRepository;

/**
 * Main controller
 * 
 * @author Wanchopi
 *
 */
@Controller
public class AppController {
	
	@Autowired 
	private TeamRepository teamRepository;
	@Autowired 
	private PlayerRepository playerRepository;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@RequestMapping(value = "/")
	public String home(ModelMap mp) {
		mp.put("players", playerRepository.findAll());
		return "index";
	}

	@GetMapping(value = "/create")
	public String showForm(ModelMap mp) {
		mp.put("player", new Player());
		mp.put("teams", teamRepository.findAll());
		return "player-form";
	}
	
	@PostMapping(value = "/save")
	public String save(@Valid Player player, BindingResult br , ModelMap mp) {
		if (br.hasErrors()) {
			mp.put("teams", teamRepository.findAll());
			return "player-form";		
		} else {
			playerRepository.save(player);
			mp.put("players", playerRepository.findAll());
			return "redirect:/";
		}	
	}
	
	@GetMapping(value = "/edit/{id}")
	public String showEditForm(@PathVariable("id") long id, ModelMap mp) {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		mp.put("player", player);
		mp.put("teams", teamRepository.findAll());
		return "/update-form";
	}
	
	@PostMapping(value = "/update")
	public String update(@Valid Player player, BindingResult br , ModelMap mp) {
		if (br.hasErrors()) {
			mp.put("teams", teamRepository.findAll());
			return "/update-form";
		} else {
			playerRepository.save(player);
			mp.put("players", playerRepository.findAll());
			return "redirect:/";
		}
	}	
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") long id, ModelMap mp) {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		playerRepository.delete(player);
		mp.put("players", playerRepository.findAll());
		return "redirect:/";
	}

}
