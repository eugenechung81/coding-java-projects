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
package org.apache.thrift;

import java.util.Arrays;

public class TBitSet {

	private final boolean[] array;

	public TBitSet(int size) {
		this.array = new boolean[size];
	}

	protected int getSize() {
		return array.length;
	}

	public void clear() {
	  Arrays.fill(array, false);
	}

	public void clear(int i) {
		set(i, false);
	}

	public boolean get(int i) {
		return array[i];
	}

	public void or(TBitSet other) {
	  
	  if (other.getSize() != getSize()) {
	    throw new IllegalArgumentException("Operands must have the same size.");
	  }
	  
		for (int i = 0; i < array.length; i++) {
			array[i] |= other.get(i);
		}
		
	}

	public void set(int i, boolean b) {
		array[i] = b;
	}

}
