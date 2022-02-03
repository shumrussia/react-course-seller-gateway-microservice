package com.sha.springbootmicroservice3apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sha.springbootmicroservice3apigateway.request.PurchaseServiceRequest;
import com.sha.springbootmicroservice3apigateway.security.UserPrincipal;

@RestController
@RequestMapping("gateway/purchase")
public class PurhaseController {
	
	@Autowired
	private PurchaseServiceRequest purchaseServiceRequest;
	
	@PostMapping
	public ResponseEntity<?> savePurchase(@RequestBody Object purchase) {
		return new ResponseEntity<>(purchaseServiceRequest.savePurchase(purchase), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPurchasesOfAUthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
		return ResponseEntity.ok(purchaseServiceRequest.getAllPurchasesOfUSer(userPrincipal.getId()));
	}
}
