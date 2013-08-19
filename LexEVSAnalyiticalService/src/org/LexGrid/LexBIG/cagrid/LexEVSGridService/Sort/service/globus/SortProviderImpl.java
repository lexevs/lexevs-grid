/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.SortImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the LexBIGCaGridServicesImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class SortProviderImpl{
	
	SortImpl impl;
	
	public SortProviderImpl() throws RemoteException {
		impl = new SortImpl();
	}
	

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetNameResponse getName(org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetNameRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetNameResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetNameResponse();
    boxedResult.setResponse(impl.getName());
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetDescriptionResponse getDescription(org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetDescriptionRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetDescriptionResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetDescriptionResponse();
    boxedResult.setResponse(impl.getDescription());
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetProviderResponse getProvider(org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetProviderRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetProviderResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetProviderResponse();
    boxedResult.setResponse(impl.getProvider());
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetVersionResponse getVersion(org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetVersionRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetVersionResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.GetVersionResponse();
    boxedResult.setResponse(impl.getVersion());
    return boxedResult;
  }

}
