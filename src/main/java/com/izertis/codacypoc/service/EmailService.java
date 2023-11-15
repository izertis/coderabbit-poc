package com.izertis.codacypoc.service;

public interface EmailService {
    /**
     * Send an email
     * @param email Email address
     * @param subject Subject of the email
     * @param body Body of the email
     * @return true if the email was sent successfully, false otherwise
     */
    boolean sendEmail(String email, String subject, String body);
}
