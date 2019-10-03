package springxml.services;

public class DataVerificationFailed implements DataVerification {
    @Override
    public String sendNotification() {
        return "This data is outdated!";
    }
}
