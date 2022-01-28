package com.pershcorporation.deltacommodityservice.controller;

import com.pershcorporation.deltacommodityservice.dto.AdminData;
import com.pershcorporation.deltacommodityservice.dto.AdminDataValues;
import com.pershcorporation.deltacommodityservice.dto.SuccessResponse;
import com.pershcorporation.deltacommodityservice.dto.UserData;
import com.pershcorporation.deltacommodityservice.service.DeltaCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {
    @Autowired
    private DeltaCommodityService deltaCommodityService;

    @GetMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestHeader String username, @RequestHeader String password) throws Exception {
        deltaCommodityService.checkUsernameAndPassword(username, password);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<SuccessResponse> logoutUser() {
        SuccessResponse karthik = new SuccessResponse();
        karthik.setSuccess(true);
        return ResponseEntity.ok(karthik);
    }

    @PostMapping("/data/user")
    public ResponseEntity<UserData> saveUserdata(@RequestBody UserData body) {
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @GetMapping("/data/admin")
    public ResponseEntity<AdminData> getAdminData() {
        AdminData adminData = new AdminData();
        AdminDataValues adminDataValues1 = new AdminDataValues();
        adminDataValues1.setMarketPrice("500");
        adminDataValues1.setRegion("India");
        adminDataValues1.setTimeStamp("2002-12-20 6:30:00");
        adminDataValues1.setPurity("99%");
        adminDataValues1.setQuantity("5");
        adminDataValues1.setBuyingPrice("100");

        AdminDataValues adminDataValues2 = new AdminDataValues();
        adminDataValues2.setMarketPrice("500");
        adminDataValues2.setRegion("India");
        adminDataValues2.setTimeStamp("2002-12-20 6:30:00");
        adminDataValues2.setPurity("99%");
        adminDataValues2.setQuantity("5");
        adminDataValues2.setBuyingPrice("100");

        List<AdminDataValues> adminDataValuesList = new LinkedList<>();
        adminDataValuesList.add(adminDataValues1);
        adminDataValuesList.add(adminDataValues2);

        adminData.setData(adminDataValuesList);
        return ResponseEntity.ok(adminData);
    }
}
