/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.core.startup;

import org.netbeans.junit.NbTestCase;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.XMLFileSystem;
import org.openide.util.test.MockLookup;

public class NbRepositoryClasspathTest extends NbTestCase {

    public NbRepositoryClasspathTest(String name) {
        super(name);
    }

    /**
     * #129583: XML layers from classpath modules should always be loaded.
     */
    public void testNbRepositoryInitializedFromClasspath() throws Exception {
        MockLookup.setInstances();
        final String PATH = "Services/MIMEResolver/org-netbeans-core-startup-layers-SystemFileSystem-Extension.xml";
        assertNotNull(FileUtil.getConfigFile(PATH));
        MockLookup.setInstances(new XMLFileSystem()); // #200848
        assertNotNull(FileUtil.getConfigFile(PATH));
    }

}
