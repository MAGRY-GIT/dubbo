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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 展接口的标记
 * <p/>
 * 扩展配置文件的更改 <br/>
 * Use <code>Protocol</code>作为例子,其配置文件'META-INF/dubbo/com.xxx.Protocol' 从: <br/>
 * <pre>
 *     com.foo.XxxProtocol
 *     com.foo.YyyProtocol
 * </pre>
 * <p>
 * 键值对 <br/>
 * <pre>
 *     xxx=com.foo.XxxProtocol
 *     yyy=com.foo.YyyProtocol
 * </pre>
 * <br/>
 * 此更改的原因是：
 * <p>
 * 如果在扩展实现中存在静态字段或方法引用的第三方库，则其类将
 * 如果第三方库不存在，则无法初始化。在这种情况下，dubbo 无法找出扩展的 id
 * 因此，如果使用以前的格式，则无法将异常信息与扩展名映射。
 * <p/>
 * 例如：
 * <p>
 * 加载 Extension（“mina”） 失败。当用户配置使用 mina 时，dubbo 会抱怨扩展无法加载，
 * 而不是报告哪个提取扩展实现失败以及提取原因。
 * </p>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

    /**
     * 默认扩展名
     */
    String value() default "";

    /**
     * SPI 的范围，默认值为应用程序范围。
     */
    ExtensionScope scope() default ExtensionScope.APPLICATION;
}
