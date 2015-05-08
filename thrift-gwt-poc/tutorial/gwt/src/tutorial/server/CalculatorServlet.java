package tutorial.server;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServlet;

import tutorial.shared.Calculator;

@SuppressWarnings("serial")
public class CalculatorServlet extends TServlet {

	public CalculatorServlet() {
		super(new Calculator.Processor<CalculatorHandler>(new CalculatorHandler()), new TJSONProtocol.Factory());
	}
	
}
