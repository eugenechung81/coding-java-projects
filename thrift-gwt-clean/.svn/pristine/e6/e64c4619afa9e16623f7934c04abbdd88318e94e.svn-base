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
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TMemoryBuffer;

/**
 * Encapsulates an async method call Need to generate: - private void
 * write_args(TProtocol protocol) - public T getResult() throws <Exception_1>,
 * <Exception_2>, ...
 * 
 * @param <T>
 */
public abstract class TAsyncMethodCall<T> {

	public static enum State {
		CONNECTING, WRITING_REQUEST_SIZE, WRITING_REQUEST_BODY, READING_RESPONSE_SIZE, READING_RESPONSE_BODY, RESPONSE_READ, ERROR;
	}

	/**
	 * Next step in the call, initialized by start()
	 */
	private State state = null;

	private final TProtocolFactory protocolFactory;
	protected final TAsyncClient client;
	private final AsyncMethodCallback<T> callback;

	private String responseText;

	protected TAsyncMethodCall(TAsyncClient client,
			TProtocolFactory protocolFactory,
			AsyncMethodCallback<T> callback, boolean isOneway) {
		
		this.callback = callback;
		this.protocolFactory = protocolFactory;
		this.client = client;
	}

	protected State getState() {
		return state;
	}

	protected boolean isFinished() {
		return state == State.RESPONSE_READ;
	}

	public TAsyncClient getClient() {
		return client;
	}

	public boolean hasTimeout() {
		return client.hasTimeout();
	}

	protected abstract void write_args(TProtocol protocol) throws TException;
	
	protected byte[] getRequestData() throws TException {
	  
	  TMemoryBuffer memoryBuffer = new TMemoryBuffer();
    TProtocol protocol = protocolFactory.getProtocol(memoryBuffer);
    
    write_args(protocol);
	  
		return memoryBuffer.getTrimmedArray();
	}
	
	protected void onError(Exception e) {
		callback.onError(e);
		state = State.ERROR;
	}

	protected void onSuccess(String responseText) {
		this.responseText = responseText;
		
		state = State.RESPONSE_READ;
		callback.onComplete((T) this);		
	}

	protected String getResponseText() {
		return responseText;
	}
	
}
