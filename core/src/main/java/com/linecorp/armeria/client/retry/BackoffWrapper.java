/*
 * Copyright 2017 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.client.retry;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

/**
 * Wraps an existing {@link Backoff}.
 */
public class BackoffWrapper implements Backoff {
    private final Backoff delegate;

    protected BackoffWrapper(Backoff delegate) {
        this.delegate = checkNotNull(delegate, "delegate");
    }

    @Override
    public long nextIntervalMillis(int numAttemptsSoFar) {
        return delegate.nextIntervalMillis(numAttemptsSoFar);
    }

    protected Backoff delegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate).toString();
    }
}
