package com.abhi.stack.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.stack.dao.InstanceRepository;
import com.abhi.stack.dao.UsageRepo;
import com.abhi.stack.model.InUsage;
import com.abhi.stack.model.Instance;

@RestController
public class StackController {

	@Autowired
	InstanceRepository repo;
	@Autowired
	UsageRepo usageRepo;
    
	//To go to home page
	@RequestMapping("/stack")
	public ModelAndView goToHome() {

		ModelAndView mv = new ModelAndView();
		List<Instance> instances = repo.findAll();
		mv.addObject("instances", instances);
		mv.setViewName("home.jsp");
		System.out.println(mv);
		System.out.println("Hii");
		return mv;

	}


	  //for accessing particular instance with mentioned instance name
	  @GetMapping("instances/instance") 
	  public ModelAndView getInstanceByName(HttpServletRequest request){
		  String name=request.getParameter("name"); 
		  System.out.println(name); 
		  Instance instance=repo.findById(name).orElse(null); 
		  if(instance==null)
			  return new ModelAndView("Hii.jsp");
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("instance", instance);
	  mv.setViewName("displayInstanceByName.jsp"); 
	  return mv;
	  }
	 
    
	@GetMapping("register")
	public ModelAndView showForm(Model model) {
		System.out.println("in register");
		Instance instance = new Instance();
		model.addAttribute("instance", instance);
		ModelAndView mv = new ModelAndView("addInstance.jsp");
		return mv;
	}

	
	//To add an instance
	@PostMapping(path = "instances/instance")
	public ModelAndView addInstance(@ModelAttribute("instance") Instance instance, BindingResult result,
			ModelMap model,HttpServletRequest request,HttpServletResponse response) {

		repo.save(instance);
		 ModelAndView mv = new ModelAndView("redirect:/stack", model); 
		 return mv;
		 
	}

	
	//To release an instance which is in use
	@RequestMapping(path = "releaseInstance/{name}")
	public ModelAndView releaseInstance(@PathVariable("name") String name,ModelMap model) {

		Instance instance = repo.findById(name).orElse(null);
		String state = instance.getState();
		if (state.equals("inUse")) {
			instance.setState("free");
			List<InUsage> inUsage = usageRepo.getUsages(name);
			InUsage usage = inUsage.get(0);
			usage.setEndtime(LocalDateTime.now());
			usageRepo.save(usage);
		}
			
		repo.save(instance);
		ModelAndView mv = new ModelAndView("redirect:/stack", model); 
		 return mv;
	}

	
	//To delete an instance
	@RequestMapping("instance/{name}")
	public ModelAndView deleteInstance(@PathVariable("name") String name,ModelMap model) {
		repo.deleteById(name);
		ModelAndView mv = new ModelAndView("redirect:/stack", model); 
		 return mv;
	}

    //To get the history of usages of particular instance
	@GetMapping("usage/{name}")
	public ModelAndView getUsages(@PathVariable("name") String name) {

		Pageable firstPageWithTenProducts = PageRequest.of(0, 10, Sort.by("id").descending());
		List<InUsage> usages = usageRepo.findAllByinstancename(name, firstPageWithTenProducts);
		ModelAndView mv = new ModelAndView();
		mv.addObject("usages", usages);
		mv.setViewName("Usages.jsp");
		return mv;

	}

	
	//To view the state of the instance,user and purpose
	@GetMapping("instanceState/{name}")
	public ModelAndView instanceState(@PathVariable("name") String name) {

		Instance instance = repo.findById(name).orElse(null);
		String state = instance.getState();
		InUsage usage = new InUsage();
		if (state.equals("free")) {
			usage.setInstanceName(name);
			usage.setUser("");
			usage.setPurpose("");
		} else {
			System.out.println(name);
			List<InUsage> inUsage = usageRepo.getUsages(name);
			for (InUsage inusage : inUsage) {
				System.out.println(inusage);
			}
			usage = inUsage.get(0);
			System.out.println(usage);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("usage", usage);
		mv.setViewName("viewInstance.jsp");
		return mv;

	}

    //when clicked on update, the current state of the instance with usage details will be retrieved and
	//redirected to the updateInstance web page with the details.
	@GetMapping("/update/{name}")
	public ModelAndView showUpdateForm(@PathVariable("name") String name, Model model) {
		Instance instance = repo.findById(name).orElse(null);
		String state = instance.getState();
		InUsage usage = new InUsage();
		if (state.equals("free")) {
			usage.setInstanceName(name);
			usage.setUser("");
			usage.setPurpose("");
		} else {
			System.out.println(name);
			List<InUsage> inUsage = usageRepo.getUsages(name);
			for (InUsage inusage : inUsage) {
				System.out.println(inusage);
			}
			usage = inUsage.get(0);
			System.out.println(usage);
		}

		InUsage inusage = new InUsage();
		inusage.setInstanceName(name);
		inusage.setPurpose(usage.getPurpose());
		inusage.setUser(usage.getUser());
		model.addAttribute("inusage", inusage);
		ModelAndView mv = new ModelAndView("updateInstance.jsp");
		return mv;
	}

	
	//To update the details of instance usage
	@PostMapping("usage")
	public ModelAndView updateInstance(@ModelAttribute("inusage") InUsage inusage, BindingResult result,
			ModelMap model) {

		System.out.println("in add Instance");
		LocalDateTime myDateObj = LocalDateTime.now();
	    System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	    System.out.println("After formatting: " + formattedDate);
	    inusage.setStarttime(myDateObj);
		System.out.println(inusage);
		usageRepo.save(inusage);
		Instance instance = repo.findById(inusage.getInstanceName()).orElse(null);
		instance.setState("inUse");
		repo.save(instance);
		ModelAndView mv = new ModelAndView("redirect:/stack", model); 
		 return mv;	}

		
}
