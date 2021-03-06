/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.services;

import junit.framework.TestCase;

import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;


/**
 * JUnit test cases for the coded node graph.
 *
 * @author <A HREF="mailto:armbrust.daniel@mayo.edu">Dan Armbrust</A>
 * @version subversion $Revision: 1.9 $ checked in on $Date: 2007/12/15 00:07:42 $
 */
public class CodedNodeGraphTest extends TestCase
{

/**
 * Test intersection.
 * 
 * @throws LBException the LB exception
 */
public void testIntersection() throws LBException
    {
        LexBIGService lbsi = ServiceHolder.instance().getLexBIGService();
        ConvenienceMethods cm = new ConvenienceMethods(lbsi);
        
        CodedNodeGraph cng = lbsi.getNodeGraph(LexBIGServiceTestCase.THES_SCHEME, null, "roles");
        
        NameAndValueList nv = Constructors.createNameAndValueList("subClassOf");
        cng = cng.restrictToAssociations(nv, null);
        cng = cng.restrictToSourceCodes(cm.createCodedNodeSet(new String[] {"C25377"}, LexBIGServiceTestCase.THES_SCHEME, null));

        CodedNodeGraph cng2 = lbsi.getNodeGraph(LexBIGServiceTestCase.THES_SCHEME, null, "roles");
        cng2 = cng2.restrictToSourceCodes(cm.createCodedNodeSet(new String[] {"C37927","C25377","C54453","C48326"}, LexBIGServiceTestCase.THES_SCHEME, null));//color
        
        cng = cng.intersect(cng2);
        ResolvedConceptReferenceList rcrl = cng.resolveAsList(Constructors.createConceptReference("C25377", LexBIGServiceTestCase.THES_SCHEME), true, false, -1, -1, null, null, null, 50);
        ResolvedConceptReference[] rcr = rcrl.getResolvedConceptReference();
        
        assertNotNull("0",rcr);

        assertTrue("1",rcr.length == 1);

        assertTrue("2",rcr[0].getConceptCode().equals("C25377"));

        //no uplink
        assertTrue("3",rcr[0].getTargetOf() == null ||  rcr[0].getTargetOf().getAssociation().length == 0);
        
        //1 down link
        Association[] assn = rcr[0].getSourceOf().getAssociation();
        assertTrue("4",assn.length == 1);
        AssociatedConcept[] ac = assn[0].getAssociatedConcepts().getAssociatedConcept();
        assertTrue("5",ac.length == 1);
        assertTrue("6",ac[0].getConceptCode().equals("C25447"));
        //no more below it 
        assertTrue("7",ac[0].getSourceOf() == null);
    }
    
    /**
     * Test is code in graph.
     * 
     * @throws LBException the LB exception
     */
    public void testIsCodeInGraph() throws LBException
    {
        LexBIGService lbsi = ServiceHolder.instance().getLexBIGService();
        ConvenienceMethods cm = new ConvenienceMethods(lbsi);
        CodedNodeGraph cng = lbsi.getNodeGraph(LexBIGServiceTestCase.THES_SCHEME, null, "roles");
         
        assertTrue("1",cng.isCodeInGraph(Constructors.createConceptReference("C12434", LexBIGServiceTestCase.THES_SCHEME)).booleanValue());//Blood
        
        assertTrue("2",cng.isCodeInGraph(Constructors.createConceptReference("C12727", LexBIGServiceTestCase.THES_SCHEME)).booleanValue());//Heart  
         
         cng = cng.restrictToSourceCodes(cm.createCodedNodeSet(new String[] {"C12727"}, LexBIGServiceTestCase.THES_SCHEME, null));//Heart
         assertTrue("3",cng.isCodeInGraph(Constructors.createConceptReference("C13018", LexBIGServiceTestCase.THES_SCHEME)).booleanValue());//Heart  
         
         cng = cng.restrictToTargetCodes(cm.createCodedNodeSet(new String[] {"C13018"}, LexBIGServiceTestCase.THES_SCHEME, null));
         assertFalse("4",cng.isCodeInGraph(Constructors.createConceptReference("C12392", LexBIGServiceTestCase.THES_SCHEME)).booleanValue());
    }
    
    /**
     * Test union.
     * 
     * @throws LBException the LB exception
     */
    public void testUnion() throws LBException
    {
        LexBIGService lbsi = ServiceHolder.instance().getLexBIGService();
        ConvenienceMethods cm = new ConvenienceMethods(lbsi);
        CodedNodeGraph cng = lbsi.getNodeGraph(LexBIGServiceTestCase.THES_SCHEME, null, "roles");
       cng = cng.restrictToAssociations(Constructors.createNameAndValueList("hasSubtype"), null);
       cng = cng.restrictToSourceCodes(cm.createCodedNodeSet(new String[] {"C13018"}, LexBIGServiceTestCase.THES_SCHEME, null));//Organ
         cng = cng.restrictToTargetCodes(cm.createCodedNodeSet(new String[] {"C12727"}, LexBIGServiceTestCase.THES_SCHEME, null));//Heart
         
         CodedNodeGraph cng2 = lbsi.getNodeGraph(LexBIGServiceTestCase.THES_SCHEME, null, "roles");
         cng2 = cng2.restrictToSourceCodes(cm.createCodedNodeSet(new String[] {"C12727"}, LexBIGServiceTestCase.THES_SCHEME, null));

         //join them
         cng.union(cng2);
         
         ResolvedConceptReference[] rcr = cng.resolveAsList(null, true, false, -1, -1, null, null, null, 50).getResolvedConceptReference();

         assertTrue("1",rcr.length == 1);
         //top node
         assertTrue("2",rcr[0].getConceptCode().equals("C12727"));

         //no uplink
         assertTrue("3",rcr[0].getTargetOf() == null ||  rcr[0].getTargetOf().getAssociation().length == 0);
         
         //1 down link
         Association[] assn = rcr[0].getSourceOf().getAssociation();
         assertTrue("4",assn.length == 3);   
    }
  
    private boolean contains(ConceptReference[] cr, String code, String codeSystem)
    {
        boolean contains = false;
        for (int i = 0; i < cr.length; i++)
        {
            if (cr[i].getConceptCode().equals(code) && cr[i].getCodingSchemeName().equals(codeSystem))
            {
                contains = true;
                break;
            }
        }
        return contains;
    }
}