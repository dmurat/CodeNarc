/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codenarc.metric.abc

import org.codenarc.source.SourceString
import org.codenarc.test.AbstractTest

/**
 * Tests for AbcComplexityCalculator
 *
 * @author Chris Mair
 * @version $Revision: 120 $ - $Date: 2009-04-06 12:58:09 -0400 (Mon, 06 Apr 2009) $
 */
abstract class AbstractAbcTest extends AbstractTest {

    protected void assertEquals(AbcVector abcVector, List expectedValues) {
        log(abcVector)
        def actualValues = [abcVector.assignments, abcVector.branches, abcVector.conditions]
        assert actualValues == expectedValues
    }

    protected parseClass(String source) {
        def sourceCode = new SourceString(source)
        calculator.sourceCode = sourceCode
        def ast = sourceCode.ast
        return ast.classes[0]
    }

}