package gateway;

import domain.Cartracker;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Casper Doolhof on 25-2-2019.
 */
public class CartrackerAppGateway extends Gateway {

    public CartrackerAppGateway() {
        super("cartrackerSendQueue", "cartrackerRecieveQueue");
    }


    @Override
    protected void processMessage(TextMessage message, String CorrelationId) throws JMSException {

        //Cartracker cartracker = (Cartracker) message;
        Cartracker cartracker1 = new Cartracker();
        cartracker1.fillFromCommaSeperatedValue(message.getText());
    }
}
