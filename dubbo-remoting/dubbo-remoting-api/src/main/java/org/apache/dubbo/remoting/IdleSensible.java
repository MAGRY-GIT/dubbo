/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.remoting;

/**
 * 指示实现（对于服务器和客户端）是否能够感知和处理空闲连接。
 * 如果服务器有能力处理空闲连接，它应该在连接发生时关闭连接，如果客户端有能力处理空闲连接，它应该将心跳发送到服务器。
 */
public interface IdleSensible {
    /**
     * 实现是否可以感知和处理空闲连接。默认情况下，它是 false，实现依赖于专用计时器来处理空闲连接。
     * @return 是否具备处理空闲连接的能力
     */
    default boolean canHandleIdle() {
        return false;
    }
}
