package com.sarva.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sarva.bind.AgeBinder;
import com.sarva.dto.Along;
import com.sarva.dto.Place;

@Controller()
public class MvcController {

	@Autowired
	public MessageSource source;

	@InitBinder
	public void customeBinding(WebDataBinder bind) {
		// to disalow a value to be binded at the runtime you provide this.
		// bind.setDisallowedFields("place.age");
		bind.registerCustomEditor(String.class, "along.age", new AgeBinder());
	}

	@RequestMapping(value = "/simple", method = RequestMethod.GET)
	public ModelAndView getSimple() {
		ModelAndView model = new ModelAndView();
		model.setViewName("simple");
		model.addObject("value", "Sarva1");
		return model;
	}

	@RequestMapping(value = "/simple1", method = RequestMethod.GET)
	public ModelAndView getSimple1() {
		ModelAndView model = new ModelAndView();
		model.setViewName("simple");
		model.addObject("value", "Sarva2");
		return model;
	}

	@RequestMapping(value = "/simple/{name}/{miss}", method = RequestMethod.GET)
	public ModelAndView getPathVars(@PathVariable Map<String, String> pathvar) {
		String who = pathvar.get("name");
		String miss = pathvar.get("miss");
		ModelAndView model = new ModelAndView();
		model.setViewName("other");
		model.addObject("who", who);
		model.addObject("miss", miss);
		return model;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView queryParam(@RequestParam("par") String par) {
		ModelAndView model = new ModelAndView();
		model.addObject("par", par);
		model.setViewName("singleQuery");
		return model;
	}

	@RequestMapping(value = "/queryMulti", method = RequestMethod.GET)
	public ModelAndView queryParamMulti(@RequestParam Map<String, String> par) {
		ModelAndView model = new ModelAndView();
		String query1 = par.get("name");
		String query2 = par.get("size");
		model.addObject("query1", query1);
		model.addObject("query2", query2);
		model.setViewName("singleQuery");
		return model;
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/formSubmit", method = RequestMethod.POST)
	public ModelAndView formSubmit(@RequestParam Map<String, String> param) {
		String where = param.get("where");
		String why = param.get("why");
		ModelAndView model = new ModelAndView("success");
		model.addObject("where", where);
		model.addObject("why", why);
		return model;
	}

	@RequestMapping(value = "/formSubmitObject", method = RequestMethod.POST)
	public ModelAndView formSubmitObject(@ModelAttribute("place") Place place) {
		if (place.getWhere().equalsIgnoreCase("manchester")) {
			place.setCustom("Thats a fucked up place mate!!!!");
		}
		ModelAndView model = new ModelAndView("success");
		return model;
	}

	@RequestMapping(value = "/formDiff", method = RequestMethod.POST)
	public ModelAndView formSubmitDiff(@ModelAttribute("place") Place place) {
		if (place.getWhere().equalsIgnoreCase("manchester")) {
			place.setCustom("Thats a fucked up place mate!!!!");
		}
		ModelAndView model = new ModelAndView("mixes");
		return model;
	}

	@RequestMapping(value = "/formDiffModel", method = RequestMethod.POST)
	public ModelAndView formSubmitDiffModel(@ModelAttribute("place") @Valid Place place, BindingResult result,
			@Valid @ModelAttribute("along") Along along, BindingResult result1, HttpSession session) {
		System.err.println("The value in the session is --->" + session.getAttribute("some"));
		String can = source.getMessage("NotEmpty.place.why", new Object[] { "something" }, new Locale("EN", "IN"));
		System.err.println("the which came here Is ------>" + can);
		// @Valid @ModelAttribute("along") Along along, BindingResult result1) {
		if (result.hasErrors()) {
			ObjectError obj = result.getGlobalError();
			System.err.println("The value of field one" + obj);
			Object oo = result.getTarget();
			List<ObjectError> err = result.getAllErrors();
			for (ObjectError ee : err) {
				System.err.println("ee.getDefaultMessage()" + " " + ee.getDefaultMessage());
				System.err.println("ee.getObjectName()" + " " + ee.getObjectName());
				System.err.println("ee.getArguments()" + " " + ee.getArguments());
				for (Object ss : ee.getArguments()) {
					System.err.println("ee.getArguments()" + " " + ss);
				}
				for (Object ss : ee.getCodes()) {
					System.err.println("ee.getCodes()" + " " + ss);
				}
				System.err.println();
				System.err.println("ee.getCodes()" + " " + ee.getCodes());
				System.err.println("ee.getCode()" + " " + ee.getCode());
			}
			System.err.println("The value of field two" + oo);
			System.err.println("Adding custom Error.");
			result.addError(new ObjectError("Sarva", "This is how you add an extra error to it."));
			Map<String, Object> map = result.getModel();
			Iterator<String> itr = map.keySet().iterator();
			while (itr.hasNext()) {
				Object tt = itr.next();
				System.err.println("Key is---->" + tt + "   And the Value is    ---->" + map.get(tt));
				System.out.println("");
			}
			ModelAndView model = new ModelAndView("errorView");
			return model;
		}
		/*
		 * if (result1.hasErrors()) { partAlong(along, result1); }
		 */
		if (place.getWhere().equalsIgnoreCase("manchester")) {
			place.setCustom("Thats a fucked up place mate!!!!");
		}
		ModelAndView model = new ModelAndView("success");
		return model;
	}

	public ModelAndView partAlong(Along along, BindingResult result) {
		ModelAndView model = new ModelAndView("errorViewAlong");
		if (result.hasErrors()) {
			ObjectError obj = result.getGlobalError();
			System.err.println("The value of field one" + obj);
			Object oo = result.getTarget();
			List<ObjectError> err = result.getAllErrors();
			for (ObjectError ee : err) {
				System.err.println("ee.getDefaultMessage()" + " " + ee.getDefaultMessage());
				System.err.println("ee.getObjectName()" + " " + ee.getObjectName());
				System.err.println("ee.getArguments()" + " " + ee.getArguments());
				for (Object ss : ee.getArguments()) {
					System.err.println("ee.getArguments()" + " " + ss);
				}
				for (Object ss : ee.getCodes()) {
					System.err.println("ee.getCodes()" + " " + ss);
				}
				System.err.println();
				System.err.println("ee.getCodes()" + " " + ee.getCodes());
				System.err.println("ee.getCode()" + " " + ee.getCode());
			}
			System.err.println("The value of field two" + oo);
			System.err.println("Adding custom Error.");
			result.addError(new ObjectError("Sarva", "This is how you add an extra error to it."));
			Map<String, Object> map = result.getModel();
			Iterator<String> itr = map.keySet().iterator();
			while (itr.hasNext()) {
				Object tt = itr.next();
				System.err.println("Key is---->" + tt + "   And the Value is    ---->" + map.get(tt));
				System.out.println("");
			}
			return model;
		}
		return model;
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ModelAndView catchException(Exception ex) {
		ModelAndView model = new ModelAndView("errorMethod");
		model.addObject("errorMessage", ex.getMessage());
		model.addObject("classs", ex.getClass());
		model.addObject("cause", ex.getCause());
		model.addObject("stackTrace", ex.getStackTrace().toString());
		model.addObject("exception", ex);
		return model;
	}

}
