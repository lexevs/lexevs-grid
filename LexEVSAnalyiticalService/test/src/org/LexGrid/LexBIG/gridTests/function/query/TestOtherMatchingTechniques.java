/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_18 TestOtherMatchingTechniques

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestOtherMatchingTechniques.
 */
public class TestOtherMatchingTechniques extends LexBIGServiceTestCase
{
    final static String testID = "testOtherMatchingTechniques";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test other matching techniques.
     * 
     * @throws LBException the LB exception
     */
    public void testOtherMatchingTechniques() throws LBException
    {

        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);

        cns = cns.restrictToMatchingDesignations("base heart", null, "LuceneQuery", null);

        ResolvedConceptReference[] rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        // should have found the concept code C48589 - "Base of the Heart"
        boolean found = false;
        for (int i = 0; i < rcr.length; i++)
        {
            if (rcr[i].getConceptCode().equals("C48589"))
            {
                found = true;
            }
        }
        assertTrue(found);

    }

    /**
     * Test other matching techniquesb.
     * 
     * @throws LBException the LB exception
     */
    public void testOtherMatchingTechniquesb() throws LBException
    {
        // Test some other code systems that aren't used by the other tests...

        // Do a query against a umls loaded terminology - make sure it is present.
        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(LexBIGServiceTestCase.MEDDRA_SCHEME, null);

        cns = cns.restrictToMatchingDesignations("person", null, "LuceneQuery", null);

        ResolvedConceptReference[] rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        // should have found the concept code: PURPR
        boolean found = false;
        for (int i = 0; i < rcr.length; i++)
        {
            if (rcr[i].getConceptCode().equals("10001321"))
            {
                found = true;
            }
        }
        assertTrue(found);
        
        // Do this again but resolve with the URN (Security Test).
        CodedNodeSet cns2 = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(LexBIGServiceTestCase.MEDDRA_URN, null);

        cns2 = cns2.restrictToMatchingDesignations("person", null, "LuceneQuery", null);

        ResolvedConceptReference[] rcr2 = cns2.resolveToList(null, null, null, 0).getResolvedConceptReference();

        // should have found the concept code: PURPR
        boolean found2 = false;
        for (int i = 0; i < rcr2.length; i++)
        {
            if (rcr2[i].getConceptCode().equals("10001321"))
            {
                found2 = true;
            }
        }
        assertTrue(found2);

    }

    /**
     * Test other matching techniquesc.
     * 
     * @throws LBException the LB exception
     */
    public void testOtherMatchingTechniquesc() throws LBException
    {
        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);

        cns = cns.restrictToMatchingDesignations("goldenro.*", null, "RegExp", null);

        ResolvedConceptReference[] rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        // should have found the concept code: 73

        assertTrue("1",rcr.length == 1);
        assertTrue("2",rcr[0].getConceptCode().equals("C52191"));

    }

    /**
     * Test other matching techniquesd.
     * 
     * @throws LBException the LB exception
     */
    public void testOtherMatchingTechniquesd() throws LBException
    {
        // non preferred should have 1 hit.
        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);

        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", SearchDesignationOption.NON_PREFERRED_ONLY,
                                           "LuceneQuery", null);
        ResolvedConceptReference[] rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        assertTrue("1",rcr.length == 1);
        assertTrue("2",rcr[0].getConceptCode().equals("C27083"));

        // preferred should have 0 hits.
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Vessel Tumor\"", SearchDesignationOption.PREFERRED_ONLY, "LuceneQuery",
                                           null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("3",rcr.length == 0);

        // Any should have 1 hit.
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", SearchDesignationOption.ALL, "LuceneQuery", null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("4",rcr.length == 1);
        assertTrue("5",rcr[0].getConceptCode().equals("C27083"));

        // null should have 1 hit.
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", null, "LuceneQuery", null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("6",rcr.length == 1);
        assertTrue("7",rcr[0].getConceptCode().equals("C27083"));

        // now, do the reverse queries. preferred should match, non-preferred should not.
        // preferred should have 1 hits.
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", SearchDesignationOption.PREFERRED_ONLY, "LuceneQuery",
                                           null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue(rcr.length == 1);
        
        // all should have 1 hits.
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", SearchDesignationOption.ALL, "LuceneQuery", null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("9",rcr.length == 1);

        // and so should null
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("\"Blood Clot\"", null, "LuceneQuery", null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("10",rcr.length == 1);

    }

}