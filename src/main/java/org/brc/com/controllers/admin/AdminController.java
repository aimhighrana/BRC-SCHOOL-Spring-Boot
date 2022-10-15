package org.brc.com.controllers.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.brc.com.authentication.model.User;
import org.brc.com.authentication.service.UserService;
import org.brc.com.configuration.model.City;
import org.brc.com.configuration.model.Class1;
import org.brc.com.configuration.model.Country;
import org.brc.com.configuration.service.ClassSectionsService;
import org.brc.com.configuration.service.CountryService;
import org.brc.com.transactional.model.Documents;
import org.brc.com.transactional.service.DocumentsService;
import org.brc.com.utility.FileUpload;
import org.brc.com.utility.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sandeep Rana
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ClassSectionsService classSectionsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DocumentsService documentsService;
	
	@Autowired
	private FileUpload fileUpload;
	
	@GetMapping("user-registration")
	public ModelAndView userRegistrationPage() {
		ModelAndView mav = new ModelAndView("admin/userregistration");
		mav.addObject("selectedId","user_registration");
		return mav;
	}
	
	@GetMapping("country-city")
	public ModelAndView countryCityPage() {
		ModelAndView mav = new ModelAndView("admin/country_city");
		mav.addObject("selectedId","country_city");
		return mav;
	}
	
	@GetMapping("class_sections")
	public ModelAndView classSectionPage() {
		ModelAndView mav = new ModelAndView("admin/class_sections");
		mav.addObject("selectedId","class_sections");
		return mav;
	}
	
	@PostMapping("/save-update-country")
	@ResponseBody
	public Country saveUpdateCountry(@RequestBody Country country) {
		return countryService.save(country);
	}
	
	@PostMapping("/save-update-city")
	@ResponseBody
	public City saveUpdateCity(@RequestBody City city) {
		return countryService.saveCity(city);
	}
	
	@GetMapping("/all-country")
	@ResponseBody
	public Map<String,List<Country>> allCountry() {
		Map<String,List<Country>> data = new HashMap<String, List<Country>>();
		data.put("data", countryService.findAll());
		return  data;
	}
	
	@GetMapping("/all-cities/{countryId}")
	@ResponseBody
	public Map<String,List<City>> cityByCountryId(@PathVariable String countryId) {
		Map<String,List<City>> data = new HashMap<String, List<City>>();
		data.put("data", countryService.findCitiesByCountryId(countryId));
		return  data;
	}
	
	@PostMapping("/save-update-class-sections")
	@ResponseBody
	public Class1 saveUpdateClassSections(@RequestBody Class1 class1) {
		return classSectionsService.saveUpdateClassSections(class1);
	}
	
	@GetMapping("/get-all-classes")
	@ResponseBody
	public List<Class1> getAllClassSections() {
		return classSectionsService.findAllClass1();
	}
	
	@DeleteMapping("/delete-cls-sections")
	@ResponseBody
	public boolean delete(@RequestBody Class1 class1) {
		return classSectionsService.delete(class1);
	}
	
	@GetMapping("/country/list")
	@ResponseBody
	public List<Country> allCountryIsEnable() {
		return countryService.getAllIsEnable();
	}
	
	@GetMapping("/city/{countryId}")
	@ResponseBody
	public List<City> allCityIsEnable(@PathVariable String countryId) {
		return countryService.getAllIsEnabled(countryId);
	}

	@GetMapping("/user/list/{role}")
	@ResponseBody
	public List<User> findAllUserByRole(@PathVariable String role) {
		return userService.findByRole(role);
	}
	
	@RequestMapping(value = "/upload-documents", method = {RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public Boolean uploadDocuments(@RequestParam String userName,  @ModelAttribute FileUploadHelper documents) throws FileUploadException {
		System.out.println(documents);
		documentsService.saveDocAndUploadDoc(documents, userName);

//		boolean isMultiPart =  ServletFileUpload.isMultipartContent(request);
//		if(isMultiPart) {
//			
//			FileItemFactory factory = new DiskFileItemFactory();
//			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
//			Map<String, List<FileItem>> items = servletFileUpload.parseParameterMap(request);
//			System.out.println(items);
//			
//		}
		
		return true;
	}
	
	@GetMapping("/user/list")
	@ResponseBody
	public List<User> getAllUsers(@RequestParam(required =false) String qryString) {
		return userService.findAll(qryString);
	}
	
}
