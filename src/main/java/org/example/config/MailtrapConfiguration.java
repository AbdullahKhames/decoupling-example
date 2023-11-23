package org.example.config;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.io.InputStream;
import java.util.Properties;

public class MailtrapConfiguration {

    private static final String CONFIG_FILE = "mail.properties";

    public static Properties loadMailtrapProperties() {
        Properties properties = new Properties();
        try (InputStream input = MailtrapConfiguration.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
                return properties;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static Session getSession() {
        Properties properties = loadMailtrapProperties();
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        properties.getProperty("mail.smtp.user"),
                        properties.getProperty("mail.smtp.password"));
            }
        });
    }
}