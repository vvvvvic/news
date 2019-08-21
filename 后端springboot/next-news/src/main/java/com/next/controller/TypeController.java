package com.next.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.pojo.Type;
import com.next.service.AllInOneService;
import com.next.utils.NEXTJSONResult;

@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private AllInOneService allInOneService;
	
	@GetMapping("/all")
	@ResponseBody
	public NEXTJSONResult all() {
		List<Type> allTypes = allInOneService.queryAllTypes();
		return NEXTJSONResult.ok(allTypes);
	}
	
}
