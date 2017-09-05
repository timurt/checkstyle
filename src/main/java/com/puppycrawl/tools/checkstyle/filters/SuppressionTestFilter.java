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

import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import com.puppycrawl.tools.checkstyle.api.AutomaticBean;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.ExternalResourceHolder;
import com.puppycrawl.tools.checkstyle.api.Filter;
import com.puppycrawl.tools.checkstyle.api.FilterSet;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * Documentation for {@code MyTestFilter}.
 *
 * @author Timur Tibeyev.
 * @noinspection NonFinalFieldReferenceInEquals, NonFinalFieldReferencedInHashCode
 */
public class SuppressionTestFilter extends AutomaticBean implements Filter, ExternalResourceHolder {
    /** Magic string. */
    private static final String MAGIC = "TEST";
    /** Set of individual suppresses. */
    private FilterSet filters = new FilterSet();

    @Override
    public Set<String> getExternalResourceLocations() {
        return Collections.singleton(MAGIC);
    }

    @Override
    public boolean accept(AuditEvent event) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final SuppressionTestFilter myTestFilter = (SuppressionTestFilter) obj;
        return Objects.equals(filters, myTestFilter.filters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters);
    }

    @Override
    protected void finishLocalSetup() throws CheckstyleException {
        filters = new FilterSet();
    }
}
