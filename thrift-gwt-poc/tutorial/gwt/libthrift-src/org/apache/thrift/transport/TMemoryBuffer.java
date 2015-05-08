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

import org.apache.thrift.TByteArrayOutputStream;

/**
 * Memory buffer-based implementation of the TTransport interface.
 */
public class TMemoryBuffer extends TTransport {
  
  private static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
  
  public TMemoryBuffer() {
    this(DEFAULT_INITIAL_BUFFER_SIZE);
  }
  
  /**
   * Create a TMemoryBuffer with an initial buffer size of <i>size</i>. The
   * internal buffer will grow as necessary to accomodate the size of the data
   * being written to it.
   */
  public TMemoryBuffer(int size) {
    arr_ = new TByteArrayOutputStream(size);
  }

  @Override
  public boolean isOpen() {
    return true;
  }

  @Override
  public void open() {
    /* Do nothing */
  }

  @Override
  public void close() {
    /* Do nothing */
  }

  @Override
  public int read(byte[] buf, int off, int len) {
    throw new UnsupportedOperationException("This transport is not readable. Use getArray() instead. ");
  }

  @Override
  public void write(byte[] buf, int off, int len) {
    arr_.write(buf, off, len);
  }

  // The contents of the buffer
  private TByteArrayOutputStream arr_;

  public int length() {
    return arr_.size();
  }

  public byte[] getArray() {
    return arr_.get();
  }
  
  public byte[] getTrimmedArray() {
    byte[] trimmedArray = new byte[length()];
    System.arraycopy(getArray(), 0, trimmedArray, 0, length());
    
    return trimmedArray;
  }
  
}

