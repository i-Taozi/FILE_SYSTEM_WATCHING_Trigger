/**
 * Copyright (c) 2012, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fortuna.ical4j.model.component;

import junit.framework.TestSuite;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentTest;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * $Id: VTimeZoneTest.java [5/07/2004]
 * <p/>
 * A test case for VTimeZone.
 *
 * @author benfortuna
 */
public class VTimeZoneTest extends ComponentTest {

    private Logger log = LoggerFactory.getLogger(VTimeZoneTest.class);

    private VTimeZone tz;

    /**
     * @param testMethod
     * @param component
     */
    public VTimeZoneTest(String testMethod, VTimeZone component) {
        super(testMethod, component);
        this.tz = component;
    }

    /**
     *
     */
    public void testCreateDefinition() {
        Calendar calendar = new Calendar();
        calendar.getComponents().add(tz);
        log.info(calendar.toString());
    }

    /**
     * @return
     */
    public static TestSuite suite() {
        TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
        TestSuite suite = new TestSuite();

        suite.addTest(new VTimeZoneTest("testCreateDefinition", registry.getTimeZone("Australia/Melbourne").getVTimeZone()));

        VTimeZone tz = new VTimeZone();
        suite.addTest(new VTimeZoneTest("testIsCalendarComponent", tz));
        suite.addTest(new VTimeZoneTest("testValidationException", tz));

        return suite;
    }
}
