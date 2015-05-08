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
package org.apache.thrift.transport;



/*
 * Only used to wrap a string
 */
public final class TMemoryInputTransport extends TTransport {

  private String buffer;
  
  public TMemoryInputTransport(String data) {
    this.buffer = data;
  }

  @Override
  public void close() {
    // Do Nothing
  }

  @Override
  public boolean isOpen() {
    return true;
  }

  @Override
  public void open() throws TTransportException {
    // Do Nothing
  }

  @Override
  public int read(byte[] buf, int off, int len) throws TTransportException {
    throw new UnsupportedOperationException("No reading allowed!");
  }

  @Override
  public void write(byte[] buf, int off, int len) throws TTransportException {
    throw new UnsupportedOperationException("No writing allowed!");
  }

  @Override
  public String getBuffer() {
    return buffer;
  }

}
