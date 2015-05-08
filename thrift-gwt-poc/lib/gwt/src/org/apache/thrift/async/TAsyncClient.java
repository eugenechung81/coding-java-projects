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

import org.apache.thrift.protocol.TProtocolFactory;

public abstract class TAsyncClient {
  protected final TProtocolFactory ___protocolFactory;
  protected final TAsyncClientManager ___manager;
  private long ___timeout;

  public TAsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager manager) {
    this(protocolFactory, manager, 0);
  }

  public TAsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager manager, long timeout) {
    this.___protocolFactory = protocolFactory;
    this.___manager = manager;
    this.___timeout = timeout;
  }

  public TProtocolFactory getProtocolFactory() {
    return ___protocolFactory;
  }

  public long getTimeout() {
    return ___timeout;
  }

  public boolean hasTimeout() {
    return ___timeout > 0;
  }

  public void setTimeout(long timeout) {
    this.___timeout = timeout;
  }

}
