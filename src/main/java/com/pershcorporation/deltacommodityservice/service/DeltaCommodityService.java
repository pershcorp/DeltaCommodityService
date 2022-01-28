package com.pershcorporation.deltacommodityservice.service;

import com.pershcorporation.deltacommodityservice.dto.AuthInfo;
import com.pershcorporation.deltacommodityservice.vo.FirebaseDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeltaCommodityService {
    @Autowired
    private FirebaseDocument firebaseDocument;

    public void checkUsernameAndPassword(String username, String password) throws Exception {
        AuthInfo authInfo = firebaseDocument.retrieve("Auth", username, AuthInfo.class);
        if (!(authInfo.getUsername().equals(username) && authInfo.getPassword().equals(password))) {
            throw new Exception("Invalid username and password");
        }
    }
}
