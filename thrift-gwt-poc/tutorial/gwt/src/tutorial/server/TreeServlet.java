package tutorial.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TreeServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
	{
		// response.setContentType("application/json");
		// PrintWriter out = response.getWriter();
		// out.print("{\"children\": [{\"children\": null, \"name\": \"TEST 12\"}, {\"children\": null, \"name\": \"TEST 23\"}], \"name\": \"SECURITY (SECURITIES)LAUREATE EDUCATION INC BOND 20190901\"}");
		// out.flush();

		// response.sendRedirect("http://127.0.0.1:8888/getTree");

		// redirectCall(response);

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		// out.print("[\"ActionScript\", \"AppleScript\", \"Asp\", \"BASIC\", \"C\", \"C++\", \"Clojure\", \"COBOL\", \"ColdFusion\", \"Erlang\", \"Fortran\", \"Groovy\", \"Haskell\", \"Java\", \"JavaScript\", \"Lisp\", \"Perl\", \"PHP\", \"Python\", \"Ruby\", \"Scala\", \"Scheme\"]");
		out.print("[{\"name\": \"ActionScript\", \"value\": \"ActionScript\"}, {\"name\": \"AppleScript\", \"value\": \"AppleScript\"}]");
		out.flush();
	}

	private void redirectCall(HttpServletResponse response) throws MalformedURLException, IOException, ProtocolException
	{
		String url = "http://127.0.0.1:8888/getTree";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response1 = new StringBuffer();

		ServletOutputStream sout = response.getOutputStream();

		while ((inputLine = in.readLine()) != null)
		{
			response1.append(inputLine);
			sout.write(inputLine.getBytes());
		}
		in.close();

		sout.flush();
	}
}
