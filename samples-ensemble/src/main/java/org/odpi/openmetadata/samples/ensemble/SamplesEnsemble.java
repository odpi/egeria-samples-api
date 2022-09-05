/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples.ensemble;


import org.odpi.openmetadata.http.HttpHelper;
import org.odpi.openmetadata.samples.*;
import org.odpi.openmetadata.samples.utilities.SampleBase;

import java.io.IOException;

import static java.lang.System.exit;

/**
 * SamplesEnsemble calls each of the samples from a main program.  It is used to load all the metadata created
 * by the samples in a single run.
 */
public class SamplesEnsemble extends SampleBase
{
    /**
     * Run the samples.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformRootURL the network address of the server running the OMAS REST servers
     * @param userId calling user
     */
    public void runSample(String serverName,
                          String serverPlatformRootURL,
                          String userId)
    {
        FrequentTravellerSample       frequentTravellerSample       = new FrequentTravellerSample();
        MapDataGHGSample              mapDataGHGSample              = new MapDataGHGSample();
        ReferenceMappingSample        referenceMappingSample        = new ReferenceMappingSample();
        UtilityBillSample             utilityBillSample             = new UtilityBillSample();
        ValueSetGHGSample             valueSetGHGSample             = new ValueSetGHGSample();
        GovernanceZoneSample          governanceZoneSample          = new GovernanceZoneSample();
        GovernanceDomainSample        governanceDomainSample        = new GovernanceDomainSample();
        GovernanceDefinitionsSample   governanceDefinitionsSample   = new GovernanceDefinitionsSample();
        SubjectAreaSample             subjectAreaSample             = new SubjectAreaSample();
        CertificationTypeSample       certificationTypeSample       = new CertificationTypeSample();
        PeopleLocationsSample         peopleLocationsSample         = new PeopleLocationsSample();
        SustainabilityAspectsSample   sustainabilityAspectsSample   = new SustainabilityAspectsSample();
        SustainabilityCommunitySample sustainabilityCommunitySample = new SustainabilityCommunitySample();
        SustainabilityGlossarySample  sustainabilityGlossarySample  = new SustainabilityGlossarySample();
        SustainabilityLeaderSample    sustainabilityLeaderSample    = new SustainabilityLeaderSample();
        MetadataServerSample          sustainabilityMetadataServer  = new MetadataServerSample();
        SustainabilityMetricsSample   sustainabilityMetricsSample   = new SustainabilityMetricsSample();
        SustainabilityProjectsSample  sustainabilityProjectsSample  = new SustainabilityProjectsSample();
        TeamEmailSample               teamEmailSample               = new TeamEmailSample();
        CatalogueSystemsSample        catalogueSystemsSample        = new CatalogueSystemsSample();
        ListNoLineageSample           listNoLineageSample           = new ListNoLineageSample();
        ListPowerUseSample            listPowerUseSample            = new ListPowerUseSample();
        AddNewSiteSample              addNewSiteSample              = new AddNewSiteSample();
        CoolantTypesSample            coolantTypesSample            = new CoolantTypesSample();
        InventoryTodoSample           inventoryTodoSample           = new InventoryTodoSample();
        ListLocationsSample           listLocationsSample           = new ListLocationsSample();
        ListSystemsLocationsSample    listSystemsLocationsSample    = new ListSystemsLocationsSample();
        RefrigerationUnitTypesSample  refrigerationUnitTypesSample  = new RefrigerationUnitTypesSample();
        CatalogueStructureSample      catalogueStructureSample      = new CatalogueStructureSample();
        LineageDataPipelinesSample    lineageDataPipelinesSample    = new LineageDataPipelinesSample();

        governanceZoneSample.runSample(serverName, serverPlatformRootURL, userId);
        governanceDomainSample.runSample(serverName, serverPlatformRootURL, userId);
        governanceDefinitionsSample.runSample(serverName, serverPlatformRootURL, userId);
        subjectAreaSample.runSample(serverName, serverPlatformRootURL, userId);

        certificationTypeSample.runSample(serverName, serverPlatformRootURL, userId);
        peopleLocationsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityCommunitySample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityLeaderSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityProjectsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityGlossarySample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityMetricsSample.runSample(serverName, serverPlatformRootURL, userId);
        teamEmailSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityAspectsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityMetadataServer.runSample(serverName, serverPlatformRootURL, userId);

        frequentTravellerSample.runSample(serverName, serverPlatformRootURL, userId);
        mapDataGHGSample.runSample(serverName, serverPlatformRootURL, userId);
        referenceMappingSample.runSample(serverName, serverPlatformRootURL, userId);
        utilityBillSample.runSample(serverName, serverPlatformRootURL, userId);
        valueSetGHGSample.runSample(serverName, serverPlatformRootURL, userId);

        catalogueSystemsSample.runSample(serverName, serverPlatformRootURL, userId);
        listNoLineageSample.runSample(serverName, serverPlatformRootURL, userId);
        listPowerUseSample.runSample(serverName, serverPlatformRootURL, userId);
        addNewSiteSample.runSample(serverName, serverPlatformRootURL, userId);
        coolantTypesSample.runSample(serverName, serverPlatformRootURL, userId);
        inventoryTodoSample.runSample(serverName, serverPlatformRootURL, userId);
        listLocationsSample.runSample(serverName, serverPlatformRootURL, userId);
        listSystemsLocationsSample.runSample(serverName, serverPlatformRootURL, userId);
        refrigerationUnitTypesSample.runSample(serverName, serverPlatformRootURL, userId);
        catalogueStructureSample.runSample(serverName, serverPlatformRootURL, userId);
        lineageDataPipelinesSample.runSample(serverName, serverPlatformRootURL, userId);
    }


    /**
     * Run the Sample Suite.
     *
     * @param args user input
     */
    public static void main(String[] args)
    {
        HttpHelper.noStrictSSLIfConfigured();

        int exitCode = 0;

        try
        {
            String url = getUrl(args);
            String serverName = getServerName(args);
            String userId = getUserId(args);

            SamplesEnsemble samplesSuite = new SamplesEnsemble();

            samplesSuite.runSample(serverName, url, userId);
        }
        catch (IOException error)
        {
            System.out.println("Error getting user input");
            error.printStackTrace();
            exitCode = -99;
        }

        exit(exitCode);
    }
}
