/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.thrift.async;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;

/**
 * Contains selector thread which transitions method call objects
 */
public class TAsyncClientManager {
	
	private String serviceUrl;
	
	public TAsyncClientManager(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public void call(final TAsyncMethodCall method) throws TException {
		
		String data = new String(method.getRequestData());

		RequestBuilder builder = new RequestBuilder(
		    RequestBuilder.POST,
				URL.encode(serviceUrl));
		
		builder.setHeader("Content-Type", "application/json");
		builder.setRequestData(new String(data));
		if (method.getClient().hasTimeout()) {
		  builder.setTimeoutMillis((int) method.getClient().getTimeout());
		}

		try {
			builder.sendRequest(new String(data), new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response response) {
					
					if (response != null) {
						
						switch (response.getStatusCode()) {
							case Response.SC_OK:
								method.onSuccess(response.getText());
								break;
								
							default:
								method.onError(new TTransportException("Bad HTTP status code: " + response.getStatusCode()));
								break;
						}
					}
					else {
						method.onError(new TTransportException("HTTP response is null."));
					}
				}

				@Override
				public void onError(Request request, Throwable exception) {
					method.onError(new TTransportException(exception));
				}
			});
		} catch (RequestException e) {
			method.onError(new TTransportException(e));
		}

	}

}
