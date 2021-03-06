import clients.SymBotClient;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsBot {
    private static final Logger log = LoggerFactory.getLogger(ElementsBot.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        try {
            SymBotClient botClient = SymBotClient.initBot("config.json");

            botClient.getDatafeedEventsService().addListeners(
                new IMListenerImpl(botClient),
                new ElementsListenerImpl(botClient)
            );
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}
