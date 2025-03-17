package di;

class NotificationService {
//    private EmailSender emailer;
//    private SmsSender smser;
    private Sender sender;

    public NotificationService(Sender sender) {
        this.sender = sender;
    }

    public void notify(String to, String subject, String body/*, String channel*/) {
//        if (channel.equals("email")) {
//            emailer.sendEmail("", "", "");
//        } else if (channel.equals("sms")) {
//            smser.sendSms("", "");
//        } else {
//            throw new IllegalArgumentException("Invalid channel: " + channel);
//        }
        sender.send(to, subject, body);
    }
}
