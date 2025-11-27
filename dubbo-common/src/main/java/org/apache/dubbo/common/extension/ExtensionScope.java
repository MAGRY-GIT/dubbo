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
package org.apache.dubbo.common.extension;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;

/**
 * 扩展 SPI 范围
 * @see SPI
 * @see ExtensionDirector
 */
public enum ExtensionScope {

    /**
     * 扩展实例在框架内使用，与所有应用程序和模块共享。
     *
     * <p>框架范围的 SPI 扩展只能获得 {@link FrameworkModel},
     * cannot get the {@link ApplicationModel} and {@link ModuleModel}.</p>
     *
     * <p></p>
     * 思考:
     * <ol>
     * <li>一些 SPI 需要在框架内的应用程序之间共享数据</li>
     * <li>无状态 SPI 在框架内安全共享</li>
     * </ol>
     */
    FRAMEWORK,

    /**
     * 扩展实例在一个应用程序中使用，与应用程序的所有模块共享，
     * 不同的应用程序创建不同的扩展实例。
     *
     * <p>Application scope SPI extension can obtain {@link FrameworkModel} and {@link ApplicationModel},
     * cannot get the {@link ModuleModel}.</p>
     *
     * <p></p>
     * Consideration:
     * <ol>
     * <li>Isolate extension data in different applications inside framework</li>
     * <li>Share extension data between all modules inside application</li>
     * </ol>
     */
    APPLICATION,

    /**
     * 扩展实例在一个模块中使用，不同的模块创建不同的扩展实例。
     *
     * <p>Module scope SPI extension can obtain {@link FrameworkModel}, {@link ApplicationModel} and {@link ModuleModel}.</p>
     *
     * <p></p>
     * Consideration:
     * <ol>
     * <li>Isolate extension data in different modules inside application</li>
     * </ol>
     */
    MODULE,

    /**
     * 自给自足，为每个作用域创建一个实例，用于特殊的 SPI 扩展，例如 {@link ExtensionInjector}
     */
    SELF
}
