package com.pershcorporation.deltacommodityservice.vo;

import com.britsa.commons.codes.ApplicationCodes;
import com.britsa.commons.codes.HTTPCodes;
import com.britsa.commons.exceptions.WebExceptionType;
import com.britsa.commons.exceptions.WebServiceException;
import com.britsa.commons.misc.FirebaseServer;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirebaseDocument {
    @Value("${firestore.database.url}")
    private String databaseUrl;
    @Value("${firestore.database.credentials}")
    private String databaseSecret;
    private Firestore firestore;

    public Firestore getDB() throws Exception {
        if (this.firestore == null)
            this.firestore = FirebaseServer.start().initialize(databaseUrl, databaseSecret);
        return this.firestore;
    }

    public <T> T retrieve(String collectionName, String documentID, Class<T> classType) throws Exception {
        DocumentSnapshot document = getDB().collection(collectionName).document(documentID).get().get();

        boolean idAvailable = document.exists();

        if (idAvailable) {
            return document.toObject(classType);
        } else {
            throw new WebServiceException(ApplicationCodes.FIREBASE_DOCUMENT_NOT_EXIST, HTTPCodes.NOT_FOUND, WebExceptionType.VALIDATION);
        }
    }
}
