package com.example.projet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.model.Administrateur;
import com.example.projet.model.Affectation;
import com.example.projet.model.ShaUn;
import com.example.projet.model.SignalementDetail;
import com.example.projet.model.StatStatusSignalRegions;
import com.example.projet.model.StatTypeSignalRegions;

import com.example.projet.repository.AdministrateurRepository;
import com.example.projet.repository.AffectionInsertRepository;
import com.example.projet.repository.DetailSignalRepository;
import com.example.projet.repository.RegionRepository;
import com.example.projet.repository.SignalementRepository;
import com.example.projet.repository.StatStatusSignalRegionsRepository;
import com.example.projet.repository.StatTypeSignalRegionsRepository;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Time;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/Administrateur")
public class AdministrateurController {

	@Autowired
	private AdministrateurRepository adRep;

	@Autowired
	private SignalementRepository signRep;

	@Autowired
	private DetailSignalRepository detailRep;

	@Autowired
	private RegionRepository regionRep;

	@Autowired
	private AffectionInsertRepository affectRep;

	@Autowired
	private StatTypeSignalRegionsRepository statRegionsTypeRep;

	@Autowired
	private StatStatusSignalRegionsRepository statRegionsStatusRep;
	
	
	

	@RequestMapping("/")
	public String formLogin(Model model) {
		// model.addAttribute("listAdmin", adRep.findAll());
		return "loginAdmin";
	}
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
		// model.addAttribute("listAdmin", adRep.findAll());
		session.invalidate();
		return "loginAdmin";
	}

	@RequestMapping("/listeSignalement")
	public String detailSignal(Model model, HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
			model.addAttribute("listedetail", detailRep.findAll());
			return "indexAdmin";
		} else {
			return "404";
		}
	}

	@RequestMapping("/loginAdmin")
	// @ResponseBody
	public String verifLogin(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "mdp") String mdp, HttpSession session) {
		List<Administrateur> l = adRep.findAll();
		model.addAttribute("listedetail", detailRep.findAll());
		ShaUn sha1 = new ShaUn();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getUsername().equalsIgnoreCase(username) == true
					&& l.get(i).getMotdepasse().equalsIgnoreCase(sha1.getShaUn(mdp)) == true) {
				session.setAttribute("identifiant", username);
				return "indexAdmin";
			}

		}
		model.addAttribute("erreur", "erreur");
		return "loginAdmin";
	}

	@RequestMapping("/listeRegion")
	public String listeRegion(Model model, HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
			model.addAttribute("listeregion", regionRep.getListeRegion());
			return "listeTouteRegion";
		} else {
			return "404";
		}
	}

	@RequestMapping("/listeRegionStat")
	public String listeRegionStat(Model model, HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
			model.addAttribute("listeregion", regionRep.getListeRegion());
			return "listeRegionStat";
		} else {
			return "404";
		}
	}

	@RequestMapping("/listeRegion1")
	public String listeRegion1(Model model, @RequestParam(name = "idSignalement") int idSignalement,
			HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
			model.addAttribute("idsignalement", idSignalement);
			model.addAttribute("listeregion", regionRep.getListeRegion());
			return "listeRegion";
		} else {
			return "404";
		}
	}

	@RequestMapping("/affecter")
	public String affectationRegion(Model model, @RequestParam(name = "idSignalement") int idSignalement,
			@RequestParam(name = "idRegion") int idRegion) {
		long millis = System.currentTimeMillis();
		java.sql.Date dateAffectation = new java.sql.Date(millis);

		long now = System.currentTimeMillis();
		Time heureAffectation = new Time(now);
		int idStatusSignalement = 1;

		// Affectation affect = new Affectation(idSignalement, idStatusSignalement,
		// dateAffectation, heureAffectation);
		// affectRep.insertWithQuery(affect);
		signRep.updateSignalementAffectation(idSignalement, idRegion);
		model.addAttribute("listedetail", detailRep.findAll());
		model.addAttribute("reussie", "affectation reussie");
		// return "redirect:/indexAdmin.html";
		return "indexAdmin";
	}

	@RequestMapping("/supprimer")
	public String supprimer(Model model, @RequestParam(name = "idSignalement") int idSignalement, HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
			long id = idSignalement;
			signRep.deleteById(id);
			model.addAttribute("listedetail", detailRep.findAll());
			// signRep.deleteSignalementAffectation(idSignalement);
			model.addAttribute("suppr", "suppression reussie");
			return "indexAdmin";
		} else {
			return "404";
		}
	}
	@RequestMapping("/fiche")
	public String fiche(Model model, @RequestParam(name = "idSignalement") int idSignalement, HttpSession session) {
		if (session.getAttribute("identifiant") != null) {
		model.addAttribute("listedetail", detailRep.getFicheSignal(idSignalement));
		System.out.println("fiche  "+detailRep.getFicheSignal(idSignalement).get(0).getDescriptionsignal());
		return "ficheSignal";
		} else {
			return "404";
		}
	}
	
	@RequestMapping("/statTypeRegionsGlobal")
	public String statTypesRegion(Model model) {
		Map<String, Integer> graphData = new TreeMap<>();
		
		List<StatTypeSignalRegions> lista = statRegionsTypeRep.statTypeRegions();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("type " + lista.get(i).getNomTypeSignalement() + " nbr " + lista.get(i).getNbr());
			 graphData.put(lista.get(i).getNomTypeSignalement(), lista.get(i).getNbr());
		}
		model.addAttribute("chartData", graphData);

		//model.addAttribute("statRegions", lista);
		return "statGlobalType";
	}

	@RequestMapping("/statStatusRegionsGlobal")
	public String statStatusRegion(Model model) {
		Map<String, Integer> graphData = new TreeMap<>();
		
		List<StatStatusSignalRegions> lista = statRegionsStatusRep.findAll();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("statut " + lista.get(i).getStatussignal() + " nbr " + lista.get(i).getNbr());
			 graphData.put(lista.get(i).getStatussignal(), lista.get(i).getNbr());
		}
		

		model.addAttribute("chartData", graphData);
		//model.addAttribute("statRegionsStatus", lista);
		return "StatGlobalStatus";
	}
	
	
}
