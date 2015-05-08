package tutorial.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TNativeJSONProtocol;

import tutorial.shared.Calculator;
import tutorial.shared.Calculator.AsyncClient.add_call;
import tutorial.shared.Calculator.AsyncClient.calculate_call;
import tutorial.shared.Calculator.AsyncClient.ping_call;
import tutorial.shared.InvalidOperation;
import tutorial.shared.Operation;
import tutorial.shared.Work;
import tutorial.shared.shared.SharedService;
import tutorial.shared.shared.SharedStruct;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tutorial implements EntryPoint {

	private static final Logger LOGGER = Logger.getLogger(Tutorial.class.getName());
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		final Button performButton = new Button("Send");
		RootPanel.get("container").add(performButton);

		
		class MyHandler implements ClickHandler {
			
			public void onClick(ClickEvent event) {
				
				Calculator.AsyncClient client = new Calculator.AsyncClient(
						new TNativeJSONProtocol.Factory(),
						new TAsyncClientManager("/calculator")); 
				
				try {
					perform(client);
				} catch (TException e) {
					LOGGER.log(Level.SEVERE, "Cannot perform the operations.", e);
				}
				
			}

		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		performButton.addClickHandler(handler);
	}
	
	private static void perform(Calculator.AsyncClient client) throws TException {
		
		client.ping(new AsyncMethodCallback<Calculator.AsyncClient.ping_call>() {
			
			@Override
			public void onComplete(ping_call response) {
				LOGGER.info("ping()");
			}
			
			@Override
			public void onError(Exception e) { 
				LOGGER.log(Level.SEVERE, "Request failed.", e);
			}
			
		});
		

		client.add(1, 1, new AsyncMethodCallback<Calculator.AsyncClient.add_call>() {

			@Override
			public void onComplete(add_call response) {
				
				try {
					int sum = response.getResult();
					LOGGER.info("1+1=" + sum);
				} catch (TException e) {
					LOGGER.log(Level.SEVERE, "Cannot read the result.", e);
				}
				
			}

			@Override
			public void onError(Exception e) {
				LOGGER.log(Level.SEVERE, "Request failed.", e);
			}
			
		});
		
		Work work = new Work();

		work.op = Operation.DIVIDE;
		work.num1 = 1;
		work.num2 = 0;
		
		client.calculate(1, work, new AsyncMethodCallback<Calculator.AsyncClient.calculate_call>() {

			@Override
			public void onComplete(calculate_call response) {
				try {
					int quotient = response.getResult();
					LOGGER.info("Whoa we can divide by 0");
				} catch (InvalidOperation io) {
					LOGGER.info("Invalid operation: " + io.why);
				} catch (TException e) {
					LOGGER.log(Level.SEVERE, "Cannot read the result.", e);
				}
			}

			@Override
			public void onError(Exception e) {
				LOGGER.log(Level.SEVERE, "Request failed.", e);
			}
			
		});

		work.op = Operation.SUBTRACT;
		work.num1 = 15;
		work.num2 = 10;

		client.calculate(1, work, new AsyncMethodCallback<Calculator.AsyncClient.calculate_call>() {

			@Override
			public void onComplete(calculate_call response) {
				
				try {
					int diff = response.getResult();
					LOGGER.info("15-10=" + diff);
				} catch (InvalidOperation io) {
					LOGGER.info("Invalid operation: " + io.why);
				} catch (TException e) {
					LOGGER.log(Level.SEVERE, "Cannot read the result.", e);
				}
				
			}

			@Override
			public void onError(Exception e) {
				LOGGER.log(Level.SEVERE, "Request failed.", e);
			}
			
		});

		client.getStruct(1, new AsyncMethodCallback<SharedService.AsyncClient.getStruct_call>() {

			@Override
			public void onComplete(SharedService.AsyncClient.getStruct_call response) {
				
				try {
					SharedStruct log = response.getResult();
					LOGGER.info("Check log: " + log.value);
				} catch (TException e) {
					LOGGER.log(Level.SEVERE, "Cannot read the result.", e);
				}
				
			}

			@Override
			public void onError(Exception e) { 
				LOGGER.log(Level.SEVERE, "Request failed.", e);
			}
			
		});
		
	}
}
