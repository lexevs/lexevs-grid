/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.ST;

public class StringStCustomConverter extends AbstractCustomConverter<String,ST>{

	@Override
	protected ST aToB(String a) {
		ST st = new ST();
		st.setValue(a);
		return st;
	}

	@Override
	protected String bToA(ST b) {
		return b.getValue();
	}

	@Override
	protected Class<?> getAClass() {
		return String.class;
	}

	@Override
	protected Class<?> getBClass() {
		return ST.class;
	}

}
