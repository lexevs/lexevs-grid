/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.MetadataPropertyList;
import org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

public class LexBIGServiceMetadataAdapter implements LexBIGServiceMetadata {

	private LexBIGServiceMetadataGridAdapter lbsm;

	public LexBIGServiceMetadataAdapter(LexBIGServiceMetadataGridAdapter adapter) throws RemoteException {
		lbsm = adapter;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#listCodingSchemes()
	 */
	public AbsoluteCodingSchemeVersionReferenceList listCodingSchemes()
	throws LBInvocationException {
		try {
			return ConvertUtils.convert(lbsm.listCodingSchemes(), org.LexGrid.LexBIG.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#resolve()
	 */
	public MetadataPropertyList resolve() throws LBParameterException,
	LBInvocationException {
		try {
			return ConvertUtils.convert(lbsm.resolve(),
					org.LexGrid.LexBIG.DataModel.Collections.MetadataPropertyList.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToCodingScheme(org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference)
	 */
	public LexBIGServiceMetadata restrictToCodingScheme(
			AbsoluteCodingSchemeVersionReference acsvr)
	throws LBParameterException {
		try {
			lbsm.restrictToCodingScheme(
					ConvertUtils.convert(acsvr, org.LexGrid.LexBIG.iso21090.DataModel.Core.AbsoluteCodingSchemeVersionReference.class));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToProperties(java.lang.String[])
	 */
	public LexBIGServiceMetadata restrictToProperties(String[] properties)
	throws LBParameterException {
		try {
			lbsm.restrictToProperties(
					Utils.stringArrayToPropertyIdentification(properties));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToPropertyParents(java.lang.String[])
	 */
	public LexBIGServiceMetadata restrictToPropertyParents(
			String[] propertyParents) throws LBParameterException {
		try {
			lbsm.restrictToPropertyParents(
					Utils.stringArrayToPropertyIdentification(propertyParents));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToValue(java.lang.String,
	 *      java.lang.String)
	 */
	public LexBIGServiceMetadata restrictToValue(String matchText,
			String matchAlgorithm) throws LBParameterException {
		try{
			lbsm.restrictToValue(
					Utils.wrapMatchCritia(matchText), 
					Utils.wrapExtensionIdentification(matchAlgorithm));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}
}
