////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2017 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;

import com.puppycrawl.tools.checkstyle.AbstractModuleTestSupport;
import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class SuppressionTestFilterTest extends AbstractModuleTestSupport {
    @Test
    public void testEqualsAndHashCodeMethods() {
        EqualsVerifier
                .forClass(SuppressionTestFilter.class)
                .usingGetClass()
                .withIgnoredFields("configuration")
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

    @Test
    public void testExternalResource() {
        final SuppressionTestFilter filter = new SuppressionTestFilter();
        assertEquals("Should equal", Collections.singleton("TEST"),
                filter.getExternalResourceLocations());
    }

    @Test
    public void testAccept() {
        final SuppressionTestFilter filter = new SuppressionTestFilter();
        final AuditEvent ev = new AuditEvent(this, "ATest.java", null);

        assertFalse("Audit event should not be accepted",
                filter.accept(ev));
    }

    @Override
    protected String getPackageLocation() {
        return null;
    }
}
