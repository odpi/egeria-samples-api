/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples.ensemble;


import org.odpi.openmetadata.http.HttpHelper;
import org.odpi.openmetadata.samples.CertificationTypeSample;
import org.odpi.openmetadata.samples.GovernanceDefinitionsSample;
import org.odpi.openmetadata.samples.GovernanceDomainSample;
import org.odpi.openmetadata.samples.GovernanceZoneSample;
import org.odpi.openmetadata.samples.MetadataServerSample;
import org.odpi.openmetadata.samples.PeopleLocationsSample;
import org.odpi.openmetadata.samples.SubjectAreaSample;
import org.odpi.openmetadata.samples.SustainabilityAspectsSample;
import org.odpi.openmetadata.samples.SustainabilityCommunitySample;
import org.odpi.openmetadata.samples.SustainabilityGlossarySample;
import org.odpi.openmetadata.samples.SustainabilityLeaderSample;
import org.odpi.openmetadata.samples.SustainabilityMetricsSample;
import org.odpi.openmetadata.samples.SustainabilityProjectsSample;
import org.odpi.openmetadata.samples.TeamEmailSample;
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
        CertificationTypeSample       certificationTypeSample       = new CertificationTypeSample();
        PeopleLocationsSample         peopleLocationsSample         = new PeopleLocationsSample();
        SustainabilityAspectsSample   sustainabilityAspectsSample   = new SustainabilityAspectsSample();
        SustainabilityCommunitySample sustainabilityCommunitySample = new SustainabilityCommunitySample();
        SustainabilityGlossarySample  sustainabilityGlossarySample  = new SustainabilityGlossarySample();
        GovernanceDefinitionsSample   governanceDefinitionsSample   = new GovernanceDefinitionsSample();
        GovernanceDomainSample        governanceDomainSample        = new GovernanceDomainSample();
        GovernanceZoneSample          governanceZoneSample          = new GovernanceZoneSample();
        SustainabilityLeaderSample    sustainabilityLeaderSample    = new SustainabilityLeaderSample();
        MetadataServerSample          sustainabilityMetadataServer  = new MetadataServerSample();
        SustainabilityMetricsSample   sustainabilityMetricsSample   = new SustainabilityMetricsSample();
        SustainabilityProjectsSample  sustainabilityProjectsSample  = new SustainabilityProjectsSample();
        SubjectAreaSample             subjectAreaSample             = new SubjectAreaSample();
        TeamEmailSample               teamEmailSample               = new TeamEmailSample();

        governanceDomainSample.runSample(serverName, serverPlatformRootURL, userId);
        governanceZoneSample.runSample(serverName, serverPlatformRootURL, userId);
        certificationTypeSample.runSample(serverName, serverPlatformRootURL, userId);
        peopleLocationsSample.runSample(serverName, serverPlatformRootURL, userId);
        subjectAreaSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityCommunitySample.runSample(serverName, serverPlatformRootURL, userId);
        governanceDefinitionsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityLeaderSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityProjectsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityGlossarySample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityMetricsSample.runSample(serverName, serverPlatformRootURL, userId);
        teamEmailSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityAspectsSample.runSample(serverName, serverPlatformRootURL, userId);
        sustainabilityMetadataServer.runSample(serverName, serverPlatformRootURL, userId);
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
