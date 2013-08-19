/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.HistoryServiceImpl;

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
public class HistoryServiceProviderImpl{
	
	HistoryServiceImpl impl;
	
	public HistoryServiceProviderImpl() throws RemoteException {
		impl = new HistoryServiceImpl();
	}
	

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetAncestorsResponse getAncestors(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetAncestorsRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetAncestorsResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetAncestorsResponse();
    boxedResult.setNCIChangeEventList(impl.getAncestors(params.getConceptReference().getConceptReference()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetBaselinesResponse getBaselines(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetBaselinesRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetBaselinesResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetBaselinesResponse();
    boxedResult.setSystemReleaseList(impl.getBaselines(params.getReleasedAfter(),params.getReleasedBefore()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptChangeVersionsResponse getConceptChangeVersions(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptChangeVersionsRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptChangeVersionsResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptChangeVersionsResponse();
    boxedResult.setCodingSchemeVersionList(impl.getConceptChangeVersions(params.getConceptReference().getConceptReference(),params.getBeginDate(),params.getEndDate()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptCreationVersionResponse getConceptCreationVersion(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptCreationVersionRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptCreationVersionResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetConceptCreationVersionResponse();
    boxedResult.setCodingSchemeVersion(impl.getConceptCreationVersion(params.getConceptReference().getConceptReference()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetDescendentsResponse getDescendents(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetDescendentsRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetDescendentsResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetDescendentsResponse();
    boxedResult.setNCIChangeEventList(impl.getDescendents(params.getConceptReference().getConceptReference()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEarliestBaselineResponse getEarliestBaseline(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEarliestBaselineRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEarliestBaselineResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEarliestBaselineResponse();
    boxedResult.setSystemRelease(impl.getEarliestBaseline());
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionListResponse getEditActionList(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionListRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionListResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionListResponse();
    boxedResult.setNCIChangeEventList(impl.getEditActionList(params.getConceptReference().getConceptReference(),params.getReleaseURN()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList2Response getEditActionList2(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList2Request params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList2Response boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList2Response();
    boxedResult.setNCIChangeEventList(impl.getEditActionList2(params.getConceptReference().getConceptReference(),params.getCodingSchemeVersion().getCodingSchemeVersion()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList3Response getEditActionList3(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList3Request params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList3Response boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetEditActionList3Response();
    boxedResult.setNCIChangeEventList(impl.getEditActionList3(params.getConceptReference().getConceptReference(),params.getBeginDate(),params.getEndDate()));
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetLatestBaselineResponse getLatestBaseline(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetLatestBaselineRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetLatestBaselineResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetLatestBaselineResponse();
    boxedResult.setSystemRelease(impl.getLatestBaseline());
    return boxedResult;
  }

    public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetSystemReleaseResponse getSystemRelease(org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetSystemReleaseRequest params) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetSystemReleaseResponse boxedResult = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.GetSystemReleaseResponse();
    boxedResult.setSystemReleaseDetail(impl.getSystemRelease(params.getReleaseURN()));
    return boxedResult;
  }

}
