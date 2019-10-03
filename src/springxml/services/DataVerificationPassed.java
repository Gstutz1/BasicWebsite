package springxml.services;

public class DataVerificationPassed implements DataVerification {
    @Override
    public String sendNotification() {
        return "Data is up to date!";
    }
}
