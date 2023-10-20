package com.orosift.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.orosift.userservice.Util.ResponseData;
import com.orosift.userservice.model.CategoiesColumnData;
import com.orosift.userservice.model.Categories;
import com.orosift.userservice.model.DataObject;
import com.orosift.userservice.model.Login;
import com.orosift.userservice.model.ProductColumnData;
import com.orosift.userservice.model.Products;
import com.orosift.userservice.model.SessionForToken;
import com.orosift.userservice.model.TypeData;
import com.orosift.userservice.model.User;
import com.orosift.userservice.repository.CateogeryRepository;
import com.orosift.userservice.repository.ProductRepository;
import com.orosift.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CateogeryRepository cateogeryRepository;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	// @Autowired
	// private SessionServiceImpl sessionService;

	/**
	 * @param user
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@PostMapping("/signup")
	public ResponseEntity<ResponseData> addUserDetails(@RequestBody String user)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		logger.warn("User SignUp API");
		return userService.signUp(user);
	}

	/**
	 * @param userId
	 * @param OTP
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@PostMapping("/validateotp")
	public ResponseEntity<ResponseData> validateotp(@RequestBody String user)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		logger.warn("Validating OTP for User");
		return userService.validateotp(user);
	}

	/**
	 * @param userId
	 * @param pass
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/addUserDetails")
	public ResponseEntity<ResponseData> storeUser(@RequestBody User usserObj) throws InterruptedException {
		logger.warn("Adding User details to the DB");
		return userService.storeUser(usserObj);
	}

	/**
	 * @param userId
	 * @param pass
	 * @param device
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/login")
	public ResponseEntity<ResponseData> loginUser(@RequestBody Login login) throws InterruptedException {
		logger.warn("User Login API");
		return userService.loginUser(login);
	}

	/**
	 * @param email
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/forgotPassword")
	public ResponseEntity<ResponseData> userForgetPass(@RequestBody User user) throws InterruptedException {
		logger.warn("User login crendensials forget API");
		return userService.userForgetPass(user);
	}

	/**
	 * @param email
	 * @param OTP
	 * @return
	 * @throws InterruptedException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	@PostMapping("/validateOTPForForgotPassword")
	public ResponseEntity<ResponseData> validateOTPforForgetPassword(@RequestBody String user)
			throws InterruptedException, JsonMappingException, JsonProcessingException {
		logger.warn("User OTP validating for forgot password API");
		return userService.validateOTPforForgetPassword(user);
	}

	/**
	 * @param email
	 * @param pass
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/changePassword")
	public ResponseEntity<ResponseData> changePassword(@RequestBody User user) throws InterruptedException {
		logger.warn("User password change API");
		return userService.changePassword(user);
	}

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 * @throws InterruptedException
	 */
	@PostMapping("/logout")
	public ResponseEntity<ResponseData> logout(@RequestBody SessionForToken login) throws InterruptedException {
		logger.warn("User logout API");
		return userService.logout(login);
	}

	@GetMapping("/getProducts")
	public ResponseEntity<ResponseData> getProduct() {
		List<DataObject> list = new ArrayList<DataObject>();
		List<ProductColumnData> productColumnData = new ArrayList<>();
		List<CategoiesColumnData> categoriesColumnData = new ArrayList<>();
		for (Products products : productRepository.findAll()) {
			ProductColumnData data = new ProductColumnData();
			data.setCategoryId(products.getCategoryId());
			data.setProductId(products.getProductId());
			data.setProductName(products.getProductName());
			data.setProductPrice(products.getProductPrice());
			productColumnData.add(data);
		}
		for (Categories categories : cateogeryRepository.findAll()) {
			CategoiesColumnData data = new CategoiesColumnData();
			data.setCategoryId(categories.getCategoryId());
			data.setCategoryName(categories.getCategoryName());
			categoriesColumnData.add(data);
		}
		DataObject object = new DataObject();
		object.setTYPE("Featured Products");
		object.setFeaturedProducts(productColumnData);
		DataObject object1 = new DataObject();
		object1.setTYPE("Categories");
		object1.setCategories(categoriesColumnData);
		TypeData typeData = new TypeData();
		list.add(object);
		list.add(object1);
		typeData.setData(list);
		ResponseData responseData = ResponseData.create(200, typeData);
		return ResponseEntity.ok(responseData);
	}

	@GetMapping("/getCateo")
	public ResponseEntity<ResponseData> getCaht() {
		List<Categories> findAll = cateogeryRepository.findAll();
		ResponseData responseData = ResponseData.create(200, findAll);
		return ResponseEntity.ok(responseData);
	}

//	@GetMapping("/getColumn")
//	public ResponseEntity<ResponseData> getColumn() {
//		/*
//		 * List<String> fetchColumnData = productRepository.fetchColumnData();
//		 * List<String> fetchColumnData2 = cateogeryRepository.fetchColumnData();
//		 * List<DataObject> list = new ArrayList<DataObject>(); DataObject object = new
//		 * DataObject(); object.setTYPE("Featured Products");
//		 * object.setFeaturedProduct(fetchColumnData); DataObject object1 = new
//		 * DataObject(); object1.setTYPE("Categories");
//		 * object1.setCategorie(fetchColumnData2); TypeData typeData = new TypeData();
//		 * list.add(object); list.add(object1); typeData.setData(list); ResponseData
//		 * responseData = ResponseData.create(200, typeData); return
//		 * ResponseEntity.ok(responseData);
//		 */
//		   //  List<Products> fetchColumnData = productRepository.fetchColumnData();
//		 List<Categories> fetchColumnData2 = cateogeryRepository.fetchColumnData();
//		  ResponseData responseData = ResponseData.create(200, fetchColumnData2);
//		  return ResponseEntity.ok(responseData);
//		 
//	}
}
