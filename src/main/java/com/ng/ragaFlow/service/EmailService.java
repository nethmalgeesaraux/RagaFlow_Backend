package com.ng.ragaFlow.service;

public interface EmailService {

    void sendCredentialsEmail(String toEmail, String userName, String password);

    void sendWelcomeEmail(String toEmail, String userName, String password);

}
